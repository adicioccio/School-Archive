// Adam Di Cioccio and Damien Manno
// Daniel Cormier - Lab section 304
// February 20, 2022

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class PiccrossGame {

    // Game Functionalities
    static private int count = 0;
    static private int score = 0;
    static private int duration = 6000;
    static private boolean markMode;
    static private boolean gameRunning = true;
    static private ArrayList<Tile> tiles = new ArrayList<Tile>();

    // Splash Screen Components
    static final JFrame splashScreen = new JFrame();
    static final JPanel splashPanel = new JPanel();
    static final JLabel splashImage = new JLabel();
    static final ImageIcon splashPic = new ImageIcon("piccross_splash.jpg");

    // File Menu Components
    static final JMenu gameMenu = new JMenu("Game");
    static final JMenuItem newItem = new JMenuItem("New");
    static final JMenu debugItem = new JMenu("Debug");
    static final JMenuItem exitItem = new JMenuItem("Exit");

    // Network Menu Components
    static final JMenu networkMenu = new JMenu("Network");
    static final JMenuItem connectItem = new JMenuItem("Connect");
    static final JMenuItem disconnectItem = new JMenuItem("Disconnect");

    // Help Menu Components
    static final JMenu helpMenu = new JMenu("Help");
    static final JMenuItem solutionItem = new JMenuItem("Solution");
    static final JMenuItem aboutItem = new JMenuItem("About");

    // Main GUI Panels
    static final JFrame frame = new JFrame();
    static final JPanel background = new JPanel();
    static final JPanel mainPanel = new JPanel();
    static final JPanel sidePanel = new JPanel();
    static final JPanel bottomPanel = new JPanel();

    // Other Components
    static final JTextField userInputArea = new JTextField();
    static final JCheckBox mark = new JCheckBox(" MARK");
    static Controller buttonHandler;
    static JButton[] myButtons = new JButton[35];
    static final String[] BUTTON_NAMES = new String[] {
                  "01", "02", "03", "04", "05",
            "10", "11", "12", "13", "14", "15",
            "20", "21", "22", "23", "24", "25",
            "30", "31", "32", "33", "34", "35",
            "40", "41", "42", "43", "44", "45",
            "50", "51", "52", "53", "54", "55"
    };
    static final String[] BUTTON_ACTION = new String[] {
                  "01", "02", "03", "04", "05",
            "10", "11", "12", "13", "14", "15",
            "20", "21", "22", "23", "24", "25",
            "30", "31", "32", "33", "34", "35",
            "40", "41", "42", "43", "44", "45",
            "50", "51", "52", "53", "54", "55"
    };
    static final ImageIcon names = new ImageIcon("piccross_names.jpg");
    static final JLabel nameImage = new JLabel();
    static final JPanel whiteBox1 = new JPanel();
    static final JPanel whiteBox2 = new JPanel();
    private static final JLabel points = new JLabel("Points: " + score);
    private static final TextArea output = new TextArea();
    static final JLabel timer = new JLabel("Timer: 0s");
    static final JButton reset = new JButton("RESET");

    private static void SplashWindow() {

        // ---------------------- SPLASH SCREEN ---------------------- \\

        splashPanel.setLayout(new BorderLayout());
        splashPanel.setOpaque(true);
        splashPanel.setBackground(Color.GRAY);

        splashImage.setPreferredSize(new Dimension(500, 386));
        splashImage.setIcon(splashPic);
        splashImage.setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        splashPanel.add(splashImage, BorderLayout.CENTER);
        splashScreen.add(splashPanel, BorderLayout.CENTER);

        splashScreen.setResizable(false);
        splashScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        splashScreen.setTitle("SPLASH SCREEN");
        splashScreen.setVisible(true);
        splashScreen.pack();

        try {
            Thread.sleep(duration);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        splashScreen.dispose();
    }

    private PiccrossGame() {
        // ---------------------- LOOK & FEEL ---------------------- \\

        UIManager.LookAndFeelInfo[] LAFIArray = UIManager.getInstalledLookAndFeels();
        try { UIManager.setLookAndFeel(LAFIArray[3].getClassName());
            /* Where 0 = Swing classic 1 = Mac style 2 = Some other style? 3 = Windows 4 = Old Windows */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ----------------------  NEW MENU  ---------------------- \\

        newItem.setMnemonic('N');
        gameMenu.add(newItem);
        newItem.addActionListener(new ActionListener() // anonymous inner class
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                reset(true);
            }
        });


        String[] debug = { "Filled", "Corners", "Blank" };

        JRadioButtonMenuItem[] debugItems = new JRadioButtonMenuItem[debug.length];
        ButtonGroup debugGroup = new ButtonGroup(); // manages colors
        ItemHandler itemHandler = new ItemHandler(); // handler for colors

        for (int count = 0; count < debug.length; count++) {
            debugItems[count] = new JRadioButtonMenuItem(debug[count]); // create item
            debugItem.add(debugItems[count]); // add item to color menu
            debugGroup.add(debugItems[count]); // add to group
            debugItems[count].addActionListener(itemHandler);
        }

        debugItem.setMnemonic('D');
        gameMenu.add(debugItem);

        exitItem.setMnemonic('E');
        gameMenu.add(exitItem);
        exitItem.addActionListener(new ActionListener() // anonymous inner class
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0); // exit application
            }
        });

        // ----------------------  NETWORK MENU  ---------------------- \\
        connectItem.setMnemonic('C');
        networkMenu.add(connectItem);
        connectItem.addActionListener(new ActionListener() // anonymous inner class
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                PiccrossNetworkModalVC p = new PiccrossNetworkModalVC(frame);
                Point thisLocation = getLocation();
                Dimension parentSize = getSize();
                Dimension modalSize = p.getSize();
                int offsetX = (parentSize.width-modalSize.width)/2+thisLocation.x;
                int offsetY = (parentSize.height-modalSize.height)/2+thisLocation.y;
                p.setLocation(offsetX,offsetY);
                p.setVisible(true);
            }
        });

        disconnectItem.setMnemonic('D');
        disconnectItem.setEnabled(false);
        networkMenu.add(disconnectItem);
        disconnectItem.addActionListener(new ActionListener() // anonymous inner class
        {
            @Override
            public void actionPerformed(ActionEvent event) {

            }
        });

        // ----------------------  HELP MENU  ---------------------- \\

        solutionItem.setMnemonic('S');
        helpMenu.add(solutionItem);
        solutionItem.addActionListener(new ActionListener() // anonymous inner class
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                int tileCount = 6;
                for (int i = 0; i < tiles.size(); i++) {
                    if (tiles.get(i).getBomb()) {
                    } else {
                        myButtons[tileCount].setText("X");
                    }
                    tileCount++;
                    if (tileCount == 11 || tileCount == 17 || tileCount == 23 || tileCount == 29) {
                        tileCount++;
                    }
                }
            }
        });

        aboutItem.setMnemonic('A');
        helpMenu.add(aboutItem);
        aboutItem.addActionListener(new ActionListener() // anonymous inner class
        {
            @Override
            public void actionPerformed(ActionEvent event) {
                JOptionPane.showMessageDialog(frame, "PICCROSS GAME\nThis program was created by,\nAdam Di Cioccio and Damien Manno\nWINTER 2022",
                        "About", JOptionPane.PLAIN_MESSAGE);
            }
        });

        // ---------------------- MENU BAR ---------------------- \\

        JMenuBar bar = new JMenuBar();
        frame.setJMenuBar(bar);

        bar.add(gameMenu);
        bar.add(networkMenu);
        bar.add(helpMenu);

        // ---------------------- MAIN FRAME ---------------------- \\

        mainPanel.setLayout(new GridLayout(6,6));
        sidePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        background.setLayout(new BorderLayout());

        mainPanel.setOpaque(true);
        sidePanel.setOpaque(true);
        background.setOpaque(true);

        mainPanel.setBackground(Color.blue);
        sidePanel.setBackground(Color.gray);

        // ---------------------- MAIN PANEL ---------------------- \\

        mark.setOpaque(true);
        mark.setBackground(Color.white);
        mainPanel.add(mark);

        buttonHandler = new Controller();

        for (int i = 0; i < myButtons.length; i++) {
            myButtons[i] = createButton(BUTTON_NAMES[i], BUTTON_ACTION[i], buttonHandler);
        }

        for (int i = 0; i < myButtons.length; i++) {
            mainPanel.add(myButtons[i]);
        }

        for (int i = 0; i < 5; i++ ) {
            myButtons[i].setText("(?)");
            myButtons[i].setBackground(Color.orange);
            myButtons[i].setOpaque(true);
            myButtons[i].setEnabled(false);
            myButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }

        for (int i = 5; i <= 29; i+=6) {
            myButtons[i].setText("(?)");
            myButtons[i].setBackground(Color.orange);
            myButtons[i].setOpaque(true);
            myButtons[i].setEnabled(false);
            myButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
        }


        // ---------------------- SIDE PANEL ---------------------- \\

        nameImage.setPreferredSize(new Dimension(200, 135));
        nameImage.setIcon(names);

        whiteBox1.setPreferredSize(new Dimension(200, 30));
        whiteBox2.setPreferredSize(new Dimension(200, 30));
        whiteBox1.add(points);
        whiteBox2.add(timer);

        output.setPreferredSize(new Dimension(200, 360));
        output.setEditable(false);

        reset.setPreferredSize(new Dimension(120, 40));

        sidePanel.add(nameImage);
        sidePanel.add(whiteBox1);
        sidePanel.add(output);
        sidePanel.add(whiteBox2);
        sidePanel.add(reset);

        mainPanel.setPreferredSize(new Dimension(600, 600));
        sidePanel.setPreferredSize(new Dimension(200, 600));

        background.add(mainPanel, BorderLayout.WEST);
        background.add(sidePanel, BorderLayout.EAST);

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                reset(false);
            }
        });

        mark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                markMode = mark.isSelected();
            }
        });

        // ---------------------- INPUT BAR ---------------------- \\
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 5));
        bottomPanel.setOpaque(true);
        bottomPanel.setBackground(Color.gray);
        bottomPanel.setPreferredSize(new Dimension(800, 35));

        userInputArea.setPreferredSize(new Dimension(790, 25));
        bottomPanel.add(userInputArea);

        background.add(bottomPanel, BorderLayout.SOUTH);

        userInputArea.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = userInputArea.getText();
                userInputArea.setText("");
                System.out.println("User entered: " + input);
            }
        });

        // ---------------------- MAIN FRAME ---------------------- \\

        frame.add(background, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Piccross Client");
        frame.setVisible(true);
        frame.pack();

    }

    private static void startTimer() {

        for(;;) {
            try {
                Thread.sleep(1000);
                count ++;
                if (gameRunning) {
                    timer.setText("Timer: " + count + "s");
                }
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    private JButton createButton(String dn, String ac, Controller hn) {

        JButton newButton = new JButton();

        newButton.setText("");
        newButton.setActionCommand(ac);

        newButton.addActionListener(hn);
        return newButton;
    }

    public static class Controller implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //output.append(e.getActionCommand() + " was pressed.\n");
            int button = Integer.parseInt(e.getActionCommand());

            int tileCount = 6;
            for (int i = 0; i < tiles.size(); i++) {
                if (tiles.get(i).getLoc() == button) {
                    if (tiles.get(i).getBomb() && !markMode) {
                        myButtons[tileCount].setBackground(Color.red);
                        myButtons[tileCount].setText("X");
                        points.setText("Points: " + --score);
                        output.append("-1\n");

                    } else if (markMode) {
                        myButtons[tileCount].setBackground(Color.blue);
                        myButtons[tileCount].setText("X");
                        tiles.get(i).setMark(true);

                    } else {
                        myButtons[tileCount].setBackground(Color.black);
                        points.setText("Points: " + ++score);
                        output.append("+1\n");
                    }
                    myButtons[tileCount].setOpaque(true);
                    myButtons[tileCount].setEnabled(false);
                    tiles.get(i).setSelect(true);
                    update();
                }
                tileCount++;
                if (tileCount == 11 || tileCount == 17 || tileCount == 23 || tileCount == 29) {
                    tileCount++;
                }

            }
        }
    }

    public static class ItemHandler implements ActionListener {
        // process color and font selections
        @Override
        public void actionPerformed(ActionEvent e) {
            output.append(e.getActionCommand() + " loaded.\n");
            int preset = 0;
            if (e.getActionCommand() == "Filled") {
                preset = 1;
            } else if (e.getActionCommand() == "Corners") {
                preset = 2;
            } else {
                preset = 3;
            }
            reset(true);
            newGame(preset);
        }
    }

    public static void update() {
        int count = 0;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getSelect()) {
                count++;
            }
        }

        if (count == 25) {
            gameComplete();
        }
    }

    public static void gameComplete() {
        int c = 0;
        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getMark() && tiles.get(i).getBomb()) {
                c++;
            }
        }
        int total = score+c;

        String title;
        if (total == 25) {
            title = "Winner!";
        } else {
            title = "Game over";
        }

        gameRunning = false;

        JOptionPane.showMessageDialog(frame, "Your score: " + total + "/25\nTime taken: " + count + "s",
                title, JOptionPane.PLAIN_MESSAGE);
        output.append("Your score: " + total + "/25\nTime taken: " + count + "s\n");
    }

    public static void newGame(int preset) {
        tiles.clear();

        if (preset == 0) {
            for(int i = 11; i <= 51; i+=10) {
                for(int j = i; j <= i+4; j++) {
                    Random rb = new Random();
                    Tile t = new Tile(rb.nextBoolean(), j);
                    tiles.add(t);
                }
            }
        } else if (preset == 1) { //Filled
            for(int i = 11; i <= 51; i+=10) {
                for(int j = i; j <= i+4; j++) {
                    Tile t = new Tile(false, j);
                    tiles.add(t);
                }
            }
        } else if (preset == 2) { //corners
            for(int i = 11; i <= 51; i+=10) {
                for(int j = i; j <= i+4; j++) {
                    if (j == 11 || j == 15 || j == 51 || j == 55) {
                        Tile t = new Tile(false, j);
                        tiles.add(t);
                    } else {
                        Tile t = new Tile(true, j);
                        tiles.add(t);
                    }
                }
            }
        } else { //blank
            for(int i = 11; i <= 51; i+=10) {
                for(int j = i; j <= i+4; j++) {
                    Tile t = new Tile(true, j);
                    tiles.add(t);
                }
            }
        }

        String safeOutput = "";
        int safeCounter = 0;
        int loops = 5;

        for (int j = 0; j <= 24; j+=5) {
            for (int i = j; i <= j+4; i++) {
                if (tiles.get(i).getBomb() == false) {
                    safeCounter++;
                } else {
                    if (safeCounter != 0) {
                        safeOutput += Integer.toString(safeCounter) + " ";
                    }
                    safeCounter = 0;
                }
            }
            if (safeCounter != 0) {
                safeOutput += Integer.toString(safeCounter);
            }
            myButtons[loops].setText(safeOutput); //good
            loops+=6;
            safeOutput = "";
            safeCounter = 0;
        }

        loops = 0;

        for (int j = 0; j<=4; j++) {
            for (int i = j; i<=j+20; i+=5) {
                if (!tiles.get(i).getBomb()) {
                    safeCounter++;
                } else {
                    if (safeCounter != 0) {
                        safeOutput += "<html>" + Integer.toString(safeCounter) + "<br>";
                    }
                    safeCounter = 0;
                }
            }
            if (safeCounter != 0) {
                safeOutput += Integer.toString(safeCounter);
            }
            myButtons[loops].setText(safeOutput); //good
            loops++;
            safeOutput = "";
            safeCounter = 0;
        }


    }

    public static void reset(boolean newGame) {
        output.setText("");
        score = 0;
        points.setText("Points: 0");
        count = -1;
        timer.setText("Resetting...");

        int tileCount = 6;
        for (int i = 0; i < tiles.size(); i++) {
            myButtons[tileCount].setBackground(Color.blue);
            myButtons[tileCount].setOpaque(true);
            myButtons[tileCount].setEnabled(true);
            myButtons[tileCount].setText("");
            tiles.get(i).setMark(false);
            tiles.get(i).setSelect(false);

            tileCount++;
            if (tileCount == 11 || tileCount == 17 || tileCount == 23 || tileCount == 29) {
                tileCount++;
            }

        }
        gameRunning = true;

        if (newGame) {
            newGame(0);
        }

    }

    public Point getLocation() {
       return frame.getLocation();
    }

    public Dimension getSize() {
        return frame.getSize();
    }

    public static void main (String[] args) {

        if(args.length == 1){
            try{
                duration = Integer.parseInt(args[0]);
            }catch (NumberFormatException mfe){
                System.out.println("Wrong command line argument: must be an integer number");
                System.out.println("The default duration 10000 milliseconds will be used");
                //mfe.printStackTrace();
            }
        }

        // Create Splash Screen
        //SplashWindow();

        // Start main application
        PiccrossGame p = new  PiccrossGame();
        newGame(0);

        // Start timer
        startTimer();



    }
}