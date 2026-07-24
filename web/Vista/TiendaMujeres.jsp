<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Modelo.Usuarios"%>

<%
    HttpSession sesion = request.getSession(false);
    Usuarios usuario = null;

    if (sesion != null) {
        usuario = (Usuarios) sesion.getAttribute("usuarioLogueado");
    }

    String ctx = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>ByStyles | Moda Mujer</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet" href="<%=ctx%>/Css/styles.css">

</head>

<body>

<nav class="navbar navbar-expand-lg navbar-dark navbar-shop">

    <div class="container-fluid">

        <a class="navbar-brand logo-shop"
           href="<%=ctx%>/Vista/Tienda.jsp">

            ByStyles

        </a>

        <button class="navbar-toggler"
                data-bs-toggle="collapse"
                data-bs-target="#menu">

            <span class="navbar-toggler-icon"></span>

        </button>

        <div class="collapse navbar-collapse"
             id="menu">

            <ul class="navbar-nav ms-4">

                <li class="nav-item">

                    <a class="nav-link active"
                       href="<%=ctx%>/Vista/TiendaMujeres.jsp">

                        Mujeres

                    </a>

                </li>

                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=ctx%>/Vista/TiendaHombres.jsp">

                        Hombres

                    </a>

                </li>

                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=ctx%>/Vista/TiendaNinos.jsp">

                        Niños

                    </a>

                </li>

                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=ctx%>/Vista/TiendaDeporte.jsp">

                        Deporte

                    </a>

                </li>

            </ul>

            <div class="ms-auto d-flex align-items-center gap-3">

                <div class="search-box">

                    <i class="bi bi-search"></i>

                    <input type="text"
                           placeholder="Buscar...">

                </div>

                <a href="#" class="shop-icon">

                    <i class="bi bi-heart"></i>

                </a>

                <a href="#" class="shop-icon">

                    <i class="bi bi-cart3"></i>

                </a>

                <% if(usuario==null){ %>

                <a href="<%=ctx%>/Vista/Login.jsp"
                   class="shop-icon">

                    <i class="bi bi-person-circle"></i>

                </a>

                <% } else { %>

                <div class="dropdown">

                    <button class="btn btn-warning dropdown-toggle"
                            data-bs-toggle="dropdown">

                        <i class="bi bi-person-circle"></i>

                        <%=usuario.getNombre()%>

                    </button>

                    <ul class="dropdown-menu dropdown-menu-end">

                        <li>

                            <h6 class="dropdown-header">

                                <%=usuario.getNombre()%>
                                <%=usuario.getApellido()%>

                            </h6>

                        </li>

                        <li>

                            <span class="dropdown-item-text">

                                <%=usuario.getEmail()%>

                            </span>

                        </li>

                        <li><hr class="dropdown-divider"></li>

                        <li>

                            <a class="dropdown-item text-danger"
                               href="<%=ctx%>/CerrarSesion">

                                <i class="bi bi-box-arrow-right"></i>

                                Cerrar sesión

                            </a>

                        </li>

                    </ul>

                </div>

                <% } %>

            </div>

        </div>

    </div>

</nav>

<section class="banner-shop">

    <div class="container">

        <div class="row align-items-center">

            <div class="col-lg-6">

                <span class="badge-shop">

                    COLECCIÓN MUJER

                </span>

                <h1>

                    Moda exclusiva para Mujer

                </h1>

                <p>

                    Encuentra vestidos, jeans, blusas y mucho más.

                </p>

                <a href="#productos"
                   class="btn btn-shop">

                    Comprar Ahora

                </a>

            </div>

            <div class="col-lg-6 text-center">

                <img src="https://images.unsplash.com/photo-1483985988355-763728e1935?w=900"
                     class="img-fluid banner-img">

            </div>

        </div>

    </div>

</section>

<section id="productos" class="shop-container">

<div class="container">

<div class="row g-4">
    <!-- PRODUCTO 1 -->
<div class="col-lg-3 col-md-6">

    <div class="product-card">

        <div class="discount">-20%</div>

        <img src="https://images.unsplash.com/photo-1496747611176-843222e1e57c?w=700">

        <div class="product-body">

            <small>Vestidos</small>

            <h5>Vestido Elegante</h5>

            <div class="stars">★★★★★</div>

            <div class="price">

                <span class="new">$169.900</span>

            </div>

            <div class="buttons">

                <button class="btn-favorite">
                    <i class="bi bi-heart"></i>
                </button>

                <button class="btn-cart">
                    <i class="bi bi-cart-plus"></i>
                    Agregar
                </button>

            </div>

        </div>

    </div>

</div>

<!-- PRODUCTO 2 -->
<div class="col-lg-3 col-md-6">

    <div class="product-card">

        <img src="https://images.unsplash.com/photo-1529139574466-a303027c1d8b?w=700">

        <div class="product-body">

            <small>Blusas</small>

            <h5>Blusa Casual</h5>

            <div class="stars">★★★★☆</div>

            <div class="price">

                <span class="new">$89.900</span>

            </div>

            <div class="buttons">

                <button class="btn-favorite">
                    <i class="bi bi-heart"></i>
                </button>

                <button class="btn-cart">
                    <i class="bi bi-cart-plus"></i>
                    Agregar
                </button>

            </div>

        </div>

    </div>

</div>

<!-- PRODUCTO 3 -->
<div class="col-lg-3 col-md-6">

    <div class="product-card">

        <img src="https://images.unsplash.com/photo-1541099649105-f69ad21f3246?w=700">

        <div class="product-body">

            <small>Jeans</small>

            <h5>Jean Skinny</h5>

            <div class="stars">★★★★★</div>

            <div class="price">

                <span class="new">$139.900</span>

            </div>

            <div class="buttons">

                <button class="btn-favorite">
                    <i class="bi bi-heart"></i>
                </button>

                <button class="btn-cart">
                    <i class="bi bi-cart-plus"></i>
                    Agregar
                </button>

            </div>

        </div>

    </div>

</div>

<!-- PRODUCTO 4 -->
<div class="col-lg-3 col-md-6">

    <div class="product-card">

        <div class="discount">-10%</div>

        <img src="https://images.unsplash.com/photo-1524504388940-b1c1722653e1?w=700">

        <div class="product-body">

            <small>Chaquetas</small>

            <h5>Chaqueta Denim</h5>

            <div class="stars">★★★★★</div>

            <div class="price">

                <span class="new">$189.900</span>

            </div>

            <div class="buttons">

                <button class="btn-favorite">
                    <i class="bi bi-heart"></i>
                </button>

                <form action="<%=ctx%>/ServletCarrito" method="post">

    <input type="hidden" name="id" value="1">
    <input type="hidden" name="nombre" value="Vestido Elegante">
    <input type="hidden" name="precio" value="169900">
    <input type="hidden" name="imagen"
           value="https://images.unsplash.com/photo-1496747611176-843222e1e57c?w=700">

    <button class="btn-cart">

        <i class="bi bi-cart-plus"></i>

        Agregar

    </button>

</form>

            </div>

        </div>

    </div>

</div>