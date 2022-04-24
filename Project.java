import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import javax.swing.border.TitledBorder;
import javax.swing.plaf.FontUIResource;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.plaf.DimensionUIResource;
import java.awt.event.ActionEvent;


class Project extends JFrame {
    Font font = new Font("Chalkboard SE", Font.PLAIN, 24);
    Font dayFont = new Font("American Typewriter", Font.BOLD, 40);
    // Declare the Panels
    private  RoundedPanel P1;
    private  RoundedPanel P2;
    private  RoundedPanel P3;
    private  RoundedPanel P4;
    Color darkblue = new Color(82, 94, 117);
    Color beige = new Color(255,240,217);
    Color darkgreen = new Color(120, 147, 138);
    Color green = new Color(146, 186, 146);
    Color yellow = new Color(242, 208, 42);
    Color darkbrown = new Color(152, 124, 74);
    Color subjectColor = new Color(247,216,186);

    // Create main project JFrame with multiple panels inside
    public Project() throws FileNotFoundException, IOException {

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
        P1.setBounds(10,30, 500, 220);
        add(P2);
        P2.setBounds(520,10, 860, 850);
        add(P3);
        P3.setBounds(10,270, 500, 550);
        add(P4);
        P4.setBounds(1390,10, 205, 850);
    }

