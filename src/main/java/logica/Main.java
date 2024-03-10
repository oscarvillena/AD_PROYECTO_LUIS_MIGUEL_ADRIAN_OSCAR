/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logica;


import Pantallas.login.Login;
import javax.swing.ImageIcon;
import Tablas.*;
import java.util.ArrayList;
import java.sql.Date;
/**
 *
 * @author 2DAM
 */
public class Main {
    
    public static Tienda shop;
    static void compras(String nombreuser, String nombreProducto, int total) {
    	Compras compra = new Compras(shop.buscarUsuario(nombreuser));
        ArrayList <Factura>fac = new <Factura>ArrayList();
        fac.add(new Factura(compra, shop.buscarProducto(nombreProducto), total));
        shop.cerrarCompra(compra, fac);
    }
    
    public static void main(String[] args) {
        shop = new Tienda();
        if (shop.existeAdmin("admin", "1234") == false) {
        	shop.añadirUsuario("admin", "1234", "Admin@gmail.com","/IMG/granjero1.jpg", true);
        	shop.añadirUsuario("Oscar", "Oscar1234", "Oscar@gmail.com","/IMG/granjero2.jpg", false);
        	shop.añadirUsuario("Adrian", "Adrian1234", "Adrian@gmail.com","/IMG/granjero3.jpg", false);
        	shop.añadirUsuario("LuisMiguel", "LuisMiguel1234", "LuisMiguel@gmail.com","/IMG/granjero1.jpg", false);
        	shop.CrearProducto("JD 6230M", "Lo ultimo en tecnologia", 210000, "/IMG/6r.jpg");
        	shop.CrearProducto("JD 6195M", "Potente ta wapo", 150000, "/IMG/JD6195M.png");
        	shop.CrearProducto("JD 5893", "cosechadora", 250000, "/IMG/5893JD.jpg");
        	shop.CrearProducto("JD Viejito", "De la old school", 13000, "/IMG/JDantiguo.jpg");
        	shop.CrearProducto("JD 8RX", "Demasiado potente", 350000, "/IMG/Tpotente.jfif");
        	shop.CrearProducto("JD Gator", "Para ir rapido a sitios", 16550, "/IMG/gator.jpg");
        	compras("Oscar", "JD 6230M", 2);
        	compras("Oscar", "JD 5893", 8);
        	compras("Oscar", "JD 5893", 1);
        	compras("Adrian", "JD 6195M", 2);
        	compras("Adrian", "JD Viejito", 5);
        	compras("Adrian", "JD 8RX", 3);
        	compras("LuisMiguel", "JD 8RX", 3);
        	compras("LuisMiguel", "JD Viejito", 1);
        	compras("LuisMiguel", "JD 6230M", 10);
        	java.util.Date fechaBase = new java.util.Date();
        	java.sql.Date alta =  new java.sql.Date(fechaBase.getTime());
        	java.sql.Date baja = new Date(1, 1, 2028);
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("Oscar"), "Transporte");
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("Oscar"), "Alquiler");
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("Oscar"), "Reparacion");
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("Adrian"), "Transporte");
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("Adrian"), "Alquiler");
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("Adrian"), "Reparacion");
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("LuisMiguel"), "Transporte");
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("LuisMiguel"), "Alquiler");
        	shop.crearReserva(baja, alta,   shop.buscarUsuario("LuisMiguel"), "Reparacion");
        }
    
        
        
        
        if(null != shop.buscarUsuario(1)) {
        System.out.println(shop.buscarUsuario(1).getCorreo());
        }
        
        if(shop.buscarUsuario("Admin", "1234") != null) {
        	System.out.println("recuperado admin");
        }else {
        	System.out.println("no se ha recuperado");
        }
        
        Login log = new Login();
        log.setVisible(true);
        shop.modificarProducto(1, "Tractor amarillo", "Tractor", 160000f, "/IMG/6r.jpg");
    }

    
    
}
