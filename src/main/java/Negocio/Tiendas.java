/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Dao.ClienteJpaController;
import Dao.Conexion;
import Dao.ServicioJpaController;
import Dao.TiendaJpaController;
import Dto.Cliente;
import Dto.Servicio;
import Dto.Tienda;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pc-Victor
 */
public class Tiendas {

    private Conexion con;

    public Tiendas() {
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
    
    public boolean registrarServicios(Servicio s) {

        ServicioJpaController sjc= new ServicioJpaController(con.getBd());
         for (Servicio se :this.getServicios()) {
            if(se.getNombre().equals(s.getNombre())){
               return false;
            }
        }
        sjc.create(s);
        return true;
    }
    
    //metodo get Servicios
    public List<Servicio> getServicios() {
         ServicioJpaController sjc= new ServicioJpaController(con.getBd());
         List<Servicio> listS=sjc.findServicioEntities();
         if(listS !=null){
             return listS;
         }
         return null;
    }
      
   
  
    public boolean registrarTienda(Tienda t) {

       TiendaJpaController tjc = new TiendaJpaController(con.getBd());
         for(Tienda ti:this.getTiendas()){
             if(ti.getEmail().equals(t.getEmail()) && ti.getNombre().equals(t.getNombre())){
                 return false;
             }
         }
        tjc.create(t);
        return true;
    }
    
     public List<Tienda> getTiendas(){
        TiendaJpaController tjc=new TiendaJpaController(con.getBd());
        List<Tienda> listT = tjc.findTiendaEntities();
         if (listT != null) {
            return listT;
        }
        return null;
    }
  
    
  
  
    public boolean login(Cliente c){
        
        List<Cliente> listC=this.getClientes();
        for(Cliente cliente:listC){
            if(cliente.getEmail().equals(c.getEmail())&&cliente.getClass().equals(c.getClave())){
                return true;
            }
        }
        return false;
    }
    
     public boolean loginTienda(Tienda t){
        List<Tienda> listT=this.getTiendas();
        for(Tienda tienda:listT){
            if(tienda.getEmail().equals(t.getEmail())&&tienda.getClass().equals(t.getClave())){
                return true;
            }
        }
        return false;
    }
     
      public void Seguir(Tienda t,Cliente c){
          List<Cliente> lc=this.getClientes();
          for(Cliente cli : lc){
              if(cli.getEmail().equals(c.getEmail())){
                  List<Tienda> ltc=cli.getTiendaList();
                  ltc.add(t);
              }
          }
      }
      public void updateCliente(Cliente c){
          ClienteJpaController cjc = new ClienteJpaController(con.getBd());
        try {
            cjc.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(Tiendas.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
      public Cliente FindCliente(String email,String clave){
          List<Cliente> lc=this.getClientes();
          for(Cliente c:lc){
              if(c.getEmail().equals(email) && c.getClave().equals(clave)){
                  return c;
              }
          }
          return null;
      }
       public Tienda FindTienda(String email,String clave){
          List<Tienda> lt=this.getTiendas();
          for(Tienda t:lt){
              if(t.getEmail().equals(email) && t.getClave().equals(clave)){
                  return t;
              }
          }
          return null;
      }

}
