package com.example.kotlinpractice

data class Ticket(val companyName : String, val name : String, var date : String, val seatNumber : Int)
// toString(), hashCode(), equals(), copy()

class TicketNormal(val companyName: String, val name : String, var date : String, var seatNumber: Int)

fun main(){
    val ticketA = Ticket("koreanAir", "joyceHong", "2020-02-16", 14)
    val ticketB = TicketNormal("koreanAir", "joyceHong", "2020-02-16", 14)

    println(ticketA)
    println(ticketB)

}