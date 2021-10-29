
package models;

/**
 *
 * @author Katsu
 */
public class Producto {
    
    private int id;
    private String producto;
    private short disponible;
    private float precio;
    private String tipo;

    public Producto() {
    }

    public Producto(int id, String producto, short disponible, float precio, String tipo) {
        this.id = id;
        this.producto = producto;
        this.disponible = disponible;
        this.precio = precio;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public short getDisponible() {
        return disponible;
    }

    public void setDisponible(short disponible) {
        this.disponible = disponible;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", producto=" + producto + ", disponible=" + disponible + ", precio=" + precio + ", tipo=" + tipo + '}' + "\n";
    }
    
    
}
