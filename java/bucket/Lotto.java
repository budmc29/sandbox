package bucket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Lotto extends JFrame implements ActionListener {

  ClassLoader loader = this.getClass().getClassLoader();
  java.net.URL iconURL = loader.getResource( "lotto.png" );
  ImageIcon icon = new ImageIcon( iconURL );
  JLabel image = new JLabel( icon );
  JTextField text = new JTextField( "", 18 );
  JButton button = new JButton( "Get My Lucky Numbers" );
  JPanel pannel = new JPanel();

  public Lotto()
  {
    super( "Lotto Application" );
    setSize( 800, 400 );
    setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

    pannel.add( image );
    pannel.add( text );
    pannel.add( button );

    button.addActionListener( this );

    add( pannel );
    setVisible( true );
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    if (actionEvent.getSource() == button )
    {
      int[] nums = new int[50];
      String string = "";
      for( int i = 1; i < 50; i++ ) {
        nums[i] = i;
      }
      for( int i = 1; i < 50; i++ )
      {
        int r = (int) ( 49 * Math.random() + 1);
        int temp = nums[i];
        nums[i] = nums[r];
        nums[r] = temp;
      }
      for (int i = 1; i < 7; i++ )
      {
        string += " " + Integer.toString( nums[i]) + " ";
      }
      text.setText( string );
    }
  }

  public static void main ( String[] args)
  {
    Lotto lotto = new Lotto();
  }
}
