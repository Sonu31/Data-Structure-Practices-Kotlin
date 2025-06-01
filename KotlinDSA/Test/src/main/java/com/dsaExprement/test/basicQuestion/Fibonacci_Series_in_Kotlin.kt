package com.dsaExprement.test.basicQuestion

fun main() {

//    fibonacciSearies2()


    printFibonacci3(10)
}


/* first way */
fun fibonacciSeries1(){
    /*1 Way */
    print("Enter the number of terms: ")
    val n = readLine()?.toIntOrNull() ?: return

    var a = 0
    var b = 1
    print("Fibonacci Series: $a, $b")
    for (i in 0.. n){
        var  sum  = a+b
        print(", $sum")
        a=b
        b=sum
    }

}


/* Second Way */

 fun fibonacciSearies2(){
     print("Enter the number of terms: ")
    var a= -1
    var b=1
     val n = readLine()?.toIntOrNull() ?: return

     println("Your entered number is  $n ")

     for(i in 0..n){
         var c = a+b
         print(" ${c}")
         a= b
         b=c
     }


/*Third way*/


 }

// 0 1
fun printFibonacci3(n: Int) {
    var a = 0
    var b = 1

    for (i in 0..n) {
        print("$a ")

        val next = a + b
        a = b
        b = next
    }
}
