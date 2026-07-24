# 1. Imagen oficial estable de Tomcat 9 con Java 17 de Corretto
FROM tomcat:10.1-jdk17-corretto

# 2. Limpiar las aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# 3. Copiar la carpeta 'web' de tu proyecto como la aplicación principal (ROOT)
COPY web/ /usr/local/tomcat/webapps/ROOT/

# 4. Exponer el puerto
EXPOSE 8080

# 5. Iniciar Tomcat en primer plano
CMD ["catalina.sh", "run"]
