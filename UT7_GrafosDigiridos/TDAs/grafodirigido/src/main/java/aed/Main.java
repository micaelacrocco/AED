package aed;

/**
 * Hello world!
 *
 */
public class Main
{
    public static void main( String[] args )
    {
        TGrafoDirigido grafo = new TGrafoDirigido(null, null);
        TVertice vertice1 = new TVertice<>("Andorra");
        TVertice vertice2 = new TVertice<>("Uruguay");
        TVertice vertice3 = new TVertice<>("Corea");
        TVertice vertice4 = new TVertice<>("Mongolia");    

        TArista arista1 = new TArista("Andorra", "Uruguay", 0);
        TArista arista2 = new TArista("Andorra", "Mongolia", 0);
        TArista arista3 = new TArista("Corea", "Urugauy", 0);

    }
}
