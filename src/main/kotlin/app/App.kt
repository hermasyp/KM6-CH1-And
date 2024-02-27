package app

import app.datasource.ComputerDataSourceImpl
import app.model.ComputerSpec
import app.utils.IOUtils
import java.lang.Exception
import java.lang.IllegalStateException


class App(var creatorName: String? = null) { //Default value Constructor

    private var computerData = ComputerDataSourceImpl().getComputerList()
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
        val selectedIndex = IOUtils.getInputInteger()
        selectedIndex?.let {
            if (selectedIndex in 1..computerData.size) {
                selectedComputer = computerData[selectedIndex - 1]
                println("Pilihan komputer anda : $selectedComputer")
            } else {
                println("Pilihan anda salah, Silahkan coba lagi")
                getSelectedComputer()
            }
        } ?: run {
            println("Input Anda salah ! coba lagi")
            getSelectedComputer()
        }

    }

    companion object {
        @JvmStatic // annotation
        fun main(args: Array<String>) {
            App("Hermas").run()
        }
    }
}

