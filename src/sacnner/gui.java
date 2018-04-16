/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacnner;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author yehia
 */
public class gui extends JFrame{
    JLabel label,labelIn,labelout;
    JButton txtIn,ManualIn,enter;
    JTextArea input,output,ManualOut;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();
     int w = width/2;
    int h  = height/2;
    String in = null;
    void init(){
        
        create();
        setLocation(height/2,WIDTH/2);
        setSize(width/2, height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
    }
    void create(){
     this.setLayout(null);
    label = new JLabel("How do you want to enter your input?");
    label.setSize(w/2,h/6);
    label.setLocation(w/4, h/8);
    add(label);
    labelIn = new JLabel("Input:");
    labelIn.setSize((w/2)+10,h/6);
    labelIn.setLocation(w/4, (h/8)-25);
    labelIn.setVisible(false);
    add(labelIn);
    labelout = new JLabel("Output:");
    labelout.setSize(w/2,h/6);
    labelout.setLocation(w/2, (h/8)-25);
    labelout.setVisible(false);
    add(labelout);
    txtIn = new JButton("use text file");
    txtIn.setSize(w/5,h/6);
    txtIn.setLocation(w/7, h/3);
    add(txtIn);
    ManualIn= new JButton("manualy");
    ManualIn.setSize(w/5,h/6);
    ManualIn.setLocation(w/2, h/3);
    add(ManualIn);
    input = new JTextArea();
    input.setSize(w/4,h/4);
    input.setLocation(w/4,  (h/8)+30);
    input.setVisible(false);
    add(input);
    output = new JTextArea();
    output.setSize(w/4,h/4);
    output.setLocation(w/2,  (h/8)+30);
    output.setVisible(false);
    output.setEditable(false);
    add(output);
    enter = new JButton("Enter");
    enter.setSize(w/7,h/8);
    enter.setLocation((w/2)+60,(int)(h/1.8)+100);
    enter.setVisible(false);
    add(enter);
    events();
    }
    void visble(){
          output.setVisible(true);
           enter.setVisible(true);
           ManualIn.setVisible(false);
           txtIn.setVisible(false);
           label.setVisible(false);
           labelIn.setVisible(true);
           labelout.setVisible(true);}
    void events(){
    ManualIn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           input.setVisible(true);
            visble();
        }
        
    });
    enter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           in = input.getText();
           
            try {
                output.setText(Sacnner.scan(in));
            } catch (IOException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    });
    txtIn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
              output.setLocation(w/4,  (h/8)+30);
              output.setSize(w/2,h/2);
              labelIn.setVisible(false);
              add(output);
             visble();
            try {
                output.setText(Sacnner.scan(in));
            } catch (IOException ex) {
                System.out.println("el 3'alta hnaaaa!!!!");
            }
        }
        
    });
    }
    public static void main(String[] args) {
        gui g = new gui();
        g.init();
    }
}
