import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Window extends JFrame implements ActionListener{
    private Drawing drawPanel = new Drawing();

    public Window(String Title, int x, int y)
    {

        super(Title);
        this.setSize(x,y);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container contentPanel = this.getContentPane() ;

//MENU
        JMenuBar m = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuAbout = new JMenu("About");

        JMenuItem Open = new JMenuItem("Open") ;
        Open.addActionListener(this);
        JMenuItem New = new JMenuItem("New") ;
        New.addActionListener(this);
        JMenuItem Save = new JMenuItem("Save") ;
        Save.addActionListener(this);
        JMenuItem Quit = new JMenuItem("Quit") ;
        Quit.addActionListener(this);
        JMenuItem Credits = new JMenuItem("Credits");
        Credits.addActionListener(this);
        menuFile.add(Open);
        menuFile.add(New);
        menuFile.add(Save);
        menuFile.add(Quit);
        menuAbout.add(Credits);
        m.add(menuFile);
        m.add(menuAbout);
        contentPanel.add(m,"North");

        JPanel panneau= new JPanel();
        panneau.setLayout(new GridLayout(2,6));


//BOUTONS

        JButton Black= new JButton("Black");
        Black.addActionListener(this);
        JButton Yellow= new JButton("Yellow");
        Yellow.addActionListener(this);
        JButton Red= new JButton("Red");
        Red.addActionListener(this);
        JButton Pink= new JButton("Pink");
        Pink.addActionListener(this);
        JButton Green= new JButton("Green");
        Green.addActionListener(this);
        JButton Magenta= new JButton("Magenta");
        Magenta.addActionListener(this);
        JButton Blue= new JButton("Blue");
        Blue.addActionListener(this);
        JButton Orange= new JButton("Orange");
        Orange.addActionListener(this);

        /*final int BI_WIDTH = 100;
        final int BI_HEIGHT = 50;
        BufferedImage lineImage = new BufferedImage(BI_WIDTH, BI_HEIGHT,
                BufferedImage.TYPE_INT_RGB);
        lineImage.createGraphics().drawOval(2, 5, 100, 25);
        JButton Ellipse = new JButton("Ellipse");
        Ellipse.setIcon(new ImageIcon(lineImage)); */

        JButton Ellipse= new JButton("Ellipse");
        Ellipse.addActionListener(this);
        JButton Rectangle= new JButton("Rectangle");
        Rectangle.addActionListener(this);
        JButton Circle= new JButton("Circle");
        Circle.addActionListener(this);
        JButton Square= new JButton("Square");
        Square.addActionListener(this);

        Black.setBackground(Color.black);
        Yellow.setBackground(Color.yellow);
        Red.setBackground(Color.red);
        Pink.setBackground(Color.pink);
        Green.setBackground(Color.green);
        Magenta.setBackground(Color.magenta);
        Blue.setBackground(Color.blue);
        Orange.setBackground(Color.orange);

        panneau.add(Black);
        Black.setOpaque(true);
        panneau.add(Yellow);
        Yellow.setOpaque(true);
        panneau.add(Red);
        Red.setOpaque(true);
        panneau.add(Pink);
        Pink.setOpaque(true);
        panneau.add(Ellipse);
        panneau.add(Rectangle);
        panneau.add(Green);
        Green.setOpaque(true);
        panneau.add(Magenta);
        Magenta.setOpaque(true);
        panneau.add(Blue);
        Blue.setOpaque(true);
        panneau.add(Orange);
        Orange.setOpaque(true);
        panneau.add(Circle);
        panneau.add(Square);


        contentPanel.add(panneau,"South");
        contentPanel.add(drawPanel);
        this.setJMenuBar(m);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();
        switch (cmd) {
            case "Black":
                System.out.println("Black has been selected");
                drawPanel.setC(Color.black);
                break;
            case "Red":
                System.out.println("Red has been selected");
                drawPanel.setC(Color.red);
                break;
            case "Blue":
                System.out.println("Blue has been selected");
                drawPanel.setC(Color.blue);
                break;
            case "green":
                System.out.println("Green has been selected");
                drawPanel.setC(Color.green);
                break;
            case "Yellow":
                System.out.println("Yellow has been selected");
                drawPanel.setC(Color.yellow);
                break;
            case "Pink":
                System.out.println("Pink has been selected");
                drawPanel.setC(Color.pink);
                break;
            case "Magenta":
                System.out.println("Magenta has been selected");
                drawPanel.setC(Color.magenta);
                break;
            case "Orange":
                System.out.println("Orange has been selected");
                drawPanel.setC(Color.orange);
                break;
            case "Ellipse":
                System.out.println("Ellipse has been selected");
                drawPanel.setNameFigure("Ellipse");
                break;
            case "Circle":
                System.out.println("Circle has been selected");
                drawPanel.setNameFigure("Circle");
                break;
            case "Rectangle":
                System.out.println("Rectangle has been selected");
                drawPanel.setNameFigure("Rectangle");
                break;
            case "Square":
                System.out.println("Square has been selected");
                drawPanel.setNameFigure("Square");
                break;
            case "New":
                System.out.println("New has been selected");
                drawPanel.setList(new ArrayList<>());
                break;
            case "Open":
                JFileChooser chooser = new JFileChooser();
                int userSelection = chooser.showOpenDialog(this);
                if (userSelection == JFileChooser.APPROVE_OPTION) {
                    String fileToOpen = chooser.getSelectedFile().getAbsolutePath();
                    drawPanel.read(fileToOpen);
                } else {
                    System.out.println("Save has been cancelled");
                }
                System.out.println("Open has been selected");
                break;
            case "Save":
                JFileChooser chooser2 = new JFileChooser();
                int userSelection2 = chooser2.showSaveDialog(this);
                if (userSelection2 == JFileChooser.APPROVE_OPTION) {
                    String fileToSave = chooser2.getSelectedFile().getAbsolutePath();
                    drawPanel.save(fileToSave);
                }
                else {
                    System.out.println("Save has been cancelled");
                }
                System.out.println("Save has been selected");
                break;
            case "Quit":
                System.out.println("Quit has been selected");
                System.exit(0);
                break;
            case "Credits":
                System.out.println("Credits has been selected");
                JOptionPane Credits = new JOptionPane();
                Credits.showInternalMessageDialog( Credits, "Authors : Jean-Pierre RIEGEL",
                        "Credits",JOptionPane.PLAIN_MESSAGE);
                break;

        }
    }
    public static void main (String args[]){
        Window win = new Window("New Paint",800,600);
    }

}
