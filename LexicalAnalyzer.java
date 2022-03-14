/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lexicalanalyzer;

import java.io.*;
import java.util.*;
/**
 *
 * @author benri
 */
public class LexicalAnalyzer {
    
  //variables
   public static int charClass;
   public static String lexeme = null;
   public static char nextChar;
   public static int token;
   public static int nextToken;
   public static File file;
   public static FileInputStream fis = null;
   //The three Character classes
   public static final int LETTER=0;
   public static final int DIGIT=1;
   public static final int UNKNOWN=99;
   //Token codes
   public static final int EOF=-1;
   public static final int INT_LIT=10;
   public static final int IDENT=11;
   public static final int ASSIGN_OP=20;
   public static final int ADD_OP=21;
   public static final int SUB_OP=22;
   public static final int MULT_OP=23;
   public static final int DIV_OP=24;
   public static final int LEFT_PAREN=25;
   public static final int RIGHT_PAREN=26;
  
  
   //getChar - determines the class of the next input
   public static void getChar() {
       int i;
       try {
           if((i = fis.read())!=-1) {
               nextChar=(char)i;
               if(Character.isLetter(nextChar))
                   charClass=LETTER;
               else if(Character.isDigit(nextChar))
                   charClass=DIGIT;
               else
                   charClass=UNKNOWN;
           }
           else
               charClass=EOF;
       } catch(IOException e) {
       }
   }

   //lookup - looks up operators and parentheses and returns the token
   public static int lookup(char ch) {
       switch (ch) {
           case '(':
               addChar();
               nextToken = LEFT_PAREN;
               break;
           case ')':
               addChar();
               nextToken = RIGHT_PAREN;
               break;
           case '+':
               addChar();
               nextToken = ADD_OP;
               break;
           case '-':
               addChar();
               nextToken = SUB_OP;
               break;
           case '*':
               addChar();
               nextToken = MULT_OP;
               break;
           case '/':
               addChar();
               nextToken = DIV_OP;
               break;
           default:
               addChar();
               nextToken = EOF;
               break;
       }
   return nextToken;
   }
  
   // addChar - adds nextChar to lexeme
   public static void addChar() {
       if (lexeme.length() <= 98) {
           lexeme = lexeme + nextChar;
       } else{
       System.out.println("Error -lexeme is too long\n");
       System.exit(1);
       }
   }
  
  
   //getNonBlank - calls getChar until it returns a non- whitespace character
   public static void getNonBlank() {
       while(Character.isSpaceChar(nextChar))
           getChar();
   }
  
   //lex - a simple lexical analyzer for arithmetic expressions
   public static int lex() {
       lexeme = "";
       getNonBlank();
      
       switch (charClass) {
           /* parse identifiers */
           case LETTER:
               addChar();
               getChar();
               while (charClass == LETTER || charClass == DIGIT) {
                   addChar();
                   getChar();
               }
               nextToken = IDENT;
               break;
           /* parse integer literals */
           case DIGIT:
               addChar();
               getChar();
               while(charClass == DIGIT) {
                   addChar();
                   getChar();
               }
               nextToken = INT_LIT;
               break;
           /* parentheses and operators */
           case UNKNOWN:
               lookup(nextChar);
               getChar();
               break;
           /* EOF */
           case EOF:
               nextToken = EOF;
               lexeme = "EOF";
               break;

       } /* end of switch */
       System.out.printf ("Next token is: %d, Next lexeme is %s\n", nextToken, lexeme);
          
       return nextToken;
   }
  

   public static void main(String args[]){
       file = new File("C://Users//benri//Downloads//FrontText//front.in.txt"); //paste directory to your text file here
       if (!file.exists()) {
           System.out.println("ERROR - cannot open front.in");
           return;
       }
       try{
           fis = new FileInputStream(file);
           while(fis.available()>0) {
               getChar();
               lex();
           }
           getChar();
           lex(); //displaying EOF
       }catch(IOException e){
       }
   }
}
