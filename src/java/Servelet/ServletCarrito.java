package Servelet;

import Modelo.ItemCarrito;
import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ServletCarrito")
public class ServletCarrito extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        ArrayList<ItemCarrito> carrito =
                (ArrayList<ItemCarrito>) session.getAttribute("carrito");

        if (carrito == null) {
            carrito = new ArrayList<>();
        }

        try {

            int id = Integer.parseInt(
                    request.getParameter("id")
            );

            String nombre =
                    request.getParameter("nombre");

            double precio = Double.parseDouble(
                    request.getParameter("precio")
            );

            String imagen =
                    request.getParameter("imagen");


            boolean existe = false;


            /*
             * BUSCAR SI EL PRODUCTO YA EXISTE
             */

            for (ItemCarrito item : carrito) {

                if (item.getId() == id) {

                    item.setCantidad(
                            item.getCantidad() + 1
                    );

                    existe = true;

                    break;
                }
            }


            /*
             * SI NO EXISTE, CREAR PRODUCTO
             */

            if (!existe) {

                ItemCarrito item =
                        new ItemCarrito();

                item.setId(id);

                item.setNombre(nombre);

                item.setPrecio(precio);

                item.setImagen(imagen);

                item.setCantidad(1);

                carrito.add(item);
            }


            /*
             * GUARDAR CARRITO EN SESIÓN
             */

            session.setAttribute(
                    "carrito",
                    carrito
            );


            /*
             * VOLVER A LA TIENDA
             */

            response.sendRedirect(
                    request.getContextPath()
                    + "/Vista/Tienda.jsp"
            );


        } catch (NumberFormatException e) {

            response.sendRedirect(
                    request.getContextPath()
                    + "/Vista/Tienda.jsp"
            );
        }
    }


    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect(
                request.getContextPath()
                + "/Vista/carrito.jsp"
        );
    }
}