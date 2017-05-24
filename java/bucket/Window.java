package bucket;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
  private JPanel pannel = new JPanel();

  public static void main( String[] args ) {
    Window gui = new Window();
  }

  public Window() {
    super( "Swing Window" );
    setSize( 500, 200 );
    setDefaultCloseOperation( EXIT_ON_CLOSE );

    add( pannel );
    setVisible( true );
  }
}
