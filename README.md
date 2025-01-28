<h2> Proyecto "QueComemos" - buffet de la Facultad de Informática - UNLP. </h2>

<h3> Dependencias </h3>
  Java: Versión 17. <br>
  Tomcat: Versión 9.0. <br>
  MariaDB: Versión 10.4.32 <br>


<h3> Ejecución: </h3>
<h5>1) Abrir el proyecto (utilizando Eclipse ó Intellij IDEA).</h5> 
<h5>2) Configurar el servidor:</h5> 
    2.1) Asegúrese que los puertos estén configurados correctamente. Utilizamos MySQL en el puerto 3306, y Tomcat en el puerto 8080. 
    Por comodidad, utilizamos XAMPP v3.3.0. Utilizando XAMPP, en nuestro caso, corremos MySQL en el puerto antes mencionado, y Apache en el puerto 80.  <br>

<h5>3) Levantar el backend:</h5>
   3.1) Corremos la aplicación ejecutando la clase "src/main/java/spring/QueComemos/QueComemosApplication.java", la misma se encargará de crear
   todas las tablas y datos de la base de datos, así como también habilitará todas las llamadas de las apis para el frontend. <br>
   
<h5>4) Levantar el frontend:</h5> <br>
   4.1) En la ubicación "src/angular", corremos el comando de Angular "ng serve", que levantará el proyecto en la ruta "localhost:4200/"  
 

<h3> Acceso al sitio: </h3>

  Una vez funcionando el backend y el frontend, accedemos a la ruta "localhost:4200/" e ingresamos las credenciales
     <h5>DNI: 30399203</h5>
     <h5>contraseña: 232323. </h5><br>
