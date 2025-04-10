/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Interfaz que define los métodos básicos de una cola de prioridad.
 *  Fecha de creación: 04/04/2025
 *  Fecha de última modificación: 09/04/2025
 */

public interface IPriorityQueue<E extends Comparable<E>> {
    void add(E element);
    E poll();
    boolean isEmpty();
}