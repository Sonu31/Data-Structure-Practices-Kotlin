package com.innovation.dsapratice.arrays.basic.question;


import java.util.Arrays;

public class Find_the_missing_number {

   void  ex1(){
       int arr[] = {1,4,5,6,8,90};
       System.out.println(" Your arr is :- "+arr);
       System.out.println("Array elements: ");


      /// Array Print Icriment Order
/*       for (int i=0;i<arr.length;i++){
           System.out.println(":-"+arr[i]);
//           System.out.println("DAta "+arr[x]);

       }*/

 /// Array Print Decriment Order
  /*     for (int i=arr.length-1;i>0;i--){
           System.out.println(":-"+arr[i]);
       }*/




       /// How to ARry Short

//       if ()




//       Arrays.stream(arr).forEach(number -> System.out.print(number + " "));
       System.out.println();
   }

   void  ex2(){
       int arr[] = {1,4,5,6,8,90};
       for (int i =0;i<arr.length;i++){
           System.out.println("HI :- "+arr[i]);
       }








   }

   int find_the_missing_number(int[] nums){

       int n =nums.length+1; //6
       int expectedSum = n*(n+1)/2;  //=    7/2
       int actualSum =0;
        System.out.println("ExpecteSum Resout "+expectedSum);

       for (int num :nums){
           actualSum += num;

       }





        return expectedSum - actualSum;
    }

    public static void main(String[] args) {
        Find_the_missing_number findTheMissingNumber= new Find_the_missing_number();


        findTheMissingNumber.ex1();

        System.out.println("-------------22/07/2025--------------------------");


     /*  int[] arrr= {1,2,3,5,6};
       int missing   = findTheMissingNumber.find_the_missing_number(arrr);
        System.out.println("Missing number is: " + missing);
*/

        System.out.println("--------------------------------");
        int expectedSum = 15;
        int actualSum =1;
        int cal = expectedSum-actualSum;
        System.out.println("Resoult :-  "+   expectedSum+"-"+actualSum+"="+cal);

        System.out.println("-------------------------------------------");


        int data= 5+1;


        int value=  data*(data+1)/2;
        System.out.println(" cal data is :- "+value);


        System.out.println("-------------------------------------------------------");
        int data2 = 30;
        int data3= 40;
        int result = 40;
        int result2 = 20;


        result += data2;
        result2 = result + data3 ;
        System.out.println("Final REslut is :- "+result);
        System.out.println("Final REslut is 2 :- "+result2);
        System.out.println("-------------------------------------------------------");

        int d1 = 8;
        int d2 = 2;
        int quotient= d1/d2; //quotient
        System.out.println("Final REslut "+quotient);


//        % → Modulus Operator
//        यह remainder (बाकी बचा हुआ हिस्सा) देता है, यानी भाग देने के बाद कितना बचा।
        int a = 10;
        int b = 3;

        int remainder = a % b  ; // remainder = 1
        System.out.println("Final REslut "+remainder);




////       findTheMissingNumber.ex1();
//       findTheMissingNumber.ex2();


    }
}
