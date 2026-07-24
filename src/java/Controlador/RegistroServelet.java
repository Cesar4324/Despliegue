package Controlador;

import Modelo.Usuarios;
import java.io.IOException;
import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// NOTA: Si tu GlassFish saca error en "jakarta", cambia "jakarta" por "javax" en los imports.
@WebServlet(name = "RegistroServlet", urlPatterns = {"/RegistroServlet"})
public class RegistroServelet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        UsuarioDAO dao = new UsuarioDAO();
        Usuarios nuevo = new Usuarios();
        
        try {
            // Mapeo exacto con los nombres 'name' de tu formulario JSP
            nuevo.setNombre(request.getParameter("nombre"));
            nuevo.setApellido(request.getParameter("apellido"));
            nuevo.setIdentificacion(request.getParameter("identificacion"));
            nuevo.setTelefono(request.getParameter("telefono"));
            nuevo.setDireccion(request.getParameter("direccion"));
            nuevo.setEmail(request.getParameter("email"));
            nuevo.setClave(request.getParameter("clave"));
            
            // Captura de la fecha_nacimiento
            String fechaInput = request.getParameter("fecha_nacimiento");
            if (fechaInput != null && !fechaInput.isEmpty()) {
                nuevo.setFecha_nacimiento(Date.valueOf(fechaInput));
            }
            
            // Captura de las llaves foráneas numéricas desde tus etiquetas <select>
            nuevo.setTipoIdentificacion_idTipoIdentificacion(
                    Integer.parseInt(request.getParameter("TipoIdentificacion_idTipoIdentificacion"))
            );
            nuevo.setRol_idRol(
                    Integer.parseInt(request.getParameter("Rol_idRol"))
            );

            // Intentar registrar en la base de datos
            boolean exito = dao.registrar(nuevo);
            
            if (exito) {
                // Si todo sale bien, redirige al Login con un mensaje de éxito
                response.sendRedirect(request.getContextPath() + "/Vista/Login.jsp?msg=success");
            } else {
                // Si falla la inserción en la BD
                request.setAttribute("error", "No se pudo completar el registro en la base de datos.");
                request.getRequestDispatcher("Vista/Registro.jsp").forward(request, response);
            }
            
        } catch (IllegalArgumentException e) {
            request.setAttribute("error", "El formato de la fecha es inválido.");
            request.getRequestDispatcher("Vista/Registro.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println("Error en RegistroServlet: " + e.getMessage());
            request.setAttribute("error", "Error inesperado: " + e.getMessage());
            request.getRequestDispatcher("Vista/Registro.jsp").forward(request, response);
        }
    }
}