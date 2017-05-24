package bucket;

import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.plaf.DimensionUIResource;

public class Buttons extends JFrame {
  private JPanel pannel = new JPanel();

  ClassLoader loader = this.getClass().getClassLoader();

  public static void main( String[] args ) {
    Buttons gui = new Buttons();
  }

  public Buttons() {
    super( "Swing Window" );
    setSize( 500, 200 );
    setDefaultCloseOperation( EXIT_ON_CLOSE );

    java.net.URL tickURL = loader.getResource( "tick.png" );
    java.net.URL crossURL = loader.getResource( "cross.png" );

    ImageIcon tick = new ImageIcon( tickURL );
    ImageIcon cross = new ImageIcon( crossURL );

    JButton button = new JButton( "Click me" );
    JButton tickButton = new JButton( tick );
    JButton crossButton = new JButton( "STOP", cross );

    pannel.add( button );
    pannel.add( tickButton );
    pannel.add( crossButton );

    add( pannel );
    setVisible( true );

  }
}
