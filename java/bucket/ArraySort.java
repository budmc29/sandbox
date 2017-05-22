package bucket;

import java.util.Arrays;

public class ArraySort
{
  public static void main( String[] args ) {
    String[] names = { "Mike", "Dave", "Andy" };
    int[] nums = { 200, 300, 100 };

    display( names );
    display( nums );

    Arrays.sort( names );
    Arrays.sort( nums );

    display( names );
    display( nums );
  }

  public static void display( String[] elem ) {
    System.out.println( "\nString Array:" );
    for (int i = 0; i < elem.length; i++) {
      System.out.println( "Element " + i + " is " + elem[i] );
    }
  }

  public static void display( int[] elems ) {
    System.out.println( "\nInteger Array:" );
    for ( int i = 0; i < elems.length; i++ ) {
      System.out.println( "Element " + i + " is " + elems[i] );
    }
  }
}
