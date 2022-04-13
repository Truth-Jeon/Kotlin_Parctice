package com.example.kotlinpractice

//1. Lamda
//람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
//1) 메소드의 파라미터로 넘겨줄 수 있다. fun maxBy(a : Int)
//2) return 값으로 사용할 수가 있다.


//람다의 기본 정의
//val lamdaName : Type = {argumentList -> codeBody}

val square : (Int) -> (Int) = {number -> number*number}
//val square = {number : Int -> number*number}
//val 상수명 다음에 : (Int) -> (Int)로 타입 선언을 해주던지, {number : Int -> number*number} 로 선언을 해주던지 타입을 선언해줘야 함. (값이 초기화가 안됐으므로)

val nameAge = {name : String, age : Int ->
    "my name is ${name} I'm ${age}"
}

fun main(){
    println(square(12))
    println(nameAge("joyce", 99))
    val a = "joyce said"
    val b = "mac said"

    println(a.pizzaIsGreat())
    println(b.pizzaIsGreat())

    println(extendString("ariana", 27))

    println(calculateGrade(97))
    println(calculateGrade(971))

    val lamda = {number : Double ->
        number == 4.3213
    }

    println(invokeLamda(lamda))

    //lamda를 선언하지 않고 바로 사용하는 것을 lamda literal이라고 한다.
    println(invokeLamda({it > 3.22})) //it은 넣는 파라미터가 1개일 때, 그것을 가르키는 것이다.

    println(invokeLamda{ it > 3.22 }) //invokeLamda({it > 3.22}) 와 똑같은 식이다. function의 마지막 식이 람다식일 경우, 이렇게 생략이 가능하다.
    //또는 invokeLamda(){it > 3.22}로도 사용 가능하다. 하지만 ()안의 파라미터가 비어있으므로 생략이 가능한 것이다.
    //앞서 얘기했듯이, 여기서 it은 1개가 들어가는 파라미터를 의미한다.
}

// 확장함수
val pizzaIsGreat : String.() -> String = {
    this + "Pizza is the best!"
}

fun extendString(name : String, age: Int) : String {
    val introduceMyself : String.(Int) -> String = {"I am ${this} and ${it} years old"}
    //this가 가리키는 것은 String이고, it은 (Int)이다.
    return name.introduceMyself(age)
}

//람다의 Return
//마지막 표현식(마지막 한 줄)이 return 값을 의미한다.
val calculateGrade : (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "Error"
    }
}

//람다를 표현하는 여러가지 방법
fun invokeLamda(lamda : (Double) -> Boolean) : Boolean {
    return lamda(5.2343)
}

//pojo
