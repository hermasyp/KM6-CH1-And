package app.model

data class ComputerSpec(
    var processorName : String,
    var processorTotalCore : Int,
    var isHaveIGPU : Boolean,
    var totalRamInGb : Int,
    var EGPUName : String
)
