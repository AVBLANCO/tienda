/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author estudiante
 */
public class Conexion {
    
    private static Conexion conexion;
    private EntityManagerFactory bd; 

    private  Conexion() {
        //se coloca la conexion.. de la persistencia.
        this.bd=Persistence.createEntityManagerFactory("com.ufps_tienda-1151331_war_1.0-SNAPSHOTPU");
        
    }
    
    
    public static Conexion getConexion()
    {
        if(conexion==null)
        {
            conexion=new Conexion();
        }
    return conexion;
    }

    public EntityManagerFactory getBd() {
        return bd;
    }
    
    
    
    
}
