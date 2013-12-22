import java.io.*;
import java.util.*;
import java.net.*;

public class METHODS_MK3
{
  //SAY USING VOICE DEFINED IN SPEECH DEFAULTS
  public static void say(String statement)
  {
    Runtime runtime = Runtime.getRuntime();
    String [] cmd = {"osascript", "-e", "say \"" + statement + "\""};
    try {
    Runtime.getRuntime().exec(cmd);
    }
    catch (IOException e)
    {
    }  
  }
  
}