<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuarios"%>

<%
    HttpSession misession = request.getSession(false);

    if (misession == null || misession.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect(request.getContextPath() + "/Vista/Login.jsp");
        return;
    }

    Usuarios usuarioLogueado = (Usuarios) misession.getAttribute("usuarioLogueado");

    String ctx = request.getContextPath();
%>

<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">

<title>Panel Administrador | ByStyles</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

<link rel="stylesheet" href="<%=ctx%>/Css/Panel.css">

</head>
<body>

<div class="wrapper">

    <!-- MENU -->

    <aside class="sidebar">

        <div class="logo">

            <h2>ByStyles</h2>

            <span>Administrador</span>

        </div>

        <ul>

    <li class="active">
        <a href="<%=ctx%>/Vista/Panel.jsp">
            <i class="bi bi-speedometer2"></i>
            Dashboard
        </a>
    </li>

    <li>
        <a href="<%=ctx%>/Vista/Producto.jsp">
            <i class="bi bi-bag-fill"></i>
            Productos
        </a>
    </li>

    <li>
        <a href="<%=ctx%>/Vista/Categorias.jsp">
            <i class="bi bi-tags-fill"></i>
            Categorías
        </a>
    </li>

    <li>
        <a href="<%=ctx%>/Vista/Pedidos.jsp">
            <i class="bi bi-cart-fill"></i>
            Pedidos
        </a>
    </li>

    <li>
        <a href="<%=ctx%>/Vista/Usuarios.jsp">
            <i class="bi bi-people-fill"></i>
            Usuarios
        </a>
    </li>

</ul>

    <!-- CONTENIDO -->

    <main class="contenido">

        <header class="topbar">

            <div>

                <h3>

                    Bienvenido,
                    <%=usuarioLogueado.getNombre()%>

                </h3>

                <small>Panel de Administración</small>

            </div>

            <div>

                <a href="<%=ctx%>/Vista/Login.jsp"
                   class="btn btn-danger">

                    <i class="bi bi-box-arrow-right"></i>

                    Cerrar Sesión

                </a>

            </div>

        </header>
                   <section class="cards">

<div class="card-box">

<i class="bi bi-bag-check-fill"></i>

<h3>120</h3>

<p>Productos</p>

</div>

<div class="card-box">

<i class="bi bi-people-fill"></i>

<h3>35</h3>

<p>Usuarios</p>

</div>

<div class="card-box">

<i class="bi bi-cart-fill"></i>

<h3>17</h3>

<p>Pedidos</p>

</div>

<div class="card-box">

<i class="bi bi-currency-dollar"></i>

<h3>$8.5 M</h3>

<p>Ventas</p>

</div>

</section>
                   <div class="perfil-admin">

<h4>

<i class="bi bi-person-circle"></i>

Información del Administrador

</h4>

<table class="table">

<tr>

<th>Nombre</th>

<td>

<%=usuarioLogueado.getNombre()%>
<%=usuarioLogueado.getApellido()%>

</td>

</tr>

<tr>

<th>Email</th>

<td>

<%=usuarioLogueado.getEmail()%>

</td>

</tr>

<tr>

<th>Documento</th>

<td>

<%=usuarioLogueado.getIdentificacion()%>

</td>

</tr>

<tr>

<th>Rol</th>

<td>

Administrador

</td>

</tr>

</table>

</div>
</main>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>