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

public class Scanner {
     

    public static String replacer(String input){
       String s1 = input.replace("+"," + ");
       String s2 = s1.replace("-"," - ");
       String s3 = s2.replace("*"," * ");
       String s4 = s3.replace("/"," / ");
       String s6 = s4.replace("<"," < ");
       String s7 = s6.replace(">"," > ");
       String s8 = s7.replace("("," ( ");
       String s9 = s8.replace(")"," ) ");
       String s10 = s9.replace(";"," ; ");
       String s11 ="",s5;
       for(int i = 1; i < input.length();i++){
        if(input.charAt(i)== '='){
              if(input.charAt(i-1) == ':')
              {
               s11 = s10.replace(":="," := ");
              }
              else{
               s5 = s10.replace("="," = "); 
              }
        }
          
       
       }
       
      return s11;
     }

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
     * @param I
     * @return 
     * @throws java.io.FileNotFoundException
     * @throws java.io.IOException
     */
   public static String scan(String I) throws FileNotFoundException, IOException{
        // TODO code application logic here
        String answ = "";
        File in = new File("Input.txt");
        BufferedReader br = new BufferedReader(new FileReader(in));
        String s,input = "";
        
        while ((s = br.readLine()) != null){
           input +=s;
  }
        if (!(I.equalsIgnoreCase(""))){
        input = I;
        }
        String  comment ="";
        Scanner sc = new Scanner();
        String In = input.replace(";"," ;");
        String finalIn = replacer(In);
     String[] tokken=finalIn.split("\\s");
         
          
      
        
        for (int i = 0; i < tokken.length; i++) {
            if (sc.isReseved(tokken[i])) {
                answ +="   "  + tokken[i] +"   " +"|"+ "   "  + "Reserved word" +"   "+"\n" ;
            } else if (sc.isSymbol(tokken[i])) {
               
                answ +="   "  + tokken[i] +"   " +"|"+ "   "  + "Symbol" +"   " +"\n"; 
            }else if (sc.isNo(tokken[i])) {
         
                answ +="   "  + tokken[i] +"   " +"|"+ "   "  + "Number" +"   " +"\n"; 
            }
            else if (sc.isIdentifer(tokken[i])) {
               
                answ +="   "  + tokken[i] +"   " +"|"+ "   "  + "Identifier" +"   " +"\n"; 
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
                
                answ +="   "  + comment +"   " +"|"+ "   "  + "Comment" +"   " +"\n"; 
            }
            else{
                answ +="   "  + tokken[i] +"   " +"|"+ "   "  + "ERROR" +"   " +"\n"; 
            }           
        }
       
    return answ;
    }

}