<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="Modelo.Usuarios" %>

<%
    // 🔒 PROTEGER LA PÁGINA
    HttpSession misession = request.getSession(false);
    Usuarios usuarioLogueado = null;

    if (misession == null || misession.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect("Login.jsp");
        return;
    } else {
        usuarioLogueado = (Usuarios) misession.getAttribute("usuarioLogueado");
    }
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ByStyle - Inicio</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body>

<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
    <div class="container-fluid">

        <a class="navbar-brand" href="#">ByStyle</a>

        <div class="collapse navbar-collapse">

            <ul class="navbar-nav me-auto">

                <li class="nav-item">
                    <a class="nav-link active" href="Home.jsp">Inicio</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Productos</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#">Usuarios</a>
                </li>

            </ul>

            <!-- 👤 Usuario + Cerrar sesión -->
            <span class="navbar-text text-white me-3">
                👤 ${usuarioLogueado.nombre}
            </span>

            <form action="${pageContext.request.contextPath}/CerrarSesion" method="post">
                <button class="btn btn-danger btn-sm" type="submit">
                    Cerrar sesión
                </button>
            </form>

        </div>
    </div>
</nav>

<!-- CONTENIDO -->
<div class="container mt-5">

    <h1>Bienvenido al sistema ByStyle 👕</h1>

    <p>
        Usuario logueado: <strong><%= usuarioLogueado.getNombre() %></strong>
    </p>

</div>

</body>
</html>