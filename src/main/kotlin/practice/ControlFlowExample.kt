package practice

import app.model.ComputerSpec

class ControlFlowExample {

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
        )// computer 2
    )

    fun run() {
        checkName()
        println(checkName("nope"))
        println(checkNameUsingWhen("agustin"))
        exampleWhen()
        printSomething()
    }

    private fun checkName(name: String?): String {
        // If else
        return if (name == null) {
            "Your name still Empty"
        } else if (name.contains("Nope", ignoreCase = true)) {
            "Oh nope anak depok ya ?"
        } else if (name.contains("Komang", ignoreCase = true)) {
            "Oh komang anak bali ?"
        } else {
            "ihhh gatau kamu dimana ...."
        }
    }

    private fun checkNameUsingWhen(name: String?): String {
        //when biasanya digunakan untuk nilai yang fix
        return when (name) {
            "agus" -> "Apakah kamu lahir di agustus ?"
            "raya" -> "Apakah kamu lahir di hari raya ?"
            else -> {
                "Data kamu tidak ada"
            }
        }
    }

    private fun exampleWhen() {
        val contentType = ContentType.REELS
        when (contentType) {
            ContentType.PHOTO -> {
                println("konten foto")
            }

            ContentType.VIDEO -> {
                println("konten video")
            }

            ContentType.REELS -> {
                println("konten reels")
            }
        }
    }

    private var name: String? = "Tony Stark"

    private fun checkName() { // void
        //escape condition
        if (name == null) return
        println("Nama anda adalah $name")
        println("Anda adalah anak pemilik BCA")
    }

    private fun printSomething() {
        //for - loop 1
        for (index in 1..3) {
            println("Ini looping ke : $index")
        }
        //for loop step looping
        for (index in 1..10 step 2) {
            println("Ini looping ke : $index")
        }
        //for loop downTo
        for (index in 10 downTo 1 step 2) {
            println("Ini looping ke : $index")
        }
        // for-loop manual
        for (index in computerData.indices) {
            println("$index ${computerData[index]}")
        }
        //equivalent
        computerData.forEach {
            println("$it")
        }
        //with index
        computerData.forEachIndexed { index, computerSpec ->
            println("${index + 1}$computerSpec")
        }

        ///While && do while
        var index = 0
        do {
            println(index)
            index++
        } while (index < 5)

        index = 0
        while (index < 5) {
            println(index)
            index++
        }

        // escape, and continue
        for (index in 1..10) {
            if (index == 5) continue
            println("Ini looping ke : $index")
        }
        // destroy the loop
        for (index in 1..10) {
            if (index == 5) break
            println("Ini looping ke : $index")
        }

    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ControlFlowExample().run()
        }
    }
}

// adalah suatu kelas yang digunakan untuk identify sesuatu yang sudah fix
enum class ContentType {
    PHOTO, VIDEO, REELS
}
