# 📚 Biblioteca

Proyecto académico desarrollado en Java para la **Universidad del Quindío** como parte del curso de Programación Orientada a Objetos (POO). Simula el sistema de gestión de una biblioteca universitaria, permitiendo administrar estudiantes, bibliotecarios, libros y préstamos con cálculo automático de costos y sueldos.

---

## 📁 Estructura del proyecto

```
src/
├── main/java/co/edu/uniquindio/poo/
│   ├── application/
│   │   └── App.java                # Punto de entrada (placeholder)
│   └── model/
│       ├── Persona.java            # Clase base con datos personales
│       ├── Estudiante.java         # Extiende Persona, gestiona sus préstamos
│       ├── Bibliotecario.java      # Extiende Persona, calcula su sueldo
│       ├── Libro.java              # Entidad libro con control de unidades
│       ├── Prestamo.java           # Entidad préstamo con cálculo de costo
│       ├── DetallesPrestamo.java   # Detalle de libro dentro de un préstamo
│       ├── EstadoPrestamo.java     # Enum: ENTREGADO / NOENTREGADO
│       └── Biblioteca.java         # Clase central de gestión
└── test/java/co/edu/uniquindio/poo/
    ├── AppTest.java
    ├── Bibliotecatest.java
    ├── Bibliotecariotest.java
    ├── Estudiantetest.java
    ├── Librotest.java
    └── Prestamotest.java
```

---

## 🧩 Modelo de clases

### Jerarquía de herencia

```
Persona
├── Estudiante
└── Bibliotecario
```

### `Persona`
Clase base con `nombre`, `cedula`, `telefono` y `correo`. La igualdad entre personas se determina por la **cédula**.

### `Estudiante`
Extiende `Persona`. Mantiene un `HashMap<String, Prestamo>` de sus préstamos, donde la clave es el código del préstamo.

- `contarcantidadprestamos()` — Cantidad de préstamos activos.
- `AgregarPrestamo` / `Eliminarprestamo` / `actualizarprestamo` — CRUD de préstamos propios.

### `Bibliotecario`
Extiende `Persona`. Además de gestionar su propia lista de préstamos, calcula su sueldo dinámicamente.

- `calcularsueldo()` — El sueldo equivale al 20% del costo total de sus préstamos gestionados, más un 2% adicional por cada año de antigüedad desde su fecha de ingreso.
- `contarcantidadprestamos()` — Cantidad de préstamos gestionados.

### `Libro`
Representa un libro con `codigo`, `isbn`, `autor`, `titulo`, `editorial`, `fechapublicacion` y `unidadesdisp`. La igualdad se determina por el **código**.

- `disminuircantidaddisponible(int)` — Se invoca al crear un `DetallesPrestamo`.
- `aumentarcantidaddisponible(int)` — Se invoca al calcular el costo del préstamo (entrega).
- `contarcantidadprestamos()` — Cuenta en cuántos detalles de préstamo aparece el libro.

### `DetallesPrestamo`
Representa un ítem dentro de un préstamo: un libro, la cantidad prestada y el costo por unidad/día. Al crearse, **descuenta automáticamente** las unidades disponibles del libro.

### `EstadoPrestamo` (enum)
`ENTREGADO` · `NOENTREGADO`

### `Prestamo`
Representa un préstamo completo. Se identifica por su **código**. Al crearse, su estado es `NOENTREGADO`.

- `calcularcostoprestamo(Date fechaentrega)` — Calcula el costo total multiplicando la suma de costos de los detalles por los días transcurridos. Marca el préstamo como `ENTREGADO` y restaura las unidades disponibles de cada libro.

### `Biblioteca`
Clase central que orquesta toda la lógica con tres colecciones:
- `ArrayList<Persona>` — estudiantes y bibliotecarios.
- `LinkedList<Libro>` — catálogo de libros.
- `HashMap<String, Prestamo>` — préstamos indexados por código.

**Operaciones principales:**

| Método | Descripción |
|---|---|
| `Agregarestudiante` / `Eliminarestudiante` / `Actualizarestudiante` | CRUD de estudiantes |
| `AgregarBibliotecario` / `EliminarBibliotecario` / `ActualizarBibliotecario` | CRUD de bibliotecarios |
| `AgregarLibro` / `EliminarLibro` / `ActualizarLibro` | CRUD de libros |
| `AgregarPrestamo` / `Eliminarprestamo` / `actualizarprestamo` | CRUD de préstamos |
| `BuscarLibroCodigo(String)` | Busca un libro por su código |
| `CantidadPrestamosLibro(String)` | Cuenta cuántas veces se ha prestado un libro por título |
| `Reemplazarlibro(Libro, Libro)` | Sustituye un libro por otro en el catálogo |
| `Entregarprestamo(String, Date)` | Registra la entrega y retorna el costo total |
| `CantidadPrestamosEmpleado()` | Lista cada bibliotecario con su cantidad de préstamos |
| `EstudianteMasPrestamos()` | Retorna el estudiante con más préstamos |
| `TotalDineroRecaudado()` | Suma el costo total de todos los préstamos |
| `TotalDineroPagarBibliotecarios()` | Suma el sueldo calculado de todos los bibliotecarios |

---

## 🧪 Pruebas unitarias

| Clase de test | Qué prueba |
|---|---|
| `Bibliotecatest` | Agregar estudiante nulo, duplicado y correcto; actualizar libro |
| `Bibliotecariotest` | Cálculo de sueldo con antigüedad y préstamos; conteo de préstamos |
| `Estudiantetest` | Conteo de préstamos; integridad del `HashMap` de préstamos |
| `Librotest` | Descuento y restauración de unidades disponibles; conteo de detalles |
| `Prestamotest` | Cálculo de costo total (días × suma detalles); método `equals` por código |

---

## 🛠️ Tecnologías

- **Java** (SE 8+)
- **Maven** (gestión del proyecto)
- **JUnit 5** (pruebas unitarias)

---

## 🚀 Cómo ejecutar

```bash
# Clonar el repositorio
git clone <url-del-repositorio>

# Compilar con Maven
mvn compile

# Ejecutar las pruebas
mvn test
```

---

## 📄 Licencia

GNU/GPL V3.0 — [Ver licencia](https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE)
