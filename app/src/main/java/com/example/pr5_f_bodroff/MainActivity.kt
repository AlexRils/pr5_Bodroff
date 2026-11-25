
package com.example.pr5_f_bodroff

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.pr5_f_bodroff.navigation.AppNavHost

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            var isDark by rememberSaveable {
                mutableStateOf(false)
            }

            MaterialTheme(
                colorScheme = if (isDark) {
                    darkColorScheme()
                } else {
                    lightColorScheme()
                }
            ) {

                val navController = rememberNavController()

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    AppNavHost(
                        navController = navController,
                        isDark = isDark,
                        onThemeChange = {
                            isDark = !isDark
                        }
                    )
                }
            }
        }
    }
}
