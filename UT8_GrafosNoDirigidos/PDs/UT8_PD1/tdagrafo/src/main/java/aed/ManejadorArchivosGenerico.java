package aed;

import java.io.*;
import java.util.ArrayList;

public class ManejadorArchivosGenerico {

    /**
     * @param nombreCompletoArchivo
     * @param listaLineasArchivo    lista con las lineas del archivo
     * @throws IOException
     */
    public static void escribirArchivo(String nombreCompletoArchivo,
            String[] listaLineasArchivo) {
        FileWriter fw;
        try {
            fw = new FileWriter(nombreCompletoArchivo, true);
            BufferedWriter bw = new BufferedWriter(fw);
            for (int i = 0; i < listaLineasArchivo.length; i++) {
                String lineaActual = listaLineasArchivo[i];
                bw.write(lineaActual);
                bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        }
    }

    public static String[] leerArchivoRutaRelativa(String nombreCompletoArchivo, boolean ignoreHeader) {
        String path = ManejadorArchivosGenerico.class
                .getResource(nombreCompletoArchivo).getPath();
        return leerArchivo(path, ignoreHeader);
    }

    public static String[] leerArchivo(String nombreCompletoArchivo, boolean ignoreHeader) {
        FileReader fr;
        ArrayList<String> listaLineasArchivo = new ArrayList<String>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            if (ignoreHeader)
                lineaActual = br.readLine();
            while (lineaActual != null) {
                listaLineasArchivo.add(lineaActual);
                lineaActual = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        }
        // System.out.println("Archivo leido satisfactoriamente");

        return listaLineasArchivo.toArray(new String[0]);
    }

    // Método para leer palabras del archivo y devolver un ArrayList
    public static ArrayList<String> leerPalabras(String nombreCompletoArchivo) {
        FileReader fr;
        ArrayList<String> listaPalabras = new ArrayList<String>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null) {
                String[] palabras = lineaActual.split("\\s+"); // Dividir la línea en palabras
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        listaPalabras.add(palabra);
                    }
                }
                lineaActual = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        }

        return listaPalabras;
    }

    // Método para leer líneas del archivo y devolver un ArrayList
    public static ArrayList<String> leerLineas(String nombreCompletoArchivo) {
        FileReader fr;
        ArrayList<String> listaLineas = new ArrayList<String>();
        try {
            fr = new FileReader(nombreCompletoArchivo);
            BufferedReader br = new BufferedReader(fr);
            String lineaActual = br.readLine();
            while (lineaActual != null) {
                listaLineas.add(lineaActual);
                lineaActual = br.readLine();
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo "
                    + nombreCompletoArchivo);
            e.printStackTrace();
        }

        return listaLineas;
    }

    // Nuevo método para leer palabras del archivo y devolver un array
    public static String[] leerPalabrasComoArray(String nombreCompletoArchivo) {
        ArrayList<String> listaPalabras = leerPalabras(nombreCompletoArchivo);
        return listaPalabras.toArray(new String[0]);
    }

    // Nuevo método para leer líneas del archivo y devolver un array
    public static String[] leerLineasComoArray(String nombreCompletoArchivo) {
        ArrayList<String> listaLineas = leerLineas(nombreCompletoArchivo);
        return listaLineas.toArray(new String[0]);
    }
}