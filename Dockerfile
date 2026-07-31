# Usa la imagen oficial de Tomcat con JDK 17 (ajusta la versión si tu app requiere otra)
FROM tomcat:10.1-jdk17

# Limpia la carpeta webapps por defecto para que solo esté tu aplicación
RUN rm -rf /usr/local/tomcat/webapps/*

# Copia el WAR directamente desde el repositorio (contexto de build)
# Ajusta la ruta si el archivo no está en la raíz del repo
COPY ByStyle.war /usr/local/tomcat/webapps/ByStyle.war

# Puerto por defecto de Tomcat
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
