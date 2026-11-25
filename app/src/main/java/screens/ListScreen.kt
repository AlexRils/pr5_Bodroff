
package com.example.pr5_f_bodroff.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pr5_f_bodroff.data.SpecialtyRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavHostController,
    isDark: Boolean,
    onThemeChange: () -> Unit
) {

    var isDark by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Каталог ИТ-специальностей")
                }
            )
        },

        bottomBar = {
            BottomAppBar {

                IconButton(
                    onClick = onThemeChange
                ) {
                    Icon(
                        imageVector = if (isDark)
                            Icons.Default.LightMode
                        else
                            Icons.Default.DarkMode,
                        contentDescription = "Сменить тему"
                    )
                }

                Text(
                    text = if (isDark) "Светлая тема" else "Тёмная тема"
                )
            }
        }

    ) { innerPadding ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            items(SpecialtyRepository.specialties) { specialty ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                        .clickable {
                            navController.navigate("detail/${specialty.id}")
                        },
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {

                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {

                        Text(
                            text = specialty.title,
                            style = MaterialTheme.typography.titleMedium
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(
                            text = "Код: ${specialty.code}",
                            style = MaterialTheme.typography.bodyMedium
                        )

                        Spacer(modifier = Modifier.height(4.dp))

                        Text(
                            text = specialty.description,
                            style = MaterialTheme.typography.bodySmall
                        )
                    }
                }
            }
        }
    }
}
