package com.innovation.dsapratice.arrays.basic.question;
/*
Input: nums = [2, 7, 11, 15], target = 9
Output: [0, 1]
Explanation: nums[0] + nums[1] = 2 + 7 = 9

*/
public class Two_sum_problem {


    public static void main(String[] args) {

        int arr[] = {3,4,5,6,7,8,3};

        int fIn= arr[0]+arr[1];



        System.out.println("------------------------ find Index Value -------------------");

        System.out.println(" Output "+fIn);

        for (int i =0;i<arr.length;i++){
            System.out.println("Result "+arr[i]);
        }

        int  getIntextValue = arr[4];
        System.out.println("------------------------Another way find Index Value -------------------");

        int arr2[] = {3, 4, 5, 6, 7, 8, 3};
        int value = -1;

        for (int i = 0; i < arr2.length; i++) {
            if (i == 4) {
                value = arr[i];
                break;
            }
        }
        System.out.println(value);  // Output: 7

        System.out.println("how to add value  first  indext using Flow loop  ");




//        System.out.println("");

    }



}
