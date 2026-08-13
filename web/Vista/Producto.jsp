<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Producto"%>
<%@page import="Controlador.ProductoDAO"%>

<%
    HttpSession misession = request.getSession(false);

    if (misession == null || misession.getAttribute("usuarioLogueado") == null) {
        response.sendRedirect(request.getContextPath() + "/Vista/Login.jsp");
        return;
    }

    String ctx = request.getContextPath();

    ProductoDAO dao = new ProductoDAO();
    List<Producto> lista = dao.listar();
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<title>Productos | ByStyles</title>

<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.css" rel="stylesheet">

<link rel="stylesheet" href="<%=ctx%>/Css/Panel.css">

</head>

<body>

<div class="contenido">
    <div class="d-flex justify-content-between align-items-center mb-4">

    <div>
        <h2><i class="bi bi-bag-fill"></i> Gestión de Productos</h2>
        <p class="text-muted">Administra todos los productos de la tienda.</p>
    </div>

    <a href="#" class="btn btn-warning">
        <i class="bi bi-plus-circle"></i> Agregar Producto
    </a>

</div>
    
    <div class="card shadow-sm mb-4">

    <div class="card-body">

        <input
            type="text"
            class="form-control"
            placeholder="Buscar producto...">

    </div>

</div>
    <div class="card shadow">

    <div class="card-header bg-dark text-white">

        <h4 class="mb-0">
            <i class="bi bi-box-seam"></i>
            Lista de Productos
        </h4>

    </div>

    <div class="card-body table-responsive">

        <table class="table table-hover table-bordered align-middle">

            <thead class="table-warning">

                <tr>

                    <th>ID</th>

                    <th>Producto</th>

                    <th>Descripción</th>

                    <th>Precio</th>

                    <th>Stock</th>

                    <th>Categoría</th>

                    <th width="180">Acciones</th>

                </tr>

            </thead>

            <tbody>

            <%

                if(lista.isEmpty()){

            %>

                <tr>

                    <td colspan="7" class="text-center text-muted">

                        No hay productos registrados.

                    </td>

                </tr>

            <%

                }else{

                    for(Producto p : lista){

            %>

                <tr>

                    <td>

                        <%=p.getIdProducto()%>

                    </td>

                    <td>

                        <%=p.getNombre()%>

                    </td>

                    <td>

                        <%=p.getDescripcion()%>

                    </td>

                    <td>

                        $ <%=String.format("%,.0f", p.getPrecio())%>

                    </td>

                    <td>

                        <span class="badge bg-success">

                            <%=p.getStock()%>

                        </span>

                    </td>

                    <td>

                        <%=p.getIdCategoria()%>

                    </td>

                    <td>

                        <a href="EditarProducto.jsp?id=<%=p.getIdProducto()%>"
                           class="btn btn-primary btn-sm">

                            <i class="bi bi-pencil-square"></i>

                        </a>

                        <a href="<%=ctx%>/ServletProducto?accion=eliminar&id=<%=p.getIdProducto()%>"
                           class="btn btn-danger btn-sm"
                           onclick="return confirm('¿Desea eliminar este producto?')">

                            <i class="bi bi-trash"></i>

                        </a>

                    </td>

                </tr>

            <%

                    }

                }

            %>

            </tbody>

        </table>

    </div>

</div>
            
            </div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>

</body>

</html>