package ut3;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertFalse;

public class EspresionTest 
{
    @Test
    public void testCorchetesBalanceados() {
        // Cargar el archivo con corchetes balanceados
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        Expresion expresion = new Expresion();

        String nombreArchivo = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD9\\secuencia_corchetes\\src\\main\\java\\ut3\\CorchetesBalanceados.txt";
        String[] lineasArchivo = manejadorArchivos.leerArchivo(nombreArchivo);
        
        List<String> lineasBalanceadas = new ArrayList<>(Arrays.asList(lineasArchivo));

        boolean resultado = expresion.controlCorchetes(lineasBalanceadas);

        assertTrue("Se esperaba que los corchetes estén balanceados.", resultado);
    }
    @Test
    public void testCorchetesNoBalanceados() {
        // Cargar el archivo con corchetes no balanceados
        ManejadorArchivosGenerico manejadorArchivos = new ManejadorArchivosGenerico();
        Expresion expresion = new Expresion();

        String nombreArchivo = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\Algorithmsn'DataStructures\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT3_PD9\\secuencia_corchetes\\src\\main\\java\\ut3\\CorchetesNoBalanceados.txt";
        String[] lineasArchivo = manejadorArchivos.leerArchivo(nombreArchivo);


        List<String> lineasNoBalanceadas = new ArrayList<>(Arrays.asList(lineasArchivo));

        boolean resultado = expresion.controlCorchetes(lineasNoBalanceadas);
        assertFalse("Se esperaba que los corchetes no estén balanceados.", resultado);
    }
}
