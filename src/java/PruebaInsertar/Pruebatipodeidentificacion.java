package PruebaInsertar;

import Controlador.TipodeidentificacionDAO;
import Modelo.Tipodeidentificacion;
import java.util.ArrayList;
import java.util.List;

public class Pruebatipodeidentificacion {

    public static void main(String[] args) {
        TipodeidentificacionDAO dao = new TipodeidentificacionDAO();
        
        // Lista con los tipos de documentos a agregar
        List<String> documentos = new ArrayList<>();
        documentos.add("Cédula de Ciudadanía");
        documentos.add("Tarjeta de Identidad");
        documentos.add("Pasaporte");
        documentos.add("Cédula de Extranjería");
        documentos.add("NIT");

        System.out.println("--- INICIANDO INSERCIÓN MASIVA ---");

        for (String nombreDoc : documentos) {
            // Usa el constructor que recibe la descripción
            Tipodeidentificacion nuevoTipo = new Tipodeidentificacion(nombreDoc);
            
            // CORREGIDO: Se cambia 'registrarTipodeidentificacion' por 'insertar'
            if (dao.insertar(nuevoTipo)) {
                System.out.println("[ OK ] Registrado: " + nombreDoc);
            } else {
                System.out.println("[ ERROR ] No se pudo registrar: " + nombreDoc);
            }
        }
        
        System.out.println("--- PROCESO TERMINADO ---");
    }
}