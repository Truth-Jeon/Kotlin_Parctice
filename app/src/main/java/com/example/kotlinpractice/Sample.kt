package com.example.kotlinpractice

import java.lang.IllegalArgumentException

fun main() {
    //3. String Template
    val name = "Joyce"
    val lastName = "Hong"
    println("my name is ${name + lastName} I'm 27") //변수를 표시하고 싶을 때 "$" 표시를 한다. 변수와 글 간의 띄어쓰기가 중요하며, 만약 띄어쓰기를 하고 싶지 않을 경우 변수명 겉에 {} 로 감싸준다.
    println("is this true? ${1==0}")
    //"$"를 출력하고 싶을 땐, backslash를 사용해서 표시한다.
    println("this is 2\$a")

    helloWorld()
    println(add(4, 5))
    checkNum(1)

    forAndWhile()

    nullcheck()

    ignoreNulls("전하윤")
}

//1.함수

fun helloWorld() : Unit { //return형이 없을 땐 Unit을 써줘야 함. Unit은 Java의 void와 동일하다.
    //회색 칠 - reduntant : 안써도 되는 문법. Unit은 굳이 쓰지 않아도 된다.
    println("Hello World!")
}

fun add(a: Int, b: Int) : Int { //자바나 C와 다른 점 : 앞에 변수를 써주고 뒤에 타입을 써준다. 타입은 맨 앞글자는 대문자.
    return a+b
}

//2. val VS car
//val = value -> 변하지 않는 값(상수)
//var = variable -> 변할 수 있는 값(변수)
//변수, 상수가 사용되지 않을 경우 회색으로 표시된다.
fun hi() {
    val a : Int = 10
    var b : Int = 9
    b = 100
    val c = 100 // : Int를 굳이 써주지 않아도 Int 값인지 안다. 단, 상수인지 변수인지 구분은 확실히 되야한다.
    var d = 100

    //단, 값을 초기화 하지 않을 경우에는 타입이 무엇인지 선언해주어야 한다.
    var e : String

    var name = "joyce" // : String도 생략 가능.
}

//4. 조건식
fun maxBy(a: Int, b: Int) : Int {
    if( a > b) {
        return a
    } else {
        return b
    }
}

fun maxBy2(a : Int, b: Int) = if(a>b) a else b // <= 코틀린은 3항연산자 개념이 없기 때문에 이런 식으로 써주면 된다. / 삼항연산자 : (a>b) ? a : b
// if(a>b) a else b 는 expression이다.

fun checkNum(score: Int) {
    when(score) {
        0 -> println("this is 0")
        1 -> println("this is 1")
        2,3 -> println("this is 2 or 3")
        //else -> println("I don't know") //function의 경우에 else를 굳이 써주지 않아도 된다.
    } //Statement의 when

    var b = when(score) {
        1 -> 1
        2 -> 2
        else -> 3
    } //변수에 when을 담을 때는 else를 반드시 써줘야 한다.
    //Expression의 when

    println("b : ${b}")

    when(score){
        in 90..100 -> println("You are genius")
        in 10..80 -> println("not bad")
        else -> println("okay")
    }
}

//Expression VS Statement
//코틀린의 모든 함수는 Expression이다. checkNum 함수의 경우에도 뒤에 아무것도 안적혀있지만, 사실은 Unit을 리턴하는 함수이다.
//자바의 void 함수는 Statement에 해당한다.
//따라서 코틀린의 모든 함수는 Expression이며, 아무리 리턴값이 없더라고 Unit 값을 반환한다.
//if문이 java에서는 Statement로만 사용 가능했다면, kotlin에서는 Expression으로도 사용 가능하다.(Statement도 가능)
//Expression은 값을 반환, Statement는 명령

//5. Array and List
// Array

//List : 1. ImmutableList(수정 불가능, List라고도 함.), 2. MutableList(수정 가능)
fun array(){
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)

    val array2 = arrayOf(1, "d", 3.4f)
    val list2 = listOf(1, "d", 11L)

    array[0] = 3
    // list[0] = 2는 불가능(값을 변경하는 것은 불가능) -> Immutable이기 때문. get으로 값을 받아오는 것은 가능.
    var result = list.get(0)

    val arrayList = arrayListOf<Int>()
    arrayList.add(10)
    arrayList.add(20) //listA listB 철수네 집, 영희네 집 주소가 있으면, 그 가족들이 서로의 집에 드나들어도 서로의 집주소가 바뀌지 않는 것과 같다.
    arrayList[0] = 20

}

//6. for / while
fun forAndWhile() {
    val students = arrayListOf("joyce", "james", "jenny", "jennifer")

    for ( name in students ) {
        println("${name}")
    }

    for ((index, name) in students.withIndex()){
        println("${index+1}번째 학생 : ${name}")
    }

    var sum : Int = 0
//    for ( i in 1..10 step 2) { //step 스텝을 밟아라 라는 뜻으로, step 2는 2칸씩 가라는 뜻. downTo 1은 1까지 작아져라라는 의미, until 100은 100을 포함하지 않고, 즉 99까지를 의미한다.
//        sum += i //sum = sum + i
//    }
    for (i in 1..100) {
        sum += i
    }
    println(sum)

    println(sum)

    var index = 0
    while(index < 10) {
        println("current index : ${index}") //index++을 하지 않으면 무한루프 돈다.
        index++
    }
}

// 7. Nullable / NonNull
fun nullcheck() {
    //NPE : Null Pointer Exception -> play를 해봐야 알 수 있다.
    //컴파일 시점을 잡아주는 것 = ?(물음표)
    var name : String = "joyce" // :String 타입 생략 가능.
    var nullName : String? = null //(물음표를 넣어줌으로써 null을 넣어줄 수 있다.) :String 타입 생략 불가능.
    var nameInUpperCase = name.toUpperCase()
    var nullNameInUpperCase : String? = nullName?.toUpperCase()

    // ?: 엘비스 프리슬리 연산자.
    val lastName : String? = "Hong"
    val fullName = name + " " + (lastName?: "NO lastName")
    var mLastName = lastName ?: throw IllegalArgumentException("No last name")
    println(fullName)

}

//!! -> Nullable 타입으로 지정되어있지만, NullType이 아님을 보증함.
fun ignoreNulls(str : String?) {
    val mNotNull : String = str!! //정말로 확실하지 않은 이상, Null이 들어가면 NPE가 생기기 때문에 사용하는 것을 지양해야 함.
    val upper = mNotNull.toUpperCase()

    val email : String?= "joycehongXXXX@nana.com"
    email?.let{
        println("my email is ${email}")
    }
}