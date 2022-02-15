/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawtree;

/**
 *
 * @author benri
 * Collaborated with Ben Davenport, as it is encouraged for homeworks
 */
import java.util.ArrayList;
import java.util.HashMap;


public class DrawTree {
      public String[] draw(int[] parents, String[] names){
         int index_of_root = rootDetermine(parents);
         String root = names[index_of_root]; //finds the name where the index is -1 (root)
         HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>(); //hasmap with string array list (length can be changed)
         map = recursionDrawing(root, parents, names, map);

         // turn map into output
         ArrayList<String> output = new ArrayList<String>();
         output = mapToDrawing("", root, 0, output, false, map);
         
         String[] out = output.toArray(new String[output.size()]);
         return out;
      }
      
            public int rootDetermine(int[] parents){
    	  int index_of_root=0; 
    	  for(int i=0; i < parents.length; i++){
    		  if(parents[i]==-1){
    			  index_of_root=i;
    		  }
    	  }
    	  return index_of_root; 
      }
      
      public ArrayList<String> mapToDrawing(String preface, String root, int depth, //map to output
    		  ArrayList<String> list, boolean sibling, 
    		  HashMap<String, ArrayList<String>> map){
    	  
    	  String node = preface + "+-" + root; //all names should be prefaced with +-
    	  if(sibling){ preface = preface + "| "; } //if there is a sibling at the connector line
    	  else{  preface = preface + "  "; } //add 2 spaces when theres a new child
    	  
//    	  System.out.println(node);
// uncomment ^^ this line to print out output and test code is working
    	  list.add(node); 
    	  if(map.containsKey(root)){
    		  ArrayList<String> children = map.get(root);
    		  String lastChild = children.get(children.size()-1);
        	  if(!children.isEmpty()){
        		  for(String child : children){
        			  if(map.containsKey(child) & !child.equals(lastChild)){
        				  sibling = true; 
        			  }
        			  else{ sibling = false; } 
            		  list = mapToDrawing(preface, child, depth+1, list, sibling, map);
            	  }
        	  }
    	  }
 
    	  return list; 
      }
      
      public HashMap<String, ArrayList<String>> recursionDrawing(String root, 
    		  int[] parents, String[] names, 
    		  HashMap<String, ArrayList<String>> map){
    	  
    	  ArrayList<String> children = new ArrayList<String>(); 
    	  
    	  // find values where parent == root
    	  for(int i=0; i < parents.length; i++){
    		  if(parents[i]!=-1){
    			  String parentName = names[parents[i]];
        		  if(parentName.equals(root)){
        			  // add to list of children
        			  children.add(names[i]);
        		  }
    		  }
    		  
    	  }
    	  if(children.isEmpty()){
    		  return map; 
    	  }
    	  else{
    		  map.put(root, children);
    		  for(String child : children){
    			  map = recursionDrawing(child, parents, names, map);
    		  }
    		  return map;
    	  }
    	  
      }
      
      public static void main(String[] args){
    	  DrawTree t = new DrawTree();
          //this code works with any list of parents or names, given they are within the assignment listed constaints, but below are some examples
    	  
/*    	  int[] parents = {-1,0,1,1,0,0,5,5};
    	  String[] names = {"Root","SubB","LEAF1","LEAF2","LEAF3","SubA","LEAF4","LEAF5"};

    	  String[] result = t.draw(parents, names);

    	  
    	  int[] parents2 = {1,2,3,4,5,6,-1};
    	  String[] names2 = {"A","B","C","D","E","F","G"};

    	  String[] results2 = t.draw(parents2, names2);
          
          
          int[] parents3 = {1,2,3,4,6,6,-1};
    	  String[] names3 = {"A","B","C","D","E","F","G"};

    	  String[] results3 = t.draw(parents3, names3);
          
          
          int[] parents4 = {6,2,3,4,5,6,-1};
    	  String[] names4 = {"A","B","C","D","E","F","G"};

    	  String[] results4 = t.draw(parents4, names4);
          
          
          int[] parents5 = {-1,0,1,1,2,2,3,3,0,8,8,9,9,10,10};
    	  String[] names5 = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"};

    	  String[] results5 = t.draw(parents5, names5);

    	  */ 
      }
}
