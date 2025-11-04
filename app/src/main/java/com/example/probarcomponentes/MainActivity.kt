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
@Composable
fun Componentes() {
    // --- VARIABLES DE ESTADO ---
    // remember + mutableStateOf permiten que Compose recuerde y reactive la interfaz al cambiar su valor

    // Guarda la opción seleccionada entre los RadioButtons
    var selectedOption by remember { mutableStateOf("option1") }

    // Guarda si el CheckBox está marcado o no
    var isChecked by remember { mutableStateOf(false) }

    // Guarda el texto introducido en el campo de texto
    var text by remember { mutableStateOf("") }


    // --- CONTENEDOR PRINCIPAL ---
    Column(
        modifier = Modifier
            .fillMaxSize()     // Hace que la columna ocupe toda la pantalla
            .padding(16.dp),   // Añade un margen interno de 16dp
        verticalArrangement = Arrangement.Top,         // Los elementos se organizan desde arriba
        horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente el contenido
    ) {

        // Espacio inicial de separación
        Spacer(modifier = Modifier.height(20.dp))


        // --- FILA: Botón + Imagen ---
        Row(
            modifier = Modifier.fillMaxWidth(),                     // Ocupa todo el ancho
            horizontalArrangement = Arrangement.SpaceAround,         // Distribuye los elementos de forma uniforme
            verticalAlignment = Alignment.CenterVertically           // Centra verticalmente los elementos
        ) {
            // Botón simple que no ejecuta ninguna acción por ahora
            Button(onClick = { }) {
                Text("Mi botón")
            }

            // Imagen cargada desde los recursos drawables
            Image(
                painter = painterResource(id = R.drawable.imagen2),   // Imagen en res/drawable/imagen2
                contentDescription = "Imagen de una flor amarilla",   // Texto alternativo accesible
                modifier = Modifier.size(100.dp)                      // Tamaño fijo de 100dp
            )
        }

        // Separación vertical entre secciones
        Spacer(modifier = Modifier.height(30.dp))


        // --- RADIO BUTTONS (selección única) ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            // Primer RadioButton
            RadioButton(
                selected = selectedOption == "option1",       // Marcado si la opción actual es "option1"
                onClick = { selectedOption = "option1" }      // Al hacer clic, cambia el valor del estado
            )
            Text("Opción 1")

            // Espacio entre las dos opciones
            Spacer(modifier = Modifier.width(16.dp))

            // Segundo RadioButton
            RadioButton(
                selected = selectedOption == "option2",
                onClick = { selectedOption = "option2" }
            )
            Text("Opción 2")
        }

        Spacer(modifier = Modifier.height(20.dp))


        // --- CHECKBOX (selección múltiple o binaria) ---
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = isChecked,                    // Estado actual del checkbox
                onCheckedChange = { isChecked = it }    // Cambia el valor al marcar o desmarcar
            )
            Text("Aceptar términos")
        }

        Spacer(modifier = Modifier.height(20.dp))


        // --- CAMPO DE TEXTO (entrada de usuario) ---
        TextField(
            value = text,                               // Valor actual del texto
            onValueChange = { text = it },              // Actualiza el estado al escribir
            label = { Text("Introduce texto") },        // Etiqueta del campo
            modifier = Modifier.fillMaxWidth()          // Ocupa todo el ancho disponible
        )

        Spacer(modifier = Modifier.height(20.dp))


        // --- BOTÓN DE TEXTO ---
        TextButton(
            onClick = { println("TextButton pulsado") } // Acción al hacer clic (solo imprime un mensaje)
        ) {
            Text("Haz clic aquí")                       // Texto del botón
        }
    }
}

/*
RESUMEN DE LOS COMPONENTES:

Elemento	                        Función
----------------------------------------------------------------------------------------------------
Column	                            Organiza los elementos en vertical.
Row	                               Organiza elementos en horizontal.
Spacer	                            Añade espacio entre elementos.
Button	                            Botón con fondo (Material 3).
Image	                            Muestra imágenes desde recursos.
RadioButton	                        Permite elegir una opción entre varias.
Checkbox	                        Permite activar o desactivar una opción.
TextField	                        Campo de texto editable.
TextButton	                        Botón de texto plano sin fondo.
remember + mutableStateOf	        Crea variables reactivas que actualizan la UI automáticamente.
 */


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