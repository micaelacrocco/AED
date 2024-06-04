package ut3;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class EliminadorDuplicadosTest 
{
    @Test
    public void removeDupsTest() {
      EliminadorDuplicados eliminadorDuplicados = new EliminadorDuplicados();
      Node head = new Node(1);
      head.next = new Node(2);
      head.next.next = new Node(2);
      head.next.next.next = new Node(3);
      head.next.next.next.next = new Node(4);
      head.next.next.next.next.next = new Node(1);
  
      eliminadorDuplicados.eliminarDuplicados(head);
  
      assertEquals(1, head.value);
      assertEquals(2, head.next.value);
      assertEquals(3, head.next.next.value);
      assertEquals(4, head.next.next.next.value);
      assertEquals(null, head.next.next.next.next);
    }
}
