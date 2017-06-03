import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class Items extends JFrame {
  private JPanel pannel = new JPanel();

  public static void main( String[] args ) {
    Items gui = new Items();
  }

  String[] toppings = { "Pepperoni", "Mushroom", "Ham", "Tomato" };

  JCheckBox checkBox1 = new JCheckBox( toppings[0] );
  JCheckBox checkBox2 = new JCheckBox( toppings[1], true );
  JCheckBox checkBox3 = new JCheckBox( toppings[2] );
  JCheckBox checkBox4 = new JCheckBox( toppings[3] );

  String[] styles = { "Deep Dish", "Gourmet Styel", "Thin & Crispy" };

  JComboBox<String> box1 = new JComboBox<String>( styles );
  JList<String> list1 = new JList<String>( toppings );

  public Items() {
    super( "Swing Window" );
    setSize( 500, 200 );
    setDefaultCloseOperation( EXIT_ON_CLOSE );

    pannel.add( checkBox1 );
    pannel.add( checkBox2 );
    pannel.add( checkBox3 );
    pannel.add( checkBox4 );

    box1.setSelectedIndex( 0 );
    pannel.add( box1 );

    pannel.add( list1 );

    add( pannel );
    setVisible( true );
  }
}
