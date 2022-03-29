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


//sample class

class Project extends JFrame {

    //declare the Vertical Pane, Horizontal pane and Panels
    private  JSplitPane VerticalPane;
    private  JSplitPane HorizontalPane;
    private  JPanel  P1;
    private  JPanel  P2;
    Color cl = new Color(190,190,240);

    // Creates main project JFrame with multiple panels inside
    public Project() {
        setTitle("OOP Project");
        //object of the panel
        JPanel PanelObj = new JPanel();
        //set borderlayout for the panel
        PanelObj.setLayout( new BorderLayout() );
        getContentPane().add( PanelObj );
        // Create three different panels
        BudgetTrackerPanel();
        P1.setBackground(cl);

        // Create vertical and horiontal splitter pane
        VerticalPane = new JSplitPane( JSplitPane.VERTICAL_SPLIT );
        PanelObj.add( VerticalPane, BorderLayout.CENTER );
        HorizontalPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        HorizontalPane.setLeftComponent( P1 );
        HorizontalPane.setRightComponent( P2 );
        VerticalPane.setLeftComponent( HorizontalPane );


        // set the Size of frame
        setSize(500, 300);
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



    
    public static void main(String[] args) {
        Project splitPane = new Project();
        splitPane.setVisible(true);
    }
}


