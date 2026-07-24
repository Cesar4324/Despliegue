package Servelet; // Asegúrate de que coincida con el nombre exacto de tu paquete de Servlets

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "index", urlPatterns = {"/index"})
public class index extends HttpServlet {

    /**
     * Maneja los requerimientos HTTP GET.
     * Al acceder a la raíz o al patrón /index, redirige a la vista index.jsp.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Como tu index.jsp está dentro de la carpeta "Vistas", especificamos la ruta correcta:
        request.getRequestDispatcher("Vista/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // En caso de que se haga alguna petición POST al index, lo mandamos al GET
        doGet(request, response);
    }
}