package practice

// Single Responsibility

class CalculatorWrong() {
    //global
    private val something: String = "Hello"

    fun plus(a: Int, b: Int) {
        //local variable
        val result = a + b
        println("Result is : $result")
    }
}

class CalculatorRight() {
    fun plus(a: Int, b: Int): Int {
        return a + b
    }
}

fun printResult(result: Number) {
    println("The Result is $result")
}

class RockPaperScissor() {

    private var playerOne: Int = -1
    private var playerTwo: Int = -1

    private fun printOptions() {
        println(
            """
            ===============================
            GUNTING BATU KERTAS
            ===============================
            OPTION
            0. GUNTING
            1. BATU
            2. KERTAS
        """.trimIndent()
        )
    }

    private fun showResult(playerOne: Int, playerTwo: Int): String {
        return if (((playerOne + 1) % 3) == playerTwo) {
            "Player 2 menang"
        } else if (playerOne == playerTwo) {
            "Seri"
        } else {
            "Player 1 menang"
        }
    }

    private fun inputPlayerOne() {
        println("Masukkan pilihan 1 (0/1/2): ")
        playerOne = readln().toInt()
    }

    private fun inputPlayerTwo() {
        println("Masukkan pilihan 2 (0/1/2): ")
        playerTwo = readln().toInt()
    }

    fun run() {
        printOptions()
        inputPlayerOne()
        inputPlayerTwo()
        println(showResult(playerOne, playerTwo))
    }
}


// Open - Closed
open class IronManSuit() {
    open fun blast() {
        println("Blast using laser powered by Arc Reactor")
    }

    fun activateAI() {
        println("Jarvis is active")
    }
}

class WarMachineSuit() : IronManSuit() {
    override fun blast() {
        //super.blast()
        println("Sleep for 2 Second")
        Thread.sleep(2000)
        println("Blast from war machine suit")
        println("Sleep for 3 Second")
        Thread.sleep(3000)
        println("Duarrr")
    }
}

// liskov subtitution
// using hot air balloon
class Capadocia() {
    private lateinit var balloon: HotAirBalloon

    fun run() {
        //balloon = RedHotAirBalloon()
        balloon = BlueHotAirBalloon()
        balloon.apply {
            carryPassengers()
            blow()
            pop()
        }
    }
}


fun main(args: Array<String>) {
    //WarMachineSuit().blast()
    Capadocia().run()
}


// Interface Segregation
interface Animal {
    fun eat()
    fun hunt()
    fun walking()
    fun sleep()
    fun jump()
    fun breath()
    fun sound()
    fun reproduction()
}

interface Aves : Animal {
    fun fly()
    fun twit()
}

interface Fish : Animal {
    fun swim()
}

class Bird() : Aves {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    override fun fly() {
        TODO("Not yet implemented")
    }

    override fun twit() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }

}

class CatFish() : Fish {
    override fun eat() {
        TODO("Not yet implemented")
    }

    override fun hunt() {
        TODO("Not yet implemented")
    }

    override fun walking() {
        TODO("Not yet implemented")
    }

    override fun swim() {
        TODO("Not yet implemented")
    }

    override fun sleep() {
        TODO("Not yet implemented")
    }

    override fun jump() {
        TODO("Not yet implemented")
    }

    override fun breath() {
        TODO("Not yet implemented")
    }

    override fun sound() {
        TODO("Not yet implemented")
    }

    override fun reproduction() {
        TODO("Not yet implemented")
    }

}

// Dependency Inversion
class FirebaseAnalytics() {
    fun log(event: String) {
        println("Logging to firebase : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success !")
    }
}

class NewRelicAnalytics() {
    fun log(event: String) {
        println("Logging to NewRelic : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success !")
    }
}

class MoEngageAnalytics() {
    fun log(event: String) {
        println("Logging to MoEngage : Event Name : $event")
        Thread.sleep(2000)
        println("Logging Success !")
    }
}

interface Analytics {
    fun logEvent(event: String)
}
//agnostic class
class AppAnalytics : Analytics {
    private var firebaseAnalytics = FirebaseAnalytics()
    private var moEngageAnalytics = MoEngageAnalytics()
    private var newRelicAnalytics = NewRelicAnalytics()

    override fun logEvent(event: String) {
        firebaseAnalytics.log(event)
        moEngageAnalytics.log(event)
        newRelicAnalytics.log(event)
    }
}
class EnhancedAppAnalytics : Analytics{
    override fun logEvent(event: String) {
    }
}


// page
class SplashScreen(private val analytics: Analytics) {

    fun openPage() {
        println("Open Page SplashScreen")
        analytics.logEvent("SplashScreen")
    }
}

class HomePage(private val analytics: Analytics) {

    fun openPage() {
        println("Open Page HomePage")
        analytics.logEvent("HomePage")
    }
}

class LoginPage(private val analytics: Analytics) {

    fun openPage() {
        println("Open Page LoginPage")
        analytics.logEvent("LoginPage")
    }
}
class App {
    private val analytics = AppAnalytics()

    fun run() {
        SplashScreen(analytics).openPage()
        HomePage(analytics).openPage()
        LoginPage(analytics).openPage()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            App().run()
        }
    }
}


