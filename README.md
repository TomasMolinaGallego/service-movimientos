# Servicio movimientos
Este servicio movimientos surgió de la necesidad de tener una herramienta por la cual poder controlar los gastos e ingresos y poder visualizarlos claramente, cosa que las aplicaciones con el banco dejan mucho que desear, así que dije, ¿por qué no hacer yo mismo una aplicación para poder verlo como quiera?
## Uso y despliege
Para cualquiera de las opciones, hace falta tener una base de datos mariadb conectada al puerto 3306 con un schema que se llame "wheredidmymoneygo" (pendiente de simplificar).
### Usarse como standalone
Si se desea usar este servicio, ya sea mediante directamente llamadas API o crearle una interfaz de usuario propia, simplemente ejecutar:
```
./mvnw spring-boot:run
```
Es posible que haya errores al intentar conectarse a la base de datos si no se dispone de la que la aplicación necesita.
Una vez ejecutado satisfactoriamente estará escuchando en localhost:8080

### Usarse junto al frontend "Where did my money go?"

Si se desea usar junto al [frontend](https://github.com/TomasMolinaGallego/WDMMG-frontend), meter ambos proyectos en un mismo directorio, sacar a ese directorio el script (para Windows) initApp.bat y ejecutar, se deberían de abrir dos consolas, una para el front y otra para el back
```
initApp.bat
```
Si se ejecuta todo correctamente, el frontend debería de estar ejecutándose en localhost:4200

## Detalles técnicos
Micro servicio para gestionar los "movimientos", los cuales son los objetos del servicio para representar las transacciones monetarias. Cuenta con las funcionalidades básicas para registrar y recuperar mediante API los movimientos (modificaciones y eliminaciones en desarrollo).

El contrato de interfaz se encuentra en api.yml donde estarán todas las rutas disponibles en el servicio.

Desarrollado con Java 17 junto a Spring Boot y base de datos en MariaDB.

Es un projecto pensado para ser un micro servicio que será utilizado por un front hecho en el repositorio, pero a libre disposición de modificar o crearle uno nuevo. 

## Lista de ToDo's

- Añadir llamada API para el delete y la modificación
- Añadir gestión de usuario (todo en local)
- Traducir readme a inglés y francés

## Agradecimientos
Muchas gracias por haber leido hasta aquí, cualquier problema, sugerencia o aporte será bienvenido.
![Gatito de despedida](https://kindpng.com/imgv/iTmmTom_cat-cute-and-kawaii-image-pixel-art-cat/)