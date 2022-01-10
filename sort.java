package Assignments;
import java.util.Arrays;


public class sort {
    public static void main(String[] args){
        int[] arraynum = new int [] {12,100,45,67,89,1};

        Arrays.sort (arraynum);
        System.out.println("sorted array is:");
    
        for ( int i=0; i <arraynum.length; i++) { 
            System.out.println(arraynum [i]);
        }
    }
}
    
