
package com.example.pr5_f_bodroff.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.pr5_f_bodroff.data.SpecialtyRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(
    specialtyId: Int,
    navController: NavHostController
) {

    val specialty = SpecialtyRepository.specialties.find {
        it.id == specialtyId
    }

    val context = LocalContext.current

    Scaffold(

        topBar = {
            TopAppBar(
                title = {
                    Text("Детали специальности")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            navController.popBackStack()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "Назад"
                        )
                    }
                }
            )
        }

    ) { innerPadding ->

        if (specialty != null) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                Text(
                    text = specialty.title,
                    style = MaterialTheme.typography.headlineMedium
                )

                Text(
                    text = "Код специальности: ${specialty.code}"
                )

                Text(
                    text = "Описание: ${specialty.description}"
                )

                Text(
                    text = "Срок обучения: ${specialty.studyPeriod}"
                )

                Text(
                    text = "Квалификация: ${specialty.qualification}"
                )

                Spacer(modifier = Modifier.height(16.dp))

                Button(
                    onClick = {
                        val intent = Intent(
                            Intent.ACTION_DIAL,
                            Uri.parse("tel:88001234567")
                        )
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Позвонить в приёмную комиссию")
                }
            }
        } else {
            Text(
                text = "Специальность не найдена",
                modifier = Modifier.padding(innerPadding).padding(16.dp)
            )
        }
    }
}
