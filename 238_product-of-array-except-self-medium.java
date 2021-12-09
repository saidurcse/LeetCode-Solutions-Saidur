import java.io.*;
import java.util.*;

/*
       CODE Explanation:
       let
             index -->  0   1   2   3   4
             nums -->  [1,  2,  3,  4,  5]

  initially output_arr is:
            output_arr --> [0, 0, 0, 0 , 0]
         Step 1: output_arr[0] = 1 --> [1, 0, 0, 0, 0]
      1st Pass:  i = 1
                 output[1] = output[0] * nums[0]
                 output[1] = 1 * 1  --> [1, 1, 0, 0, 0]
      2nd Pass:  i = 2
                output[2] = output[1] * nums[1]
                output[1] = 1 * 2  --> [1, 1, 2, 0, 0]
      3rd Pass:  i = 3
                output[3] = output[2] * nums[2]
                output[1] = 2 * 3  --> [1, 1, 2, 6, 0]
      4th Pass:  i = 4           4 < 5  TRUE
                output[4] = output[3] * nums[3]
                output[4] = 6 * 4  --> [1, 1, 2, 6, 24]    --> Here NOTE 24 is the Product for nums[4] except itself

   Now
         let rightProduct = 1
       1st Pass:  i = 4              4 >= 0 TRUE
                 output[4] = output[4] * 1                   As, output[i] = output[i] * rightProduct
                 output[4] = 24 * 1  --> [1, 1, 2, 6, 24]
                 rightProduct = 1 * 5 = 5                    As, rightProduct = rightProduct * nums[i]
      2st Pass:  i = 3               3 >= 0 TRUE
                 output[3] = output[3] * 5                   As, output[i] = output[i] * rightProduct
                 output[3] = 6 * 5  --> [1, 1, 2, 30, 24]
                 rightProduct = 5 * 4 = 20                    As, rightProduct = rightProduct * nums[i]
      3rd Pass:  i = 2                2 >= 0 TRUE
                 output[2] = output[2] * 20                   As, output[i] = output[i] * rightProduct
                 output[2] = 2 * 20  --> [1, 1, 40, 30, 24]
                 rightProduct = 20 * 3 = 60                    As, rightProduct = rightProduct * nums[i]
      4th Pass:  i = 1                1 >= 0 TRUE
                 output[1] = output[1] * 60                   As, output[i] = output[i] * rightProduct
                 output[1] = 1 * 60  --> [1, 60, 40, 30, 24]
                 rightProduct = 60 * 2 = 120                    As, rightProduct = rightProduct * nums[i]
        5th Pass:  i = 0                0 >= 0 TRUE
                 output[0] = output[1] * 120                   As, output[i] = output[i] * rightProduct
                 output[0] = 1 * 120  --> [120, 60, 40, 30, 24]
                 rightProduct = 120 * 1 = 120                    As, rightProduct = rightProduct * nums[i]

     So,
        Resultant Output Array is -->  [120, 60, 40, 30, 24]
        */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int [] output_arr = new int[nums.length];

        output_arr[0] = 1;
        for(int i=1; i<nums.length; i++){
            output_arr[i] = output_arr[i-1] * nums[i-1];
        }

        int rightProduct = 1;
        for(int i= nums.length-1; i>=0; i--){
            output_arr[i] = output_arr[i]*rightProduct;
            rightProduct = rightProduct * nums[i];
        }
        return  output_arr;
    }
}
