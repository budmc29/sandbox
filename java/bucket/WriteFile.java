package bucket;

import java.io.*;

public class WriteFile
{
    public static void main (String[] args) {
        try {
            FileWriter file = new FileWriter( "test.txt");

            BufferedWriter buffer = new BufferedWriter( file );

            buffer.write( "The wind blew as if it had blown its last" );
            buffer.newLine();
            buffer.write( "The rattling showers rose on its blast" );

            buffer.close();
        } catch (IOException e) {
            System.out.println("A write error has occurred.");
        }

        System.out.println("File was written successfully");
    }
}
