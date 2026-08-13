package Servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/api/promociones")
public class PromocionesServelet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Configuración para retornar JSON en UTF-8
        response.setContentType("application/json;charset=UTF-8");

        // Cabeceras CORS para permitir la conexión desde dispositivos móviles
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET, POST, OPTIONS");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type");

        PrintWriter out = response.getWriter();

        String jsonPromociones = "["
            + "{\"id\": 1, \"titulo\": \"Chaquetas STROGER\", \"descuento\": \"30% OFF\"},"
            + "{\"id\": 2, \"titulo\": \"Camisetas Básicas\", \"descuento\": \"2x1\"},"
            + "{\"id\": 3, \"titulo\": \"Pantalones Cargo\", \"descuento\": \"Envío Gratis\"},"
            + "{\"id\": 4, \"titulo\": \"Colección de Invierno\", \"descuento\": \"Hasta 50% OFF\"}"
            + "]";

        out.print(jsonPromociones);
        out.flush();
    }
}