package Servelet;

import Controlador.UsuarioDAO;
import Modelo.Usuarios;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String email = request.getParameter("email");
        String clave = request.getParameter("clave");

        UsuarioDAO dao = new UsuarioDAO();
        Usuarios usuario = dao.validarLogin(email, clave);

        if (usuario != null) {

            HttpSession session = request.getSession(true);
            session.setAttribute("usuarioLogueado", usuario);

            // Administrador
            if (usuario.getRol_idRol() == 1) {

                response.sendRedirect(
                        request.getContextPath()
                        + "/Vista/Panel.jsp");

            }
            // Cliente
            else {

                response.sendRedirect(
                        request.getContextPath()
                        + "/Vista/Tienda.jsp");

            }

        } else {

            request.setAttribute(
                    "error",
                    "Correo o contraseña incorrectos");

            request.getRequestDispatcher(
                    "/Vista/Login.jsp")
                    .forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(
                request.getContextPath()
                + "/Vista/Login.jsp");
    }
}