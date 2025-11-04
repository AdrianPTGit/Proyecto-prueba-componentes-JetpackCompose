# Finalidad: Conocer los diferentes elementos UI disponibles en Jetpack:
  - Texto
  - cajas de texto 
  - botones 
  - listas
  - Snackbars
  - cuadros de información etc…
# Lista de elementos UI en Jetpack Compose

## 🧱 Componentes básicos de UI

| Elemento | Descripción |
|-----------|-------------|
| `Text()` | Muestra texto en pantalla. |
| `Image()` | Muestra una imagen (painter o recurso). |
| `Icon()` | Muestra un icono (usualmente de Material Icons). |
| `Button()` | Botón con acción al hacer clic. |
| `TextButton()` | Botón con solo texto. |
| `OutlinedButton()` | Botón con borde. |
| `IconButton()` | Botón que solo contiene un ícono. |
| `FloatingActionButton()` | Botón flotante circular. |
| `Card()` | Contenedor con sombra y esquinas redondeadas. |
| `Surface()` | Contenedor base para aplicar color, forma, elevación, etc. |

---

## 📦 Contenedores y disposición (Layout)

| Elemento | Descripción |
|-----------|-------------|
| `Column()` | Coloca los elementos uno debajo del otro (vertical). |
| `Row()` | Coloca los elementos uno al lado del otro (horizontal). |
| `Box()` | Superpone elementos o los organiza libremente. |
| `Spacer()` | Crea espacio vacío. |
| `LazyColumn()` | Lista vertical eficiente (scroll). |
| `LazyRow()` | Lista horizontal eficiente (scroll). |
| `LazyVerticalGrid()` | Disposición en cuadrícula (scrollable). |
| `FlowRow()` / `FlowColumn()` | Distribuye elementos automáticamente (similar a flexbox). |
| `Scaffold()` | Estructura principal (con barra superior, inferior, FAB, etc). |
| `ConstraintLayout()` | Permite posicionar elementos con restricciones, similar a XML. |
| `BoxWithConstraints()` | Permite obtener las restricciones del layout (tamaño, etc). |

---

## 🧭 Navegación y estructura

| Elemento | Descripción |
|-----------|-------------|
| `TopAppBar()` | Barra superior de aplicación. |
| `BottomAppBar()` | Barra inferior de aplicación. |
| `BottomNavigation()` | Barra de navegación inferior. |
| `NavigationRail()` | Menú lateral vertical (tablets o pantallas grandes). |
| `Drawer()` / `ModalNavigationDrawer()` | Menú lateral deslizable. |
| `TabRow()` / `ScrollableTabRow()` | Pestañas para cambiar de vista. |
| `Snackbar()` | Mensaje temporal con acción. |
| `AlertDialog()` | Cuadro de diálogo con botones. |
| `DropdownMenu()` | Menú desplegable. |
| `Popup()` | Ventana emergente personalizada. |

---

## ✏️ Entrada de datos (Forms y campos)

| Elemento | Descripción |
|-----------|-------------|
| `TextField()` | Campo de texto editable. |
| `OutlinedTextField()` | Campo de texto con borde. |
| `BasicTextField()` | Campo de texto sin estilo. |
| `Checkbox()` | Casilla de verificación. |
| `RadioButton()` | Botón de opción única. |
| `Switch()` | Interruptor (on/off). |
| `Slider()` | Selector de valor numérico deslizable. |
| `RangeSlider()` | Selector de rango. |
| `DropDownMenu()` | Selector de opciones desplegable. |
| `DatePicker()` | Selector de fecha. |
| `TimePicker()` | Selector de hora. |

---

## 🖼️ Visuales y decorativos

| Elemento | Descripción |
|-----------|-------------|
| `Divider()` | Línea divisoria. |
| `CircularProgressIndicator()` | Indicador de carga circular. |
| `LinearProgressIndicator()` | Indicador de carga lineal. |
| `Canvas()` | Dibujo personalizado. |
| `ImageBitmap()` / `Painter()` | Para mostrar imágenes más avanzadas. |
| `LazyListScope.item` / `items` | Elementos dentro de listas `Lazy`. |

---

## 🧩 Material 3 (Jetpack Compose Material Design 3)

> Estos se encuentran en el paquete `androidx.compose.material3`.

| Elemento | Descripción |
|-----------|-------------|
| `CenterAlignedTopAppBar()` | Barra superior centrada. |
| `SmallTopAppBar()` / `LargeTopAppBar()` | Barras superiores de distintos tamaños. |
| `NavigationBar()` | Barra de navegación inferior (estilo Material 3). |
| `NavigationDrawer()` | Panel lateral moderno. |
| `Card()` / `ElevatedCard()` / `OutlinedCard()` | Variantes de tarjetas Material 3. |
| `ElevatedButton()` / `FilledButton()` / `OutlinedButton()` | Variantes modernas de botones. |
| `AssistChip()` / `FilterChip()` / `InputChip()` | Chips interactivos. |
| `DatePickerDialog()` / `TimePickerDialog()` | Selectores con estilo Material 3. |
| `AlertDialog()` | Cuadro de diálogo Material 3. |

---

## ⚙️ Otros útiles

| Elemento | Descripción |
|-----------|-------------|
| `remember { ... }` | Guarda estado en composición. |
| `rememberSaveable { ... }` | Guarda estado incluso tras recreaciones. |
| `LaunchedEffect()` | Ejecuta código con efectos secundarios. |
| `AnimatedVisibility()` | Muestra u oculta contenido con animación. |
| `Crossfade()` | Transición suave entre composables. |
| `rememberCoroutineScope()` | Permite lanzar corrutinas en Composables. |

---
