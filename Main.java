/**
 *  @author José Manuel Sanchez Hernández - 24092
 *  @version 1.0
 *  Descripción: Clase principal que implementa un sistema de atención de pacientes en una sala de emergencias.
 *  Fecha de creación: 09/04/2025
 *  Fecha de última modificación: 09/04/2025
 */

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Sistema de Atención de Pacientes\n");
        System.out.println("1. VectorHeap");
        System.out.println("2. JCFPriorityQueue");
        System.out.print("\nSeleccione el tipo de cola de prioridad: ");
        int tipo = scanner.nextInt();
        scanner.nextLine(); 
        IPriorityQueue<Paciente> cola = PQFactory.createPriorityQueue(tipo);

        try {
            cargarPacientes(cola);
        } catch (IOException e) {
            System.out.println("Error al cargar pacientes: " + e.getMessage());
        }

        String opcion = "";

        while (!opcion.equals("3")) {
            System.out.println("\n-----------MENÚ-----------\n");
            System.out.println("1. Atender paciente");
            System.out.println("2. Mostrar pacientes en espera");
            System.out.println("3. Salir");

            System.out.print("\nElige una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    atenderPacientes(cola);
                    break;
                case "2":
                    mostrarPacientes(cola);
                    break;
                case "3":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } 
        scanner.close();
    }

    /**
     * Carga los pacientes desde un archivo de texto y los añade a la cola de prioridad.
     * @param cola Cola de prioridad donde se añadirán los pacientes
     * @throws IOException Si ocurre un error al leer el archivo
     */
     private static void cargarPacientes(IPriorityQueue<Paciente> cola) throws IOException {
        int ordenLlegada = 1;
        BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"));
        String linea;
        
        while ((linea = br.readLine()) != null) {
            String[] datos = linea.split(",", 3);
            if (datos.length == 3) {
                String nombre = datos[0].trim();
                String sintoma = datos[1].trim();
                char codigo = datos[2].trim().charAt(0);
                
                Paciente paciente = new Paciente(nombre, sintoma, codigo, ordenLlegada++);
                cola.add(paciente);
            }
        }
        
        br.close();
    }

    /**
     * Método para atender al paciente con mayor prioridad en la cola.
     * @param cola Cola de prioridad donde se encuentran los pacientes
     */
    private static void atenderPacientes(IPriorityQueue<Paciente> cola) {
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en la cola.");
        } else {
            Paciente pacienteAtendido = cola.poll();
            System.out.println("Paciente atendido: " + pacienteAtendido);
        }
    }  
    
    /**
     * Método para mostrar los pacientes en espera en la cola.
     * @param cola Cola de prioridad donde se encuentran los pacientes
     */
    private static void mostrarPacientes(IPriorityQueue<Paciente> cola) {
        if (cola.isEmpty()) {
            System.out.println("No hay pacientes en la cola.");
            return;
        }
        
        System.out.println("\n--------- PACIENTES EN ESPERA ---------\n");
        
        java.util.ArrayList<Paciente> pacientesTemp = new java.util.ArrayList<>();
        
        int contador = 1;
        while (!cola.isEmpty()) {
            Paciente p = cola.poll();
            System.out.println(contador + ". " + p);
            pacientesTemp.add(p);
            contador++;
        }
        
        for (Paciente p : pacientesTemp) {
            cola.add(p);
        }
    }
}