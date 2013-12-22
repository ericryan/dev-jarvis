import java.util.*;
import java.io.*;

public class JarvisVersion1
{
  static Scanner cpu = new Scanner(System.in);
  static ArrayList wordlist = new ArrayList();
  static JarvisMethods jarv = new JarvisMethods();
  static int count_02;
  static boolean muted = true;
  static String output = new String("");
  static String stock = new String("");
  
  public static void main (String[] args)
  {
    JarvisVersion1.input_Phrase();
    JarvisVersion1.process_Phrase();
    JarvisVersion1.clear_List();
  }
  
  public static void input_Phrase()
  {
    String phrase = new String(" ");
    int index = 0;
    phrase = cpu.nextLine();
    
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
  
  public static void clear_List()
  {
    wordlist.clear();
  }
  
  public static void process_Phrase()
  {
    
    for (int count_02 = 0; count_02 < wordlist.size(); count_02 ++)
    {
      
      //OPEN APPLICATION
      if (wordlist.get(count_02).toString().equalsIgnoreCase("open"))
      {
          JarvisMethods.open();
      }
      
      //CLOSE APPLICATION
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("close"))
      {
          JarvisMethods.close();
      }
      
      //SEARCH WITH GOOGLE CHROME
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("search"))
      {
        JarvisMethods.search();
      }
      
      //JARVIS SPEAKS THE REST OF THE PHRASE
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("say"))
      {
        String statement = "";
        for (int count_03 = JarvisVersion1.count_02 + 1; count_03 < JarvisVersion1.wordlist.size(); count_03 ++)
        {
          if (!JarvisVersion1.wordlist.get(count_03).toString().equalsIgnoreCase("say"))
          {
            statement = statement + JarvisVersion1.wordlist.get(count_03) + " ";
          }
        }
        JarvisVersion1.output = statement;
        JarvisMethods.say(statement);
      }
      
      //MUTE AUDIO
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("mute"))
      {
        JarvisMethods.mute();
      }
      
      //RESTORE AUDIO
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("unmute"))
      {
        JarvisMethods.unmute();
      }
      
      //SHOW DAY OF WEEK
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("day"))
      {
        JarvisMethods.info_day();
      }
      
      //GET WEATHER
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("weather"))
      {
        JarvisMethods.info_weather();
      }
      
      //GET STOCK INFO
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("stock"))
      {
        JarvisVersion1.stock = wordlist.get(count_02 + 1).toString();
        JarvisMethods.info_stock();
      }
      
      //SHOW INFO
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("info"))
      {
      }
      
      else if (wordlist.get(count_02).toString().equalsIgnoreCase("startup"))
      {
        //HOW ARE STOCKS DOING
        //SCHEDULE
        //WEATHER
        //TO DO LIST
        //MAIL OPEN UDEL AND SEE MESSAGES IN OPTONLINE
        //NEWS
      }
      
      else
      {
      }
    }
  }
  
}