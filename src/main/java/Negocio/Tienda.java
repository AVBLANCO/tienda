/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.ClienteJpaController;
import Dao.Conexion;
import Dto.Cliente;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc-Victor
 */
public class Tienda {

    private Conexion con;

    public Tienda() {
        con = Conexion.getConexion();
    }

    public boolean registrarCliente(Cliente c) {
        //crear una conexion por metodo
        ClienteJpaController cjc = new ClienteJpaController(con.getBd());
        List<Cliente> listC=this.getClientes();
        for(Cliente cl:listC){
            if(cl.getEmail().equals(c.getEmail())){
                return false;
            }
        }
        try {
            cjc.create(c);
        } catch (Exception e) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE,null,e);
        }
        return true;

    }

    //buscar lista de estudiantes
    public List<Cliente> getClientes() {
        ClienteJpaController cjc = new ClienteJpaController(con.getBd());
        return cjc.findClienteEntities();

    }

}
