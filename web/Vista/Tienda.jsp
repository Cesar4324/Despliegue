<%@page import="Modelo.Usuarios"%>
<%@page import="Modelo.ItemCarrito"%>
<%@page import="java.util.ArrayList"%>

<%
    HttpSession sesion = request.getSession(false);

    Usuarios usuario = null;

    if (sesion != null) {
        usuario = (Usuarios) sesion.getAttribute("usuarioLogueado");
    }

    String ctx = request.getContextPath();

    ArrayList<ItemCarrito> carrito = null;

    if (sesion != null) {
        carrito = (ArrayList<ItemCarrito>) sesion.getAttribute("carrito");
    }

    int cantidadCarrito = 0;

    if (carrito != null) {
        for (ItemCarrito item : carrito) {
            cantidadCarrito += item.getCantidad();
        }
    }
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">

    <meta name="viewport"
          content="width=device-width, initial-scale=1.0">

    <title>ByStyles | Tienda</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <!-- Bootstrap Icons -->
    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <!-- CSS -->
    <link rel="stylesheet"
          href="<%=ctx%>/Css/styles.css">

</head>

<body>

<!-- =====================================================
     NAVBAR
===================================================== -->

<nav class="navbar navbar-expand-lg navbar-dark navbar-shop">

    <div class="container-fluid">

        <!-- LOGO -->

        <a class="navbar-brand logo-shop"
           href="<%=ctx%>/index.jsp">

            ByStyles

        </a>


        <!-- BOTÓN RESPONSIVE -->

        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#menu">

            <span class="navbar-toggler-icon"></span>

        </button>


        <div class="collapse navbar-collapse"
             id="menu">


            <!-- MENÚ -->

            <ul class="navbar-nav align-items-lg-center">

                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=ctx%>/Vista/TiendaMujeres.jsp">

                        MUJER

                    </a>

                </li>


                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=ctx%>/Vista/TiendaHombres.jsp">

                        HOMBRE

                    </a>

                </li>


                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=ctx%>/Vista/TiendaNinos.jsp">

                        NIÑOS

                    </a>

                </li>


                <li class="nav-item">

                    <a class="nav-link"
                       href="<%=ctx%>/Vista/TiendaDeporte.jsp">

                        DEPORTE

                    </a>

                </li>


                <li class="nav-item">

                    <a class="nav-link ofertas-link"
                       href="#productos">

                        OFERTAS

                    </a>

                </li>

            </ul>


            <!-- DERECHA -->

            <div class="ms-auto d-flex align-items-center gap-3 navbar-right">


                <!-- BUSCADOR -->

                <div class="search-box">

                    <i class="bi bi-search"></i>

                    <input type="text"
                           id="buscador"
                           placeholder="Buscar productos..."
                           onkeyup="buscarProductos()">

                </div>


                <!-- FAVORITOS -->

                <a href="#"
                   class="shop-icon"
                   title="Favoritos">

                    <i class="bi bi-heart"></i>

                </a>


                <!-- CARRITO -->

                <a href="<%=ctx%>/Vista/carrito.jsp"
                   class="shop-icon position-relative"
                   title="Carrito">

                    <i class="bi bi-cart3"></i>

                    <span class="cart-count"
                          id="cartCount">

                        <%=cantidadCarrito%>

                    </span>

                </a>


                <!-- USUARIO -->

                <% if (usuario == null) { %>

                    <a href="<%=ctx%>/Vista/Login.jsp"
                       class="shop-icon"
                       title="Iniciar sesión">

                        <i class="bi bi-person-circle"></i>

                    </a>

                <% } else { %>

                    <div class="dropdown">

                        <button class="btn btn-user dropdown-toggle"
                                type="button"
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


                            <li>

                                <hr class="dropdown-divider">

                            </li>


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


<!-- =====================================================
     BANNER
===================================================== -->

<section class="banner-shop">

    <div class="container">

        <div class="row align-items-center">

            <div class="col-lg-6">

                <span class="badge-shop">

                    NUEVA COLECCIÓN

                </span>


                <h1>

                    Descubre la nueva temporada

                </h1>


                <p>

                    Moda exclusiva para mujer, hombre y niños.

                </p>


                <a href="#productos"
                   class="btn btn-shop">

                    Comprar ahora

                    <i class="bi bi-arrow-right"></i>

                </a>

            </div>


            <div class="col-lg-6 text-center">

                <img src="https://images.unsplash.com/photo-1523381210434-271e8be1f52?w=900"
                     class="img-fluid banner-img"
                     alt="Nueva colección">

            </div>

        </div>

    </div>

</section>


<!-- =====================================================
     PRODUCTOS
===================================================== -->

<section id="productos"
         class="shop-container">

    <div class="container-fluid">

        <div class="row">


            <!-- =================================================
                 FILTROS
            ================================================= -->

            <div class="col-lg-3">

                <div class="filter-box">

                    <h4>

                        <i class="bi bi-funnel-fill"></i>

                        Filtros

                    </h4>


                    <hr>


                    <h6>

                        Categorías

                    </h6>


                    <div class="form-check">

                        <input class="form-check-input"
                               type="checkbox">

                        <label class="form-check-label">

                            Camisetas

                        </label>

                    </div>


                    <div class="form-check">

                        <input class="form-check-input"
                               type="checkbox">

                        <label class="form-check-label">

                            Jeans

                        </label>

                    </div>


                    <div class="form-check">

                        <input class="form-check-input"
                               type="checkbox">

                        <label class="form-check-label">

                            Chaquetas

                        </label>

                    </div>


                    <div class="form-check">

                        <input class="form-check-input"
                               type="checkbox">

                        <label class="form-check-label">

                            Zapatos

                        </label>

                    </div>


                    <hr>


                    <h6>

                        Tallas

                    </h6>


                    <div class="sizes">

                        <button type="button">S</button>

                        <button type="button">M</button>

                        <button type="button">L</button>

                        <button type="button">XL</button>

                    </div>


                    <hr>


                    <h6>

                        Precio

                    </h6>


                    <input type="range"
                           class="form-range"
                           min="0"
                           max="300000"
                           value="300000">


                    <p>

                        Hasta $300.000

                    </p>

                </div>

            </div>


            <!-- =================================================
                 PRODUCTOS
            ================================================= -->

            <div class="col-lg-9">

                <div class="row g-4"
                     id="listaProductos">


                    <!-- =================================================
                         PRODUCTO 1
                    ================================================= -->

                    <div class="col-lg-4 col-md-6 producto-item">

                        <div class="product-card">

                            <div class="discount">

                                -25%

                            </div>


                            <img src="https://evidencia.com.co/wp-content/uploads/2026/04/1000276672-scaled.png"
                                 alt="Camiseta Oversize">


                            <div class="product-body">

                                <small>

                                    CAMISETAS

                                </small>


                                <h5>

                                    Camiseta Oversize

                                </h5>


                                <div class="stars">

                                    ?????

                                </div>


                                <div class="price">

                                    <span class="old">

                                        $119.900

                                    </span>

                                    <span class="new">

                                        $89.900

                                    </span>

                                </div>


                                <form action="<%=ctx%>/ServletCarrito"
                                      method="post"
                                      class="buttons">

                                    <input type="hidden"
                                           name="id"
                                           value="1">

                                    <input type="hidden"
                                           name="nombre"
                                           value="Camiseta Oversize">

                                    <input type="hidden"
                                           name="precio"
                                           value="89900">

                                    <input type="hidden"
                                           name="imagen"
                                           value="https://evidencia.com.co/wp-content/uploads/2026/04/1000276672-scaled.png">


                                    <button type="button"
                                            class="btn-favorite"
                                            onclick="toggleFavorito(this)">

                                        <i class="bi bi-heart"></i>

                                    </button>


                                    <button type="submit"
                                            class="btn-cart">

                                        <i class="bi bi-cart-plus"></i>

                                        Agregar

                                    </button>

                                </form>

                            </div>

                        </div>

                    </div>


                    <!-- =================================================
                         PRODUCTO 2
                    ================================================= -->

                    <div class="col-lg-4 col-md-6 producto-item">

                        <div class="product-card">

                            <img src="https://i.ebayimg.com/images/g/AMwAAeSwCFxpZwvt/s-l1200.jpg"
                                 alt="Jeans Levis 501">


                            <div class="product-body">

                                <small>

                                    JEANS

                                </small>


                                <h5>

                                    Jeans Levis 501

                                </h5>


                                <div class="stars">

                                    ?????

                                </div>


                                <div class="price">

                                    <span class="new">

                                        $129.900

                                    </span>

                                </div>


                                <form action="<%=ctx%>/ServletCarrito"
                                      method="post"
                                      class="buttons">

                                    <input type="hidden"
                                           name="id"
                                           value="2">

                                    <input type="hidden"
                                           name="nombre"
                                           value="Jeans Levis 501">

                                    <input type="hidden"
                                           name="precio"
                                           value="129900">

                                    <input type="hidden"
                                           name="imagen"
                                           value="https://i.ebayimg.com/images/g/AMwAAeSwCFxpZwvt/s-l1200.jpg">


                                    <button type="button"
                                            class="btn-favorite"
                                            onclick="toggleFavorito(this)">

                                        <i class="bi bi-heart"></i>

                                    </button>


                                    <button type="submit"
                                            class="btn-cart">

                                        <i class="bi bi-cart-plus"></i>

                                        Agregar

                                    </button>

                                </form>

                            </div>

                        </div>

                    </div>


                    <!-- =================================================
                         PRODUCTO 3
                    ================================================= -->

                    <div class="col-lg-4 col-md-6 producto-item">

                        <div class="product-card">

                            <div class="discount">

                                -15%

                            </div>


                            <img src="https://images.snowleader.com/media/catalog/product/cache/1/image/0dc2d03fe217f8c83829496872af24a0/T/H/THEN05326_01_202507170447.jpg"
                                 alt="Chaqueta Bomber">


                            <div class="product-body">

                                <small>

                                    CHAQUETAS

                                </small>


                                <h5>

                                    Chaqueta Bomber

                                </h5>


                                <div class="stars">

                                    ?????

                                </div>


                                <div class="price">

                                    <span class="old">

                                        $269.900

                                    </span>

                                    <span class="new">

                                        $229.900

                                    </span>

                                </div>


                                <form action="<%=ctx%>/ServletCarrito"
                                      method="post"
                                      class="buttons">

                                    <input type="hidden"
                                           name="id"
                                           value="3">

                                    <input type="hidden"
                                           name="nombre"
                                           value="Chaqueta Bomber">

                                    <input type="hidden"
                                           name="precio"
                                           value="229900">

                                    <input type="hidden"
                                           name="imagen"
                                           value="https://images.snowleader.com/media/catalog/product/cache/1/image/0dc2d03fe217f8c83829496872af24a0/T/H/THEN05326_01_202507170447.jpg">


                                    <button type="button"
                                            class="btn-favorite"
                                            onclick="toggleFavorito(this)">

                                        <i class="bi bi-heart"></i>

                                    </button>


                                    <button type="submit"
                                            class="btn-cart">

                                        <i class="bi bi-cart-plus"></i>

                                        Agregar

                                    </button>

                                </form>

                            </div>

                        </div>

                    </div>


                    <!-- =================================================
                         PRODUCTO 4
                    ================================================= -->

                    <div class="col-lg-4 col-md-6 producto-item">

                        <div class="product-card">

                            <img src="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=900"
                                 alt="Sneakers Urban">


                            <div class="product-body">

                                <small>

                                    ZAPATOS

                                </small>


                                <h5>

                                    Sneakers Urban

                                </h5>


                                <div class="stars">

                                    ?????

                                </div>


                                <div class="price">

                                    <span class="new">

                                        $140.000

                                    </span>

                                </div>


                                <form action="<%=ctx%>/ServletCarrito"
                                      method="post"
                                      class="buttons">

                                    <input type="hidden"
                                           name="id"
                                           value="4">

                                    <input type="hidden"
                                           name="nombre"
                                           value="Sneakers Urban">

                                    <input type="hidden"
                                           name="precio"
                                           value="140000">

                                    <input type="hidden"
                                           name="imagen"
                                           value="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=900">


                                    <button type="button"
                                            class="btn-favorite"
                                            onclick="toggleFavorito(this)">

                                        <i class="bi bi-heart"></i>

                                    </button>


                                    <button type="submit"
                                            class="btn-cart">

                                        <i class="bi bi-cart-plus"></i>

                                        Agregar

                                    </button>

                                </form>

                            </div>

                        </div>

                    </div>


                    <!-- =================================================
                         PRODUCTO 5
                    ================================================= -->

                    <div class="col-lg-4 col-md-6 producto-item">

                        <div class="product-card">

                            <img src="https://equipment-ec.com/wp-content/uploads/2025/02/Copia-19_25-adi.webp"
                                 alt="Hoodie Clásico">


                            <div class="product-body">

                                <small>

                                    CAMISETAS

                                </small>


                                <h5>

                                    Hoodie Clásico

                                </h5>


                                <div class="stars">

                                    ?????

                                </div>


                                <div class="price">

                                    <span class="new">

                                        $99.900

                                    </span>

                                </div>


                                <form action="<%=ctx%>/ServletCarrito"
                                      method="post"
                                      class="buttons">

                                    <input type="hidden"
                                           name="id"
                                           value="5">

                                    <input type="hidden"
                                           name="nombre"
                                           value="Hoodie Clásico">

                                    <input type="hidden"
                                           name="precio"
                                           value="99900">

                                    <input type="hidden"
                                           name="imagen"
                                           value="https://equipment-ec.com/wp-content/uploads/2025/02/Copia-19_25-adi.webp">


                                    <button type="button"
                                            class="btn-favorite"
                                            onclick="toggleFavorito(this)">

                                        <i class="bi bi-heart"></i>

                                    </button>


                                    <button type="submit"
                                            class="btn-cart">

                                        <i class="bi bi-cart-plus"></i>

                                        Agregar

                                    </button>

                                </form>

                            </div>

                        </div>

                    </div>


                    <!-- =================================================
                         PRODUCTO 6
                    ================================================= -->

                    <div class="col-lg-4 col-md-6 producto-item">

                        <div class="product-card">

                            <div class="discount">

                                -20%

                            </div>


                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_4UsB7GiAtniiVcYIRj11ehPRUWeQe_QKAN_oauD55fjz9fEnyRNTA-w&s=10"
                                 alt="Botas Kumbre">


                            <div class="product-body">

                                <small>

                                    ZAPATOS

                                </small>


                                <h5>

                                    Botas Kumbre

                                </h5>


                                <div class="stars">

                                    ?????

                                </div>


                                <div class="price">

                                    <span class="old">

                                        $299.900

                                    </span>

                                    <span class="new">

                                        $239.900

                                    </span>

                                </div>


                                <form action="<%=ctx%>/ServletCarrito"
                                      method="post"
                                      class="buttons">

                                    <input type="hidden"
                                           name="id"
                                           value="6">

                                    <input type="hidden"
                                           name="nombre"
                                           value="Botas Kumbre">

                                    <input type="hidden"
                                           name="precio"
                                           value="239900">

                                    <input type="hidden"
                                           name="imagen"
                                           value="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_4UsB7GiAtniiVcYIRj11ehPRUWeQe_QKAN_oauD55fjz9fEnyRNTA-w&s=10">


                                    <button type="button"
                                            class="btn-favorite"
                                            onclick="toggleFavorito(this)">

                                        <i class="bi bi-heart"></i>

                                    </button>


                                    <button type="submit"
                                            class="btn-cart">

                                        <i class="bi bi-cart-plus"></i>

                                        Agregar

                                    </button>

                                </form>

                            </div>

                        </div>

                    </div>


                    <!-- =================================================
                         PRODUCTO 7
                    ================================================= -->

                    <div class="col-lg-4 col-md-6 producto-item">

                        <div class="product-card">

                            <div class="discount">

                                -10%

                            </div>


                            <img src="https://images.unsplash.com/photo-1503341504253-dff4815485f1?w=900"
                                 alt="Camisa Casual">


                            <div class="product-body">

                                <small>

                                    HOMBRES

                                </small>


                                <h5>

                                    Camisa Casual

                                </h5>


                                <div class="stars">

                                    ?????

                                </div>


                                <div class="price">

                                    <span class="old">

                                        $119.900

                                    </span>

                                    <span class="new">

                                        $107.900

                                    </span>

                                </div>


                                <form action="<%=ctx%>/ServletCarrito"
                                      method="post"
                                      class="buttons">

                                    <input type="hidden"
                                           name="id"
                                           value="7">

                                    <input type="hidden"
                                           name="nombre"
                                           value="Camisa Casual">

                                    <input type="hidden"
                                           name="precio"
                                           value="107900">

                                    <input type="hidden"
                                           name="imagen"
                                           value="https://images.unsplash.com/photo-1503341504253-dff4815485f1?w=900">


                                    <button type="button"
                                            class="btn-favorite"
                                            onclick="toggleFavorito(this)">

                                        <i class="bi bi-heart"></i>

                                    </button>


                                    <button type="submit"
                                            class="btn-cart">

                                        <i class="bi bi-cart-plus"></i>

                                        Agregar

                                    </button>

                                </form>

                            </div>

                        </div>

                    </div>


                </div>

            </div>

        </div>

    </div>

</section>


<!-- =====================================================
     JAVASCRIPT
===================================================== -->

<script>

    /* ================================================
       FAVORITOS
    ================================================ */

    function toggleFavorito(boton) {

        const icono = boton.querySelector("i");

        if (icono.classList.contains("bi-heart")) {

            icono.classList.remove("bi-heart");

            icono.classList.add("bi-heart-fill");

            boton.classList.add("favorito-activo");

        } else {

            icono.classList.remove("bi-heart-fill");

            icono.classList.add("bi-heart");

            boton.classList.remove("favorito-activo");

        }

    }


    /* ================================================
       BUSCADOR
    ================================================ */

    function buscarProductos() {

        const texto =
            document.getElementById("buscador")
            .value
            .toLowerCase();

        const productos =
            document.querySelectorAll(".producto-item");

        productos.forEach(function(producto) {

            const contenido =
                producto.innerText.toLowerCase();

            if (contenido.includes(texto)) {

                producto.style.display = "";

            } else {

                producto.style.display = "none";

            }

        });

    }


    /* ================================================
       TALLAS
    ================================================ */

    document.querySelectorAll(".sizes button")
        .forEach(function(boton) {

            boton.addEventListener("click", function() {

                boton.classList.toggle("active");

            });

        });

</script>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js">
</script>

</body>

</html>