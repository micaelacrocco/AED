package ut3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> listaSucursalesSuc1 = new ArrayList<>();
        ManejadorArchivosGenerico manejadorArchivosSuc1 = new ManejadorArchivosGenerico();
        String nombreArchivo1 = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD6\\gestor_sucursales\\src\\main\\java\\ut3\\suc1.txt";
        String[] lineasArchivo1 = manejadorArchivosSuc1.leerArchivo(nombreArchivo1);

        for (String linea : lineasArchivo1) {
            listaSucursalesSuc1.add(linea);
        }

        System.out.println(listaSucursalesSuc1.size());
        System.out.println(listaSucursalesSuc1);

        listaSucursalesSuc1.remove("Chicago");
        System.out.println(listaSucursalesSuc1.size());
        System.out.println(listaSucursalesSuc1);

        ArrayList<String> listaSucursalesSuc2 = new ArrayList<>();
        ManejadorArchivosGenerico manejadorArchivosSuc2 = new ManejadorArchivosGenerico();
        String nombreArchivo2 = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD6\\gestor_sucursales\\src\\main\\java\\ut3\\suc2.txt";
        String[] lineasArchivo2 = manejadorArchivosSuc2.leerArchivo(nombreArchivo2);

        for (String linea : lineasArchivo2) {
            listaSucursalesSuc2.add(linea);
        }

        listaSucursalesSuc2.remove("Shanzen");
        listaSucursalesSuc2.remove("Tokio");

        System.out.println(listaSucursalesSuc2.size());

        ArrayList<String> listaSucursalesSuc3 = new ArrayList<>();
        ManejadorArchivosGenerico manejadorArchivosSuc3 = new ManejadorArchivosGenerico();
        String nombreArchivo3 = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD6\\gestor_sucursales\\src\\main\\java\\ut3\\suc3.txt";
        String[] lineasArchivo3 = manejadorArchivosSuc3.leerArchivo(nombreArchivo3);

        for (String linea : lineasArchivo3) {
            listaSucursalesSuc3.add(linea);
        }

        System.out.println(String.join(";_", listaSucursalesSuc3));
    }
}
