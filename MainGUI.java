package mgmt;
import javax.swing.*;
public class MainGUI {
    public void mainScreen() {
        JLabel l=new JLabel("Welcome to the Kankure Management System");
        JFrame f=new JFrame("Kankure Management System");  
        JButton n=new JButton("New User"); 
        JButton c=new JButton("Clear all users");
        n.setBounds(50,100,95,30);
        c.setBounds(350,100,95,30);
        l.setBounds(115, 50, 300, 30);
        f.add(n); 
        f.add(c); 
        f.add(l); 
        f.setSize(500,500);  
        f.setLayout(null);  
        f.setVisible(true); 
        
        
    }
}
