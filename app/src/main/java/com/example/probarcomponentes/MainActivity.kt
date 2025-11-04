package com.example.probarcomponentes

// Importaciones necesarias de Jetpack Compose y Android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // Contiene Column, Row, Spacer, etc.
import androidx.compose.material3.* // Contiene Button, Text, TextField, Checkbox, etc.
import androidx.compose.runtime.* // Para manejar estados con remember y mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource // Para cargar imágenes desde recursos
import androidx.compose.ui.unit.dp // Para definir tamaños en dp
import com.example.probarcomponentes.ui.theme.ProbarComponentesTheme // Tema de la app

// --- Clase principal de la aplicación ---
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Habilita el diseño de borde a borde (sin barras de sistema visibles)
        enableEdgeToEdge()

        // Define el contenido de la interfaz con Compose
        setContent {
            // Aplica el tema de la app
            ProbarComponentesTheme {
                // Llama al composable principal que contiene los componentes de la UI
                Componentes()
            }
        }
    }
}

// --- Función composable principal ---
@Composable
fun Componentes() {
    // 🔹 Declaración de estados recordados (persisten mientras la composición esté activa)
    var selectedOption by remember { mutableStateOf("option1") } // Guarda la opción seleccionada del RadioButton
    var isChecked by remember { mutableStateOf(false) }           // Guarda el estado del Checkbox (marcado o no)
    var text by remember { mutableStateOf("") }                   // Guarda el texto escrito en el TextField

    // 🔹 Columna principal: organiza todo el contenido de arriba a abajo
    Column(
        modifier = Modifier
            .fillMaxSize()             // Ocupa toda la pantalla
            .padding(16.dp),           // Margen interior
        verticalArrangement = Arrangement.Top,        // Coloca los elementos desde arriba
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente los elementos
    ) {
        Spacer(modifier = Modifier.height(20.dp)) // Espacio inicial superior

        // --- Bloque: Botón + Imagen ---
        Row(
            modifier = Modifier.fillMaxWidth(), // La fila ocupa todo el ancho disponible
            horizontalArrangement = Arrangement.SpaceAround, // Espacia los elementos de forma uniforme
            verticalAlignment = Alignment.CenterVertically   // Centra los elementos verticalmente
        ) {
            Button(onClick = { }) { // Botón sin acción
                Text("Mi botón")    // Texto que muestra el botón
            }

            // Imagen cargada desde los recursos de la app
            Image(
                painter = painterResource(id = R.drawable.imagen2),
                contentDescription = "Imagen de una flor amarilla",
                modifier = Modifier.size(100.dp) // Tamaño de la imagen
            )
        }

        Spacer(modifier = Modifier.height(30.dp)) // Espacio entre bloques

        // --- Bloque: Opciones de RadioButton ---
        Row(
            verticalAlignment = Alignment.CenterVertically // Alinea los elementos al centro vertical
        ) {
            // RadioButton 1
            RadioButton(
                selected = selectedOption == "option1",   // Seleccionado si el estado coincide
                onClick = { selectedOption = "option1" }  // Cambia el estado al hacer clic
            )
            Text("Opción 1") // Etiqueta de la opción

            Spacer(modifier = Modifier.width(16.dp)) // Espacio entre los botones

            // RadioButton 2
            RadioButton(
                selected = selectedOption == "option2",
                onClick = { selectedOption = "option2" }
            )
            Text("Opción 2")
        }

        Spacer(modifier = Modifier.height(20.dp)) // Espacio vertical entre bloques

        // --- Bloque: Checkbox ---
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Checkbox(
                checked = isChecked,               // Estado actual del checkbox
                onCheckedChange = { isChecked = it } // Cambia el estado al hacer clic
            )
            Text("Aceptar términos") // Texto junto al checkbox
        }

        Spacer(modifier = Modifier.height(20.dp))

        // --- Bloque: Campo de texto ---
        TextField(
            value = text,                           // Valor actual del texto
            onValueChange = { text = it },          // Actualiza el estado cuando el usuario escribe
            label = { Text("Introduce texto") },    // Etiqueta del campo
            modifier = Modifier.fillMaxWidth()      // El campo ocupa todo el ancho disponible
        )

        Spacer(modifier = Modifier.height(20.dp))

        // --- Bloque: TextButton ---
        TextButton(
            onClick = { println("TextButton pulsado") } // Acción al pulsar (imprime en la consola)
        ) {
            Text("Haz clic aquí") // Texto visible en el botón
        }
    }
}

/*
🔍 RESUMEN DE QUÉ HACE CADA PARTE:
----------------------------------------------------------
- Column → organiza los bloques verticalmente.
- Row → organiza los elementos dentro de un bloque horizontalmente.
- horizontalArrangement = Arrangement.SpaceAround → distribuye los elementos de forma simétrica.
- Spacer → añade separación vertical (height) o horizontal (width).
- Alignment.CenterVertically → alinea verticalmente los elementos dentro de la fila.
- remember + mutableStateOf → permite guardar y actualizar estados en la UI de Compose.
----------------------------------------------------------
*/
