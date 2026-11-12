package persistenciaproducto;

/**
 *
 * @author maryse
 *
 * 1. El Modelo de Dominio (POO Puro)
 * Primero, definimos una clase que encapsula
 * el estado y el comportamiento de una entidad de negocio, protegiendo sus
 * atributos mediante modificadores de acceso (private) y exponiendo métodos de
 * acceso controlados (getters y setters).
 */

public class Producto {

    private int id;
    private String nombre;
    private double precio;
    private int stock;

    // Constructor completo
    public Producto(int id, String nombre, double precio, int stock) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    // Constructor vacío para mapeos
    public Producto() {
    }

    // Encapsulamiento (Getters y Setters)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 0) {
            this.precio = precio;
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }

    @Override
    public String toString() {
        return String.format("Producto [ID=%d, Nombre=%s, Precio=%.2f, Stock=%d]", id, nombre, precio, stock);
    }
}
