/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacnner;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.*;

/**
 *
 * @author yehia
 */
public class gui extends JFrame{
    JLabel label;
    JButton txtIn,ManualIn;
    JTextArea input,output;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();
    
    void init(){
        
        create();
        setLocation(height/2,WIDTH/2);
        setSize(width/2, height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
    }
    void create(){
        
    label = new JLabel("How do you want to enter your input?");
    label.setBounds(width/2, height/5, WIDTH/7, HEIGHT/7);
    add(label);
    }
    public static void main(String[] args) {
        gui g = new gui();
        g.init();
    }
}
