import java.awt.*;
import javax.swing.*;

public class Project {
    public static void main(String args[]) {
        JFrame fr = new JFrame("OOP Project");
        JPanel pan = new JPanel();

        fr.setSize(1000,700);
        fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Place JFrame window in center of screen (regardless of different screensizes)
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        fr.setLocation(dim.width/2-fr.getSize().width/2, dim.height/2-fr.getSize().height/2);

        /*
        // Add red panel 
        pan.setSize(350,350);
        pan.setBackground(Color.red);

        fr.add(pan);
        */

        /*
        // Border Layout
        fr.setLayout(new BorderLayout());

        fr.add("East", new JButton("East"));
        fr.add("West", new JButton("West"));
        fr.add("North", new JButton("North"));
        fr.add("South", new JButton("South"));
        fr.add("Center", new JButton("Center"));
        */
         
        // Grid Layout 
        fr.setLayout(new GridLayout(3,2));
        fr.add(new JButton("1"));
        fr.add(new JButton("2"));
        fr.add(new JButton("3"));
        fr.add(new JButton("4"));
        fr.add(new JButton("5"));
        fr.add(new JButton("6"));
        
        fr.setVisible(true);
    }
}