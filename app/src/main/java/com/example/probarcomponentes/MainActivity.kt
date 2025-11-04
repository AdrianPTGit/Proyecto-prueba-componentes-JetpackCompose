package com.example.probarcomponentes

// Importaciones necesarias de Jetpack Compose y Android
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.* // Column, Row, Spacer, etc.
import androidx.compose.material3.* // Button, Text, TextField, Checkbox, etc.
import androidx.compose.runtime.* // remember, mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource // Para cargar imágenes
import androidx.compose.ui.unit.dp // Tamaños en dp
import com.example.probarcomponentes.ui.theme.ProbarComponentesTheme
import kotlinx.coroutines.launch

// --- Clase principal ---
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProbarComponentesTheme {
                // ✅ Ambas funciones son composables y están al mismo nivel
               // Componentes()
                ProbarSnackBar()
            }
        }
    }
}

// --- Función composable principal ---
@Composable
fun Componentes() {
    var selectedOption by remember { mutableStateOf("option1") }
    var isChecked by remember { mutableStateOf(false) }
    var text by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        // --- Botón + Imagen ---
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { }) {
                Text("Mi botón")
            }

            Image(
                painter = painterResource(id = R.drawable.imagen2),
                contentDescription = "Imagen de una flor amarilla",
                modifier = Modifier.size(100.dp)
            )
        }

        Spacer(modifier = Modifier.height(30.dp))

        // --- RadioButtons ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            RadioButton(
                selected = selectedOption == "option1",
                onClick = { selectedOption = "option1" }
            )
            Text("Opción 1")

            Spacer(modifier = Modifier.width(16.dp))

            RadioButton(
                selected = selectedOption == "option2",
                onClick = { selectedOption = "option2" }
            )
            Text("Opción 2")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // --- Checkbox ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isChecked,
                onCheckedChange = { isChecked = it }
            )
            Text("Aceptar términos")
        }

        Spacer(modifier = Modifier.height(20.dp))

        // --- TextField ---
        TextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Introduce texto") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // --- TextButton ---
        TextButton(onClick = { println("TextButton pulsado") }) {
            Text("Haz clic aquí")
        }
    }
}

// --- ✅ Snackbar separado (fuera de Componentes) ---
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProbarSnackBar() {
    // 🔹 Crea un estado para controlar los mensajes del Snackbar.
    // SnackbarHostState permite mostrar, ocultar o actualizar un snackbar.
    val snackbarHostState = remember { SnackbarHostState() }

    // 🔹 Crea un alcance de corrutina para ejecutar tareas asíncronas (como mostrar el Snackbar).
    val scope = rememberCoroutineScope()

    // 🔹 Scaffold es una estructura base de Material Design.
    // Permite incluir barras superiores, botones flotantes, snackbars, etc.
    Scaffold(
        modifier = Modifier.fillMaxSize(), // Hace que ocupe toda la pantalla.
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) } // Conecta el Snackbar al Scaffold.
    ) { innerPadding -> // innerPadding evita que el contenido se superponga con el Snackbar o la barra del sistema.

        // 🔹 Contenedor en columna (vertical)
        Column(
            modifier = Modifier
                .padding(innerPadding) // Aplica el padding interno del Scaffold.
                .fillMaxSize()          // Ocupa todo el espacio disponible.
                .padding(16.dp),        // Añade margen interno de 16dp.
            verticalArrangement = Arrangement.Center,        // Centra los elementos verticalmente.
            horizontalAlignment = Alignment.CenterHorizontally // Centra los elementos horizontalmente.
        ) {

            // 🔹 Botón que, al pulsarse, muestra el Snackbar.
            Button(
                onClick = {
                    // Al hacer clic, lanzamos una corrutina (porque showSnackbar es suspend).
                    scope.launch {
                        // Muestra el Snackbar con un mensaje y una acción opcional ("Deshacer").
                        val result = snackbarHostState.showSnackbar(
                            message = "Acción realizada con éxito ✅",
                            actionLabel = "Deshacer"
                        )

                        // 🔹 Cuando el Snackbar desaparece o se pulsa la acción, devuelve un resultado:
                        when (result) {
                            // Si el usuario pulsa la acción "Deshacer"
                            SnackbarResult.ActionPerformed -> {
                                // Muestra otro Snackbar indicando que la acción se revirtió.
                                snackbarHostState.showSnackbar("Acción deshecha 🔄")
                            }

                            // Si el usuario cierra o ignora el Snackbar
                            SnackbarResult.Dismissed -> {
                                println("Snackbar cerrado")
                            }
                        }
                    }
                }
            ) {
                // 🔹 Texto dentro del botón
                Text("Mostrar Snackbar")
            }
        }
    }
}
/*
Resumen rápido:

Elemento	                            Función
----------------------------------------------------------------------------------------------------

Scaffold	                            Estructura base que aloja el Snackbar.

SnackbarHostState	                    Gestiona el estado (mostrar/ocultar) del Snackbar.

rememberCoroutineScope()	            Permite ejecutar tareas suspendidas desde un evento de UI.

scope.launch	                        Lanza la corrutina que muestra el Snackbar.

showSnackbar()	                        Muestra el mensaje temporal con una posible acción.

SnackbarResult.ActionPerformed	        Se ejecuta si el usuario pulsa “Deshacer”.

SnackbarResult.Dismissed	            Se ejecuta si el Snackbar desaparece sin interacción.
 */