# CFI_6
link al repositorio. https://github.com/KravAD/CFI_6.git

El proyecto es una aplicacion de Java capaz de manejar datos y rutas de directorios. La aplicación consta de una interfaz de usuario construida con Swing y tiene tres botones para interactuar con el usuario. En comparación a otras entregas, se ha hecho un pequeña personalización como el de los botones e imagen de fondo de ventana. 
El proyecto se ha estructurado en 4 packages referentes a cada uno de los apartados del ejercicio. 
· El package AnalisisOrganizacion contiene las clases Venta y AnalisisRegistro. Venta es una clase que representa el objeto de venta y la clase AnalisisRegistro usa ese objeto para sus dos métodos de ordenación y filtro.
·El package MapasDatos contiene la clase Asociacion con dos métodos, asociarNumerosLetras y asociarNumerosTextuales, que usan map para hacer una conversión de número a letra o palabra.
·El package UI contiene dos clases que se encargan de la interfaz de usuario, estas son Interfaz y VentanaDatosDinamicos. Interfaz gestiona la ventana principal. Esta tiene tres JButtons: "Datos Dinámicos", "Indexar Archivos" y "Rutas Guardadas". Por otro lado, está la ventana secundaria VentanaDatosDinamicos que se abre al presionar el boton "Datos Dinamicos". Esta ventana ofrece una herramienta para añadir, modificar y eliminar datos que se van guardando en una lista.
