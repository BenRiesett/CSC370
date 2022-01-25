/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package runlengthencode;

import java.util.Scanner;
/**
 *
 * @author benri
 */
public class RunLengthEncode {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner s = new Scanner(System.in);
        String input;
        int length;
        int errorCode;
        //the do-while loop is for the constraints listed in the project description. Only characters a-z, A-Z, 0-9, and {}[]():;'+=., are accepted by the
        //system as well as input between 0 and 50 characters inclusive
        do
        {
            errorCode = 0;
            System.out.println("Enter text to be encoded: ");
            input = s.nextLine();
            length = input.length();
            if(length > 50)
            {
                System.out.println("Error: Sting length cannot be greater than 50");
                errorCode = 1;
            }
            else
            {
                for(int i = 0; i<length;i++) //ASCII code is used to find the unaccepted characters and if the string contains them it is not accepted
                    {
                       if(input.charAt(i) >= 126 || input.charAt(i) == 124 || input.charAt(i) == 95 || input.charAt(i) == 94 || input.charAt(i) == 92 || input.charAt(i) == 64
                    || input.charAt(i) == 63 || input.charAt(i) == 62 || input.charAt(i) == 60 || input.charAt(i) == 47 || input.charAt(i) == 42 || input.charAt(i) == 38
                    || input.charAt(i) == 37 || input.charAt(i) == 36 || input.charAt(i) == 35 || input.charAt(i) == 34 || input.charAt(i) == 33)
                        {
                System.out.println("Error: Unacceptable Characters Present. Acceptable characters include a-z, A-Z, 0-9, and {}[]():;'+=.,");
                errorCode = 2;
                break;
                        }
                    }
            }
        }while (errorCode != 0);
        
        int i = 0;
        int count = 0;
        char storeChar = input.charAt(0);
        String output = "";
        
        for(i = 0; i<length; i++)
        {
            if(i + 1 < length)
            {
                if(input.charAt(i) == input.charAt(i+1))
                {
                    count++;
                }
                else if (count >= 9)
                {
                    output = output + "/" + Integer.toString(count+1) + storeChar;
                    count = 0;
                    storeChar = input.charAt(i+1);
                }
                else if (count >= 4)
                {
                    output = output + "/0" + Integer.toString(count+1) + storeChar; //if count is a single digit number I added a 0 beforehand to keep everything 2 digit
                    count = 0;
                    storeChar = input.charAt(i+1);
                }
                else
                {
                    for( int ii = 0; ii < count+1; ii++)
                    {
                    output = output + storeChar;
                    }
                    storeChar = input.charAt(i + 1);
                    count = 0;
                }
            }
            else 
            {
                if (count >= 9)
                {
                    output = output + "/" + Integer.toString(count+1) + storeChar;
                }
                else if (count >= 4)
                {
                    output = output + "/0" + Integer.toString(count+1) + storeChar;
                }
                else
                {
                    output = output + storeChar;
                }
            }
        }
        System.out.println("Encoded: " + output);
    }
    
}
