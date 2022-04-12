import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionEvent;


class Project extends JFrame {
    // Declare the 3 Panes and Panels
    private  JSplitPane VerticalPane;
    private  JSplitPane HorizontalPane;
    private  JSplitPane Pane;
    private  RoundedPanel P1;
    private  RoundedPanel P2;
    private  RoundedPanel P3;
    private  RoundedPanel P4;
    Color darkblue = new Color(82, 94, 117);
    Color beige = new Color(255,240,217);
    Color darkgreen = new Color(120, 147, 138);
    Color green = new Color(146, 186, 146);

    // Create main project JFrame with multiple panels inside
    public Project() {

        setLayout(null);

        setTitle("stUwUdent");

        // Hide corners with cute stickers lol
        add(HideCorners("assets/img/hider-sun.png", 500, 790, 80, 80));
        add(HideCorners("assets/img/hider-rabbit.png", 1300, 780, 100, 100));

        // Create three different panels
        BudgetTrackerPanel();
        StudentPanel();
        ToDoPanel();
        SchedulePanel();

        // Set the Size of JFrame
        setSize(1600, 900);
        // Place JFrame window in center of screen (regardless of different screensizes)
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

        P1.setBackground(darkblue);
        P2.setBackground(beige);
        P3.setBackground(darkgreen);
        P4.setBackground(green);

        add(P1);
        P1.setBounds(10,10, 500, 410);
        add(P2);
        P2.setBounds(520,10, 860, 850);
        add(P3);
        P3.setBounds(10,450, 500, 410);
        add(P4);
        P4.setBounds(1390,10, 205, 850);
    }

