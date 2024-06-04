package ut3;


import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        Expresion expresion = new Expresion();

        String nombreArchivo = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD9\\secuencia_corchetes\\src\\main\\java\\ut3\\CorchetesBalanceados.txt";
        String[] lineasArchivo = manejadorArchivos.leerArchivo(nombreArchivo);

        List<String> listaDeEntrada = new ArrayList<>(Arrays.asList(lineasArchivo));

        boolean controlCorchetes = expresion.controlCorchetes(listaDeEntrada);

        if (controlCorchetes) {
            System.out.println("Los corchetes están balanceados.");
        } else {
            System.out.println("Los corchetes no están balanceados.");
        }
    }
}

