package bucket;

import java.io.*;

public class ReadFile
{
   public static void main(String[] args)  {
      try {
         FileReader file = new FileReader("test.txt");

         BufferedReader buffer = new BufferedReader( file );

         String line = "";

         while ( ( line = buffer.readLine() ) != null ) {
            System.out.println(line);
         }

         buffer.close();
      } catch (IOException e) {
        System.out.println("A reading error has occured.");
      }
   }
}