    public void BudgetTrackerPanel() {
        JTable jt;
        P1 = new RoundedPanel();

        // Panel title
        JLabel jl4 = new JLabel();
        ImageIcon imageIcon4 = new javax.swing.ImageIcon(getClass().getResource("assets/img/header-budget.png"));
        Image image4 = imageIcon4.getImage();
        Image newimg4 = image4.getScaledInstance(200,65,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon4 = new ImageIcon(newimg4);
        jl4.setIcon(imageIcon4);
        P1.add(jl4);
        jl4.setLocation(50,40);

        // Data that will be displayed in JTable
        String[][] content = {
            { "0€", "0€" ,"0€" , "0€"}
        };
        // Names of the column
        String[] header = { "Food", "Housing", "Clothing", "Transport" };

        // JTable initialization
        jt = new JTable(content, header);
        
        P1.add(new JScrollPane(jt));
    }

    public void StudentPanel() {
        P2 = new RoundedPanel();
        P2.setLayout(null);
        //P2.setPreferredSize(new Dimension(900, 190));

        // Panel title
        JLabel jl4 = new JLabel();
        ImageIcon imageIcon4 = new javax.swing.ImageIcon(getClass().getResource("assets/img/header-student-profile.png"));
        Image image4 = imageIcon4.getImage();
        Image newimg4 = image4.getScaledInstance(180,100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon4 = new ImageIcon(newimg4);
        jl4.setIcon(imageIcon4);
        P2.add(jl4);
        jl4.setLocation(350,40);
        jl4.setSize(180,100);
        
        // Student image 
        JLabel jl = new JLabel();
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("assets/img/student.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(320, 320,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon = new ImageIcon(newimg);
        jl.setIcon(imageIcon);
        P2.add(jl);

        Font font = new Font("Chalkboard SE", Font.PLAIN, 24);

        JLabel firstName = new JLabel("First name: Joel");
        firstName.setForeground(darkblue);
        firstName.setFont(font);
        JLabel lastname = new JLabel("Last name: Courtois");
        lastname.setForeground(darkblue);
        lastname.setFont(font);
        JLabel classe = new JLabel("Birthday: 01/01");
        classe.setForeground(darkblue);
        classe.setFont(font);
        JLabel birthday = new JLabel("Class: SPE");
        birthday.setForeground(darkblue);
        birthday.setFont(font);
        JLabel averageGrade = new JLabel("Average Grade: 15.6/20");
        averageGrade.setForeground(darkblue);
        averageGrade.setFont(font);

        P2.add(firstName);
        P2.add(lastname);
        P2.add(classe);
        P2.add(birthday);
        P2.add(averageGrade);

        jl.setLocation(90,180); 
        firstName.setLocation(410,210); 
        lastname.setLocation(410,250); 
        classe.setLocation(410,290); 
        birthday.setLocation(410,330); 
        averageGrade.setLocation(410,370); 
        
        jl.setSize(320,320);
        firstName.setSize(400, 80);
        lastname.setSize(400, 80);
        classe.setSize(400, 80);
        birthday.setSize(400, 80);
        averageGrade.setSize(400, 80);

        // Bottom logo
        JLabel jl2 = new JLabel();
        ImageIcon imageIcon2 = new javax.swing.ImageIcon(getClass().getResource("assets/img/stuwudent-banner.png"));
        Image image2 = imageIcon2.getImage();
        Image newimg2 = image2.getScaledInstance(850,442,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon2 = new ImageIcon(newimg2);
        jl2.setIcon(imageIcon2);
        P2.add(jl2);
        jl2.setLocation(1,400);
        jl2.setSize(850,442);
    }

    public void ToDoPanel() {
        P3 = new RoundedPanel();
        P3.setLayout(null);

        // Panel title
        JLabel jl4 = new JLabel();
        ImageIcon imageIcon4 = new javax.swing.ImageIcon(getClass().getResource("assets/img/header-todo.png"));
        Image image4 = imageIcon4.getImage();
        Image newimg4 = image4.getScaledInstance(260,80,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon4 = new ImageIcon(newimg4);
        jl4.setIcon(imageIcon4);
        P3.add(jl4);
        jl4.setLocation(150,0);
        jl4.setSize(260,80);

        JTextField task;
        task = new JTextField("Enter a new task...");
        task.setBounds(100,100, 150,30);
        P3.add(task);
    }

    public void SchedulePanel() {
        P4 = new RoundedPanel();

        // Timetable image 
        JLabel jl = new JLabel();
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("assets/img/timetable.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(170, 730,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon = new ImageIcon(newimg);
        jl.setIcon(imageIcon);
        P4.add(jl);
    }

    public JLabel HideCorners(String img, int x, int y, int width, int height) {
        JLabel jl = new JLabel();
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource(img));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon = new ImageIcon(newimg);
        jl.setIcon(imageIcon);
        jl.setLocation(x, y);
        jl.setSize(width, height);
        return jl;
    }


    // Implemented Class to make panels with rounded corners
    public class RoundedPanel extends JPanel {

        /** Stroke size. it is recommended to set it to 1 for better view */
        protected int strokeSize = 1;
        /** Color of shadow */
        protected Color shadowColor = Color.black;
        /** Sets if it drops shadow */
        protected boolean shady = true;
        /** Sets if it has an High Quality view */
        protected boolean highQuality = true;
        /** Double values for Horizontal and Vertical radius of corner arcs */
        protected Dimension arcs = new Dimension(40, 40);
        /** Distance between shadow border and opaque panel border */
        protected int shadowGap = 8;
        /** The offset of shadow.  */
        protected int shadowOffset = 12;
        /** The transparency value of shadow. ( 0 - 255) */
        protected int shadowAlpha = 130;
    
        //FOLLOWING CODES GOES HERE
        public RoundedPanel() {
            super();
            setOpaque(false);
        }

        @Override
   protected void paintComponent(Graphics g) {
       super.paintComponent(g);
       int width = getWidth();
       int height = getHeight();
       int shadowGap = this.shadowGap;
       Color shadowColorA = new Color(shadowColor.getRed(),
   shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
       Graphics2D graphics = (Graphics2D) g;

       //Sets antialiasing if HQ.
       if (highQuality) {
           graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
           RenderingHints.VALUE_ANTIALIAS_ON);
       }

       //Draws shadow borders if any.
       if (shady) {
           graphics.setColor(shadowColorA);
           graphics.fillRoundRect(
                   shadowOffset,// X position
                   shadowOffset,// Y position
                   width - strokeSize - shadowOffset, // width
                   height - strokeSize - shadowOffset, // height
                   arcs.width, arcs.height);// arc Dimension
       } else {
           shadowGap = 1;
       }

       //Draws the rounded opaque panel with borders.
       graphics.setColor(getBackground());
       graphics.fillRoundRect(0, 0, width - shadowGap,
       height - shadowGap, arcs.width, arcs.height);
       graphics.setColor(getForeground());
       graphics.setStroke(new BasicStroke(strokeSize));
       graphics.drawRoundRect(0, 0, width - shadowGap,
       height - shadowGap, arcs.width, arcs.height);

       //Sets strokes to default, is better.
       graphics.setStroke(new BasicStroke());
   }
    } 
    
    public static void main(String[] args) {
        Project splitPane = new Project();
        splitPane.setVisible(true);
    }
}