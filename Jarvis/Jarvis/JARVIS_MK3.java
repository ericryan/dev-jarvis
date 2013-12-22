import java.util.*;
import java.io.*;

public class JARVIS_MK3
{
  static Scanner cpu = new Scanner(System.in);
  static METHODS_MK3 m1 = new METHODS_MK3();

  static int location;
  static boolean muted = true;
  static String temp = new String("");
  static String raw = new String("");
  
  static ArrayList wordlist = new ArrayList();
  static ArrayList taglist = new ArrayList();
  static ArrayList tagindexes = new ArrayList();
  
  public static void main (String[] args)
  {
    input_Phrase();
    process_Phrase();
    
    //PRINTS OUT TAGLIST FOR TESTING PURPOSES
    for (int location = 0; location < taglist.size(); location++)
    {
      System.out.println(taglist.get(location).toString());
      System.out.println(tagindexes.get(location).toString());
    }
    
    //execute_Phrase();
    clear_Lists();
  }
  
  //FOR READING FROM DR. JAVA DIRECTLY
  public static void input_Phrase()
  {
    String phrase = new String(" ");
    int index = 0;
    phrase = cpu.nextLine();
    
    for (int count = 0; count < phrase.length(); count ++)
    {
      //taglist.add("null");
      if (phrase.substring(count, count + 1).equals(" "))
      {
        wordlist.add(phrase.substring(index, count));
        index = count + 1;
      }
      if (count == phrase.length() - 1)
      {
        wordlist.add(phrase.substring(index, count + 1));
      }
    }
  }
  
  //FOR READING IN FROM A GUI ETC
  public static void input_Phrase(String phrase)
  {
    int index = 0;
    
    for (int count = 0; count < phrase.length(); count ++)
    {
      if (phrase.substring(count, count + 1).equals(" "))
      {
        wordlist.add(phrase.substring(index, count));
        index = count + 1;
      }
      if (count == phrase.length() - 1)
      {
        wordlist.add(phrase.substring(index, count + 1));
      }
    }
  }
  
  //CLEARING LISTS
   public static void clear_Lists()
  {
    wordlist.clear();
    taglist.clear();
  }
   
   //PROCESSING THE PHRASE
   public static void process_Phrase()
   {
     //PROCESS SENTENCE BY WORD
     for (int location = 0; location < wordlist.size(); location++)
     {
       //CHECK IF IT IS A COMMAND
       //READ IN TXT FILE IN SAME DIR
       try {
       BufferedReader br = new BufferedReader(new FileReader("COMMANDS.txt"));
       int line_num = 1;
       String line;
       while ((line = br.readLine()) != null) {
         //CHECK IF THE CURRENT WORD LOCATION IS A COMMAND
         if (wordlist.get(location).toString().equalsIgnoreCase(line.toString()))
         {
           //taglist.set(location,"CMD" + line_num);
           taglist.add("CMD" + line_num);
           tagindexes.add(location);
         }
         //INCREMENT COUNTER
         line_num++;
       }
       br.close();
       }
       catch (IOException e)
       {
       }
       
       //CHECK IF IT IS AN OPTION
       //READ IN TXT FILE IN SAME DIR
       try {
       BufferedReader br = new BufferedReader(new FileReader("OPTIONS.txt"));
       int line_num = 1;
       String line;
       while ((line = br.readLine()) != null) {
         //CHECK IF THE CURRENT WORD LOCATION IS A COMMAND
         if (wordlist.get(location).toString().equalsIgnoreCase(line.toString()))
         {
           //taglist.set(location,"OPT" + line_num);
           taglist.add("OPT" + line_num);
           tagindexes.add(location);
         }
         //INCREMENT COUNTER
         line_num++;
       }
       br.close();
       }
       catch (IOException e)
       {
       }
     }
     //ETC
   }
}