package app.utils

import java.lang.Exception

object IOUtils {
    fun getInputInteger(): Int? {
        return try {
            readln().toInt()
        } catch (e: Exception) {
            null
        }
    }
}