package ut3;

import static org.junit.Assert.*;
import org.junit.Test;

public class ConjuntoTest {
    
    @Test
    public void testUnion() {
        
        IConjunto<TAlumno> cursoAED1 = new Conjunto<>();
        IConjunto<TAlumno> cursoPF = new Conjunto<>();
        
        TAlumno alumno1 = new TAlumno(1234, "Juan", "Perez");
        TAlumno alumno2 = new TAlumno(5678, "Maria", "Lopez");
        TAlumno alumno3 = new TAlumno(9012, "Carlos", "Garcia");
        TAlumno alumno4 = new TAlumno(3456, "Ana", "Martinez");
        
        cursoAED1.insertar(alumno1.getCedula(), alumno1);
        cursoAED1.insertar(alumno2.getCedula(), alumno2);
        
        cursoPF.insertar(alumno2.getCedula(), alumno2); 
        cursoPF.insertar(alumno3.getCedula(), alumno3);
        cursoPF.insertar(alumno4.getCedula(), alumno4);
        
        IConjunto<TAlumno> unionCursos = cursoAED1.union(cursoPF);
        
        assertTrue(unionCursos.cantElementos() == 4);
    }
    
    @Test
    public void testInterseccion() {
        
        IConjunto<TAlumno> cursoAED1 = new Conjunto<>();
        IConjunto<TAlumno> cursoPF = new Conjunto<>();
        
        TAlumno alumno1 = new TAlumno(1234, "Juan", "Perez");
        TAlumno alumno2 = new TAlumno(5678, "Maria", "Lopez");
        TAlumno alumno3 = new TAlumno(9012, "Carlos", "Garcia");
        TAlumno alumno4 = new TAlumno(3456, "Ana", "Martinez");
        
        cursoAED1.insertar(alumno1.getCedula(), alumno1);
        cursoAED1.insertar(alumno2.getCedula(), alumno2);
        
        cursoPF.insertar(alumno2.getCedula(), alumno2); 
        cursoPF.insertar(alumno3.getCedula(), alumno3);
        cursoPF.insertar(alumno4.getCedula(), alumno4);
        
        IConjunto<TAlumno> interseccionCursos = cursoAED1.interseccion(cursoPF);
        
        assertTrue(interseccionCursos.cantElementos() == 1);
        assertNotNull(interseccionCursos.buscar(alumno2.getCedula()));
    }
}

