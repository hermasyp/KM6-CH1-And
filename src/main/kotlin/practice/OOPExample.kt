package practice

// Encapsulation
private class AClass() {
    private fun run() {
        println("This is from class A")
    }

    fun runPublic() {
        println("This is from class A in public")
    }
}

class BClass() {
    fun run() {
        // we cannot call run bcs it's private :D
        // AClass().run()
        AClass().runPublic()
        println("This is from class B")
    }
}

// Kakek
//abstraction
interface Balloon {
    fun blow()
    fun pop()
}

//Bapak
abstract class HotAirBalloon() : Balloon {
    override fun blow() {
        println("Blow the balloon using hot air")
    }

    override fun pop() {
        println("Danger !!!")
    }

    fun moveLeft() {
        println("Move the balloon to the left")
    }

    // wajib untuk di implement di turunan class nya
    abstract fun carryPassengers()
}

// anaknya si bapak
class RedHotAirBalloon() : HotAirBalloon() {
    // wajib untuk di implement di turunan class nya
    override fun carryPassengers() {
        println("Carrying 5 Passengers")
    }

    override fun blow() {
        println("blowing the balloon using Doa")
    }

    //overloading
    fun blow(name: String) {

    }
}
class BlueHotAirBalloon() : HotAirBalloon() {
    // wajib untuk di implement di turunan class nya
    override fun carryPassengers() {
        println("Carrying 5 Passengers")
    }

    override fun blow() {
        println("blowing the balloon using Blue Energy")
    }

    //overloading
    fun blow(name: String) {

    }
}
//polymorphism
class RedBalloon() : Balloon {
    override fun blow() {
        println("Meniup balonnnn Merah...")
    }

    override fun pop() {
        println("Balon Merah Meledak !!!...")
    }
}

class BlueBalloon() : Balloon {
    override fun blow() {
        println("Meniup balonnnn Biru...")
    }

    override fun pop() {
        println("Balon Biru Meledak !!!...")
    }
}
//inheritance using open class
open class Processor(val name: String) {
    open fun initProcessor() {
        println("Initialize ... $name")
    }
}

class AMDProcessor() : Processor("Ryzen 9")
class IntelProcessor() : Processor("i3")

fun main(args: Array<String>) {
    RedHotAirBalloon().let {
        //sifat kakek
        it.blow()
        it.pop()
        //sifat bapak
        it.moveLeft()
        it.carryPassengers()
    }
    AMDProcessor().initProcessor()
    IntelProcessor().initProcessor()
}