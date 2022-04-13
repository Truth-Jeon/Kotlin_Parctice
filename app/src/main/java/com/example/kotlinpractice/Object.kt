package com.example.kotlinpractice

//자바에서는 Boilerplate를 사용해서 많은 코드를 적어야 하지만, Kotlin에서는 object를 사용하여 간단하게 Singleton Pattern을 만들 수 있다.

//Singleton Pattern
object CarFactory {
    val cars = mutableListOf<Car>()
    //Object가 다른 클래스들과 다른 점 : CarFactory라는 객체가 모든 앱을 실행 시 딱 1번만 만들어진다. 즉, Singleton Pattern을 적용한 것이다.
    //실행 시 한번 딱 클래스를 읽어오고, 다시 객체가 생성되지 않는다. => 불필요하게 메모리가 사용되는 것을 막는다.

    fun makeCar(horsePower: Int) : Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }

}

data class Car(val horsePower : Int)

fun main() {
    val car = CarFactory.makeCar(10)
    var car2 = CarFactory.makeCar(200)

    println(car)
    println(car2)
    println(CarFactory.cars.size.toString())
}