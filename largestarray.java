package Assignments;

public class largestarray {
        public static void main(String args[]){
            int array[] = {78,67,110,67,45};
            int temp=array[0];
            for(int i = 0; i<array.length; i++ ){
               if(array[i]>temp)
               temp=array[i];
            }
            System.out.println(temp);
        }
    }
