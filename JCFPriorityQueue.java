/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que implementa una cola de prioridad utilizando la clase PriorityQueue de Java.
 *  Fecha de creación: 09/04/2025
 *  Fecha de última modificación: 09/04/2025
 */

import java.util.PriorityQueue;

public class JCFPriorityQueue<E extends Comparable<E>> implements IPriorityQueue<E> {
    private PriorityQueue<E> queue;

    /**
     * Constructor de la clase JCFPriorityQueue
     */
    public JCFPriorityQueue() {
        queue = new PriorityQueue<>();
    }

    /**
     * Método que añade un elemento a la cola de prioridad
     * @param element Elemento a añadir
     */
    @Override
    public void add(E element) {
        queue.add(element);
    }

    /**
     * Método que obtiene y elimina el elemento con mayor prioridad de la cola
     * @return Elemento con mayor prioridad
     */
    @Override
    public E poll() {
        return queue.poll();
    }

    /**
     * Método que verifica si la cola de prioridad está vacía
     * @return true si está vacía, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}