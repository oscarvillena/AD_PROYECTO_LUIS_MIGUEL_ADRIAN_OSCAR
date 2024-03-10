package Tablas;

import logica.IDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import jakarta.persistence.Query;

public class ProductoDao implements IDAO<Producto, Integer> {
	
	Session session; 
	
	public ProductoDao() {
		session = HibernateUtils.getSessionFactory().openSession();
	}
	
	@Override
	public boolean createRecord(Producto model) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.save(model);
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction !=null) {
				transaction.rollback();
			}
			
			return false;
		}finally {
			session.close();
		}
	}
	
	@Override
	public Producto readRecord(Integer idModel) {
		try {
			return session.get(Producto.class, idModel);
		} catch (Exception e) {
			
			return null;
		}finally {
			session.close();
		}
	}
	
	@Override
	public boolean updateRecord(Producto model, Integer idModel) {
		Transaction transaction = null;
		model.setIdPro(idModel); 
		try {
			transaction = session.beginTransaction();
			session.update(model);;
			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			
			return false;
		}finally {
			session.close();
		}
	}
	
	@Override
	public boolean deleteRecord(Integer idModel) {
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			Producto producto = session.get(Producto.class, idModel);
			if (producto != null) {
				session.delete(producto);
				transaction.commit();
				return true;
			}
			return false;
		} catch (Exception e) { 
			if (transaction != null) {
				transaction.rollback();
			}
			
			return false;
		}finally {
			session.close();
		}
	}
	
	
public Producto readRecord(String nombre) {
			Producto p = null;
			try {
				String hql = "from Producto where nombre = :nombre";
				Query query = session.createQuery(hql);
		        query.setParameter("nombre", nombre);
		        query.setMaxResults(1);
		        p = (Producto) query.getSingleResult();
			}catch(Exception e) {
				
			}finally {
				session.close();
			}
			return p;
}
		 @Override
	    public List<Producto> readRecords() {
	        try {
	            return session.createQuery("FROM Producto", Producto.class).list();
	        } catch (Exception e) {
	            
	            return null;
	        }finally {
				session.close();
			}
	}
}

