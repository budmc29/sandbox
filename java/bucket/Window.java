package bucket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
  private JPanel pannel = new JPanel();

  public static void main( String[] args ) {
    Window gui = new Window();
  }

  ImageIcon tick = new ImageIcon( "tick.png" );
  ImageIcon cross = new ImageIcon( "cross.png" );

  JButton button = new JButton( "Click me" );
  JButton tickButton = new JButton( tick );
  JButton crossButton = new JButton( "STOP", cross );

  public Window() {
    super( "Swing Window" );
    setSize( 500, 200 );
    setDefaultCloseOperation( EXIT_ON_CLOSE );

    pannel.add( button );
    pannel.add( tickButton );
    pannel.add( crossButton );

    add( pannel );
    setVisible( true );

  }
}
