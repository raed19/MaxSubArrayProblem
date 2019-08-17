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
        
        int Xarray [] = { -2, -4, 5, 5};
       
       int result = Maximum_sum_subarray_method1(Xarray,Xarray.length);
        System.out.println ("The result using method 1 is "+result);
        
        
        
        
        result = Maximum_sum_subarray_method2(Xarray,Xarray.length);
        System.out.println ("The result using method 2 is "+result);
     
        
        
        result = maxSubArray(Xarray);
        System.out.println ("The result using method 3 is "+result);
     
                       
                         
             
           
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
    // Next, we are going to use recursive to improve our time complexity more 
     static int Maximum_sum_subarray_method2 (int arr[], int n )
    {
         //Arrays.sort(arr);
        
       int ans =  0;
       
       for ( int start_index = 0; start_index < n; ++start_index)
       {
           int sum = 0; 
           for ( int sub_array_size = 1  ; sub_array_size <=  n ; ++sub_array_size)
           {
              
                 if (start_index + sub_array_size > n)
               {
                   break;
               }
              sum = sum + arr[start_index + sub_array_size-1];
              ans = max(ans,sum);
           }
       }
       return ans;
    }
    
    
     //.Here, we are going to use Divide and Concur method using recursion
     // Note, this algorith will take log n time which better than the other two methods.
     // Using this approch, we are going to divide the array into two sub-arrays, then we will compute the max of each one and compare them. Note, there is another case which 
     // both of the sub array could be the final result. 
    static int Maximum_sum_subarray_method3 (int arr[], int start, int end )
    {
        
        // Note: without this if condition, the program will give error due stack over florw error because it will has infinite loop (recursion)
       if ( start == end ) //if only one element, return that
       {
           return arr[start];
       }
      
       
       int mid = start + (end-start)/2;
       int left_max = Maximum_sum_subarray_method3 (arr,start, mid);
       int right_max = Maximum_sum_subarray_method3 (arr,mid+1, end);
       
       
       // case 1
       // This part for the left subarray
       int leftSum = 0;
       int sum = 0; 
       for ( int i = mid; i >= start; i--)
       {
           sum = sum + arr[i];
             if(sum>leftSum)
                leftSum = sum;
       }
         
       
       // case 2
       // This part for the right subarray
         int rightSum = 0;
         sum = 0;   
       for (int i = mid+1; i <= end ; i++) 
       {
           sum = sum + arr[i];
           rightSum = max (rightSum,sum);
       }
       
       int combine = (left_max+right_max);
      int ans = max(combine,max(left_max,right_max));
       
       return ans;
    }
     static public int maxSubArray(int [] A){
        if(A.length==0)//if length  = 0, return 0
            return 0;
        else
            return Maximum_sum_subarray_method3(A, 0, A.length-1);
    }

}
