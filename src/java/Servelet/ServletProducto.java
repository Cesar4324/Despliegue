package Servelet;

import Controlador.ProductoDAO;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/ServletProducto")
public class ServletProducto extends HttpServlet {


    ProductoDAO dao = new ProductoDAO();


    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        String accion = request.getParameter("accion");


        if(accion == null){

            accion = "listar";

        }


        switch(accion){


            case "eliminar":

                eliminar(request,response);

                break;


            default:

                response.sendRedirect(
                    request.getContextPath()
                    + "/Vista/Producto.jsp"
                );

                break;

        }

    }



    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {


        request.setCharacterEncoding("UTF-8");


        String accion = request.getParameter("accion");



        if("agregar".equals(accion)){


            agregar(request,response);


        }else if("actualizar".equals(accion)){


            actualizar(request,response);

        }


    }




    private void agregar(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException{


        String nombre =
                request.getParameter("nombre");


        String descripcion =
                request.getParameter("descripcion");


        double precio =
                Double.parseDouble(
                request.getParameter("precio"));


        int stock =
                Integer.parseInt(
                request.getParameter("stock"));


        int categoria =
                Integer.parseInt(
                request.getParameter("categoria"));



        int marca =
                Integer.parseInt(
                request.getParameter("marca"));


        int color =
                Integer.parseInt(
                request.getParameter("color"));


        int talla =
                Integer.parseInt(
                request.getParameter("talla"));



        dao.agregar(
                nombre,
                descripcion,
                precio,
                stock,
                categoria,
                marca,
                color,
                talla
        );


        response.sendRedirect(
                request.getContextPath()
                + "/Vista/Producto.jsp"
        );

    }





    private void actualizar(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException{


        int id =
            Integer.parseInt(
            request.getParameter("id"));



        String nombre =
            request.getParameter("nombre");


        double precio =
            Double.parseDouble(
            request.getParameter("precio"));


        int stock =
            Integer.parseInt(
            request.getParameter("stock"));



        dao.actualizar(
                id,
                nombre,
                precio,
                stock
        );


        response.sendRedirect(
                request.getContextPath()
                + "/Vista/Producto.jsp"
        );


    }





    private void eliminar(HttpServletRequest request,
            HttpServletResponse response)
            throws IOException{


        int id =
            Integer.parseInt(
            request.getParameter("id"));



        dao.eliminar(id);



        response.sendRedirect(
                request.getContextPath()
                + "/Vista/Producto.jsp"
        );

    }



}