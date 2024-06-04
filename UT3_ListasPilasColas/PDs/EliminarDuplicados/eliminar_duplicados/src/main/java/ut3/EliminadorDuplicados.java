package ut3;

import java.util.HashSet;

public class EliminadorDuplicados {
    public void eliminarDuplicados(Node head) {
        HashSet<Integer> foundValues = new HashSet<Integer>();
        foundValues.add(head.value);
        Node current = head;
    
        while (current != null && current.next != null) {
          if (!foundValues.add(current.next.value)) {
            // Si se encuentra el nodo se elimina
            current.next = current.next.next;
          }
    
          // Seguimos iterando en la lista
          current = current.next;
        }
    }
}
