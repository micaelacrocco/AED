package ut1;

import javax.swing.JOptionPane;

class BuclesAnidados {
    public static void main(String[] args) {
        
        int largo, ancho;

        largo = Integer.parseInt(JOptionPane.showInputDialog("Digite el largo: "));
        ancho = Integer.parseInt(JOptionPane.showInputDialog("Digite el ancho: "));

        for (int i = 0; i < largo; i++) {
            for (int j = 0; j < ancho; j++ ) {
                System.out.print("x ");
            }
            System.out.println();
        }
    }
}