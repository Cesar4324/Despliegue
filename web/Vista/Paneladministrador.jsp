<%@ page import="Modelo.Usuarios" %>

<%
    HttpSession misession = request.getSession(false);
    Usuarios usuarioLogueado = (misession != null)
        ? (Usuarios) misession.getAttribute("usuarioLogueado")
        : null;

    String ctx = request.getContextPath();
%>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">

    <div class="container">

        <a class="navbar-brand fw-bold" href="<%=ctx%>/index.jsp">
            ByStyles
        </a>

        <button class="navbar-toggler"
                type="button"
                data-bs-toggle="collapse"
                data-bs-target="#menu">

            <span class="navbar-toggler-icon"></span>

        </button>

        <div class="collapse navbar-collapse" id="menu">

            <ul class="navbar-nav ms-auto align-items-center">

                <li class="nav-item">
                    <a class="nav-link active" href="<%=ctx%>/index.jsp">
                        Inicio
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#productos">
                        Productos
                    </a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="#contacto">
                        Contacto
                    </a>
                </li>

                <!-- USUARIO LOGUEADO -->
                <% if (usuarioLogueado != null) { %>

                    <li class="nav-item ms-3">
                        <span class="navbar-text text-white fw-bold">
                            Hola, <%= usuarioLogueado.getNombre() %>
                        </span>
                    </li>

                    <!-- SOLO ADMIN -->
                    <% if (usuarioLogueado.getRol() == 1) { %>

                        <li class="nav-item ms-2">
                            <a class="btn btn-warning btn-sm"
                               href="<%=ctx%>/Vista/PanelAdministrador.jsp">
                                Administrador
                            </a>
                        </li>

                    <% } %>

                    <li class="nav-item ms-2">
                        <a class="btn btn-outline-light btn-sm"
                           href="<%=ctx%>Vista/Login.jsp">
                            Salir
                        </a>
                    </li>

                <% } else { %>

                    <li class="nav-item">
                        <a class="nav-link" href="<%=ctx%>/Vistas/Login.jsp">
                            Iniciar Sesión
                        </a>
                    </li>

                    <li class="nav-item">
                        <a class="nav-link" href="<%=ctx%>/Vistas/registro.jsp">
                            Registro
                        </a>
                    </li>

                <% } %>

            </ul>

        </div>

    </div>

</nav>