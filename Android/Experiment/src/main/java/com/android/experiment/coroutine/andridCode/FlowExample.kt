package com.android.experiment.coroutine.andridCode

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
/*What is RunBolck */
    /*
     - Kotlin Flow suspend function ke concept pe kaam karta hai.
     - Matlab Flow ko collect() karna ek suspending operation hai.
     - Suspending operations ko direct normal main() function mein nahi chala sakte.
     - To hum runBlocking {} ka use karte hain taaki normal code mein bhi coroutine environment mil jaaye.

:- What is Runblocking

  1. Ek coroutine banata hai jisme hum Flow ko safely collect() kar sakte hain.
  2. Jab tak andar ka kaam pura nahi ho jaata, main thread ko block karke wait karta hai.
  3. Mainly Testing / Demo / Learning examples mein use karte hain.




     */









fun main() = runBlocking {
    val numbersFlow = flow {
        for (i in 1..5) {
            delay(500) // 500ms rukenge har number ke beech
            emit(i) // Data
        // emit kar rahe hain
        }
    }

    // Flow ko collect kar rahe hain
    numbersFlow.collect { value ->
        println("Received: $value")
    }
}