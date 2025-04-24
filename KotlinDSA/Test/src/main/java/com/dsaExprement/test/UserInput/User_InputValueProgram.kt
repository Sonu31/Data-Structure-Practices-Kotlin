package UserInput

import kotlin.math.absoluteValue

fun main() {

//    userInputValuefun()
    stringToCharusingLoop()


    /*For Loop ka Use karke String ko Characters me Convert Karna*/


}

  fun userInputValuefun(){
      print("Enter your name")
      val name = readLine()
      println("Hi  , $name")
      println("Your String Valeu Size is ${name?.length}")


      /*How to convert String to Charcter*/
      var charIs = name?.toCharArray()
      println("Owr Char is :- ${charIs?.joinToString()}")


      println("How to Print Value One by One ")
      var stringValue = name?.length
      stringValue?.let {
          for (i in 0..it){
              println("Your Char is ${i.absoluteValue}")
          }
      }
  }
  fun stringToCharusingLoop(){
  /*    var  data = "RAushan"
      val charList = mutableListOf<Char>()
      for (chasr in data)
      {
          charList.add(chasr)
      }
      println("${charList}" )
      */




      /*Second way */

      var textData = "Raohit"

      var charArray = CharArray(textData.length)

      for (i in textData.indices)
      {
          charArray[i]= textData[i]
      }
      println(charArray.joinToString())  // Output: H, e, l, l, o

  }