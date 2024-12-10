# Generador de regiones | grafo de Argentina
## Video
[![Video del Proyecto](https://img.youtube.com/vi/3ohxWuWwB3U/maxresdefault.jpg)](https://www.youtube.com/watch?v=3ohxWuWwB3U)
## Descripción
El proyecto permite al usuario establecer similitudes entre provincias y visualizar las conexiones en un mapa. Además, se puede verificar si el grafo es conexo y crear regiones basadas en las similitudes.

## Tecnologías Utilizadas

- **Java**: Lenguaje de programación principal utilizado para desarrollar la lógica de la aplicación.
- **Swing**: Biblioteca de Java para crear la interfaz gráfica de usuario (GUI).
- **JMapViewer**: Biblioteca para integrar mapas interactivos en la aplicación.
- **JUnit**: Framework para realizar pruebas unitarias en el proyecto.
- **Eclipse**: IDE utilizado para el desarrollo del proyecto.

## Estructura del Proyecto

- `src/tpGrafos/logica`: Contiene la lógica del negocio, incluyendo las clases `AProvincia`, `BFS`, `ControladoraLogica`, `GrafoListaVecinos`, y `NProvincia`.
- `src/tpGrafos/igu`: Contiene la interfaz gráfica de usuario, incluyendo la clase `GrafoEditor`.
- `src/tpGrafosMain`: Contiene la clase principal para ejecutar la aplicación, `Main.java`.
- `src/tpGrafos/logica/test`: Contiene las pruebas unitarias, incluyendo la clase `GrafoListaVecinosTest`.

## Conceptos Aplicados

- **Grafos**: Estructura de datos utilizada para representar las provincias y sus conexiones. Se utiliza una lista de adyacencia (`GrafoListaVecinos`) para almacenar los grafos.
- **Búsqueda en Anchura (BFS)**: Algoritmo utilizado para recorrer el grafo y verificar si es conexo.
- **Interfaz Gráfica de Usuario (GUI)**: Implementada con Swing para permitir la interacción del usuario con la aplicación.
- **Mapas Interactivos**: Integración de `JMapViewer` para visualizar las provincias y sus conexiones en un mapa.
- **Pruebas Unitarias**: Uso de JUnit para asegurar la calidad del código y la correcta funcionalidad de los métodos.

## Funcionalidades

- **Agregar Provincias**: Permite al usuario agregar nuevas provincias al grafo.
- **Establecer Similitudes**: Permite definir la similitud (peso) entre dos provincias.
- **Verificar Conexidad**: Utiliza el algoritmo BFS para verificar si el grafo es conexo.
- **Crear Regiones**: Basado en las similitudes, permite crear regiones y visualizarlas en el mapa.
- **Visualización en Mapa**: Muestra las provincias y sus conexiones en un mapa interactivo.

## Pruebas Unitarias

Las pruebas unitarias se encuentran en `src/tpGrafos/logica/test/GrafoListaVecinosTest.java` y cubren los siguientes casos:

- **testNProvinciasNull**: Verifica que no se pueda crear un grafo con una lista de provincias nula.
- **testNumVerticesIncorrecto**: Verifica que no se pueda crear un grafo con un número incorrecto de vértices.
- **testAgregarVeticeNull**: Verifica que no se pueda agregar una arista con un vértice nulo.
- **testAgregarVeticeIgual**: Verifica que no se pueda agregar una arista entre el mismo vértice.
- **testAgregarVertice**: Verifica que se pueda agregar una arista correctamente.
- **testBorrarVertice**: Verifica que se pueda borrar una arista correctamente.
- **testNeighbors**: Verifica que se puedan obtener los vecinos de un vértice.
- **testVerificarVerticeNull**: Verifica que no se pueda verificar un vértice nulo.
- **testIgualTamanio**: Verifica que el tamaño del grafo sea correcto.

## Requisitos

- **Java 8 o superior**
- **Eclipse IDE**
- **Bibliotecas**: `JMapViewer`, `JUnit`

## Ejecución

1. Clonar el repositorio.
2. Importar el proyecto en Eclipse.
3. Ejecutar la clase `GrafoEditor` para iniciar la aplicación.

## Contribuciones

Las contribuciones son bienvenidas. Por favor, abre un issue o un pull request para discutir cualquier cambio que desees realizar.
