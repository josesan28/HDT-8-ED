/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase que implementa el patrón de diseño Factory para crear colas de prioridad.
 *  Fecha de creación: 09/04/2025
 *  Fecha de última modificación: 09/04/2025
 */

public class PQFactory {
    /**
     * Método para crear una cola de prioridad
     * @param tipo Tipo de cola de prioridad a crear
     * @return Cola de prioridad creada
     */
    public static IPriorityQueue<Paciente> createPriorityQueue(int tipo) {
        if (tipo == 1) {
            return new VectorHeap<>();
        } 
        
        else if (tipo == 2) {
            return new JCFPriorityQueue<>();
        } 
        
        else {
            throw new IllegalArgumentException("Tipo de cola de prioridad no válido");
        }
    }
    
}
