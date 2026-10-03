package ganimedes.config;

/**
 * Clase que gestiona la conexión a la Base de Datos del Centro de Salud Ganimedes.
 * Implementa el Patrón de Diseño Singleton exigido por la universidad.
 */
public class ConexionBD {
    
    // 1. Instancia estática única y privada de la propia clase
    private static ConexionBD instancia;
    
    // Atributo simulado de la cadena de conexión
    private final String urlConexion;

    // 2. Constructor PRIVADO: Evita que se creen instancias con "new" fuera de esta clase
    private ConexionBD() {
        this.urlConexion = "jdbc:mysql://localhost:3306/ganimedes_db";
        System.out.println("[Singleton] -> Instancia única creada. Conexión establecida con la BD de Ganimedes.");
    }

    // 3. Método público global para acceder a la única instancia activa
    public static synchronized ConexionBD getInstancia() {
        if (instancia == null) {
            instancia = new ConexionBD(); // Se crea solo la primera vez
        }
        return instancia;
    }

    // Método para obtener la URL de conexión
    public String getUrlConexion() {
        return this.urlConexion;
    }
}