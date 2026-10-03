package ganimedes.controller;

import ganimedes.model.Paciente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "AdmisionServlet", urlPatterns = {"/AdmisionServlet"})
public class AdmisionServlet extends HttpServlet {

        @Override
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response)
            throws javax.servlet.ServletException, IOException {

        
        // 1. Recibir datos del formulario web
        String dni = request.getParameter("txtDni");
        String nombre = request.getParameter("txtNombre");
        String telefono = request.getParameter("txtTelefono");
        String medico = request.getParameter("txtMedico");

        // 2. Instanciar la lógica de validación que ya programaste
        Paciente paciente = new Paciente(dni, nombre, telefono, medico, "Diagnóstico preliminar");
        String estadoDni = paciente.getEstadoDni();
        String estadoTelefono = paciente.getEstadoTelefono();

        // 3. Renderizar la respuesta HTML interactiva
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head><title>Resultado de Admisión</title>");
            out.println("<link href='https://jsdelivr.net' rel='stylesheet'></head>");
            out.println("<body class='bg-light'><div class='container mt-5' style='max-width: 600px;'>");
            out.println("<div class='card shadow'>");
            
            if (estadoDni.equals("VALIDO") && estadoTelefono.equals("VALIDO")) {
                out.println("<div class='card-header bg-success text-white text-center'><h4>¡PROCESO VÁLIDO!</h4></div>");
            } else {
                out.println("<div class='card-header bg-danger text-white text-center'><h4>¡PROCESO INVÁLIDO!</h4></div>");
            }
            
            out.println("<div class='card-body'>");
            out.println("<p><strong>Paciente:</strong> " + paciente.getNombreCompleto() + "</p>");
            out.println("<p><strong>Médico Asignado:</strong> " + paciente.getMedicoAsignado() + "</p>");
            out.println("<p><strong>Evaluación DNI (" + dni + "):</strong> <span class='badge " + (estadoDni.equals("VALIDO")?"bg-success":"bg-danger") + "'>" + estadoDni + "</span></p>");
            out.println("<p><strong>Evaluación Teléfono (" + telefono + "):</strong> <span class='badge " + (estadoTelefono.equals("VALIDO")?"bg-success":"bg-danger") + "'>" + estadoTelefono + "</span></p>");
            out.println("<hr><a href='index.jsp' class='btn btn-secondary w-100'>Volver al Formulario</a>");
            out.println("</div></div></div></body></html>");
        }
    }
}
