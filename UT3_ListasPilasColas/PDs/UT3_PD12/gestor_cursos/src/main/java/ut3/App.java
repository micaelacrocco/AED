package ut3;

import java.util.ArrayList;
import java.util.List;

public class App 
{
    public static void main(String[] args)
    {
        IConjunto<Alumno> BasicoIng1 = new Conjunto<>();
        IConjunto<Alumno> BasicoIng2 = new Conjunto<>();

        IConjunto<Alumno> Integrador101 = new Conjunto<>();
        IConjunto<Alumno> Exigente102 = new Conjunto<>();

        ManejadorArchivosGenerico manejadorArchivosGenerico = new ManejadorArchivosGenerico();

        String nombreArchivo1 = "ut3_pd12\\src\\main\\basico-ing.txt";
        String nombreArchivo2 = "ut3_pd12\\src\\main\\basico-emp.txt";
        String nombreArchivo3 = "ut3_pd12\\src\\main\\java\\ut3\\Integrador101.txt";
        String nombreArchivo4 = "ut3_pd12\\src\\main\\java\\ut3\\Exigente102.txt";
        

        String[] lineas_BasicoIng1 = ManejadorArchivosGenerico.leerArchivo(nombreArchivo1);
        String[] lineas_BasicoIng2 = ManejadorArchivosGenerico.leerArchivo(nombreArchivo2);
        

        for (String linea : lineas_BasicoIng1) {
            String[] partes = linea.split(",");
            Alumno alumno = new Alumno(Integer.parseInt(partes[0]), partes[1]);
            BasicoIng1.insertar(alumno.getCodigo(), alumno);
        }

        for (String linea : lineas_BasicoIng2) {
            String[] partes = linea.split(",");
            Alumno alumno = new Alumno(Integer.parseInt(partes[0]), partes[1]);
            BasicoIng1.insertar(alumno.getCodigo(), alumno);
        }

        Integrador101 = BasicoIng1.union(BasicoIng2);
        Exigente102 = BasicoIng1.interseccion(BasicoIng2);

        Lista<String> lineas_Exigente102 = new Lista<>();

        for (int i = 0; i < Exigente102.cantElementos(); i++) {
            Nodo<Alumno> nodo = Exigente102.buscar(i);
            lineas_Exigente102.insertar(new Nodo<>(nodo.getEtiqueta(), nodo.getDato().toString()));
        }
        ManejadorArchivosGenerico.escribirArchivo(nombreArchivo4, lineas_Exigente102.toArray());
        
        Lista<String> lineas_Integrador101 = new Lista<>();
        
        for (int i = 0; i < Integrador101.cantElementos(); i++) {
            Nodo<Alumno> nodo = Integrador101.buscar(i);
            lineas_Integrador101.insertar(new Nodo<>(nodo.getEtiqueta(), nodo.getDato().toString()));
        }
        ManejadorArchivosGenerico.escribirArchivo(nombreArchivo3, lineas_Integrador101.toArray());

        
    }
}
