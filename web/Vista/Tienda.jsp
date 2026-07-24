<%@page import="Modelo.Usuarios"%>

<%
HttpSession sesion = request.getSession(false);

Usuarios usuario = null;

if(sesion != null){
    usuario = (Usuarios) sesion.getAttribute("usuarioLogueado");
}
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String ctx = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>ByStyles | Tienda</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Icons -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <!-- CSS propio -->
    <link rel="stylesheet" href="<%=ctx%>/Css/styles.css">

</head>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark navbar-shop">

    <div class="container-fluid">

        <a class="navbar-brand logo-shop" href="<%=ctx%>/index.jsp">
            ByStyles
        </a>

        <button class="navbar-toggler" data-bs-toggle="collapse" data-bs-target="#menu">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="menu">

            <li class="nav-item">
    <a class="nav-link" href="<%=ctx%>/Vista/TiendaMujeres.jsp">
        Mujeres
    </a>
</li>

<li class="nav-item">
    <a class="nav-link" href="<%=ctx%>/Vista/TiendaHombres.jsp">
        Hombres
    </a>
</li>

<li class="nav-item">
    <a class="nav-link" href="<%=ctx%>/Vista/TiendaNinos.jsp">
        Niños
    </a>
</li>

<li class="nav-item">
    <a class="nav-link" href="<%=ctx%>/Vista/TiendaDeporte.jsp">
        Deporte
    </a>
