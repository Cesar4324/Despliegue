# 1. Usar Tomcat 10 con Java 17
FROM tomcat:10.1-jdk17

# 2. Limpiar las aplicaciones por defecto de Tomcat
RUN rm -rf /usr/local/tomcat/webapps/*

# 3. Copiar tu archivo .war como la aplicación principal (ROOT)
COPY ByStyle.war /usr/local/tomcat/webapps/ROOT.war

# 4. Exponer el puerto HTTP
EXPOSE 8080

# 5. Iniciar Tomcat
CMD ["catalina.sh", "run"]
