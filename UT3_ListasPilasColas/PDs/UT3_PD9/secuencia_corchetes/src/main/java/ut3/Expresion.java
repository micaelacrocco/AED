package ut3;

import java.util.List;

public class Expresion {

    public boolean controlCorchetes(List<String> listaDeEntrada) {
        Stack<Character> stack = new Stack<>();
    
        for (String linea : listaDeEntrada) {
            // Recorrer cada caracter de la línea
            for (int i = 0; i < linea.length(); i++) {
                char caracter = linea.charAt(i);
                // Utiliza el caracter
                if (caracter == '{') {
                    stack.push('{');
                }
                if (caracter == '}') {
                    if (stack.isEmpty()) {
                        return false;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