</li>

            <!-- DERECHA -->
            <div class="ms-auto d-flex align-items-center gap-3">

                <!-- BUSCADOR -->
                <div class="search-box">
                    <i class="bi bi-search"></i>
                    <input type="text" placeholder="Buscar productos...">
                </div>

                <!-- ICONOS -->
                <a href="#" class="shop-icon"><i class="bi bi-heart"></i></a>

                <a href="#" class="shop-icon position-relative">
                    <i class="bi bi-cart3"></i>
                    <span class="cart-count">0</span>
                </a>

                <% if(usuario == null){ %>

    <a href="<%=ctx%>/Vista/Login.jsp" class="shop-icon">
        <i class="bi bi-person-circle"></i>
    </a>

<% } else { %>

<div class="dropdown">

    <button class="btn btn-warning dropdown-toggle"
            type="button"
            data-bs-toggle="dropdown"
            aria-expanded="false">

        <i class="bi bi-person-circle"></i>
        <%= usuario.getNombre() %>

    </button>

    <ul class="dropdown-menu dropdown-menu-end">

        <li>
            <h6 class="dropdown-header">
                <%= usuario.getNombre() %> <%= usuario.getApellido() %>
            </h6>
        </li>

        <li>
            <span class="dropdown-item-text">
                <%= usuario.getEmail() %>
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
                <span class="badge-shop">NUEVA COLECCIÓN</span>
                <h1>Descubre la nueva temporada</h1>
                <p>Moda exclusiva para mujer, hombre y niños.</p>
                <a href="#productos" class="btn btn-shop"></a>
            </div>
            <div class="col-lg-6 text-center">
                <img src="https://images.unsplash.com/photo-1523381210434-271e8be1f52?w=900"
                     class="img-fluid banner-img">
            </div>
        </div>
    </div>
</section>

<section id="productos" class="shop-container">
    <div class="container-fluid">
        <div class="row">

            <!-- FILTROS -->
            <div class="col-lg-3">
                <div class="filter-box">
                    <h4><i class="bi bi-funnel-fill"></i> Filtros</h4>
                    <hr>
                    <h6>Categorías</h6>
                    <div class="form-check"><input class="form-check-input" type="checkbox"> Camisetas</div>
                    <div class="form-check"><input class="form-check-input" type="checkbox"> Jeans</div>
                    <div class="form-check"><input class="form-check-input" type="checkbox"> Chaquetas</div>
                    <div class="form-check"><input class="form-check-input" type="checkbox"> Zapatos</div>
                    <hr>
                    <h6>Tallas</h6>
                    <div class="sizes">
                        <button>S</button>
                        <button>M</button>
                        <button>L</button>
                        <button>XL</button>
                    </div>
                    <hr>
                    <h6>Precio</h6>
                    <input type="range" class="form-range">
                    <p class="mt-2">Hasta $300.000</p>
                </div>
            </div>

          
            <div class="col-lg-9">
                <div class="row g-4">

                  
                    <div class="col-lg-4">
                        <div class="product-card">
                            <div class="discount">-25%</div>
                            <img src="https://evidencia.com.co/wp-content/uploads/2026/04/1000276672-scaled.png">
                            <div class="product-body">
                                <small>Camisetas</small>
                                <h5>Camiseta Oversize</h5>
                                <div class="stars">★★★★★</div>
                                <div class="price">
                                    <span class="old">$89.900</span>
                                </div>
                                <div class="buttons">
                                    <button class="btn-favorite"><i class="bi bi-heart"></i></button>
                                    <button class="btn-cart"><i class="bi bi-cart-plus"></i> Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    
                    <div class="col-lg-4">
                        <div class="product-card">
                            <img src="https://i.ebayimg.com/images/g/AMwAAeSwCFxpZwvt/s-l1200.jpg">
                            <div class="product-body">
                                <small>Jeans</small>
                                <h5>Jeans Levis 501</h5>
                                <div class="stars">★★★★☆</div>
                                <div class="price">
                                    <span class="new">$129.900</span>
                                </div>
                                <div class="buttons">
                                    <button class="btn-favorite"><i class="bi bi-heart"></i></button>
                                    <button class="btn-cart"><i class="bi bi-cart-plus"></i> Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                   
                    <div class="col-lg-4">
                        <div class="product-card">
                            <div class="discount">-15%</div>
                            <img src="https://images.snowleader.com/media/catalog/product/cache/1/image/0dc2d03fe217f8c83829496872af24a0/T/H/THEN05326_01_202507170447.jpg">
                            <div class="product-body">
                                <small>Chaquetas</small>
                                <h5>Chaqueta Bomber</h5>
                                <div class="stars">★★★★★</div>
                                <div class="price">
                                    <span class="old">$229.900</span>
                                </div>
                                <div class="buttons">
                                    <button class="btn-favorite"><i class="bi bi-heart"></i></button>
                                    <button class="btn-cart"><i class="bi bi-cart-plus"></i> Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                   
                    <div class="col-lg-4">
                        <div class="product-card">
                            <img src="https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=900">
                            <div class="product-body">
                                <small>Zapatos</small>
                                <h5>Sneakers Urban</h5>
                                <div class="stars">★★★★☆</div>
                                <div class="price">
                                    <span class="new">$140.000</span>
                                </div>
                                <div class="buttons">
                                    <button class="btn-favorite"><i class="bi bi-heart"></i></button>
                                    <button class="btn-cart"><i class="bi bi-cart-plus"></i> Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

           

          
                    <div class="col-lg-4">
                        <div class="product-card">
                            <img src="https://equipment-ec.com/wp-content/uploads/2025/02/Copia-19_25-adi.webp">
                            <div class="product-body">
                                <small>Camisetas</small>
                                <h5>Hoodie Clásico</h5>
                                <div class="stars">★★★★☆</div>
                                <div class="price">
                                    <span class="new">$99.900</span>
                                </div>
                                <div class="buttons">
                                    <button class="btn-favorite"><i class="bi bi-heart"></i></button>
                                    <button class="btn-cart"><i class="bi bi-cart-plus"></i> Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                  
                    <div class="col-lg-4">
                        <div class="product-card">
                            <div class="discount">-20%</div>
                            <img src="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS_4UsB7GiAtniiVcYIRj11ehPRUWeQe_QKAN_oauD55fjz9fEnyRNTA-w&s=10">
                            <div class="product-body">
                                <small>Zapatos</small>
                                <h5>Botas Kumbre</h5>
                                <div class="stars">★★★★★</div>
                                <div class="price">
                                    <span class="new">$239.900</span>
                                </div>
                                <div class="buttons">
                                    <button class="btn-favorite"><i class="bi bi-heart"></i></button>
                                    <button class="btn-cart"><i class="bi bi-cart-plus"></i> Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-4">
                        <div class="product-card">
                            <div class="discount">-10%</div>
                            <img src="https://images.unsplash.com/photo-1503341504253-dff4815485f1?w=900">
                            <div class="product-body">
                                <small>Hombres</small>
                                <h5>Camisa Casual </h5>
                                <div class="stars">★★★★★</div>
                                <div class="price">
                                    <span class="new">$107.900</span>
                                </div>
                                <div class="buttons">
                                    <button class="btn-favorite"><i class="bi bi-heart"></i></button>
                                    <button class="btn-cart"><i class="bi bi-cart-plus"></i> Agregar</button>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

        </div>
    </div>
</section>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>

