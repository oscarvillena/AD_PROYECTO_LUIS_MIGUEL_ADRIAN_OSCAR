package logica;
import Tablas.*;
//import Objects.*;
import Pantallas.Principal.PantallaPrincipal;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Date;
import javax.swing.ImageIcon;
import logica.*;
import jakarta.persistence.NoResultException;
import jakarta.persistence.Query;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;


/**
 *
 * @author 2DAM
 */
public class Tienda {
    
    private static Session session;
	
    private  ArrayList<Usuario> users;
    private  ArrayList<Reserva> reservas;
    private ArrayList<Producto> productos;
    
    
    public Tienda(){
        users = new ArrayList<>();
        reservas = new ArrayList<>();
        productos = new ArrayList<>();
       //crearProductos();
       //crearReservas();
    }
    public boolean existeAdmin(String nombre, String contraseña) {
    	if(buscarUsuario(nombre,contraseña) == null) {
    		return false;
    	}
    	return true;
    }
    public ArrayList<Usuario> devolverUsers(){
        return this.users;
    }
    
    public boolean añadirUsuario(String nombre, String contraseña, String correo, String img, boolean admin) {
    	if (buscarUsuario(nombre) == null) {
            Usuario user = new Usuario(nombre, contraseña, correo, img, admin);
            UsuarioDao uDao = new UsuarioDao();
            return uDao.createRecord(user);
        }
    	return false;
    }
    
    public void cambiarImagenUser(Usuario user, String img) {
    	user.setFoto(img);
    	new UsuarioDao().updateRecord(user, user.getIdUse());
    }
    public static String guardarEnIMG(String rutaArchivo, String nombreDestino) {
    	//rutaArchivo.replace("\\","\\\\");
        Path origen = Paths.get(rutaArchivo);
        Path destino = Paths.get("src/main/java/IMG/", nombreDestino + ".png");

        try {
            File archivoOrigen = new File(rutaArchivo);
            File archivoDestino = new File(destino.toString());

            Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado exitosamente a: " + archivoDestino.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error al copiar el archivo: " + e.getMessage());
        }
        return "/IMG/"+ nombreDestino + ".png";
    }
    
    /////////////////////////////
    public  Usuario buscarUsuario(int id){
        Usuario aux = new UsuarioDao().readRecord(id);
        return aux;
    }
    ////////////
    
    public  Usuario buscarUsuario(String nombre){
        Usuario aux = new UsuarioDao().readRecord(nombre);
        return aux;
    }
    //////////////
    public  Usuario buscarUsuario(String nombre, String contraseña){
        Usuario aux = new UsuarioDao().readRecord(nombre, contraseña);
        return aux;
    }
    public void modificarProducto(int id, String nombre, String des, float precio, String img){
        new ProductoDao().updateRecord(new Producto(nombre, des, precio, img), id);
    }
    public List<Producto> devolverTodosProductos(){
        List <Producto> lista = new ProductoDao().readRecords();
        return lista;
    }
    
    ////////////////////////
    public List<Compras> devolveCompraPorUsuario(int id){
    	Usuario u = new UsuarioDao().readRecord(id);
    	return new ComprasDAO().readRecordsUser(u);
    } 



    public void cerrarCompra(Compras c, ArrayList <Factura>f) {
    	ComprasDAO dcom = new ComprasDAO();
    	dcom.createRecord(c);
    	for(Factura fac : f) {
			new FacturaDAO().createRecord(fac);
		}
    }
    public void crearReserva( Date fechaBaja, Date fechaAlta, Usuario usuario, String tipo){
        Reserva res = new Reserva(usuario, fechaAlta, fechaBaja, tipo);
        ReservaDao dres = new ReservaDao();
        dres.createRecord(res);
    }
    
    public List<Reserva> devolverReservas(Usuario idUse){
       ReservaDao reservasUsuario = new ReservaDao();
       return reservasUsuario.readRecord(idUse);
    }
    public void modificarReserva(int i,  Date fechaBaja, String tipo){
        ReservaDao dres = new ReservaDao();
        dres.updateRecord(i, fechaBaja, tipo);
    }
    
    public Reserva darReserva(int i){
        Reserva modi = new ReservaDao().readRecord(i);
        return modi;
    }
    
    public void eliminarReserva(int i){
        ReservaDao el= new ReservaDao();
        el.deleteRecord(i);
    }


    public List<Producto> listaProductos(){
    	return new ProductoDao().readRecords();
    }
    public void CrearProducto(String nombre, String descripcion, float precio, String imagen) {
    	if (buscarProducto(nombre) == null) {
    		Producto nuevo = new Producto(nombre, descripcion, precio, imagen);
    		ProductoDao pd = new ProductoDao();
    		pd.createRecord(nuevo);
    	} 
     }
     public  Producto buscarProducto(String nombre){
         Producto aux = new ProductoDao().readRecord(nombre);
         return aux;
     }
     public List<Reserva> devolverTodasReservas() {
         ReservaDao reservaDao = new ReservaDao();
         return reservaDao.readRecords();
     }
    /*
    private void crearProductos(){
        productos.add(new Producto(150000, "JD 6195M", "Potente ta wapo", "/img/JD6195M.png"));
        productos.add(new Producto(250000, "JD 5893", "cosechadora", "/img/5893JD.jpg"));
        productos.add(new Producto(13000, "JD Viejito", "De la old school", "/img/JDantiguo.jpg"));
        productos.add(new Producto(350000, "JD 8RX", "Demasiado potente", "/img/Tpotente.jfif"));
        productos.add(new Producto(16550, "JD Gator", "Para ir rapido a sitios", "/img/gator.jpg"));
        productos.add(new Producto(210000, "JD 6230M", "Lo ultimo en tecnologia", "/img/6r.jpg"));
        
        
    }
    
    private void crearReservas(){
        reservas.add(new Reserva(new Date(), "Admin", "Transporte"));
        reservas.add(new Reserva(new Date(), "Manolo", "Alquiler"));
        reservas.add(new Reserva(new Date(), "Miguel", "Reparacion"));
        reservas.add(new Reserva(new Date(), "Paulina", "Transporte"));
    }
    
    
    public  void añadirUsuario(String nombre, String contraseña, String correo){
        users.add(new Usuario(nombre,contraseña, correo));
    }
    
    public  Usuario buscarUsuario(String nombre, String contraseña){
     Usuario aux = null;
        for (Usuario user : users) {
            if(user.getNombre().equals(nombre) && user.getContraseña().equals(contraseña)){
                aux = user;
            }
        }
   
     return aux;
    }
    
    
    public void crearReserva( Date fechaBaja, String usuario, String tipo){
        int antes, despues;
        antes = this.reservas.size();
        this.reservas.add(new Reserva(fechaBaja, usuario, tipo));
        despues = this.reservas.size();
        if(antes < despues){
            System.out.println("Ta wapo");
        }else{
            System.out.println("no Ta wapo");
        }
        
    }
    
    
    public Producto devolverProducto(int pos){
    return productos.get(pos);
    }
    
    public ArrayList<Reserva> devolverReservas(){
        return this.reservas;
    }
    public void eliminarReserva(int i){
        reservas.remove(i);
    }
    
    */
}
