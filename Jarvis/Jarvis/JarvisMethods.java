import java.io.*;
import java.util.*;
import java.net.*;

public class JarvisMethods
{ 
  public static Random rand = new Random();
  public static boolean back = false;
  
  public static String openTest()
  {
    String phrase1 = "";
    for (int count_03 = JarvisVersion1.count_02 + 1; count_03 < JarvisVersion1.wordlist.size(); count_03 ++)
    {
      if (JarvisVersion1.wordlist.get(count_03).equals("in"))
      {
        if (JarvisVersion1.wordlist.get(count_03 + 1).equals("background"))
        {
          back = true;
          return phrase1;
        }
      }
      if (phrase1.equals(""))
      {
        phrase1 = phrase1 + JarvisVersion1.wordlist.get(count_03);
      }  
      else
      {
        phrase1 = phrase1 + "\\ " + JarvisVersion1.wordlist.get(count_03);
      }
    }
    return phrase1;
  }
  
  //OPEN APPLICATION
  public static void open()
  {  
    String[] cmd = {"/bin/sh", "-c", "open -a" + openTest()};
    try {
      Runtime.getRuntime().exec(cmd);
    }
    catch (IOException e)
    {
    }
    back = false;
    
     if (!(JarvisVersion1.muted))
    {
      try {
      Thread.sleep(1000);
      }
      catch (Exception e)
      {
      }
      say(openTest() + " is open");
    }
     
    JarvisVersion1.output = "OPEN: " + openTest().toUpperCase();
  }
  
  //CLOSE SPECIFIED APPLICATION
  public static void close()
  {
    String phrase3 = "";
    for (int count_04 = JarvisVersion1.count_02 + 1; count_04 < JarvisVersion1.wordlist.size(); count_04 ++)
    {
      if (phrase3.equals(""))
      {
        phrase3 = phrase3 + JarvisVersion1.wordlist.get(count_04);
      }
      else
      {
        phrase3 = phrase3 + "\\ " + JarvisVersion1.wordlist.get(count_04);
      }
    }
     
    String[] cmd = {"/bin/sh", "-c", "osascript -e 'tell application \"" + phrase3 + "\" to quit'"};
    try {
    Runtime.getRuntime().exec(cmd);
    }
    catch (IOException e)
    {
    }
    
     if (!(JarvisVersion1.muted))
    {
      try {
      Thread.sleep(1000);
      }
      catch (Exception e)
      {
      }
      say("closing your application");
    }
    
    JarvisVersion1.output = "CLOSE: " + phrase3.toUpperCase();
  }
  
  //SEARCH GOOGLE CHROME
  public static void search()
  {
    String phrase2 = "";
    for (int count_03 = JarvisVersion1.count_02 + 1; count_03 < JarvisVersion1.wordlist.size(); count_03 ++)
    {
      phrase2 = phrase2 + "+" + JarvisVersion1.wordlist.get(count_03);
    }
    
    String[] cmd = {"/bin/sh", "-c", "open http://www.google.com/search?q=" + phrase2 + "&aq=f&sugexp=chrome,mod=4&sourceid=chrome&ie=UTF-8"};
    try {
    Runtime.getRuntime().exec(cmd);
    }
    catch (IOException e)
    {
    } 
    
    if (!(JarvisVersion1.muted))
    {
      try {
      Thread.sleep(1000);
      }
      catch (Exception e)
      {
      }
      say("searching google");
    }
    
    JarvisVersion1.output = "GOOGLE SEARCH: " + phrase2.substring(1,phrase2.length()).toUpperCase();
  }
  
  //AUDIO POINTER
  public static void say(String statement)
  {
    //JarvisAudio.say("null");
    //JarvisAudio.say(statement);
    Runtime runtime = Runtime.getRuntime();
    String [] cmd = {"osascript", "-e", "say \"" + statement + "\""};
    try {
    Runtime.getRuntime().exec(cmd);
    }
    catch (IOException e)
    {
    } 
   
    //JarvisVersion1.output = "SAY: " + statement.toUpperCase();
  }
  
