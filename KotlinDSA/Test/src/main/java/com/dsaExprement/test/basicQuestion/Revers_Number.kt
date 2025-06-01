package com.dsaExprement.test.basicQuestion


fun main() {
    reversNumbar ()
}

fun reversNumbar (){

    var intdata = arrayOf(1,22,33,11,22,33,44)

//    var storeValue =0
    for (elmenet in  intdata){
        println("Integer DAta ${elmenet}")
    }
    println("------------------")
    for (i in  0  .. intdata.size-1){
        println("Integer DAta  intdex ${i} :- ${intdata[i]} ")
    }

    println("------------------")
    for (i in  intdata.size -1 downTo 0){
        println("Integer DAta  intdex ${i} :- ${intdata[i]} ")
    }


}