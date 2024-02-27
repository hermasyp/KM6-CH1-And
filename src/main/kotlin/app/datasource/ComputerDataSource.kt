package app.datasource

import app.model.ComputerSpec

interface ComputerDataSource {
    fun getComputerList() : List<ComputerSpec>
}

class ComputerDataSourceImpl() : ComputerDataSource{
    override fun getComputerList() : List<ComputerSpec>{
        return listOf(
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
    }
}