/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sacnner;

import java.io.*;
import java.util.*;
import org.w3c.dom.CharacterData;

/**
 *
 * @author yehia
 */
public class Sacnner {
     
     boolean isReseved(String s){         
     if(s.equalsIgnoreCase("if") || s.equalsIgnoreCase("then") || s.equalsIgnoreCase("else") || s.equalsIgnoreCase("end")
             || s.equalsIgnoreCase("repeate") || s.equalsIgnoreCase("until") || s.equalsIgnoreCase("read") || s.equalsIgnoreCase("write")){
           
     return true;
     }
     return false;
     }
     boolean isSymbol(String s){
         if (s.equalsIgnoreCase("+") || s.equalsIgnoreCase("-") || s.equalsIgnoreCase("*") || s.equalsIgnoreCase("/") || s.equalsIgnoreCase("=") || s.equalsIgnoreCase("<")
                 || s.equalsIgnoreCase(">") || s.equalsIgnoreCase("(") || s.equalsIgnoreCase(")") || s.equalsIgnoreCase(";") || s.equalsIgnoreCase(":=")
                 ) {
               return true;
         }
         return false;
     }
     boolean isNo(String s){
        try {  
    double d = Double.parseDouble(s);  
           }  
       catch(NumberFormatException e)  
           {  
           return false;  
        }  
  return true;  
     }
     boolean isIdentifer(String s){
         return s.matches("[a-zA-Z]+");
     }
     boolean isComment(String s){
     if(s.charAt(0) == '{'){
          
     }
     return false;
     }
    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        File in = new File("Input.txt");
        BufferedReader br = new BufferedReader(new FileReader(in));
        String s,input = "";
        
        while ((s = br.readLine()) != null){
           input +=s;
  }
        String  comment ="";
        Sacnner sc = new Sacnner();
        String In = input.replace(";"," ;");
     String[] tokken=In.split("\\s");
     
     
        System.out.println("___________________________________________________");
        System.out.println("        Read        " +"|"+ "      Reserved word      ");
        for (int i = 0; i < tokken.length; i++) {
            if (sc.isReseved(tokken[i])) {
                System.out.println("___________________________________________");
                System.out.println("   "  + tokken[i] +"   " +"|"+ "   "  + "Reserved word" +"   " );
            } else if (sc.isSymbol(tokken[i])) {
               System.out.println("___________________________________________");
                System.out.println("   "  + tokken[i] +"   " +"|"+ "   "  + "Symbol" +"   " ); 
            }else if (sc.isNo(tokken[i])) {
               System.out.println("___________________________________________");
                System.out.println("   "  + tokken[i] +"   " +"|"+ "   "  + "Number" +"   " ); 
            }
            else if (sc.isIdentifer(tokken[i])) {
               System.out.println("___________________________________________");
                System.out.println("   "  + tokken[i] +"   " +"|"+ "   "  + "Identifier" +"   " ); 
            }
            else if (tokken[i].equals("")) {
                continue;
            }
            else if (tokken[i].charAt(0) == '{') {
                while (tokken[i].charAt((tokken[i].length())-1) != '}') {                    
                   comment += tokken[i] + " "; 
                   i++;
                }
                comment += tokken[i];
                 System.out.println("___________________________________________");
                System.out.println("   "  + comment +"   " +"|"+ "   "  + "Comment" +"   " ); 
            }
            else{
            System.out.println("___________________________________________");
                System.out.println("   "  + tokken[i] +"   " +"|"+ "   "  + "other" +"   " ); 
            }           
        }
    }    
}
