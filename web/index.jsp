<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");
    String ctx = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>ByStyles</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet" href="<%=ctx%>/Css/index.css">

</head>

<body>
<!-- NAVBAR -->
<nav class="navbar navbar-expand-lg navbar-light navbar-bystyle">

    <div class="container-fluid px-4">

        <a class="navbar-brand fw-bold logo-bystyle"
           href="<%=ctx%>/index.jsp">
            ByStyles
        </a>

        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#menu">

            <span class="navbar-toggler-icon"></span>

        </button>

        <div class="collapse navbar-collapse"
             id="menu">

           <ul class="navbar-nav ms-4">

    <!-- MUJERES -->
    <li class="nav-item dropdown mega-menu">

        <a class="nav-link active" href="#">
            Mujeres
        </a>

        <div class="mega-menu-content">

            <div class="row">

                <div class="col-md-3">
                    <h5>NOVEDADES</h5>
                    <a href="#">Más Vendidos</a>
                    <a href="#">Moda de Verano</a>
                    <a href="#">Looks Destacados</a>
                    <a href="#">Estilo Diario</a>
                    <a href="#">Ofertas</a>
                </div>

                <div class="col-md-3">
                    <h5>ZAPATOS</h5>
                    <a href="#">Tenis Casual</a>
                    <a href="#">Running</a>
                    <a href="#">Plataforma</a>
                    <a href="#">Botas</a>
                    <a href="#">Todos los Zapatos</a>
                </div>

                <div class="col-md-3">
                    <h5>ROPA</h5>
                    <a href="#">Camisetas</a>
                    <a href="#">Pantalones</a>
                    <a href="#">Vestidos</a>
                    <a href="#">Chaquetas</a>
                    <a href="#">Toda la Ropa</a>
                </div>

                <div class="col-md-3">
                    <h5>ACCESORIOS</h5>
                    <a href="#">Bolsos</a>
                    <a href="#">Gorras</a>
                    <a href="#">Medias</a>
                    <a href="#">Relojes</a>
                </div>

            </div>

        </div>

    </li>

    <!-- HOMBRES -->
    <li class="nav-item dropdown mega-menu">

        <a class="nav-link" href="#">
            Hombres
        </a>

        <div class="mega-menu-content">

            <div class="row">

                <div class="col-md-3">
                    <h5>NOVEDADES</h5>
                    <a href="#">Nuevos Lanzamientos</a>
                    <a href="#">Más Vendidos</a>
                    <a href="#">Colección Urbana</a>
                </div>

                <div class="col-md-3">
                    <h5>ZAPATOS</h5>
                    <a href="#">Running</a>
                    <a href="#">Casuales</a>
                    <a href="#">Botines</a>
                    <a href="#">Deportivos</a>
                </div>

                <div class="col-md-3">
                    <h5>ROPA</h5>
                    <a href="#">Camisetas</a>
                    <a href="#">Jeans</a>
                    <a href="#">Sudaderas</a>
                    <a href="#">Chaquetas</a>
                </div>

                <div class="col-md-3">
                    <h5>ACCESORIOS</h5>
                    <a href="#">Gorras</a>
                    <a href="#">Mochilas</a>
                    <a href="#">Cinturones</a>
                </div>

            </div>

        </div>

    </li>

    <!-- NIÑOS -->
    <li class="nav-item dropdown mega-menu">

        <a class="nav-link" href="#">
            Niños
        </a>

        <div class="mega-menu-content">

            <div class="row">

                <div class="col-md-4">
                    <h5>ROPA</h5>
                    <a href="#">Camisetas</a>
                    <a href="#">Pantalones</a>
                    <a href="#">Uniformes</a>
                </div>

                <div class="col-md-4">
                    <h5>ZAPATOS</h5>
                    <a href="#">Escolares</a>
                    <a href="#">Casuales</a>
                    <a href="#">Deportivos</a>
                </div>

                <div class="col-md-4">
                    <h5>ACCESORIOS</h5>
                    <a href="#">Morrales</a>
                    <a href="#">Gorras</a>
                </div>

            </div>

        </div>

    </li>

    <!-- ESTILO DE VIDA -->
    <li class="nav-item">
        <a class="nav-link" href="#">
            Estilo de Vida
        </a>
    </li>

    <!-- DEPORTE -->
    <li class="nav-item dropdown mega-menu">

        <a class="nav-link" href="#">
            Deporte
        </a>

        <div class="mega-menu-content">

            <div class="row">

                <div class="col-md-3">
                    <h5>FÚTBOL</h5>
                    <a href="#">Guayos</a>
                    <a href="#">Uniformes</a>
                </div>

                <div class="col-md-3">
                    <h5>GYM</h5>
                    <a href="#">Entrenamiento</a>
                    <a href="#">Pesas</a>
                </div>

                <div class="col-md-3">
                    <h5>RUNNING</h5>
                    <a href="#">Tenis Running</a>
                    <a href="#">Ropa Running</a>
                </div>

                <div class="col-md-3">
                    <h5>BALONCESTO</h5>
                    <a href="#">Tenis Basket</a>
                    <a href="#">Camisetas</a>
                </div>

            </div>

        </div>

    </li>

    <!-- REBAJAS -->
    <li class="nav-item">
        <a class="nav-link text-warning" href="#">
            Rebajas
        </a>
    </li>

 <!-- TIENDA -->
