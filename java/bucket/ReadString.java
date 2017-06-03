import java.io.*;

public class ReadString
{
    public static void main(String[] args) {
        System.out.print("Enter string: ");

        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader buffer = new BufferedReader( isr );

        String input = "";

        try
        {
            input = buffer.readLine();
            buffer.close();
        }
        catch (IOException e)
        {
            System.out.println("An input error has occurred.");
        }

        System.out.println("Your input is: " + input);
    }
}
