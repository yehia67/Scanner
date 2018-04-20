/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package scanner;

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

    int w = (int)(screenSize.getWidth())/2;
    int h  = (int) (screenSize.getHeight())/2;
    
    String in = null;
    void init(){
        
        create();
        setSize(500, 500);
        this.setLocation(screenSize.width/2-this.getSize().width/2, screenSize.height/2-this.getSize().height/2);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true); 
    }
    void create(){
    
    this.add(pnlheader,BorderLayout.NORTH);
    this.add(pnlcenter);
    this.add(pnlButtons,BorderLayout.SOUTH);
    
    label = new JLabel("How do you want to enter your input?");
    pnlheader.add(label, BorderLayout.CENTER);
    
    labelIn = new JLabel("Input:");
    labelIn.setVisible(false);
    
    labelout = new JLabel("Output:");
    labelout.setVisible(false);
    
    input = new JTextArea();
    input.setVisible(false);
    
    output = new JTextArea();
    output.setVisible(false);
    output.setEditable(false);
    
    txtIn = new JButton("Read Code from Text File");
    txtIn.setSize(100,220);
    
    ManualIn= new JButton("Enter Code Manually");
    ManualIn.setSize(100,100);
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.ipady = 40;      //make this component tall
    gbc.weightx = 0.0;
    gbc.gridwidth = 1;
    
    pnlcenter.setLayout(new GridBagLayout());
    gbc.insets=new Insets(0,0,0,50);
    pnlcenter.add(txtIn,gbc);
    gbc.insets=new Insets(0,50,0,0);
    pnlcenter.add(ManualIn,gbc);
    
    pnlButtons.setLayout(new GridBagLayout());
    enter = new JButton("Enter");
    enter.setVisible(false);
    pnlButtons.add(enter);
    
    
    events();
    }
    void visble(){
        
        pnlcenter.removeAll();
        pnlcenter.setLayout(new GridBagLayout());
        gbc.weightx = 1.0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets=new Insets(0,10,0,100);
        gbc.gridy=0;
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
            setSize(1000, 1000);
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
            try {
                setSize(1000, 1000);
                
                txtIn.setVisible(false);
                ManualIn.setVisible(false);
                
                label.setText("Your code has been imported and scanned");
                
                pnlcenter.removeAll();
                pnlcenter.setLayout(new GridBagLayout());            
                
                gbc.weightx = 1.0;
                gbc.anchor = GridBagConstraints.CENTER;
                gbc.fill = GridBagConstraints.BOTH;
                gbc.insets=new Insets(0,0,0,100);   
                gbc.gridy=0;
                pnlcenter.add(labelout,gbc);
                gbc.gridy=1;
                pnlcenter.add(output,gbc);
                output.setVisible(true);
                labelout.setVisible(true);
                output.setText(Scanner.scan(""));

            } catch (IOException ex) {
                Logger.getLogger(gui.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    });
    }
    public static void main(String[] args) {
        gui g = new gui();
        g.init();
    }
}
