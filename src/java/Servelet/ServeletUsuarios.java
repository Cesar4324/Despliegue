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

@WebServlet("/ServletUsuario")
public class ServeletUsuarios extends HttpServlet {

private UsuarioDAO usuarioDAO = new UsuarioDAO();

@Override
protected void doGet(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    response.sendRedirect(
            request.getContextPath()
            + "/Vistas/Login.jsp");
}

@Override
protected void doPost(HttpServletRequest request,
        HttpServletResponse response)
        throws ServletException, IOException {

    request.setCharacterEncoding("UTF-8");

    String email = request.getParameter("email");
    String clave = request.getParameter("clave");

    Usuarios usuario =
            usuarioDAO.validarAcceso(email, clave);

    if (usuario != null) {

        HttpSession session =
                request.getSession(true);

        session.setAttribute(
                "usuarioLogueado",
                usuario);

        response.sendRedirect(
                request.getContextPath()
                + "/Vistas/Principal.jsp");

    } else {

        request.setAttribute(
                "error",
                "Correo o contraseña incorrectos");

        request.getRequestDispatcher(
                "/Vistas/Login.jsp")
                .forward(request, response);
    }
}

}
