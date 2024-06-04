package ut3;

public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "C:\\Users\\MICAE\\OneDrive\\Escritorio\\aed-2024-1-portafolio-micaelacrocco\\UT3\\UT2_PD1\\ordenamiento_burbuja\\Entradas\\numeros.txt";
        
        // Leyendo el archivo
        String[] lineas = ManejadorArchivosGenerico.leerArchivo(nombreArchivo);
        
        if (lineas != null && lineas.length > 0) {
            try {
                int N = Integer.parseInt(lineas[0]);
                int[] numeros = new int[N];
    
                for (int i = 1; i < lineas.length; i++) {
                    numeros[i - 1] = Integer.parseInt(lineas[i]);
                }
    
                AlgoritmoBurbuja.ordenar(numeros);
    
                System.out.println("Largo N: " + N);
                System.out.println("Contador de 'si': " + AlgoritmoBurbuja.getContadorSi());
                System.out.println("Número en la primera posición: " + numeros[0]);
                System.out.println("Número en la última posición: " + numeros[N - 1]);
                
            } catch (NumberFormatException e) {
                System.err.println("El primer valor del archivo no es un número válido.");
            }
        } else {
            System.err.println("El archivo está vacío o no se pudo leer.");
        }
    }
}
