package Servelet;

import Controlador.UsuarioDAO;
import Modelo.Usuarios;
import java.io.IOException;
import java.sql.Date;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Registro")
public class Registro extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(
                request.getContextPath()
                + "/Vista/registro.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        try {

            Usuarios usuario = new Usuarios();

            usuario.setNombre(
                    request.getParameter("nombre"));

            usuario.setApellido(
                    request.getParameter("apellido"));

            usuario.setIdentificacion(
                    request.getParameter("identificacion"));

            usuario.setTelefono(
                    request.getParameter("telefono"));

            usuario.setDireccion(
                    request.getParameter("direccion"));

            usuario.setEmail(
                    request.getParameter("email"));

            usuario.setClave(
                    request.getParameter("clave"));

            usuario.setTipoIdentificacion_idTipoIdentificacion(
                    Integer.parseInt(
                            request.getParameter("tipoIdentificacion")));

            usuario.setRol_idRol(
                    Integer.parseInt(
                            request.getParameter("rol")));

            usuario.setFecha_nacimiento(
                    Date.valueOf(
                            request.getParameter("fecha_nacimiento")));

            UsuarioDAO dao = new UsuarioDAO();

            boolean registrado = dao.registrar(usuario);

            if (registrado) {

                request.setAttribute(
                        "mensajeExito",
                        "Usuario registrado correctamente");

                request.getRequestDispatcher(
                        "/Vista/Login.jsp")
                        .forward(request, response);

            } else {

                request.setAttribute(
                        "error",
                        "No fue posible registrar el usuario");

                request.getRequestDispatcher(
                        "/Vista/registro.jsp")
                        .forward(request, response);
            }

        } catch (Exception e) {

            e.printStackTrace();

            request.setAttribute(
                    "error",
                    "Error: " + e.getMessage());

            request.getRequestDispatcher(
                    "/Vista/registro.jsp")
                    .forward(request, response);
        }
    }
}