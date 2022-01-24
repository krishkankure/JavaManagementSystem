package mgmt;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MainGUI extends Load {
    public void mainScreen(){

        //Creating the Frame
        JFrame frame = new JFrame("KUIS Beta 1.1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 100);

        //Creating the MenuBar and adding components
        JMenuBar mb = new JMenuBar();
        JMenu m1 = new JMenu("User");
        JMenu m2 = new JMenu("Help");
        mb.add(m1);
        mb.add(m2);
        JMenuItem m11 = new JMenuItem("New User");
        JMenuItem m22 = new JMenuItem("Delete all users");
        JMenuItem m33 = new JMenuItem("Info");
        m1.add(m11);
        m1.add(m22);
        m2.add(m33);
        //Creating the panel at bottom and adding components
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Search user");
        JTextField tf = new JTextField(10);
        JButton send = new JButton("Search");
        JButton reset = new JButton("Clear");
        panel.add(label); 
        panel.add(tf);
        panel.add(send);
        panel.add(reset);

        // Text Area at the Center
        JTextArea ta = new JTextArea();

        //Adding Components to the frame.
        frame.getContentPane().add(BorderLayout.SOUTH, panel);
        frame.getContentPane().add(BorderLayout.NORTH, mb);
        frame.getContentPane().add(BorderLayout.CENTER, ta);
        frame.setVisible(true);
        boolean finished = true;
        while(finished) {
            if(m33.getModel().isPressed()) {
                System.out.println("bug test");
                helpWindow();
            }
        }
    } 
    public void helpWindow() {
        // creating the window
        JFrame frame1 = new JFrame("Help");
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.setSize(500, 200);

        JPanel body = new JPanel();
        JLabel titleText = new JLabel("KUIS Beta 1.1 Help");
        JLabel words = new JLabel("KUIS stands for Kankure User Interface Software. User the bar on the top to navigate. Use the search bar to search for users.");
        body.add(titleText);
        body.add(words);
        frame1.getContentPane().add(BorderLayout.CENTER, body);
        frame1.setVisible(true);
    }

}