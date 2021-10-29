
package com.mycompany.crud;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.sql.Statement.RETURN_GENERATED_KEYS;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Pedido;
import models.Producto;

/**
 *
 * @author Katsu
 */
public class Controller implements Serializable {
    
    private static Connection con;

    static {
        String url = "jdbc:mysql://localhost:3306/crud?zeroDateTimeBehavior=CONVERT_TO_NULL";
        String user = "root";
        String password = "";
        try {
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión establecida con la base de datos");
        } catch (SQLException ex) {
            Logger.getLogger(Pedido.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static final String LIST_PRODUCTS = "SELECT * FROM productos";
    static final String CREATE_PEDIDO = "INSERT INTO pedidos(alumno,ciclo,estado, producto_id) VALUES (?,?,?,?)";
    static final String DELETE_PEDIDO = "DELETE FROM pedidos WHERE id=?";
    static final String LIST_COMANDAS = "SELECT * FROM pedidos WHERE estado='pendiente'";
    static final String MARCAR_PEDIDO = "UPDATE pedidos SET estado = 'Recogido' WHERE id=?";
    

    public void createPedido(){
            String nombre;
            String ciclo;
            String estado;
            Scanner sc = new Scanner(System.in);
            System.out.println("Inserte su nombre: ");
            nombre = sc.next();
            System.out.println("Inserte su ciclo: ");
            ciclo = sc.next();
            System.out.println("Inserte el estado: ");
            estado = sc.next();
            System.out.println("Inserte el id del producto: ");
            int idProd = sc.nextInt();

            try ( PreparedStatement ps = con.prepareStatement(CREATE_PEDIDO, RETURN_GENERATED_KEYS)) {
                ps.setString(1, nombre);
                ps.setString(2, ciclo);
                ps.setString(3, estado);
                ps.setInt(4, idProd);
                ps.executeUpdate();

        }   catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
        
    public int eliminarPedido(){
        int pedido;
        int res = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el id del pedido a eliminar: ");
        pedido = sc.nextInt();
        
        try ( PreparedStatement ps = con.prepareStatement(DELETE_PEDIDO)) {
            ps.setInt(1, pedido);
            res = ps.executeUpdate();
        }   catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    return res;
    }
    
    public void marcarPedido(){
        int nPedido;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Inserte el id del pedido recogido: ");
        nPedido = sc.nextInt();
        
        try ( PreparedStatement ps = con.prepareStatement(MARCAR_PEDIDO)) {
            ps.setInt(1, nPedido);
            ps.executeUpdate();
        }   catch (SQLException ex) {
                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public ArrayList<Pedido> listarComandas(){
        var salida = new ArrayList<Pedido>();

        try ( Statement st = con.createStatement()) {

            ResultSet resultado = st.executeQuery(LIST_COMANDAS);

            while (resultado.next()) {
                Pedido p = new Pedido();
                p.setAlumno(resultado.getString("alumno"));
                p.setCiclo(resultado.getString("ciclo"));
                p.setEstado(resultado.getString("estado"));
                p.setId(resultado.getInt("id"));
                p.setProdId(resultado.getInt("producto_id"));
                p.setFecha(resultado.getString("fecha"));


                salida.add(p);
            }
            } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
    
    public ArrayList<Producto> listarCarta() {

        var salida = new ArrayList<Producto>();

        try ( Statement st = con.createStatement()) {

            ResultSet resultado = st.executeQuery(LIST_PRODUCTS);

            while (resultado.next()) {
                Producto pr = new Producto();
                pr.setId(resultado.getInt("id"));
                pr.setProducto(resultado.getString("producto"));
                pr.setDisponible(resultado.getShort("disponible"));
                pr.setPrecio(resultado.getFloat("precio"));
                pr.setTipo(resultado.getString("tipo"));

                salida.add(pr);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
        return salida;
    }
}
   
    



