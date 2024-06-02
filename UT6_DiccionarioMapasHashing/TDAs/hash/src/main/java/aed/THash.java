package aed;

import java.util.Arrays;

public class THash implements IHash {
    private int[] tabla;
    private int size;
    private static final double FACTOR_CARGA = 0.7;

    public THash(int capacidadInicial) {
        tabla = new int[capacidadInicial];
        Arrays.fill(tabla, -1);  // -1 indica un espacio vacío
    }

    @Override
    public int buscar(int unaClave) {
        int indice = funcionHashing(unaClave);
        while (tabla[indice] != -1) {
            if (tabla[indice] == unaClave) {
                return indice;
            }
            indice = (indice + 1) % tabla.length;  // Siguiente índice
        }
        // System.out.println(unaClave); // Imprime las claves que no encontro
        return -1;  // No se encontró la clave
    }

    @Override
    public int insertar(int unaClave) {
        if (size >= FACTOR_CARGA * tabla.length) {
            redimensionar();
        }
        int indice = funcionHashing(unaClave);
        while (tabla[indice] != -1) {
            indice = (indice + 1) % tabla.length;  // Siguiente índice
        }
        tabla[indice] = unaClave;
        size++;
        return indice;
    }

    @Override
    public int funcionHashing(int unaClave) {
        return unaClave % tabla.length;
    }

    private void redimensionar() {
        int[] tablaAntigua = tabla;
        tabla = new int[2 * tablaAntigua.length];
        Arrays.fill(tabla, -1);
        size = 0;
        for (int clave : tablaAntigua) {
            if (clave != -1) {
                insertar(clave);
            }
        }
    }
}
