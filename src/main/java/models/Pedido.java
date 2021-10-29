
package models;

/**
 *
 * @author Katsu
 */
public class Pedido{
    int id;
    String alumno;
    String ciclo;
    String fecha;
    String estado;
    int prodId;
   // DATABASE HANDLER Long hora;

    public Pedido() {
    }

    public Pedido(int id, String alumno, String ciclo, String estado, int prodId) {
        this.id = id;
        this.alumno = alumno;
        this.ciclo = ciclo;
        this.estado = estado;
        this.prodId = prodId;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlumno() {
        return alumno;
    }

    public void setAlumno(String alumno) {
        this.alumno = alumno;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    @Override
    public String toString() {
        return "Pedido{" + "id=" + id + ", alumno=" + alumno + ", ciclo=" + ciclo + ", fecha=" + fecha + ", estado=" + estado + ", prodId=" + prodId + '}'+ "\n";
    }


    
}