    // BUDGET TRACKER FUNCTION //
    FlowLayout experimentLayout = new FlowLayout();
    JTextArea area;
    JTable jt;
    String dessous;
    int foodsauv=0;       
    int houssauv=0;
    int cloth=0;
    int tran=0;
    public void BudgetTrackerPanel() throws FileNotFoundException, IOException {    
        P1 = new RoundedPanel();
        P1.setLayout(experimentLayout);

        // Plus buttons under JTable
        JPanel ButtonsPanel = new JPanel();
        ButtonsPanel.setBackground(darkblue);

        // Title panel
        JLabel jl4 = new JLabel();
        ImageIcon imageIcon4 = new javax.swing.ImageIcon(getClass().getResource("assets/img/header-budget.png"));
        Image image4 = imageIcon4.getImage();
        Image newimg4 = image4.getScaledInstance(200,65,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon4 = new ImageIcon(newimg4);
        jl4.setIcon(imageIcon4);
        P1.add(jl4);

            String[] header = { "","Food", "Housing", "Clothing", "Transport" };
            File doc = new File("depenses.txt");
            if(doc.exists()){
                try(BufferedReader obj = new BufferedReader(new FileReader(doc))){
                    String strng;
                    while((strng=obj.readLine())!=null){
                        int sauv=0;
                        int i=0;
                        if(strng.charAt(i)=='F'){
                            i++;
                            while(i<strng.length()){
                                char myChar = strng.charAt(i);
                                sauv*=10;
                                sauv+= Character.getNumericValue(myChar);
                                i++;
                            }
                            foodsauv+=sauv;
                        }
                        else if(strng.charAt(i)=='H'){
                            i++;
                            while(i<strng.length()){
                                char myChar = strng.charAt(i);
                                sauv*=10;
                                sauv+= Character.getNumericValue(myChar);
                                i++;
                            }
                            houssauv+=sauv;
                        }
                        else if(strng.charAt(i)=='C'){
                            i++;
                            while(i<strng.length()){
                                char myChar = strng.charAt(i);
                                sauv*=10;
                                sauv+= Character.getNumericValue(myChar);
                                i++;
                            }
                            cloth+=sauv;
                        }
                        else if(strng.charAt(i)=='T'){
                            i++;
                            while(i<strng.length()){
                                char myChar = strng.charAt(i);
                                sauv*=10;
                                sauv+= Character.getNumericValue(myChar);
                                i++;
                            }
                            tran+=sauv;
                        }
                    }
        
                }
            }
            else{
                doc.createNewFile();
            }
        
            String[][] content = {
                {"","Food", "Housing", "Clothing", "Transport"},
                { "Totals",Integer.toString(foodsauv)+"€", Integer.toString(houssauv)+"€" ,Integer.toString(cloth)+"€" , Integer.toString(tran)+"€"},
            };
            Icon icon =new ImageIcon("assets/img/plusicons.png");
            dessous="Total : "+Integer.toString(foodsauv+houssauv+cloth+tran);
            // JTable initialization
            jt = new JTable(content, header);
            jt.setBounds(30, 40, 200, 300);
            jt.setSize(20, 20);
            jt.isCellEditable(1, 1);
            jt.isCellEditable(1, 2);
            jt.isCellEditable(1, 3);
            jt.isCellEditable(1, 4);
            area = new JTextArea();
            area.append(dessous);
        
        JButton plusfood =new JButton(icon);
        plusfood.setOpaque(false);
        plusfood.setContentAreaFilled(false);
        plusfood.setBorderPainted(false);
        plusfood.setPreferredSize(new DimensionUIResource(80, 30));
        plusfood.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            // Tu crée un objet fenêtre par exemple: 
            JDialog f =new JDialog();
            f.add( new JTextArea("How much did you spend on FOOD?"));
            f.setLayout(new FlowLayout());
            JTextField text = new JTextField(20);
            JButton ok=new JButton("ADD");
            ok.addActionListener(new ActionListener()
            {
            public void actionPerformed(ActionEvent e)
            {
                String s =text.getText();
                FileWriter fw;
                try {
                    fw = new FileWriter("depenses.txt",true);
                    foodsauv=houssauv+Integer.parseInt(s);
                    dessous="Total : "+Integer.toString(foodsauv+houssauv+cloth+tran);
                    jt.setValueAt(Integer.toString(foodsauv)+"€", 1, 1);
            jt.setBounds(30, 40, 200, 300);
            jt.setSize(20, 20);
            area.setText(dessous);
                    fw.write("F"+s+'\n');
                    fw.close();
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
                f.dispose();
            }
            });
            f.add(text);
            f.add(ok);
            f.setSize(350,80);
            
            f.setLocationRelativeTo(null);
            f.setVisible(true);
        }
    });
    JButton plushous =new JButton(icon);
    plushous.setOpaque(false);
    plushous.setContentAreaFilled(false);
    plushous.setBorderPainted(false);
    plushous.setPreferredSize(new DimensionUIResource(80, 30));
    plushous.addActionListener( new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
    // Tu crée un objet fenêtre par exemple: 
        JDialog f =new JDialog();
        f.add( new JTextArea("How much did you spend on HOUSING?"));
        f.setLayout(new FlowLayout());
        JTextField text = new JTextField(20);
        JButton ok=new JButton("ADD");
    ok.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
        String s =text.getText();
        FileWriter fw;
        try {
            fw = new FileWriter("depenses.txt",true);
            houssauv=houssauv+Integer.parseInt(s);    
            dessous="Total : "+Integer.toString(foodsauv+houssauv+cloth+tran);
            jt.setValueAt(Integer.toString(houssauv)+"€", 1, 2);
    jt.setBounds(30, 40, 200, 300);
    jt.setSize(20, 20);
    area.setText(dessous);
            fw.write("H"+s+'\n');
            fw.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        f.dispose();
        }
    });
        f.add(text);
        f.add(ok);
        f.setSize(350,80);
        
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    });
    JButton pluscloth =new JButton(icon);
    pluscloth.setOpaque(false);
    pluscloth.setContentAreaFilled(false);
    pluscloth.setBorderPainted(false);
    pluscloth.setPreferredSize(new DimensionUIResource(80, 30));
    pluscloth.addActionListener( new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
    // Tu crée un objet fenêtre par exemple: 
        JDialog f =new JDialog();
        f.add( new JTextArea("How much did you spend on CLOTHING?"));
        f.setLayout(new FlowLayout());
        JTextField text = new JTextField(20);
        JButton ok=new JButton("ADD");
    ok.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
        String s =text.getText();
        FileWriter fw;
        try {
            fw = new FileWriter("depenses.txt",true);
            cloth=cloth+Integer.parseInt(s);
            dessous="Total : "+Integer.toString(foodsauv+houssauv+cloth+tran);
            jt.setValueAt(Integer.toString(cloth)+"€", 1, 3);
    jt.setBounds(30, 40, 200, 300);
    jt.setSize(20, 20);
    area.setText(dessous);
            fw.write("C"+s+'\n');
            fw.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        f.dispose();
        }
    });
        f.add(text);
        f.add(ok);
        f.setSize(350,80);
        
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    });
    JButton plustran =new JButton(icon);
    plustran.setOpaque(false);
    plustran.setContentAreaFilled(false);
    plustran.setBorderPainted(false);
    plustran.setPreferredSize(new DimensionUIResource(80, 30));
    plustran.addActionListener( new ActionListener()
    {
    public void actionPerformed(ActionEvent e)
    {
    // Tu crée un objet fenêtre par exemple: 
        JDialog f =new JDialog();
        f.add( new JTextArea("How much did you spend on TRANSPORT?"));
        f.setLayout(new FlowLayout());
        JTextField text = new JTextField(20);
        JButton ok=new JButton("ADD");
    ok.addActionListener(new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
        String s =text.getText();
        FileWriter fw;
        try {
            fw = new FileWriter("depenses.txt",true);
            tran=tran+Integer.parseInt(s);
            dessous="Total : "+Integer.toString(foodsauv+houssauv+cloth+tran);
            jt.setValueAt(Integer.toString(tran)+"€", 1, 4);
    jt.setBounds(30, 40, 200, 300);
    jt.setSize(20, 20);
    

    area.setText(dessous);
            fw.write("T"+s+'\n');
            fw.close();
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        f.dispose();
        }

    });
        f.add(text);
        f.add(ok);
        f.setSize(350,80);
        
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    });
    setVisible(true);
        P1.add(jt);
        P1.add(area);
        ButtonsPanel.add(plusfood);
        ButtonsPanel.add(plushous);
        ButtonsPanel.add(pluscloth);
        ButtonsPanel.add(plustran);
        P1.add(ButtonsPanel);
    }
    
    String firstname ;
    String last;
    String Birth;
    String Clas;
    int sexe;
    ImageIcon imageIcon ; 
    Image image;
    Image newimg;
    JLabel jl;
    public void StudentPanel() throws FileNotFoundException, IOException {
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
        jl4.setLocation(350,40);
        jl4.setSize(180,100);
        P2.add(jl4);
        File doc = new File("profil.txt");
        if(doc.exists()){
            try(BufferedReader obj = new BufferedReader(new FileReader(doc))){
                String strng;
                strng=obj.readLine();
                if(48==strng.charAt(0)){
                    imageIcon  = new javax.swing.ImageIcon(getClass().getResource("assets/img/studentF.png"));
                }
                else{
                    imageIcon = new javax.swing.ImageIcon(getClass().getResource("assets/img/studentM.png"));
                }
                firstname=obj.readLine();
                last=obj.readLine();
                Birth=obj.readLine();
                Clas=obj.readLine();
                
            }
        }
        else{
            firstname ="Joël";
            last="Courtois";
            Clas="SPE";
            Birth="01/01";
            sexe=0;
            if(sexe==0){
                imageIcon  = new javax.swing.ImageIcon(getClass().getResource("assets/img/studentF.png"));
            }
            else{
                imageIcon = new javax.swing.ImageIcon(getClass().getResource("assets/img/studentM.png"));
            }
            FileWriter fw;
            try {
                            
                fw = new FileWriter("profil.txt",true);
                System.out.println(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                fw.write(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                fw.close();
            } catch (IOException e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
        }
        }
        // Student image
        jl = new JLabel();
        
        image = imageIcon.getImage();
        newimg = image.getScaledInstance(320, 320,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon = new ImageIcon(newimg);
        jl.setIcon(imageIcon);
       

        JLabel firstName = new JLabel("First name: "+firstname);
        firstName.setForeground(darkblue);
        firstName.setFont(font);
        JLabel lastname = new JLabel("Last name: "+last);
        lastname.setForeground(darkblue);
        lastname.setFont(font);
        JLabel classe = new JLabel("Birthday: "+Birth);
        classe.setForeground(darkblue);
        classe.setFont(font);
        JLabel birthday = new JLabel("Class: "+Clas);
        birthday.setForeground(darkblue);
        birthday.setFont(font);
        JLabel averageGrade = new JLabel("Average Grade: 15.6/20");
        averageGrade.setForeground(darkblue);
        averageGrade.setFont(font);
        Icon icon =new ImageIcon("assets/img/stylo.png");

        JButton modifie = new JButton(icon);
        modifie.setOpaque(false);
        modifie.setContentAreaFilled(false);
        modifie.setBorderPainted(false);
        
        modifie.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //show jdialog when button is clicked
                JDialog dialog = new JDialog();
                dialog.setLayout(new FlowLayout());
                JLabel Changea= new JLabel("Do you want to change avatar's sexe ?");
                JButton Ok5=new JButton("YES");
                Ok5.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    
                    if(sexe==0){
                        sexe=1;
                        imageIcon  = new javax.swing.ImageIcon(getClass().getResource("assets/img/studentM.png")); 
                    }
                    else{
                        sexe=0;
                        imageIcon  = new javax.swing.ImageIcon(getClass().getResource("assets/img/studentF.png"));
                    }
        
                    image = imageIcon.getImage();
                     newimg = image.getScaledInstance(320, 320,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
                    imageIcon = new ImageIcon(newimg);
                    jl.setIcon(imageIcon);
                    if(doc.exists()){
                        doc.delete();
                    }
                    FileWriter fw;
                try {
                                
                    fw = new FileWriter("profil.txt",true);
                    System.out.println(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.write(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.close();
                } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
                    }
                });
                JLabel Changen= new JLabel("Change your Firstname :");
                JTextField Fname = new JTextField(10);
                JButton Ok=new JButton("OK");
                Ok.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    String n = Fname.getText();
                    firstname=n;
                       firstName.setText("First name: "+firstname);
                       if(doc.exists()){
                        doc.delete();
                    }
                    FileWriter fw;
                try {
                                
                    fw = new FileWriter("profil.txt",true);
                    System.out.println(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.write(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.close();
                } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
                    }
                });
                JLabel Changel= new JLabel("Change your Lastname :");
                JTextField Lname = new JTextField(10);
                JButton Ok2=new JButton("OK");
                Ok2.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    String n = Lname.getText();
                    last =n;
                       lastname.setText("Last name: "+last);
                       if(doc.exists()){
                        doc.delete();
                    }
                    FileWriter fw;
                try {
                                
                    fw = new FileWriter("profil.txt",true);
                    System.out.println(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.write(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.close();
                } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
                    }
                });
                JLabel Changeb= new JLabel("Change your Birthday exemple : \"31/12/2002\" :");
                JTextField birth = new JTextField(10);
                JButton Ok3=new JButton("OK");
                Ok3.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    String n = birth.getText();
                    Birth=n;
                       classe.setText("Birthday: "+Birth);
                       if(doc.exists()){
                        doc.delete();
                    }
                    FileWriter fw;
                try {
                                
                    fw = new FileWriter("profil.txt",true);
                    System.out.println(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.write(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.close();
                } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
                    }
                });
                JLabel Changec= new JLabel("Change your Class level :");
                JTextField cours = new JTextField(10);
                JButton Ok4=new JButton("OK");
                Ok4.addActionListener(new ActionListener()
                {
                    public void actionPerformed(ActionEvent e)
                    {
                    String n = cours.getText();
                    Clas=n;
                    birthday.setText("Class: "+Clas);
                    if(doc.exists()){
                        doc.delete();
                    }
                    FileWriter fw;
                try {
                                
                    fw = new FileWriter("profil.txt",true);
                    System.out.println(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.write(Integer.toString(sexe)+'\n'+firstname+'\n'+last+'\n'+Birth+'\n'+Clas);
                    fw.close();
                } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            }
                    }
                });
                
       

                dialog.add(Changen);   
                dialog.add(Fname);   
                dialog.add(Ok);   
                dialog.add(Changel);   
                dialog.add(Lname);   
                dialog.add(Ok2);
                dialog.add(Changeb);   
                dialog.add(birth);   
                dialog.add(Ok3); 
                dialog.add(Changec);   
                dialog.add(cours);   
                dialog.add(Ok4);   
                dialog.add(Changea);   
                dialog.add(Ok5);         
                dialog.setSize(520,200);
                dialog.setLocationRelativeTo(null);
                dialog.setVisible(true);
                
            }
        });
        
       
        P2.add(firstName);
        P2.add(lastname);
        P2.add(classe);
        P2.add(birthday);
        P2.add(averageGrade);
        P2.add(modifie);
        P2.add(jl);

        jl.setLocation(90,180); 
        firstName.setLocation(410,210); 
        lastname.setLocation(410,250); 
        classe.setLocation(410,290); 
        birthday.setLocation(410,330); 
        averageGrade.setLocation(410,370); 
        modifie.setLocation(500,430);
        
        jl.setSize(320,320);
        firstName.setSize(400, 80);
        lastname.setSize(400, 80);
        classe.setSize(400, 80);
        birthday.setSize(400, 80);
        averageGrade.setSize(400, 80);
        modifie.setSize(50,50);

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
    

    private DefaultListModel todos;
    private JList list;
    public void ToDoPanel() {
        P3 = new RoundedPanel();

        CardLayout cardLayout = new CardLayout();
        JPanel cards = new JPanel(cardLayout);
        JPanel buttonsPanel = new JPanel();

        // Panel title
        JLabel jl4 = new JLabel();
        ImageIcon imageIcon4 = new javax.swing.ImageIcon(getClass().getResource("assets/img/header-todo.png"));
        Image image4 = imageIcon4.getImage();
        Image newimg4 = image4.getScaledInstance(310,100,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon4 = new ImageIcon(newimg4);
        jl4.setIcon(imageIcon4);


        buttonsPanel.setBackground(darkgreen);
        todos = new DefaultListModel();
        // create JButton for adding a task
        JButton addButton = new JButton( "Add" );
        addButton.addActionListener(
            new ActionListener() {
           
            public void actionPerformed( ActionEvent event )
            {
                String name = JOptionPane.showInputDialog("Enter a new task :3" );
                todos.addElement(name);
            }
        }
        );

        // create JButton for removing a task
        JButton removeButton =
        new JButton( "Remove" );
       
        removeButton.addActionListener(
            new ActionListener() {
           
            public void actionPerformed( ActionEvent event )
            {
                todos.removeElement(
                list.getSelectedValue() );
            }
        }
        );

        buttonsPanel.add(addButton);
        buttonsPanel.add(removeButton);

        list = new JList(todos); 
        list.setFont(font);
        list.setForeground(Color.white);
        list.setPreferredSize(new Dimension(400, 200));
        list.setBackground(darkgreen);

        cards.add(jl4, BorderLayout.PAGE_START);

        P3.add(cards);
        P3.add(buttonsPanel);
        P3.add(list);
    }

    public void SchedulePanel() {
        P4 = new RoundedPanel();
        P4.setLayout(null);

        // Editable textfields
        JTextField day = new JTextField("Monday");
        day.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        day.setHorizontalAlignment(JTextField.CENTER);
        day.setFont(dayFont);
        day.setForeground(yellow);
        day.setBackground(green);
        day.setBounds(5,50, 190,50);
        P4.add(day);

        // Editable subjects || I tried doing a for loop but it wouldn't show up on the app so yeah here are really badly hard-coded textfields
        int separator = 0;
        JTextField subject = new JTextField("Subject");
        subject.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        subject.setHorizontalAlignment(JTextField.CENTER);
        subject.setFont(font);
        subject.setForeground(darkbrown);
        subject.setBackground(subjectColor);
        subject.setBounds(20,130+separator, 155,50);
        separator += 100;
        P4.add(subject);

        JTextField subject2 = new JTextField("Subject");
        subject2.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        subject2.setHorizontalAlignment(JTextField.CENTER);
        subject2.setFont(font);
        subject2.setForeground(darkbrown);
        subject2.setBackground(subjectColor);
        subject2.setBounds(20,130+separator, 155,50);
        separator += 105;
        P4.add(subject2);

        JTextField subject3 = new JTextField("Subject");
        subject3.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        subject3.setHorizontalAlignment(JTextField.CENTER);
        subject3.setFont(font);
        subject3.setForeground(darkbrown);
        subject3.setBackground(subjectColor);
        subject3.setBounds(20,130+separator, 155,50);
        separator += 105;
        P4.add(subject3);

        JTextField subject4 = new JTextField("Subject");
        subject4.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        subject4.setHorizontalAlignment(JTextField.CENTER);
        subject4.setFont(font);
        subject4.setForeground(darkbrown);
        subject4.setBackground(subjectColor);
        subject4.setBounds(20,130+separator, 155,50);
        separator += 105;
        P4.add(subject4);

        JTextField subject5 = new JTextField("Subject");
        subject5.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        subject5.setHorizontalAlignment(JTextField.CENTER);
        subject5.setFont(font);
        subject5.setForeground(darkbrown);
        subject5.setBackground(subjectColor);
        subject5.setBounds(20,130+separator, 155,50);
        separator += 95;
        P4.add(subject5);

        JTextField subject6 = new JTextField("Subject");
        subject6.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        subject6.setHorizontalAlignment(JTextField.CENTER);
        subject6.setFont(font);
        subject6.setForeground(darkbrown);
        subject6.setBackground(subjectColor);
        subject6.setBounds(20,130+separator, 155,50);
        P4.add(subject6);

        // Timetable image 
        JLabel jl = new JLabel();
        ImageIcon imageIcon = new javax.swing.ImageIcon(getClass().getResource("assets/img/timetable.png"));
        Image image = imageIcon.getImage();
        Image newimg = image.getScaledInstance(170, 730,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way 
        imageIcon = new ImageIcon(newimg);
        jl.setIcon(imageIcon);
        jl.setLocation(15,10);
        jl.setSize(170,730);
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
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Project splitPane = new Project();
        splitPane.setVisible(true);
    }
}