/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maxsubarrayporoblem;

import static java.lang.Integer.max;
import java.util.Arrays;

/**
 *
 * @author raeda
 */
public class MaxSubArrayPoroblem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        int Xarray [] = { -2, 4, 2,10};
       
        int result = Maximum_sum_subarray_method1(Xarray,Xarray.length);
        System.out.println ("The result using method 1 is "+result);
        
        
        
        
        result = Maximum_sum_subarray_method2(Xarray,Xarray.length);
        System.out.println ("The result using method 2 is "+result);
     
                       
                         
             
           
        }
        
        
    // this method 1, the complexity is O (n^3) 
   // see this video https://www.youtube.com/watch?v=ohHWQf1HDfU  
   // Next method, we will try to improve the time complexity
    static int Maximum_sum_subarray_method1 (int arr[], int n )
    {
        Arrays.sort(arr);
        
       int ans =   arr[0];
       for ( int sub_array_size = 1; sub_array_size <= n; ++sub_array_size )
       {
           for ( int start_index = 0; start_index < n; ++start_index)
           {
               if (start_index + sub_array_size > n)
               {
                   break;
               }
              int sum = 0;
              for ( int i = start_index; i < (start_index + sub_array_size); i++)
              sum+= arr[i];
              
              ans = max(ans,sum);
           
           }
       }
       return ans;
    }
    
    
    
    
    // we improve our time complexity using this method, now the time complexity become O(n^2)
    // Next, we are going to use recuresive to improve our time complexity more 
     static int Maximum_sum_subarray_method2 (int arr[], int n )
    {
         Arrays.sort(arr);
        
       int ans =   arr[0];
       
       for ( int start_index = 0; start_index <= n; start_index++)
       {
           int sum = 0; 
           for ( int sub_array_size = start_index  ; sub_array_size <  arr.length; sub_array_size++)
           {
              
                 if (start_index + sub_array_size > n)
               {
                   break;
               }
              sum = sum + arr[sub_array_size];
              ans = max(ans,sum);
           }
       }
       return ans;
    }
    
    
    
}
