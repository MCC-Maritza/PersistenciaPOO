package persistenciaproducto;

import java.util.List;

/**
 *
 * @author maryse Específicamente para la entidad Producto, extendemos o
 * implementamos este comportamiento:
 *
 */
public interface ProductoDAO extends GenericDAO<Producto, Integer> {

    // Métodos de negocio específicos si se requieren
    List<Producto> buscarPorRangoPrecio(double min, double max);
}
