package persistenciaproducto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author maryse 
 * 4. Uso de la Capa de Persistencia (Clase Principal)
 * Finalmente, la capa de aplicación interactúa exclusivamente con las
 * abstracciones y objetos de dominio, ignorando los detalles de cómo se
 * ejecutan las sentencias SQL.
 */

public class Main {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/tienda_db";
        String user = "root";
        String password = "12345";

        // Establecer conexión y usar el DAO mediante polimorfismo
        try (Connection conexion = DriverManager.getConnection(url, user, password)) {

            ProductoDAO productoDAO = new ProductoDAOImpl(conexion);

            // 1. Crear y persistir un nuevo objeto
            Producto nuevoProducto = new Producto(0, "Laptop Enterprise", 1250.00, 10);
            productoDAO.insertar(nuevoProducto);
            System.out.println("Producto guardado exitosamente.");

            // 2. Consultar y listar objetos persistidos
            System.out.println("\nListado de productos en el sistema:");
            productoDAO.listarTodos().forEach(System.out::println);

            // 3. Buscar por ID y modificar estado del objeto
            productoDAO.buscarPorId(1).ifPresent(prod -> {
                prod.setStock(prod.getStock() - 1);
                productoDAO.actualizar(prod);
                System.out.println("\nProducto actualizado: " + prod);
            });

        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
        }
    }
}
