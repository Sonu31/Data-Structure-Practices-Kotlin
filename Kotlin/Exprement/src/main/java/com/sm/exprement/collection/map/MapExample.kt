package com.sm.exprement.collection.map

import com.sm.exprement.collection.map.model.User
import com.sm.exprement.collection.map.model.UserDto

fun main() {


    /*1,*/
    var mapData = mapOf("name" to "Sonu", "age" to "20","Roll" to "3456")

    println("Map Value are :- ${mapData}")


/*update */
    val mutableMap = mutableMapOf("city" to "Delhi")
    mutableMap["country"] = "India"       // Add
    mutableMap["city"] = "Mumbai"         // Update



























    /*1. Use Case: API se aayi list ko map karke RecyclerView me dikhana.*/
    val apiResponse = listOf(
        UserDto("Amit Kumar", 25),
        UserDto("Ravi Singh", 30),
        UserDto("Sneha Roy", 22)
    )
    println("MY Data1 ${apiResponse}")

    val users = apiResponse.map { dto ->
        User(name = dto.fullName, age = dto.age)
    }

    println("MY Data ${users}")






}





class MapExample {
}