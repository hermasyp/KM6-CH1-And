package practice

import java.lang.Exception

data class Fruit(val id: String, val fruitName: String, val pricePerPcs: Double)

class BranchingApp {
    private var selectedFruit: Fruit? = null
    private var totalFruit: Int = 0
    private var totalPrice: Double = 0.0

    private val fruits = listOf(
        Fruit(id = "1", fruitName = "Melon", 20000.0),
        Fruit(id = "2", fruitName = "Apple", 6000.0),
        Fruit(id = "3", fruitName = "Mango", 10000.0),
        Fruit(id = "4", fruitName = "Avocado", 8000.0),
        Fruit(id = "5", fruitName = "Watermelon", 21000.0),
    )

    fun printMenu() {
        println(
            """
            =========================
            Welcome to Fruit Store !
            =========================
            Our Fruits today :
            1. Melon
            2. Apple
            3. Mango
            4. Avocado
            5. Watermelon
            
            What do you want to buy ? 1/2/3/4/5
        """.trimIndent()
        )
    }

    fun run() {
        printMenu()
        readUserInputMenu()
        readTotalFruitUser()
        calculateTotalPrice()
    }

    fun readUserInputMenu() {
        inputMenuLoop@ while (true) {
            val input = readlnOrNull()?.trim()
            val fruitResult = fruits.find { fruit -> fruit.id == input }
            if (fruitResult != null) {
                selectedFruit = fruitResult
                break@inputMenuLoop
            } else {
                println("You input wrong value")
                printMenu()
            }
        }
        println("You select ${selectedFruit?.fruitName}")
    }

    fun readTotalFruitUser() {
        println("......................")
        println("How many ${selectedFruit?.fruitName} you wanna buy ? ")
        try {
            val input = readlnOrNull()?.trim()
            totalFruit = input?.toInt() ?: 0
        } catch (e: NumberFormatException) {
            println("Masukkan dengan format angka !")
            readTotalFruitUser()
        } catch (e: Exception) {
            println("Terjadi Error , Silahkan diulangi!")
            readTotalFruitUser()
        }
    }

    fun calculateTotalPrice() {
        totalPrice = totalFruit * (selectedFruit?.pricePerPcs ?: 0.0)
        println("Total price = $totalPrice")
        when {
            totalPrice in 0.0..99999.9 ->{
                println("You got no bonus Item")
            }

            totalPrice in 100000.0..150000.0 -> {
                println("You got extra 1 Watermelon")
            }

            totalPrice in 150000.0..200000.0 -> {
                println("You got extra 2 Melon")
            }

            totalPrice in 200000.0..250000.0 -> {
                println("You got extra 6 Avocado")
            }

            else -> {
                println("You got 1 KG apple")
            }
        }
    }
}

fun main() {
    BranchingApp().run()
}