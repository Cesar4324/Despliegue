# Usa la imagen oficial de Tomcat con JDK 17 (puedes cambiar la versión si tu app requiere otra)
FROM tomcat:10.1-jdk17

# Evita avisos durante la instalación de paquetes
ENV DEBIAN_FRONTEND=noninteractive

# Opcional: Limpia la carpeta webapps por defecto si quieres que solo esté tu aplicación
RUN rm -rf /usr/local/tomcat/webapps/*

# Instala curl (por si la imagen base no lo incluye) y descarga el archivo WAR desde GitHub
ARG WAR_URL="https://github.com/TU_USUARIO/TU_REPOSITO/raw/main/ByStyle.war"
RUN apt-get update && \
    apt-get install -y --no-install-recommends curl && \
    curl -L -o /usr/local/tomcat/webapps/ByStyle.war "${WAR_URL}" && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Puerto por defecto de Tomcat
EXPOSE 8080

# Comando para iniciar Tomcat
CMD ["catalina.sh", "run"]
