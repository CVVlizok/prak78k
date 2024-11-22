package com.example.prak78k

import android.content.Context
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase.assertNotNull
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityModuleTest {
    @Test
    fun testImageIsLoaded() {
        val network = NetworkUtilities()

        val imageUrl = "https://i.pinimg.com/474x/5a/4c/30/5a4c30bb0403e02a363ce958ed4e7ebf.jpg"
        val bitmapDeferred = network.downloadImage(imageUrl)

        runBlocking {
            val bitmap = bitmapDeferred.await() // Получаем загруженное изображение
            assertNotNull(bitmap) // Проверяем, что изображение не null
        }
    }
}