package bucket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MessageDialog extends JFrame implements ActionListener {
  private JPanel pannel = new JPanel();

  public static void main( String[] args ) {
    MessageDialog gui = new MessageDialog();
  }

  JButton button1 = new JButton( "Show Information Message" );
  JButton button2 = new JButton( "Show Warning Message" );
  JButton button3 = new JButton( "Show Error Message" );

  public MessageDialog() {
    super( "Swing Window" );
    setSize( 500, 200 );
    setDefaultCloseOperation( EXIT_ON_CLOSE );

    pannel.add( button1 );
    pannel.add( button2 );
    pannel.add( button3 );

    button1.addActionListener( this );
    button2.addActionListener( this );
    button3.addActionListener( this );

    add( pannel );
    setVisible( true );
  }

  @Override
  public void actionPerformed(ActionEvent actionEvent) {
    if (actionEvent.getSource() == button1 ) {
      JOptionPane.showMessageDialog( this, "Information...", "Message Dialog", JOptionPane.INFORMATION_MESSAGE);
    }

    if (actionEvent.getSource() == button2 ) {
      JOptionPane.showMessageDialog( this, "Warning...", "Message Dialog", JOptionPane.WARNING_MESSAGE);
    }

    if (actionEvent.getSource() == button3 ) {
      JOptionPane.showMessageDialog( this, "Error...", "Message Dialog", JOptionPane.ERROR_MESSAGE); }
  }
}
