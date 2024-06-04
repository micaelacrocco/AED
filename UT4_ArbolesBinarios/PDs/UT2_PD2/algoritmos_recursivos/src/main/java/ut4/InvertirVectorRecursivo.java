package ut4;

public class InvertirVectorRecursivo {
    public static void invertirVector(int[] vector, int inicio, int fin) {
        if (inicio >= fin)
            return;
        
        int temp = vector[inicio];
        vector[inicio] = vector[fin];
        vector[fin] = temp;

        invertirVector(vector, inicio + 1, fin - 1);
    }
}
