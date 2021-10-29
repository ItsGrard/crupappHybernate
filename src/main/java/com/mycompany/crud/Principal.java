
package com.mycompany.crud;

import java.util.Scanner;

/**
 *
 * @author Katsu
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Controller contr = new Controller();
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do{
            System.out.println("Elija accion a realizar: \n" + "Crear pedido: 1\n"
            + "Eliminar pedido: 2\n" + "Marcar pedido como recogido: 3 \n"
            +"Listar todas las comandas pendientes: 4\n"
            +"Listar la carta: 5\n"
            +"Salir: 6\n");
            opcion = sc.nextInt();
            switch (opcion){
            
                case 1: contr.createPedido();
                break;
                case 2: contr.eliminarPedido();
                break;
                case 3: contr.marcarPedido();
                break;
                case 4: System.out.println(contr.listarComandas());
                break;
                case 5: System.out.println(contr.listarCarta());
                break;
                case 6:
                break;
                default: opcion = 0; System.out.println("Seleccione una opcion.");
            }
        }while(opcion != 6);
    }
    
}
