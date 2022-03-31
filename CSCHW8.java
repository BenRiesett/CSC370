

package cschw8;

import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author Ben Riesett
 */
public class CSCHW8 {

        public static String name_generator(int len) {
        //all character string to choose random character from it.
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        //random object created
        Random rand = new Random();
        //creating a string builder of given length
        StringBuilder sb = new StringBuilder(len);
        //for the given length making a random string
        int i = 0;
        while (i < len) {
            sb.append(chars.charAt(rand.nextInt(chars.length())));
            i++;
        }
        return sb.toString();
    }
    public static int randomInt(){
        //defining min and max range to choose a random integer
        int min = 1;
        int max = 99;

        //Generate random int value from 1 to 99
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
    }

    
    
    
    public static void main(String[] args) {
        //creating a hashmap with key as String and value as Integer
        HashMap<String,Integer> people = new HashMap<>();
        //running a loop for 100000 times and putting random name alongside their age in the hashmap
        for(int i=0;i<100000;i++){
            people.put(name_generator(3),randomInt());
        }
        //printing the hashmap
        people.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + " " + entry.getValue());
        });

    }
}

