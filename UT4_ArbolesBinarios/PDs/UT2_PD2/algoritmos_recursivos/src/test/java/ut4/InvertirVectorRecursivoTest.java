package ut4;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class InvertirVectorRecursivoTest {
    @Test
    public void testInvertirVector() {
        int[] vector1 = {1, 2, 3, 4, 5};
        int[] vector2 = {};
        int[] vector3 = {1};
        int[] vector4 = {1, 2, 3};
        int[] expectedVector1 = {5, 4, 3, 2, 1};
        int[] expectedVector4 = {3, 2, 1};

        InvertirVectorRecursivo.invertirVector(vector1, 0, 4);
        InvertirVectorRecursivo.invertirVector(vector2, 0, 0);
        InvertirVectorRecursivo.invertirVector(vector3, 0, 0);
        InvertirVectorRecursivo.invertirVector(vector4, 0, 2);

        assertArrayEquals(expectedVector1, vector1);
        assertArrayEquals(new int[] {}, vector2);
        assertArrayEquals(new int[] {1}, vector3);
        assertArrayEquals(expectedVector4, vector4);
    }
}
