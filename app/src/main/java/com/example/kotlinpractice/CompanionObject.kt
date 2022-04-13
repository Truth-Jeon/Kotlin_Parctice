package com.example.kotlinpractice

class Book private constructor (val id : Int, val name : String){ //private constructor을 사용함으로써 다른 곳에서는 객체를 생성하지 못하도록 함.
    companion object BookFactory :IdProvider{
        //여기에 있는 것들은 각각 static mathod, static property이다.
        override fun getId(): Int {
            return 444
        }

        val myBook = "new book"
//        fun create() = Book(getId(), myBook)
        fun create() = Book(0, myBook)
    }
}

interface IdProvider {
    fun getId() : Int
}

fun main(){
    val book = Book.create()

    val bookId = Book.BookFactory.getId()
    println("${book.id} ${book.name}")
}