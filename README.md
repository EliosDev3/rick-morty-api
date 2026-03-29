# rick-morty-api
API que consume y muestra los personajes de la API REST rickandmortyapi.com

Como correr el desarrollo
- Tener previamente instalado Java version 21 en adelante con las variables de ambiente PATH y JAVA_HOME configuradas.
- Descargar Spring Tools desde la liga https://spring.io/tools en donde seleccionaremos la descarga para Eclipse e indicaremos para nuestro caso que es Windows. Lo anterior descargará un archivo zip, ejem: spring-tools-for-eclipse-5.1.1.RELEASE-e4.39.0-win32.win32.x86_64.zip
- El zip descargado se descomprime y la carpeta se deja en un direcctorio de nuestra elección, ejem: C:\sts-5.1.1.RELEASE
- Creamos la carpeta que sera nuestro workspace que es en donde guardaremos todos los proyectos, el nombre de la carpeta y directorio a nuestra elección, ejem: C:\Proyectos
- Descargamos el ZIP del proyecto rick-morty-api de GitHub y se descomprime en la carpeta C:\Proyectos
- Ejecutamos el archivo SpringToolsForEclipse.exe que esta dentro de C:\sts-5.1.1.RELEASE y en el cuadro de dialogo que muestra para seleccionar el directorio que será el workspace le indicamos que es C:\Proyectos y continuamos.
- Dentro de Spring Tools, nos dirigimos al menú "File->Open Projects for File System"
  - En la caja de texto "Import source:" le indicamos donde está nuestro proyecto presionando el boton "Directory" y escogemos el folder de nuestro proyecto que está en nuestro workspace, ejem: C:\Proyectos\rick-morty-api-main y se mostrará nuestro proyecto junto a un checkbox, si el checkbox no esta seleccionado lo seleccionamos y presionamos el boton "Finish".
  - El proyecto se mostrará en el área "Package Explorer" que está en la parte superior izquierda.
  - Para correr nuestro proyecto, en la parte inferior izquierda se muestra el área "Boot Dashboard", en la opcion "local" damos click en el icono "v" para desplegar los proyectos con SpringBoot y ahí se motrará nuestro proyecto "rick-morty-api-main", click derecho sobre nuestro proyecto y seleccionamos la opción (Re)start, mostrándose en la parte inferior en la pestaña "Console" el log del proceso de despliege de la aplicación.
  - Finalmente, para visualizar la aplicación, en el explorador de internet escribimos: http://localhost:8080/personajes/listarPersonajes
  - Nota: Verificar que el puerto 8080 no este ocupado por otro proceso.

Decisiones técnicas
- Lenguaje y framework: Java 21 - Spring Boot 3.5.13.
- Organización del código: Se implementa el patron Controller-Service y Model para el transporte de datos.
- Motor de plantillas: Thymeleaf.
- Configuración externa: Se utiliza archivos .yml para externalizar la configuración.
- Manejo de errores: Se crea un manejador global de excepciones (@ControllerAdvice).
- Inyección de dependencias: Se utiliza inyección por campo (@Autowired).

Mejoras futuras
- Manejar algunas validaciones del template en javascript.
- Mejorar la paginación del template.
- Mejorar la carga de las imagenes.
- Manejo de errores.


<img width="1595" height="1079" alt="screenshot3" src="https://github.com/user-attachments/assets/9ffe1830-49f5-4abd-bc4f-5ec62de92656" />
<img width="1592" height="1080" alt="screenshot2" src="https://github.com/user-attachments/assets/e33df2d7-bfcc-472b-af38-72d265492eb5" />
<img width="1606" height="1076" alt="screenshot1" src="https://github.com/user-attachments/assets/1317e330-814e-4eaa-8add-e1cd679601bc" />