  //MUTE AUDIO
  public static void mute()
  {
    JarvisVersion1.muted = true;
    JarvisVersion1.output = "MUTED";
  }
  
  //UNMUTE AUDIO
  public static void unmute()
  {
    JarvisVersion1.muted = false;
    JarvisVersion1.output = "UNMUTED";
  }
  
  //GET DAILY SCHEDULE
  public static void info_day()
  {
    String day = "";
    Calendar cal = Calendar.getInstance();
    int weekday = cal.get(Calendar.DAY_OF_WEEK);
    switch (weekday)
    {
      case 1:
        day = "sunday";
        break;
      case 2:
        day = "monday";
        break;
      case 3:
        day = "tuesday";
        break;
      case 4:
        day = "wednesday";
        break;
      case 5:
        day = "thursday";
        break;
      case 6:
        day = "friday";
        break;
      case 7:
        day = "saturday";
        break;
    }
    
    if (!(JarvisVersion1.muted))
    {
      try {
      Thread.sleep(1000);
      }
      catch (Exception e)
      {
      }
      say("today is " + day);
    }
    
    JarvisVersion1.output = "DAY: " + day.toUpperCase();
  }
  
  
  //GET WEATHER (ONLY AUDIO)
  public static void info_weather()
  {
    String weather  = new String("weather");
    
    Runtime runtime = Runtime.getRuntime();
    String url = "\"http://weather.yahooapis.com/forecastrss?p=19717&u=f\"";
    String applescriptCommand = "set weather to \"curl \" & quote & " + url + " & quote\n" + "set postWeather to \"grep -E '(Current Conditions:|F<BR)'\"\n" + "set forecast to do shell script weather & \" | \" & postWeather\n" + "set statement to (characters 1 through -7 of paragraph 2 of forecast) as string\n" + "say statement";
    String applescriptCommand2 = "set weather to \"curl \" & quote & " + url + " & quote\n" + "set postWeather to \"grep -E '(Current Conditions:|F<BR)'\"\n" + "set forecast to do shell script weather & \" | \" & postWeather\n" + "set statement to (characters 1 through -7 of paragraph 2 of forecast) as string\n" + "statement";
    
    String [] cmd = {"osascript", "-e", applescriptCommand};
    try {
    Runtime.getRuntime().exec(cmd);
    }
    catch (IOException e)
    {
    } 
    
    JarvisVersion1.output = weather.toUpperCase();
  }
  
  //GET STOCK INFO
  public static void info_stock()
  {
    try {
      String webPage = "http://finance.yahoo.com/q?s=" + JarvisVersion1.stock;
      URL url = new URL(webPage);
      URLConnection urlConnection = url.openConnection();
      InputStream is = urlConnection.getInputStream();
      InputStreamReader isr = new InputStreamReader(is);
      
      int numCharsRead;
      char[] charArray = new char[1024];
      StringBuffer sb = new StringBuffer();
      while ((numCharsRead = isr.read(charArray)) > 0) {
        sb.append(charArray, 0, numCharsRead);
      }
      String result = sb.toString();
      
      String reference = "class=\"yfi_rt_quote_summary_rt_top\"><p> <span class=\"time_rtq_ticker\"><span id=";
      int first_index = result.indexOf(reference);
      int second_index = result.indexOf("</span>", first_index);
      String stock_price = result.substring(first_index + reference.length() + 14, second_index);
      
      //System.out.println(stock_price);
      JarvisVersion1.output = JarvisVersion1.stock.toUpperCase() + ": " + stock_price;
      
      if (!(JarvisVersion1.muted))
    {
      try {
      Thread.sleep(1000);
      }
      catch (Exception e)
      {
      }
      say("the stock price of " + JarvisVersion1.stock + " is " + stock_price);
    }
    }
    catch (IOException e)
    {
    }
  }
  
}