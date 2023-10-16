// Adam Di Cioccio and Damien Manno
// Daniel Cormier - Lab section 304
// February 20, 2022


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PiccrossGame {

    static int count = 0;

    // Menu Components
    private final JFrame frame = new JFrame();
    private final JPanel background = new JPanel();
    private final JPanel mainPanel = new JPanel();
    private final JPanel sidePanel = new JPanel();

    private final JCheckBox mark = new JCheckBox(" MARK");
    private final JLabel display01 = new JLabel("(1)", SwingConstants.CENTER);
    private final JLabel display02 = new JLabel("(2)", SwingConstants.CENTER);
    private final JLabel display03 = new JLabel("(3)", SwingConstants.CENTER);
    private final JLabel display04 = new JLabel("(4)", SwingConstants.CENTER);
    private final JLabel display05 = new JLabel("(5)", SwingConstants.CENTER);
    private final JLabel display10 = new JLabel("(1)", SwingConstants.CENTER);
    private final JButton display11 = new JButton("1,1");
    private final JButton display12 = new JButton("1,2");
    private final JButton display13 = new JButton("1,3");
    private final JButton display14 = new JButton("1,4");
    private final JButton display15 = new JButton("1,5");
    private final JLabel display20 = new JLabel("(2)", SwingConstants.CENTER);
    private final JButton display21 = new JButton("2,1");
    private final JButton display22 = new JButton("2,2");
    private final JButton display23 = new JButton("2,3");
    private final JButton display24 = new JButton("2,4");
    private final JButton display25 = new JButton("2,5");
    private final JLabel display30 = new JLabel("(3)", SwingConstants.CENTER);
    private final JButton display31 = new JButton("3,1");
    private final JButton display32 = new JButton("3,2");
    private final JButton display33 = new JButton("3,3");
    private final JButton display34 = new JButton("3,4");
    private final JButton display35 = new JButton("3,5");
    private final JLabel display40 = new JLabel("(4)", SwingConstants.CENTER);
    private final JButton display41 = new JButton("4,1");
    private final JButton display42 = new JButton("4,2");
    private final JButton display43 = new JButton("4,3");
    private final JButton display44 = new JButton("4,4");
    private final JButton display45 = new JButton("4,5");
    private final JLabel display50 = new JLabel("(5)", SwingConstants.CENTER);
    private final JButton display51 = new JButton("5,1");
    private final JButton display52 = new JButton("5,2");
    private final JButton display53 = new JButton("5,3");
    private final JButton display54 = new JButton("5,4");
    private final JButton display55 = new JButton("5,5");

    private final ImageIcon names = new ImageIcon("piccross_names.jpg");
    private final JLabel nameImage = new JLabel();
    private final JPanel whiteBox1 = new JPanel();
    private final JPanel whiteBox2 = new JPanel();
    private final JLabel points = new JLabel("Points: 00000");
    private final TextArea output= new TextArea();
    private static JLabel timer = new JLabel("Timer: 0s");
    private final JButton reset = new JButton("RESET");


    public PiccrossGame() {
        // ---------------------- LOOK & FEEL ---------------------- \\

        UIManager.LookAndFeelInfo LAFIArray[] = UIManager.getInstalledLookAndFeels();
        try { UIManager.setLookAndFeel(LAFIArray[3].getClassName());
            /* Where 0 = Swing classic 1 = Mac style 2 = Some other style? 3 = Windows 4 = Old Windows */
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

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
        display01.setOpaque(true);
        display02.setOpaque(true);
        display03.setOpaque(true);
        display04.setOpaque(true);
        display05.setOpaque(true);
        display10.setOpaque(true);
        display20.setOpaque(true);
        display30.setOpaque(true);
        display40.setOpaque(true);
        display50.setOpaque(true);

        mark.setBackground(Color.gray);
        display01.setBackground(Color.orange);
        display02.setBackground(Color.orange);
        display03.setBackground(Color.orange);
        display04.setBackground(Color.orange);
        display05.setBackground(Color.orange);
        display10.setBackground(Color.orange);
        display20.setBackground(Color.orange);
        display30.setBackground(Color.orange);
        display40.setBackground(Color.orange);
        display50.setBackground(Color.orange);

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

        mainPanel.add(mark);
        mainPanel.add(display01);
        mainPanel.add(display02);
        mainPanel.add(display03);
        mainPanel.add(display04);
        mainPanel.add(display05);

        mainPanel.add(display10);
        mainPanel.add(display11);
        mainPanel.add(display12);
        mainPanel.add(display13);
        mainPanel.add(display14);
        mainPanel.add(display15);

        mainPanel.add(display20);
        mainPanel.add(display21);
        mainPanel.add(display22);
        mainPanel.add(display23);
        mainPanel.add(display24);
        mainPanel.add(display25);

        mainPanel.add(display30);
        mainPanel.add(display31);
        mainPanel.add(display32);
        mainPanel.add(display33);
        mainPanel.add(display34);
        mainPanel.add(display35);

        mainPanel.add(display40);
        mainPanel.add(display41);
        mainPanel.add(display42);
        mainPanel.add(display43);
        mainPanel.add(display44);
        mainPanel.add(display45);

        mainPanel.add(display50);
        mainPanel.add(display51);
        mainPanel.add(display52);
        mainPanel.add(display53);
        mainPanel.add(display54);
        mainPanel.add(display55);

        sidePanel.add(nameImage);
        sidePanel.add(whiteBox1);
        sidePanel.add(output);
        sidePanel.add(whiteBox2);
        sidePanel.add(reset);

        background.add(mainPanel, BorderLayout.WEST);
        background.add(sidePanel, BorderLayout.EAST);

        mainPanel.setPreferredSize(new Dimension(600, 600));
        sidePanel.setPreferredSize(new Dimension(200, 600));

        frame.add(background, BorderLayout.CENTER);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("PICCROSS");
        frame.setVisible(true);
        frame.pack();

        display11.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("1,1 pressed.\n");
            }
        });
        display12.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("1,2 pressed.\n");
            }
        });
        display13.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("1,3 pressed.\n");
            }
        });
        display14.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("1,4 pressed.\n");
            }
        });
        display15.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("1,5 pressed.\n");
            }
        });

        display21.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("2,1 pressed.\n");
            }
        });
        display22.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("2,2 pressed.\n");
            }
        });
        display23.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("2,3 pressed.\n");
            }
        });
        display24.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("2,4 pressed.\n");
            }
        });
        display25.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("2,5 pressed.\n");
            }
        });
        
        display31.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("3,1 pressed.\n");
            }
        });
        display32.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("3,2 pressed.\n");
            }
        });
        display33.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("3,3 pressed.\n");
            }
        });
        display34.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("3,4 pressed.\n");
            }
        });
        display35.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("3,5 pressed.\n");
            }
        });

        display41.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("4,1 pressed.\n");
            }
        });
        display42.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("4,2 pressed.\n");
            }
        });
        display43.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("4,3 pressed.\n");
            }
        });
        display44.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("4,4 pressed.\n");
            }
        });
        display45.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("4,5 pressed.\n");
            }
        });

        display51.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("5,1 pressed.\n");
            }
        });
        display52.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("5,2 pressed.\n");
            }
        });
        display53.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("5,3 pressed.\n");
            }
        });
        display54.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("5,4 pressed.\n");
            }
        });
        display55.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.append("5,5 pressed.\n");
            }
        });

        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                output.setText("RESET pressed.\nTIMER reset.\n");

                count = -1;
                timer.setText("Resetting...");
            }
        });

        mark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (mark.isSelected()) {
                    output.append("MARK checked.\n");
                } else {
                    output.append("MARK unchecked.\n");
                }
            }
        });

    }

    public static void startTimer() {
        for(;;) {
            try {
                Thread.sleep(1000);
                count ++;
                timer.setText("Timer: " + count + "s");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    public static void main (String[] args) {
        new PiccrossGame();
        startTimer();
    }
}