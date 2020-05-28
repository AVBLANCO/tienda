package Dto;

import Dto.Cliente;
import Dto.Servicio;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-05-28T09:21:51")
@StaticMetamodel(Tienda.class)
public class Tienda_ { 

    public static volatile SingularAttribute<Tienda, String> descripcion;
    public static volatile ListAttribute<Tienda, Cliente> clienteList;
    public static volatile SingularAttribute<Tienda, String> clave;
    public static volatile SingularAttribute<Tienda, String> web;
    public static volatile SingularAttribute<Tienda, String> propietario;
    public static volatile SingularAttribute<Tienda, String> facebook;
    public static volatile SingularAttribute<Tienda, String> imagen;
    public static volatile SingularAttribute<Tienda, Integer> id;
    public static volatile ListAttribute<Tienda, Servicio> servicioList;
    public static volatile SingularAttribute<Tienda, String> nombre;
    public static volatile SingularAttribute<Tienda, String> email;
    public static volatile SingularAttribute<Tienda, String> lema;

}