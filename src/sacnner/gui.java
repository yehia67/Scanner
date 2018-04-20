/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacnner;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
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
    
    GridBagConstraints gbc= new GridBagConstraints();
    
    private JPanel pnlButtons = new JPanel();
    private JPanel pnlcenter = new JPanel();
    private JPanel pnlheader = new JPanel();
    /*int width = (int) screenSize.getWidth();
    int height = (int) screenSize.getHeight();*/
    int w = (int)(screenSize.getWidth())/2;
    int h  = (int) (screenSize.getHeight())/2;
    String in = null;
    void init(){
        
        create();
        setSize(500, 500);
        this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
        //setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
    }
    void create(){
    //this.setLayout(null);
    this.add(pnlheader,BorderLayout.NORTH);
        this.add(pnlcenter);
    this.add(pnlButtons,BorderLayout.SOUTH);
    
    label = new JLabel("How do you want to enter your input?");
    //label.setSize(60,60);
    //label.setLocation(w/4, h/8);
    pnlheader.add(label, BorderLayout.CENTER);
    
    labelIn = new JLabel("Input:");
    //labelIn.setSize(60,60);
    //labelIn.setLocation(w/4, (h/8)-25);
    labelIn.setVisible(false);
    
    labelout = new JLabel("Output:");
    //labelout.setSize(200,200);
    //labelout.setLocation(w/2, (h/8)-25);
    labelout.setVisible(false);
    
    input = new JTextArea();
    //input.setSize(100,100);
    //input.setLocation(w/4,  (h/8)+30);
    input.setVisible(false);
    
    output = new JTextArea();
    /*output.setSize(w/4,h/4);
    output.setLocation(w/2,  (h/8)+30);*/
    output.setVisible(false);
    output.setEditable(false);
    
    /*pnlcenter.setLayout(new GridBagLayout());
    gbc.weightx = 1.0;
    //gbc.weighty = 1.0;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.BOTH;
    //gbc.ipady = 900;
    gbc.insets=new Insets(0,0,0,100);
    gbc.gridy=0;
    //pnlcenter.setSize(200, 200);
    pnlcenter.add(labelIn,gbc);
    gbc.insets=new Insets(0,100,0,0);
    pnlcenter.add(labelout,gbc);
    gbc.gridy=1;
    gbc.insets=new Insets(0,0,0,100);
    pnlcenter.add(input,gbc);
    gbc.insets=new Insets(0,100,0,0);
    pnlcenter.add(output,gbc);*/
    
    
    txtIn = new JButton("Read Code from Text File");
    txtIn.setSize(100,220);
    //txtIn.setLocation(w/7, h/3);
    
    ManualIn= new JButton("Enter Code Manually");
    ManualIn.setSize(100,100);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.ipady = 40;      //make this component tall
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    
    //ManualIn.setLocation(w/2, h/3);
    pnlcenter.setLayout(new GridBagLayout());
    gbc.insets=new Insets(0,0,0,100);
    pnlcenter.add(txtIn,gbc);
    gbc.insets=new Insets(0,100,0,0);
    pnlcenter.add(ManualIn,gbc);
    
    
    
    pnlButtons.setLayout(new GridBagLayout());
    enter = new JButton("Enter");
    //enter.setSize(w/7,h/8);
    //enter.setLocation((w/2)+60,(int)(h/1.8)+100);
    enter.setVisible(false);
    pnlButtons.add(enter);
    
    
    events();
    }
    void visble(){
        
        pnlcenter.removeAll();
        pnlcenter.setLayout(new GridBagLayout());
        gbc.weightx = 1.0;
        //gbc.weighty = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        //gbc.ipady = 60;
        gbc.insets=new Insets(0,0,0,100);
        gbc.gridy=0;
        //pnlcenter.setSize(200, 200);
        pnlcenter.add(labelIn,gbc);
        gbc.insets=new Insets(0,100,0,0);
        pnlcenter.add(labelout,gbc);
        gbc.gridy=1;
        gbc.insets=new Insets(0,0,0,100);
        pnlcenter.add(input,gbc);
        gbc.insets=new Insets(0,100,0,0);
        pnlcenter.add(output,gbc);
        
        output.setVisible(true);  //lw 7asal 7aga 8alat check dool
        enter.setVisible(true);
        ManualIn.setVisible(false);
        txtIn.setVisible(false);
        //label.setVisible(false);
        labelIn.setVisible(true);
        labelout.setVisible(true);
    }
    void events(){
    ManualIn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            label.setText("Enter your code in the input text area provided");
           input.setVisible(true);
            visble();
        }
        
    });
    enter.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           in = input.getText();
           
            try {
                output.setText(Scanner.scan(in));
            } catch (IOException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    });
    txtIn.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            /*output.setLocation(w/4,  (h/8)+30);
            output.setSize(w/2,h/2);
            labelIn.setVisible(false);
            add(output);*/
            pnlcenter.removeAll();
            pnlcenter.setLayout(new GridBagLayout());            
            label.setText("Your code has been imported and scanned");
            gbc.weightx = 1.0;
            //gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.CENTER;
            gbc.fill = GridBagConstraints.BOTH;
            //gbc.ipady = 60;
            gbc.insets=new Insets(0,0,0,100);
            gbc.gridy=0;
            pnlcenter.add(labelout,gbc);
            gbc.gridy=1;
            pnlcenter.add(output,gbc);
             //visble();
            try {
                output.setText(Scanner.scan(in));
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
