package practice

import app.model.ComputerSpec

class ScopeFunctionExample {

    private val creatorName : String? = null
    private var computerData : ComputerSpec? = null

    fun run() {
        //let
        creatorName?.let {
            println("Created by : $creatorName")
        } ?: run {
            println("This program is Open Source")
        }

        /*Equals
        *   if(creatorName != null){
                println("Created by : $creatorName")
            }else{
                println("This program is Open Source")
            }
        * */

        // apply
        println(computerData)
        // computer data is null
        computerData?.apply {
            this.processorName = "Intel Pentium"
        } ?: run{ println("Computer data is null") }
        computerData = ComputerSpec(
            processorName = "Intel i9",
            processorTotalCore = 8,
            isHaveIGPU = true,
            totalRamInGb = 32,
            EGPUName = "RTX 4060"
        )
        //computer data not null
        computerData?.apply {
            this.processorName = "Intel Pentium"
        } ?: run{ println("Computer data is null") }
        println(computerData)

        //with
        //before
        println(computerData?.processorName)
        println(computerData?.totalRamInGb)
        println(computerData?.isHaveIGPU)

        //after
        with(computerData){
            println(this?.processorName)
            println(this?.totalRamInGb)
            println(this?.isHaveIGPU)
        }
    }


    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            ScopeFunctionExample().run()
        }
    }
}