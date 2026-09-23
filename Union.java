/*
    arr1 = {7, 3, 9}
    arr2 = {6, 3, 9, 2, 9, 4}
    
    union = 6{7, 3, 9, 6, 2, 4}
*/

import java.util.*;
public class Union {

    public static int Union1(int arr1[], int arr2[]){ //O(n)
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<arr1.length; i++){
            set.add(arr1[i]);
        }
        for(int j=0; j<arr2.length; j++) {
            set.add(arr2[j]);
        }  
        return set.size();
    }
    public static void main(String[] args) {
        int arr1[] = {7, 3, 9};
        int arr2[] = {6, 3, 9, 2, 9, 4};
        System.out.println(Union1(arr1, arr2));
    }
}