/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase Paciente que representa a un paciente en una sala de emergencias.
 *  Fecha de creación: 04/04/2025
 *  Fecha de última modificación: 09/04/2025
 */

public class Paciente implements Comparable<Paciente> {
    private String nombre;
    private String descripcionSintoma;
    private char codigo;
    private int ordenLlegada;

    /**
     * Constructor de la clase Paciente
     * @param nombre Nombre del paciente
     * @param descripcionSintoma Descripción del síntoma
     * @param codigo Código de prioridad
     * @param ordenLlegada Orden de llegada del paciente
     */
    public Paciente(String nombre, String descripcionSintoma, char codigo, int ordenLlegada) {
        this.nombre = nombre;
        this.descripcionSintoma = descripcionSintoma;
        this.codigo = codigo;
        this.ordenLlegada = ordenLlegada;
    }
    
    /**
     * Método para obtener el código de prioridad del paciente
     * @return Código de prioridad del paciente
     */
    public char getCodigo() {
        return codigo;
    }


    /**
     * Método para comparar y determinar el orden de prioridad entre dos pacientes
     */
    @Override
    public int compareTo(Paciente otro) {
        if (this.codigo != otro.codigo) {
            return Character.compare(this.codigo, otro.codigo);
        }
        return Integer.compare(this.ordenLlegada, otro.ordenLlegada);
    }

    /**
     * Método para obtener el paciente como un String
     */
    @Override
    public String toString() {
        return nombre + " - " + descripcionSintoma + " - " + codigo;
    }
}