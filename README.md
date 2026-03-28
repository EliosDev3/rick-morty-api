# rick-morty-api
API que consume y muestra los personajes de la API REST rickandmortyapi.com

Decisiones Técnicas
- Lenguaje y framework: Java 21 - Spring Boot
- Organización del código: Se implementa el patron Controller-Service y Model para el transporte de datos.
- Motor de plantillas: Thymeleaf
- Configuración externa: Se utiliza archivos .yml para externalizar la configuración.
- Manejo de errores: Se crea un manejador global de excepciones (@ControllerAdvice).
- Inyección de dependencias: Se utiliza inyección por campo (@Autowired).

Mejoras futuras
- Manejar algunas validaciones del template en javascript
- Mejorar la paginación del template
- Mejorar la carga de las imagenes
- Manejo de errores


<img width="1606" height="1076" alt="screenshot1" src="https://github.com/user-attachments/assets/1317e330-814e-4eaa-8add-e1cd679601bc" />
<img width="1592" height="1080" alt="screenshot2" src="https://github.com/user-attachments/assets/e33df2d7-bfcc-472b-af38-72d265492eb5" />
<img width="1595" height="1079" alt="screenshot3" src="https://github.com/user-attachments/assets/9ffe1830-49f5-4abd-bc4f-5ec62de92656" />
