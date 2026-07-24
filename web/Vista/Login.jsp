<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>

<%
    String ctx = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="es">

<head>

    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>ByStyles | Iniciar Sesión</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
          rel="stylesheet">

    <link rel="stylesheet"
          href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

    <link rel="stylesheet"
          href="<%=ctx%>/Css/Login.css">

</head>

<body class="login-body">

<div class="login-container">

    <div class="login-left">

        <h1 class="brand-title">
            ByStyles
        </h1>

        <p class="brand-text">
            Moda, estilo y elegancia en un solo lugar.
        </p>

        <div class="brand-decoration"></div>

    </div>

    <div class="login-right">

        <div class="login-card">

            <h2 class="mb-4 text-center">
                Iniciar Sesión
            </h2>

            <c:if test="${not empty error}">
                <div class="alert alert-danger">
                    ${error}
                </div>
            </c:if>

            <c:if test="${not empty mensajeExito}">
                <div class="alert alert-success">
                    ${mensajeExito}
                </div>
            </c:if>

            <form action="<%=ctx%>/ServletLogin"
                  method="POST">

                <div class="mb-3">

                    <label class="form-label">
                        Correo Electrónico
                    </label>

                    <input type="email"
                           name="email"
                           class="form-control input-login"
                           required>

                </div>

                <div class="mb-4">

                    <label class="form-label">
                        Contraseña
                    </label>

                    <input type="password"
                           name="clave"
                           class="form-control input-login"
                           required>

                </div>

                <button type="submit"
                        class="btn-login w-100">

                    Entrar

                </button>

            </form>

            <div class="text-center mt-4">

                <a href="<%=ctx%>/Vista/registro.jsp"
                   class="link-login">

                    ¿No tienes cuenta? Regístrate

                </a>

            </div>

        </div>

    </div>

</div>

</body>
</html>