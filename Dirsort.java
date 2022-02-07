/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dirsort;

/**
 *
 * @author benri
 */
public class Dirsort {
    
    
public static String[] Dirsort(String[] dirs)
    {
        int[] numSlashes;
        int mostSlashes = 0;
        String[] sorted;
        sorted = new String[dirs.length];
        numSlashes = new int[dirs.length];
        if(dirs.length > 50)
        {
            System.out.println("Error: There cannot be more than 50 directories.");
            System.exit(-1);
        }
        for(int i = 0; i < dirs.length; i++)
        {
            if(dirs[i].length() > 50)
            {
                System.out.println("Error: Length of any directory cannot be greater than 50.");
                System.exit(-2);
            }
            if(dirs[i].charAt(0) != '/' || dirs[i].charAt((dirs[i].length() - 1)) != '/')
            {
                System.out.println("Error: All directories must begin and end with a slash.");
                System.exit(-3);
            }
            for(int ii = 0; ii < dirs[i].length(); ii++)
            {
                if((dirs[i].charAt(ii) > 'z' || dirs[i].charAt(ii) < 'a') && dirs[i].charAt(ii) != '/')
                {
                    System.out.println(dirs[i].charAt(ii));
                    System.out.println("Error: Directories can only contain  lowercase letters [a-z], inclusive, and the slash ('/') character.");
                    System.exit(-4);
                }
            }
            for(int iii = 0; iii < (dirs[i].length() - 1); iii++)
            {
                if(dirs[i].charAt(iii) == '/' && dirs[i].charAt(iii+1) == '/')
                {
                    System.out.println("Error: Directories cannot contain double slashes (//) anywhere.");
                    System.exit(-5);
                }
            }
        }
        for(int i = 0; i < dirs.length; i++)
        {
            numSlashes[i] = 0;
            for(int ii = 0; ii < dirs[i].length(); ii++)
            {
                if(dirs[i].charAt(ii) == '/')
                {
                   numSlashes[i] = numSlashes[i] + 1; 
                }
            }
            if(numSlashes[i] > mostSlashes)
            {
                mostSlashes = numSlashes[i];
            }
        }
        //the below loop sorts everything in terms of number of slashes
        int a = 0;
        for(int i = 1; i < mostSlashes+1; i++)
        {
            for(int ii = 0; ii < dirs.length; ii++)
            {
                if(numSlashes[ii] == i)
                {
                    sorted[a] = dirs[ii];
                    a++;
                }
            }
        }
        //number of slashes are refound after sorting
        for(int i = 0; i < sorted.length; i++)
        {
            numSlashes[i] = 0;
            for(int ii = 0; ii < sorted[i].length(); ii++)
            {
                if(sorted[i].charAt(ii) == '/')
                {
                   numSlashes[i] = numSlashes[i] + 1; 
                }
            }
        }
        //sorting each level of slashes 
        String temp;
        for(int i = 1; i < mostSlashes+1; i++)
        {
            for(int ii = 0; ii < (sorted.length-1); ii++)
            {
                if(numSlashes[ii] == i && numSlashes[ii+1] == i)
                {
                    if(sorted[ii].compareTo(sorted[ii+1]) > 0)
                    {
                        temp = sorted[ii];
                        sorted[ii] = sorted[ii+1];
                        sorted[ii+1] = temp;
                        ii = 0;
                    }
                }
            }
        }


        return sorted;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    /*System.out.println("\nExample 1:\n");
    String[] dirs = {"/","/usr/","/usr/local/","/usr/local/bin/","/games/","/games/snake/","/homework/","/temp/downloads/"};
    String[] sorted = Dirsort(dirs);
    for(int i = 0; i < sorted.length; i++)
    {
        System.out.println(sorted[i]);
    }
    
    System.out.println("\nExample 2:\n");
    String[] dirs2 = {"/usr/","/usr/local/","/bin/","/usr/local/bin/","/usr/bin/","/bin/local/","/bin/local/"};
    String[] sorted2 = Dirsort(dirs2);
    for(int i = 0; i < sorted2.length; i++)
    {
        System.out.println(sorted2[i]);
    }
    
     System.out.println("\nExample 3:\n");
    String[] dirs3 = {"/","/a/","/b/","/c/","/d/","/e/","/f/","/g/"};
    String[] sorted3 = Dirsort(dirs3);
    for(int i = 0; i < sorted3.length; i++)
    {
        System.out.println(sorted3[i]);
    }
    
     System.out.println("\nExample 4:\n");
    String[] dirs4 = {"/","/a/","/b/","/c/","/d/","/e/","/f/","/g/","/a/a/","/b/g/c/","/g/f/"};
    String[] sorted4 = Dirsort(dirs4);
    for(int i = 0; i < sorted4.length; i++)
    {
        System.out.println(sorted4[i]);
    }
    
      System.out.println("\nExample 5:\n");
    String[] dirs5 = {"/a/b/c/d/e/f/g/h/i/j/k/l/m/n/","/o/p/q/r/s/t/u/v/w/x/y/z/"};
    String[] sorted5 = Dirsort(dirs5);
    for(int i = 0; i < sorted5.length; i++)
    {
        System.out.println(sorted5[i]);
    }
    
      System.out.println("\nExample 6:\n");
    String[] dirs6 = {"/a/b/","/ab/cd/","/c/d/","/a/b/c/","/ab/c/d/","/a/bc/d/","/a/b/cd/"};
    String[] sorted6 = Dirsort(dirs6);
    for(int i = 0; i < sorted6.length; i++)
    {
        System.out.println(sorted6[i]);
    }*/

    
    
    

    }
    
}
