package Tablas;

import logica.IDAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.mysql.cj.Query;
import utils.HibernateUtils;

public class ComprasDAO implements IDAO<Compras, Integer> {
    
    Session session;

    public ComprasDAO() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    @Override
    public boolean createRecord(Compras model) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(model);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public Compras readRecord(Integer idModel) {
        try {
            return session.get(Compras.class, idModel);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            session.close();
        }
    }
    
    
    
    @Override
    public boolean updateRecord(Compras model, Integer idModel) {
        Transaction transaction = null;
        model.setIdCom(idModel);
        try {
            transaction = session.beginTransaction();
            session.update(model);
            transaction.commit();
            return true;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            
            return false;
        } finally {
            session.close();
        }
    }
    
   
    
    @Override
    public boolean deleteRecord(Integer idModel) {
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            Compras compras = session.get(Compras.class, idModel);
            if (compras != null) {
                session.delete(compras);
                transaction.commit();
                return true;
            }
            return false;
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
           
            return false;
        } finally {
            session.close();
        }
    }

    @Override
    public List<Compras> readRecords() {
        try {
            return session.createQuery("FROM Compras", Compras.class).list();
        } catch (Exception e) {
            
            return null;
        } finally {
            session.close();
        }
    }
    public List<Compras> readRecordsUser(Usuario idModel) {
    	List<Compras> c = null;
    	List<Compras> comprasDevolver = new ArrayList<>();
        try {
            c = session.createQuery("FROM Compras", Compras.class).list();
            for(Compras com: c) {
            	if(com.getUsuario().getIdUse() == idModel.getIdUse()) {
            		comprasDevolver.add(com);
            	}
            }
        } catch (Exception e) {
            
           
        } finally {
            session.close();
        }
        return comprasDevolver;
    }
    
    
}
