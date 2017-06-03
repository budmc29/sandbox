import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RequestInput extends JFrame implements ActionListener {
  private JPanel pannel = new JPanel();

  public static void main( String[] args ) {
    RequestInput gui = new RequestInput();
  }

  JTextField field = new JTextField( 38 );
  JButton request_decision = new JButton( "Request Decision" );
  JButton request_input = new JButton( "Request Input" );

  public RequestInput() {
    super( "Swing Window" );
    setSize( 500, 200 );
    setDefaultCloseOperation( EXIT_ON_CLOSE );

    pannel.add( field );
    pannel.add( request_decision );
    pannel.add( request_input );

    request_decision.addActionListener( this );
    request_input.addActionListener( this );

    add( pannel );
    setVisible( true );
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    if ( actionEvent.getSource() == request_decision )
    {
      int confirm_dialog = JOptionPane.showConfirmDialog(
         this, "Do you agree?", "Confirmation Dialog",
          JOptionPane.YES_NO_CANCEL_OPTION
      );
      switch( confirm_dialog )
      {
        case 0 : field.setText( "Agreed" );
          break;
        case 1 : field.setText( "Disagreed" );
          break;
        case 2 : field.setText( "Cancelled" );
          break;
      }
    }

    if ( actionEvent.getSource() == request_input )
    {
      field.setText( JOptionPane.showInputDialog(
         this, "Enter your comment", "Input Dialog",
          JOptionPane.PLAIN_MESSAGE
      ));
    }
  }
}
