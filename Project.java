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



class Project extends JFrame {

    // Declare the 3 Panes and Panels
    private  JSplitPane VerticalPane;
    private  JSplitPane HorizontalPane;
    private  JSplitPane Pane;
    private  JPanel  P1;
    private  JPanel  P2;
    private  JPanel  P3;
    private  JPanel  P4;
    Color lightpurple = new Color(190,190,240);
    Color beige = new Color(238,199,154);

    // Create main project JFrame with multiple panels inside
    public Project() {
        setTitle("stUwUdent");
        // Object of the panel
        JPanel PanelObj = new JPanel();
        PanelObj.setLayout( new BorderLayout() );
        getContentPane().add( PanelObj );

        // Create three different panels
        BudgetTrackerPanel();
        HomeworkPanel();
        ToDoPanel();
        SchedulePanel();
        P1.setBackground(lightpurple);
        P2.setBackground(beige);

        // Create vertical and horiontal splitter pane
        VerticalPane = new JSplitPane( JSplitPane.VERTICAL_SPLIT, P1, P3);
        HorizontalPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT, VerticalPane, P2);
        Pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, HorizontalPane, P4);
        PanelObj.add(Pane, BorderLayout.CENTER );

        // Set the Size of JFrame
        setSize(1700, 900);
        // Place JFrame window in center of screen (regardless of different screensizes)
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width/2-getSize().width/2, dim.height/2-getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    }

    public void BudgetTrackerPanel() {
        JTable jt;

        P1 = new JPanel();

        P1.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "My Living Expenses Tracker", TitledBorder.CENTER, TitledBorder.TOP));

        // Data that will be displayed in JTable
        String[][] content = {
            { "0€", "0€" ,"0€" , "0€"}
        };
        // Names of the column
        String[] header = { "Food", "Housing", "Clothing", "Transport" };

        // JTable initialization
        jt = new JTable(content, header);
        jt.setBounds(30, 40, 200, 300);
        
        P1.add(new JScrollPane(jt));
    }

    public void HomeworkPanel() {
        P2 = new JPanel();
        P2.setPreferredSize(new Dimension(900, 190));
        P2.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Homework", TitledBorder.CENTER, TitledBorder.TOP));
    }

    public void ToDoPanel() {
        P3 = new JPanel();
        P3.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "My To-Do List", TitledBorder.CENTER, TitledBorder.TOP));
    }

    public void SchedulePanel() {
        P4 = new JPanel();
        P4.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Today's schedule", TitledBorder.CENTER, TitledBorder.TOP));
    }



    
    public static void main(String[] args) {
        Project splitPane = new Project();
        splitPane.setVisible(true);
    }
}