<li class="nav-item">
    <a class="nav-link" href="<%=ctx%>/Vista/Tienda.jsp">
        Tienda
    </a>
</li>

</ul>

<ul class="navbar-nav ms-auto align-items-center">

    <!-- Iniciar Sesión -->
    <li class="nav-item">

        <a class="nav-link" href="<%=ctx%>/Vista/Login.jsp">

            <i class="bi bi-box-arrow-in-right me-1"></i>
            Iniciar Sesión

        </a>

    </li>

    <!-- Registro -->
    <li class="nav-item">

        <a class="nav-link" href="<%=ctx%>/Vista/registro.jsp">

            <i class="bi bi-person-plus me-1"></i>
            Registro

        </a>

    </li>

    <!-- Carrito -->
    <li class="nav-item">

        <a class="nav-link" href="<%=ctx%>/Vista/Carrito.jsp">

            <i class="bi bi-cart3 me-1"></i>
            Carrito

        </a>

    </li>

</ul>
    </li>
</nav>

<!-- HERO -->
<section class="inicio text-center text-white d-flex align-items-center">

    <div class="container hero-card">

        <h1 class="display-3 fw-bold title-hero">

            Bienvenido a ByStyles

        </h1>

        <p class="lead mt-3 subtitulo-hero">

            Tu tienda de ropa con estilo, moda y calidad.

        </p>

        <a href="#productos"
           class="btn btn-purple-main btn-lg mt-3">

            Ver Colección
            <i class="bi bi-arrow-down-short ms-1"></i>

        </a>

    </div>

</section>

<!-- PRODUCTOS -->
<section id="productos"
         class="container py-5">

    <h2 class="text-center section-title mb-5">

        Nuestros Productos

    </h2>

    <div class="row g-4">

        <div class="col-md-4">

            <div class="card card-custom h-100 shadow">

                <div class="card-img-container">

                    <img src="https://images.unsplash.com/photo-1521572163474-6864f9cf17ab?q=80&w=880&auto=format&fit=crop"
                         class="card-img-top"
                         alt="Camisetas">

                </div>

                <div class="card-body text-center card-info-area">

                    <h5 class="card-title-custom">
                        Camisetas
                    </h5>

                    <p class="card-text-custom">
                        Diseños modernos y cómodos para cualquier ocasión.
                    </p>

                </div>

            </div>

        </div>

        <div class="col-md-4">

            <div class="card card-custom h-100 shadow">

                <div class="card-img-container">

                    <img src="https://images.unsplash.com/photo-1541099649105-f69ad21f3246?q=80&w=870&auto=format&fit=crop"
                         class="card-img-top"
                         alt="Pantalones">

                </div>

                <div class="card-body text-center card-info-area">

                    <h5 class="card-title-custom">
                        Pantalones
                    </h5>

                    <p class="card-text-custom">
                        Moda urbana y elegante con la mejor calidad.
                    </p>

                </div>

            </div>

        </div>

        <div class="col-md-4">

            <div class="card card-custom h-100 shadow">

                <div class="card-img-container">

                    <img src="https://images.unsplash.com/photo-1523381210434-271e8be1f52b?q=80&w=870&auto=format&fit=crop"
                         class="card-img-top"
                         alt="Chaquetas">

                </div>

                <div class="card-body text-center card-info-area">

                    <h5 class="card-title-custom">
                        Chaquetas
                    </h5>

                    <p class="card-text-custom">
                        Estilo y comodidad para complementar tu outfit.
                    </p>

                </div>

            </div>

        </div>

    </div>

</section>

<!-- NOSOTROS -->
<section id="nosotros"
         class="bg-dark-secondary text-white py-5">

    <div class="container text-center max-width-text">

        <h2 class="section-title">

            Sobre Nosotros

        </h2>

        <p class="mt-3 subtitulo-hero">

            En ByStyles buscamos ofrecer ropa moderna, elegante y accesible para todos los estilos.

        </p>

    </div>

</section>

<!-- CONTACTO -->
<section id="contacto"
         class="container py-5">

    <h2 class="text-center section-title mb-4">

        Contáctanos

    </h2>

    <div class="form-container-index shadow mx-auto">
<%
String mensajeExito =
(String) session.getAttribute("mensajeExito");

if(mensajeExito != null){
%>

<div class="alert alert-success text-center mb-4">
    <%= mensajeExito %>
</div>

<%
session.removeAttribute("mensajeExito");
}
%>
        <form action="<%=ctx%>/ContactoServlet"
              method="post">

            <div class="mb-3 input-group-index">

                <input type="text"
                       name="nombre"
                       class="form-control-index"
                       placeholder="Nombre"
                       required>

            </div>

            <div class="mb-3 input-group-index">

                <input type="email"
                       name="correo"
                       class="form-control-index"
                       placeholder="Correo"
                       required>

            </div>

            <div class="mb-3 input-group-index">

                <textarea name="mensaje"
                          class="form-control-index"
                          rows="4"
                          placeholder="Mensaje"
                          required></textarea>

            </div>

            <button type="submit"
                    class="btn-purple-submit w-100">

                Enviar Mensaje
                <i class="bi bi-send ms-2"></i>

            </button>

        </form>

    </div>

</section>

<!-- FOOTER -->
<footer class="footer-custom text-center p-4">

    <p class="mb-0">

        © 2026
        <span class="text-white fw-bold">ByStyles</span>

        - Todos los derechos reservados -
        Cesar Cifuentes

    </p>

</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>