package aed;

public class App {

    public static void main( String[] args )
    {
        String[] texto = ManejadorArchivosGenerico2.leerArchivoXPalabras("UT6_DiccionarioMapasHashing\\PDs\\pd4\\libro.txt");
        ContadorPalabras.contarPalabras(texto);
    }
}
