package ut3;

public class Main {
    public static void main(String[] args) {
        Lista<String> listaSucursalesSuc1 = new Lista<>(); 
        ManejadorArchivosGenerico manejadorArchivosSuc1 = new ManejadorArchivosGenerico();
        String nombreArchivo1 = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD6\\gestor_sucursales\\src\\main\\java\\ut3\\suc1.txt";
        String[] lineasArchivo1 = manejadorArchivosSuc1.leerArchivo(nombreArchivo1);

        for (String linea : lineasArchivo1) {
            Nodo<String> nodo = new Nodo<>(linea, linea); 
            listaSucursalesSuc1.insertar(nodo);
        }

        System.out.println(listaSucursalesSuc1.cantElementos());
        System.out.println(listaSucursalesSuc1.imprimir());

        listaSucursalesSuc1.eliminar("Chicago");
        System.out.println(listaSucursalesSuc1.cantElementos());
        System.out.println(listaSucursalesSuc1.imprimir());


        Lista<String> listaSucursalesSuc2 = new Lista<>();
        ManejadorArchivosGenerico manejadorArchivosSuc2 = new ManejadorArchivosGenerico();
        String nombreArchivo2 = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD6\\gestor_sucursales\\src\\main\\java\\ut3\\suc2.txt";
        String[] lineasArchivo2 = manejadorArchivosSuc2.leerArchivo(nombreArchivo2);

        for (String linea : lineasArchivo2) {
            Nodo<String> nodo = new Nodo<>(linea, linea);
            listaSucursalesSuc2.insertar(nodo);
        }

        listaSucursalesSuc2.eliminar("Shanzen");
        listaSucursalesSuc2.eliminar("Tokio");

        System.out.println(listaSucursalesSuc2.cantElementos());


        Lista<String> listaSucursalesSuc3 = new Lista<>();
        ManejadorArchivosGenerico manejadorArchivosSuc3 = new ManejadorArchivosGenerico();
        String nombreArchivo3 = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD6\\gestor_sucursales\\src\\main\\java\\ut3\\suc3.txt";
        String[] lineasArchivo3 = manejadorArchivosSuc3.leerArchivo(nombreArchivo3);

        for (String linea : lineasArchivo3) {
            Nodo<String> nodo = new Nodo<>(linea, linea);
            listaSucursalesSuc3.insertar(nodo);
        }

        System.out.println(listaSucursalesSuc3.imprimir(";_"));
    }
}