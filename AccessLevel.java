/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package accesslevel;

import java.util.Scanner;
/**
 *
 * @author benri
 */

public class AccessLevel {

    public static String AccessLevel(int[] rights, int minPermission)
    {
        String output = "";
        for(int i = 0; i < rights.length ; i++)
        {
            if(rights[i] >= minPermission)
            {
              output = output + "A";
            }
            else
            {
                output = output + "D";
            }
        }
        return output;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        int size;
        do
        {
            System.out.println("How many users do you have?");
            size = s.nextInt();
            if(size > 50)
            {
                System.out.println("Error: There cannot be more than 50 users. Try again.");
            }
        }while(size > 50);
        int[] rights;
        rights = new int[size];
        int minPermission;
        
        for(int i =0; i < size; i++)
        {
            do
            {
               System.out.print("Access level of user " + (i+1) + ": ");
               rights[i] = s.nextInt();
               if(rights[i] > 100)
               {
                   System.out.println("Error: Maximum access level is 100. Try again.");
               }
            }while(rights[i] > 100);
        }
        do
        {
            System.out.println("What is the minimum access level to access this resource?");
            minPermission = s.nextInt();
            if(minPermission > 100)
            {
                System.out.println("Error: Maximum access level is 100. Try again.");
            }
        }while(minPermission > 100);
        System.out.println(AccessLevel(rights, minPermission));
        
    }
    
    
}
