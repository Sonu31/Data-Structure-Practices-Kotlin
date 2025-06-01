package com.dsaExprement.test.basicQuestion

fun main() {
    reverstionName()
}

fun  reverstionName(){
    var  stingdata= "SONU "


    var reversion=""

    var  chatData=stingdata.reversed()

    for (i in 0 until  stingdata.length){
        println("String  :- ${stingdata[i]}")

    }
    println("-------------------------------------------")
    for (element in stingdata){
        println("String  :- ${element}")
    }
    println("---------- using Funciton----------------------")
    println("String  :- ${chatData}")
    println("------------without funcciton-------------")
    for (i in stingdata.length - 1 downTo 0) {
        reversion += stingdata[i]
    }

    println("Reversed String: $reversion")
}