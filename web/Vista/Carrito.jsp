<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.ItemCarrito"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
    String ctx = request.getContextPath();

    ArrayList<ItemCarrito> carrito =
            (ArrayList<ItemCarrito>) session.getAttribute("carrito");

    double subtotal = 0;

    if (carrito != null) {
        for (ItemCarrito p : carrito) {
            subtotal += p.getPrecio() * p.getCantidad();
        }
    }

    double iva = subtotal * 0.19;
    double total = subtotal + iva;
%>

<!DOCTYPE html>
<html lang="es">

<head>

<meta charset="UTF-8">

<meta name="viewport"
      content="width=device-width, initial-scale=1.0">

<title>Mi Carrito | ByStyles</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
      rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css"
      rel="stylesheet">

<link rel="stylesheet"
      href="<%=ctx%>/Css/styles.css">

</head>

<body>

<nav class="navbar navbar-dark bg-dark">

<div class="container">

<a class="navbar-brand"
   href="<%=ctx%>/Vista/Tienda.jsp">

ByStyles

</a>

<a href="<%=ctx%>/Vista/Tienda.jsp"
   class="btn btn-warning">

<i class="bi bi-arrow-left"></i>

Seguir Comprando

</a>

</div>

</nav>

<div class="container mt-5">

<h2 class="mb-4">

<i class="bi bi-cart3"></i>

Mi Carrito

</h2>
    
    <%
if(carrito==null || carrito.isEmpty()){
%>

<div class="alert alert-warning text-center">

<h4>

Tu carrito está vacío

</h4>

<a href="<%=ctx%>/Vista/Tienda.jsp"
   class="btn btn-dark mt-3">

Ir a la tienda

</a>

</div>

<%
}else{
%>

<table class="table table-striped table-hover align-middle">

<thead class="table-dark">

<tr>

<th>Imagen</th>

<th>Producto</th>

<th>Precio</th>

<th>Cantidad</th>

<th>Subtotal</th>

</tr>

</thead>

<tbody>
    <%
for(ItemCarrito item : carrito){
%>

<tr>

<td width="120">

<img src="<%=item.getImagen()%>"
     class="img-fluid rounded"
     style="width:100px;height:100px;object-fit:cover;">

</td>

<td>

<h5><%=item.getNombre()%></h5>

</td>

<td>

$ <%=String.format("%,.0f", item.getPrecio())%>

</td>

<td>

<span class="badge bg-warning text-dark fs-6">

<%=item.getCantidad()%>

</span>

</td>

<td>

$ <%=String.format("%,.0f",
item.getPrecio()*item.getCantidad())%>

</td>

</tr>

<%
}
%>

</tbody>

</table>

<div class="row justify-content-end">

<div class="col-md-4">

<div class="card shadow">

<div class="card-body">

<h5 class="mb-3">

Resumen del Pedido

</h5>

<hr>

<p class="d-flex justify-content-between">

<span>Subtotal</span>

<strong>

$ <%=String.format("%,.0f",subtotal)%>

</strong>

</p>

<p class="d-flex justify-content-between">

<span>IVA (19%)</span>

<strong>

$ <%=String.format("%,.0f",iva)%>

</strong>

</p>

<hr>

<h4 class="d-flex justify-content-between">

<span>Total</span>

<strong class="text-success">

$ <%=String.format("%,.0f",total)%>

</strong>

</h4>

<div class="d-grid gap-2 mt-4">

<a href="<%=ctx%>/Vista/Tienda.jsp"
   class="btn btn-secondary">

<i class="bi bi-arrow-left"></i>

Seguir Comprando

</a>

<button class="btn btn-success">

<i class="bi bi-credit-card"></i>

Finalizar Compra

</button>

</div>

</div>

</div>

</div>

</div>

<%
}
%>

</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>