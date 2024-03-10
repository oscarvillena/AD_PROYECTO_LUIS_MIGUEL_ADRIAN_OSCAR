package Tablas;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import logica.IDAO;
import utils.HibernateUtils;
import org.hibernate.Transaction;

import jakarta.persistence.Query;

public class UsuarioDao implements IDAO<Usuario, Integer>{

	Session session;
	
	public UsuarioDao() {
		session = HibernateUtils.getSessionFactory().openSession();
	}
	
	@Override
	public boolean createRecord(Usuario model){
		boolean f = false;
		Transaction tx = session.beginTransaction();
		session.persist(model);
		tx.commit();
		session.close();
		f= true;
		return f;
	}

	@Override
	public Usuario readRecord(Integer idModel) {
		Usuario u = null;
		try {
		String hql = "from Usuario where idUse = :idUse";
        Query query = session.createQuery(hql);
        query.setParameter("idUse", idModel);
        
        u = (Usuario) query.getSingleResult();
		}catch (Exception e) {
		
		}finally {
		session.close();
		}
		return u;
	}
	
	public Usuario readRecord(String nombre) {
		Usuario u = null;
		try {
			String hql = "from Usuario where nombre = :nombre";
			Query query = session.createQuery(hql);
	        query.setParameter("nombre", nombre);
	        query.setMaxResults(1);
	        u = (Usuario) query.getSingleResult();
		}catch(Exception e) {
		
		}finally {
			session.close();
		}
		return u;
	}
	
	public Usuario readRecord(String nombre, String contraseña) {
		Usuario u = null;
		try {
			String hql = "from Usuario where nombre = :nombre AND contraseña = :contraseña";
			Query query = session.createQuery(hql);
	        query.setParameter("nombre", nombre);
	        query.setParameter("contraseña", contraseña);
	        query.setMaxResults(1);
	        u = (Usuario) query.getSingleResult();
		}catch(Exception e) {
			
		}finally {
			session.close();
		}
		return u;
	}

	@Override
	public boolean updateRecord(Usuario model, Integer idModel) {
		try {
			String hql = "from Usuario Where idUse =: idUse";
			Query query = session.createQuery(hql);
			query.setParameter("idUse", idModel);
			Transaction tx = session.beginTransaction();
			query.setMaxResults(1);
			Usuario aux = (Usuario) query.getSingleResult();
			aux.setContraseña(model.getContraseña());
			aux.setCorreo(model.getCorreo());
			aux.setFoto(model.getFoto());
			aux.setNombre(model.getNombre());
			session.update(aux);
			tx.commit();
		}catch (Exception e) {
		}finally {
			session.close();
		}
		return true;
	}

	@Override
	public boolean deleteRecord(Integer idModel) {
		
		return false;
	}

	@Override
	public List<Usuario> readRecords() {
            
            try{
                return session.createQuery("FROM Usuario", Usuario.class).list();
            }catch(Exception e){
                
            }
            return null;
	}
	
	
	

}
