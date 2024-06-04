public class InterpolationSearch {
    public static int interpolationSearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high && key >= array[low] && key <= array[high]) {
            // Calculamos la posición probable del elemento usando interpolación
            int pos = low + ((key - array[low]) * (high - low)) / (array[high] - array[low]);

            // Si la posición calculada es igual al elemento buscado, devolvemos la posición
            if (array[pos] == key) {
                return pos;
            }

            // Si el elemento buscado es menor que el elemento en la posición calculada, buscamos en la mitad izquierda
            if (array[pos] > key) {
                high = pos - 1;
            } else { // Si el elemento buscado es mayor que el elemento en la posición calculada, buscamos en la mitad derecha
                low = pos + 1;
            }
        }

        return -1; // Si no se encuentra el elemento, devolvemos -1
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int key = 11; // Elemento que no está presente en el array

        int index = interpolationSearch(array, key);
        if (index != -1) {
            System.out.println("El elemento " + key + " se encuentra en la posición " + index + " del array.");
        } else {
            System.out.println("El elemento " + key + " no se encuentra en el array.");
        }
    }
}
