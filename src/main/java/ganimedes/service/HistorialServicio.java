package ganimedes.service;

import ganimedes.model.Paciente;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class HistorialServicio {
    
    private final List<Paciente> listaPacientes;

    public HistorialServicio() {
        this.listaPacientes = new ArrayList<>();
        
        // Inyección de datos simulando registros con DNI correctos, incorrectos y Médicos asignados
        listaPacientes.add(new Paciente("71234567", "Carlos Mendoza", "987654321", "Dr. Luis Peralta (Medicina General)", "Diabetes Tipo 2"));
        listaPacientes.add(new Paciente("45678912", "Ana Delgado", "9554433", "Dra. Maria Espinoza (Pediatría)", "Hipertensión Arterial")); // Teléfono corto (Inválido)
        listaPacientes.add(new Paciente("12345", "Juan Pérez", "911223344", "Dr. Carlos Torres (Gastroenterología)", "Gastritis Crónica")); // DNI corto (Inválido)
    }

    public List<Paciente> buscarPacientes(Predicate<Paciente> filtro) {
        return this.listaPacientes.stream().filter(filtro).toList();
    }

    public Paciente obtenerPacientePorDni(String dni) throws Exception {
        if (dni == null || dni.trim().isEmpty()) {
            throw new IllegalArgumentException("Error técnico: El DNI proporcionado no puede estar vacío.");
        }
        Optional<Paciente> resultado = this.listaPacientes.stream()
                                                          .filter(p -> p.getDni().equals(dni))
                                                          .findFirst();
        return resultado.orElseThrow(() -> new Exception("Control de Error: El paciente con DNI " + dni + " no está registrado."));
    }
}
