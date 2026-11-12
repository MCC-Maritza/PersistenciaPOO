package persistenciaproducto;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author maryse
 *
 * 2. El Contrato de Persistencia (Patrón DAO).
 * Para desacoplar la lógica de
 * negocio de la tecnología de almacenamiento (ya sea MySQL, archivos planos,
 * MongoDB, etc.), definimos una interfaz genérica que establece las operaciones
 * CRUD (Create, Read, Update, Delete).
 *
 */
public interface GenericDAO<T, ID> {

    void insertar(T entidad);

    Optional<T> buscarPorId(ID id);

    List<T> listarTodos();

    void actualizar(T entidad);

    void eliminar(ID id);
}
