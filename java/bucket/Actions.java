import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

class Actions extends JFrame implements ActionListener {

  public static void main( String[] args ) {
    Actions gui = new Actions();
  }

  private JPanel pannel = new JPanel();

  JButton button1 = new JButton( "Button 1" );
  JButton button2 = new JButton( "Button 2" );
  JTextArea textArea = new JTextArea( 5, 38 );

  public Actions() {
    super( "Swing Window" );
    setSize( 500, 200 );
    setDefaultCloseOperation( EXIT_ON_CLOSE );

    pannel.add( button1 );
    pannel.add( button2 );
    pannel.add( textArea );

    button2.setEnabled( false );
    textArea.setText( "Button 2 is Disabled" );

    add( pannel );
    setVisible( true );

    button1.addActionListener( this );
    button2.addActionListener( this );
  }

  public void actionPerformed( ActionEvent event ) {
    textArea.setText( event.getActionCommand() + " Clicked and Disabled" );

    if ( event.getSource() == button1 ) {
      button2.setEnabled( true );
      button1.setEnabled( false );
    }

    if ( event.getSource() == button2 ) {
      button1.setEnabled( true );
      button2.setEnabled( false );
    }
  }
}
