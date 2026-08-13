# 1. Usar una imagen oficial de Tomcat con Java 11
FROM tomcat:9.0-jdk11-openjdk-slim

# 2. Limpiar las aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# 3. Copiar la carpeta 'web' de tu proyecto como la aplicación principal (ROOT)
COPY web/ /usr/local/tomcat/webapps/ROOT/

# 4. Exponer el puerto
EXPOSE 8080

# 5. Iniciar el servidor Tomcat
CMD ["catalina.sh", "run"]