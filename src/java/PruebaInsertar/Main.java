package PruebaInsertar;

import Controlador.UsuarioDAO;
import Modelo.Usuarios;
import java.sql.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        UsuarioDAO dao = new UsuarioDAO();

        int opcion;

        do {
            System.out.println("\n========== MENU BYSTYLE ==========");
            System.out.println("1. Registrar Nuevo Usuario");
            System.out.println("2. Iniciar Sesión");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");

            // Evitamos errores si el usuario digita algo que no sea un número
            while (!sc.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido.");
                System.out.print("Seleccione una opción: ");
                sc.next();
            }
            opcion = sc.nextInt();
            sc.nextLine(); // Limpiar el buffer

            switch (opcion) {

                case 1:
                    System.out.println("\n--- REGISTRO ---");

                    Usuarios nuevo = new Usuarios();

                    System.out.print("Nombre: ");
                    nuevo.setNombre(sc.nextLine());

                    System.out.print("Apellido: ");
                    nuevo.setApellido(sc.nextLine());

                    System.out.print("Identificación: ");
                    nuevo.setIdentificacion(sc.nextLine());

                    System.out.print("Teléfono: ");
                    nuevo.setTelefono(sc.nextLine());

                    System.out.print("Dirección: ");
                    nuevo.setDireccion(sc.nextLine());

                    System.out.print("Email: ");
                    nuevo.setEmail(sc.nextLine());

                    System.out.print("Clave: ");
                    nuevo.setClave(sc.nextLine());

                    // --- SOLUCIÓN DEL ERROR DE FECHA ---
                    Date fechaValida = null;
                    while (fechaValida == null) {
                        System.out.print("Fecha Nacimiento (AAAA-MM-DD): ");
                        String fechaInput = sc.nextLine().trim();
                        try {
                            fechaValida = Date.valueOf(fechaInput);
                        } catch (IllegalArgumentException e) {
                            System.out.println("[ ERROR ] Formato de fecha inválido. Recuerda usar guiones (Ej: 1995-05-25).");
                        }
                    }
                    nuevo.setFecha_nacimiento(fechaValida);
                    // ------------------------------------

                    nuevo.setTipoIdentificacion_idTipoIdentificacion(1);
                    nuevo.setRol_idRol(2);

                    if (dao.registrar(nuevo)) {
                        System.out.println("\n[ OK ] Usuario registrado correctamente.");
                    } else {
                        System.out.println("\n[ ERROR ] No se pudo registrar en la base de datos.");
                    }
                    break;

                case 2:
                    System.out.println("\n--- LOGIN ---");

                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    System.out.print("Clave: ");
                    String clave = sc.nextLine();

                    Usuarios usuario = dao.validarLogin(email, clave);

                    if (usuario != null) {
                        System.out.println("\n[ OK ] Bienvenido " + usuario.getNombre());
                    } else {
                        System.out.println("\n[ ERROR ] Correo o contraseña incorrectos");
                    }
                    break;

                case 3:
                    System.out.println("Hasta luego.");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 3);

        sc.close();
    }
}