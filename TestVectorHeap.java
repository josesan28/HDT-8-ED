/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Pruebas unitarias para la clase VectorHeap.
 *  Fecha de creación: 09/04/2025
 *  Fecha de última modificación: 09/04/2025
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestVectorHeap {

    private VectorHeap<Integer> heap;

    @Before
    public void setUp() {
        heap = new VectorHeap<>();
    }

    @Test
    public void testAdd() {
        heap.add(5);
        heap.add(3);
        heap.add(1);

        assertEquals(3, heap.size());
        assertEquals(1, heap.getFirst().intValue());
        assertEquals(1, heap.poll().intValue());
        assertEquals(3, heap.getFirst().intValue());
        assertEquals(3, heap.poll().intValue());
        assertEquals(5, heap.getFirst().intValue());
        assertEquals(5, heap.poll().intValue());
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testAddDuplicateValues() {
        heap.add(5);
        heap.add(5);
        heap.add(3);

        assertEquals(3, heap.getFirst().intValue());
        heap.poll();
        assertEquals(5, heap.getFirst().intValue());
        heap.poll();
        assertEquals(5, heap.getFirst().intValue());
        heap.poll();
        assertTrue(heap.isEmpty());
    }

    @Test
    public void testPoll() {
        heap.add(5);
        heap.add(3);
        heap.add(1);

        assertEquals(3, heap.size());
        assertEquals(1, heap.poll().intValue());
        assertEquals(2, heap.size());
        assertEquals(3, heap.poll().intValue());
        assertEquals(1, heap.size());
        assertEquals(5, heap.poll().intValue());
        assertEquals(0, heap.size());
        assertNull(heap.poll());
        assertTrue(heap.isEmpty());
    }
    
    @Test
    public void testPollEmptyHeap() {
        assertNull(heap.poll());
        assertTrue(heap.isEmpty());
    }
}