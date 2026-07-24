<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<%
String ctx = request.getContextPath();
%>

<!DOCTYPE html>
<html lang="es">

<head>

<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">

<title>Registro | ByStyles</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<link rel="stylesheet"
      href="<%=ctx%>/Css/Registro.css">

</head>

<body>

<div class="container py-5">

<div class="row justify-content-center">

<div class="col-lg-8 col-md-10">

<div class="card card-registro p-4">

<h2 class="text-center fw-bold mb-4">
Crear Cuenta en ByStyles
</h2>

<c:if test="${not empty error}">
<div class="alert alert-danger">
${error}
</div>
</c:if>

<form action="${pageContext.request.contextPath}/Registro" method="POST">

<div class="row">

<div class="col-md-6 mb-3">
<label class="form-label">Nombre</label>
<input type="text" name="nombre" class="form-control" required>
</div>

<div class="col-md-6 mb-3">
<label class="form-label">Apellido</label>
<input type="text" name="apellido" class="form-control" required>
</div>

</div>

<div class="row">

<div class="col-md-6 mb-3">

<label class="form-label">
Tipo de Identificación
</label>

<select
<select name="tipoIdentificacion"
class="form-select"
required>

<option value="1">Cédula de Ciudadanía</option>
<option value="2">Tarjeta de Identidad</option>
<option value="3">Pasaporte</option>
<option value="4">Cédula de Extranjería</option>

</select>

</div>

<div class="col-md-6 mb-3">

<label class="form-label">
Número de Identificación
</label>

<input type="text"
name="identificacion"
class="form-control"
required>

</div>

</div>

<div class="row">

<div class="col-md-6 mb-3">

<label class="form-label">
Teléfono
</label>

<input type="text"
name="telefono"
class="form-control">

</div>

<div class="col-md-6 mb-3">

<label class="form-label">
Dirección
</label>

<input type="text"
name="direccion"
class="form-control">

</div>

</div>

<div class="row">

<div class="col-md-6 mb-3">

<label class="form-label">
Fecha de Nacimiento
</label>

<input type="date"
name="fecha_nacimiento"
class="form-control"
required>

</div>

<div class="col-md-6 mb-3">

<label class="form-label">
Rol
</label>

<select
<select name="rol"
class="form-select"
required>

<option value="2">Cliente</option>
<option value="1">Administrador</option>

</select>

</div>

</div>

<div class="mb-3">

<label class="form-label">
Correo Electrónico
</label>

<input type="email"
name="email"
class="form-control"
required>

</div>

<div class="mb-4">

<label class="form-label">
Contraseña
</label>

<input type="password"
name="clave"
class="form-control"
required>

</div>

<button type="submit"
class="btn btn-morado w-100">

Registrarse

</button>

<div class="text-center mt-3">

<a href="<%=ctx%>/Vista/Login.jsp"
class="text-decoration-none">

¿Ya tienes cuenta? Inicia sesión

</a>

</div>

</form>

</div>

</div>

</div>

</div>

</body>
</html>