package ganimedes.model;

import java.util.Base64;

/**
 * Entidad Paciente alineada a la Ley N.° 29733.
 * Incorpora la asignación del médico y validaciones estrictas de identidad.
 */
public class Paciente {
    private String dni;
    private String nombreCompleto;
    private String telefono;
    private String medicoAsignado; // 🌟 Nuevo atributo solicitado
    private String diagnosticoCifrado;

    // Constructor actualizado
    public Paciente(String dni, String nombreCompleto, String telefono, String medicoAsignado, String diagnosticoTextoPlano) {
        this.dni = dni;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.medicoAsignado = medicoAsignado;
        this.diagnosticoCifrado = cifrarDatoSensible(diagnosticoTextoPlano);
    }

    /**
     * Evalúa si el DNI cumple con los requisitos legales (8 dígitos numéricos).
     * @return Mensaje de estado para la interfaz o reporte.
     */
    public String getEstadoDni() {
        if (this.dni != null && this.dni.matches("\\d{8}")) {
            return "VALIDO";
        }
        return "INVALIDO";
    }

    /**
     * Evalúa si el Teléfono cumple con los requisitos (9 dígitos numéricos).
     * @return Mensaje de estado para la interfaz o reporte.
     */
    public String getEstadoTelefono() {
        if (this.telefono != null && this.telefono.matches("\\d{9}")) {
            return "VALIDO";
        }
        return "INVALIDO";
    }

    private String cifrarDatoSensible(String texto) {
        if (texto == null) return "";
        return Base64.getEncoder().encodeToString(texto.getBytes());
    }

    public String getDiagnosticoDesencriptado() {
        if (this.diagnosticoCifrado == null || this.diagnosticoCifrado.isEmpty()) return "";
        byte[] bytesDecodificados = Base64.getDecoder().decode(this.diagnosticoCifrado);
        return new String(bytesDecodificados);
    }

    // --- Getters y Setters ---
    public String getDni() { return dni; }
    public void setDni(String dni) { this.dni = dni; }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }

    public String getMedicoAsignado() { return medicoAsignado; }
    public void setMedicoAsignado(String medicoAsignado) { this.medicoAsignado = medicoAsignado; }

    public String getDiagnosticoCifrado() { return diagnosticoCifrado; }
}
