package app

import app.model.ComputerSpec
import java.lang.Exception
import java.lang.IllegalStateException

class App(var creatorName: String? = null) { //Default value Constructor

    private var computerData = listOf(
        ComputerSpec(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRamInGb = 32,
            EGPUName = "RTX 4060"
        ),// computer 1
        ComputerSpec(
            processorName = "Intel i7",
            processorTotalCore = 8,
            isHaveIGPU = false,
            totalRamInGb = 16,
            EGPUName = "RTX 3060"
        ),// computer 2
        ComputerSpec(
            processorName = "Intel i3",
            processorTotalCore = 6,
            isHaveIGPU = false,
            totalRamInGb = 16,
            EGPUName = "RTX 2080"
        )// computer 3
    )
    private var selectedComputer: ComputerSpec? = null

    fun run() {
        printHeader()
        getSelectedComputer()
    }

    private fun printHeader() {
        println("============================")
        println("Created by : $creatorName")
        println("============================")
        println("Order PC App")
        println("============================")
        computerData.forEachIndexed { index, data ->
            println("${index + 1}.${data.processorName} : ${data.EGPUName}")
        } // lambda function
        println("============================")
    }

    private fun getSelectedComputer() {
        println("Masukan pilhan anda : ")
        try {
            val selectedIndex = readln().toInt()
            if (selectedIndex in 1..computerData.size) {
                selectedComputer = computerData[selectedIndex - 1]
                println("Pilihan komputer anda : $selectedComputer")
            } else {
                println("Pilihan anda salah, Silahkan coba lagi")
                getSelectedComputer()
            }
        } catch (e: Exception) {
            println("Menu Anda Salah")
            getSelectedComputer()//recursive
        }
    }

    companion object {
        @JvmStatic // annotation
        fun main(args: Array<String>) {
            App("Hermas").run()
        }
    }
}

