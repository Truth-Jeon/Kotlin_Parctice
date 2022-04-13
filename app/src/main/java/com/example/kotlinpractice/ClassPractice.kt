package com.example.kotlinpractice

//자바와 코틀린의 다른 점 : 코틀린은 파일 이름과 클래스 이름이 일치하지 않아도 되고,
//여러 클래스도 한 파일에 넣을 수 있다.

open class Human (val name : String = "Anonymous"){ //자바라면 생성자(constructor)를 초기화 할 때, Human(){} 이런 식으로 했을 것이다.
    //코틀린은 class Human constructor(){}로 사용해도 되고, class Human(){}로 사용해도 된다.
    //val name = name => 생성자에 직접 변수타입을 붙여줬으므로 지워도 됨.
    fun eatingCake() {
        println("this is so yummy~~~~") //주 생성자
    }

    //코드블록을 넣고 싶을 경우에 init을 사용하는데, 어떤 동작을 할 것인지를 정의한다.
    init {
        println("New human has been born!!")
    }

    //부 생성자
    //(1) JAVA
    /*
        class Person {
            public Person(String name) {
            }

            public Person(String name, int age) {
                this(name);
            }
        }
     */

    //(2) Kotlin
    constructor(name: String, age:Int) : this(name){ //부 생성자는 주 생성자에게 위임을 받아야 한다. : this()를 통해서 받을 수 있다.
        println("my name is ${name}, ${age}years old")
    }
    //Class에서 init{}이 가장 먼저 생성된다. 왜냐하면 주 생성자의 일부이기 때문이다.
    //그 다음에 constructor(){} 블록이 생성된다.

    open fun singASong(){
        println("lalala")
    }
}

class Korean : Human() { //자바에서는 상속을 받기 위해서 extends를 썼지만, 코틀린에서는 : 클래스이름() 을 써주면 된다. extends(상속)은 java와 마찬가지로 1개만 가능하다.
    //하지만, 코틀린의 Class는 기본적으로 Final class 이므로, 상속받을 클래스 앞에 open을 써줘야 한다.
    //자바의 override 개념 : 상속받은 메소드를 특정 클래스에서만 사용하고 싶을 때.
    //코틀린에서도 override가 사용 가능하지만, 약간 다른 점은, override 할 메소드 앞에 open을 써줘야 한다.
    override fun singASong(){
        super.singASong() //class Human의 singASong() 메소드도 사용하고 싶을 때.
        println("랄랄라")
        println("my name is :${name}")
    }
}

fun main() {
//    val human = Human("minsu")
//
//    val stranger = Human()
//
//    human.eatingCake()

//    val mom = Human("Kuri", 52)

//    println("this human's name is ${stranger.name}")

    val korean = Korean()
    korean.singASong()
}