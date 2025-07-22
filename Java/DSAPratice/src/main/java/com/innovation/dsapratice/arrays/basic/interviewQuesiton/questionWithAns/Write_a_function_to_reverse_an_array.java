package com.innovation.dsapratice.arrays.basic.interviewQuesiton.questionWithAns;

public class Write_a_function_to_reverse_an_array {

    void function_to_reverse_an_array(int[] arr){
        int start= 0 ;
        int end = arr.length-1;

        while (start<end){
            System.out.println("startDataValue "+start);
            int temp = arr[start];
            System.out.println("tempDataValue "+temp);

            arr[start] = arr[end];
            System.out.println("tempDataValue "+arr[end] +" "+arr[start]);

            arr[end] = temp;
            System.out.println("Temp DAta "+temp);
            System.out.println("Temp DAta "+arr[end]);

            start++;
            System.out.println("start incr DAta "+start++);
            end--;
            System.out.println("end dec DAta "+ end--);

        }



    }


    void function1(int[] arr){

        System.out.println("----------------INCriment---------------- ");
        System.out.println();
        for (int i =0 ;i<arr.length;i++){
            System.out.print(" "+arr[i]);
        }
        System.out.println();

        System.out.print("----------------reverse-----------------");
        System.out.println();
        for (int j=arr.length-1;j>0;j--){
            System.out.print(" "+arr[j]);
        }


    }


    public static void main(String[] args) {
        Write_a_function_to_reverse_an_array  obj= new Write_a_function_to_reverse_an_array();

        int arr[] = {1, 2, 3, 4, 5, 6};

        System.out.println("---------------Reversion using fun ---------------------------------");
        System.out.println("Original array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }

        // Reverse the array using the function
        obj.function_to_reverse_an_array(arr);
        System.out.println();
        System.out.println("\nReversed array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }



        System.out.println();

        System.out.print("----------------------------Revers  using For Loop");
        System.out.println();
        obj.function1(arr);
    }

}



