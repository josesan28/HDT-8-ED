/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que implementa una cola de prioridad utilizando un vector. 
 *  Fecha de creación: 04/04/2025
 *  Fecha de última modificación: 09/04/2025
 *  Fuentes: implementación de la clase VectorHeap recopilada del libro Java Structures de Duane A. Bailey.
 */

import java.util.Vector;

public class VectorHeap<E extends Comparable<E>> implements IPriorityQueue<E> {
    protected Vector<E> data;

    /**
     * Constructor de la clase VectorHeap
     */
    public VectorHeap() {
        data = new Vector<E>();
    }

    /**
     * Constructor de la clase VectorHeap
     * @param v Vector de elementos a añadir al heap
     */
    public VectorHeap(Vector<E> v) {
        data = new Vector<E>(v.size());
        for (int i = 0; i < v.size(); i++) {
            add(v.get(i));
        }
    }

    /**
     * Método para obtener el padre de un nodo en el heap
     * @param i Índice del nodo
     * @return Índice del padre del nodo
     */
    protected static int parent(int i) {
        return (i - 1) / 2;
    }

    /**
     * Método para obtener el hijo izquierdo de un nodo en el heap
     * @param i Índice del nodo
     * @return Índice del hijo izquierdo del nodo
     */
    protected static int left(int i) {
        return 2 * i + 1;
    }

    /**
     * Método para obtener el hijo derecho de un nodo en el heap
     * @param i Índice del nodo
     * @return Índice del hijo derecho del nodo
     */
    protected static int right(int i) {
        return 2 * (i + 1);
    }

    /**
     * Método que intercambia la hoja con su padre si es menor su prioridad
     * @param leaf Índice del nodo a mover
     */
    protected void percolateUp(int leaf) {
        int parent = parent(leaf);
        E value = data.get(leaf);
        while (leaf > 0 && value.compareTo(data.get(parent)) < 0) {
            data.set(leaf, data.get(parent));
            leaf = parent;
            parent = parent(leaf);
        }
        data.set(leaf, value);
    }

    /**
     * Método para añadir un elemento al heap
     */
    @Override
    public void add(E value) {
        data.add(value);
        percolateUp(data.size() - 1);
    }

    /**
     * Método para mover un nodo hacia abajo en el heap
     * @param root Índice del nodo a mover
     */
    protected void pushDownRoot(int root) {
        int heapSize = data.size();
        E value = data.get(root);

        while (root < heapSize) {
            int childpos = left(root);

            if (childpos < heapSize) {
                if ((right(root) < heapSize) &&
                    (data.get(childpos + 1).compareTo(data.get(childpos)) < 0)) {
                    childpos++;
                }

                if (data.get(childpos).compareTo(value) < 0) {
                    data.set(root, data.get(childpos));
                    root = childpos;
                } 
                
                else {
                    data.set(root, value);
                    return;
                }
            } 
            
            else {
                data.set(root, value);
                return;
            }
        }
    }

    /**
     * Método para eliminar un elemento en el heap
     */
    @Override
    public E poll() {
        if (data.isEmpty()) {
            return null;
        }

        E minVal = getFirst();
        data.set(0, data.get(data.size() - 1));
        data.remove(data.size() - 1);

        if (data.size() > 1) {
            pushDownRoot(0);
        }

        return minVal;
    }

    /**
     * Método para obtener el primer elemento del heap
     * @return Primer elemento del heap
     */
    public E getFirst() {
        return data.get(0);
    }

    /**
     * Método para verificar si el heap está vacío
     * @return true si el heap está vacío, false en caso contrario
     */
    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Método para obtener el tamaño del heap
     * @return Tamaño del heap
     */
    public int size() {
        return data.size();
    }
}