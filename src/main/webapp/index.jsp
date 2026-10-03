<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Centro de Salud Ganímedes - Admisión</title>
    <link href="https://jsdelivr.net" rel="stylesheet">
</head>
<body class="bg-light">
    <div class="container mt-5" style="max-width: 600px;">
        <div class="card shadow">
            <div class="card-header bg-primary text-white text-center">
                <h4>SISTEMA WEB - CENTRO DE SALUD GANÍMEDES</h4>
                <small>Módulo de Admisión y Registro de Pacientes</small>
            </div>
            <div class="card-body">
                
                <form action="AdmisionServlet" method="POST">
                    <div class="mb-3">
                        <label class="form-label">DNI (8 dígitos):</label>
                        <input type="text" name="txtDni" class="form-control" required placeholder="Ej. 71234567">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Nombre Completo:</label>
                        <input type="text" name="txtNombre" class="form-control" required placeholder="Ej. Carlos Mendoza">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Teléfono Celular (9 dígitos):</label>
                        <input type="text" name="txtTelefono" class="form-control" required placeholder="Ej. 987654321">
                    </div>
                    <div class="mb-3">
                        <label class="form-label">Médico Asignado:</label>
                        <select name="txtMedico" class="form-select">
                            <option>Dr. Luis Peralta (Medicina General)</option>
                            <option>Dra. Maria Espinoza (Pediatría)</option>
                            <option>Dr. Carlos Torres (Gastroenterología)</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary w-100">Evaluar y Registrar</button>
                </form>

            </div>
        </div>
    </div>
</body>
</html>
