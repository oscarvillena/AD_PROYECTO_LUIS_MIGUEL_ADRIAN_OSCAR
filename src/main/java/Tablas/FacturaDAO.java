package Tablas;

import logica.IDAO;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

public class FacturaDAO implements IDAO<Factura, Integer> {
    
    Session session;

    public FacturaDAO() {
        session = HibernateUtils.getSessionFactory().openSession();
    }

    @Override
    public boolean createRecord(Factura model) {
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
            
            return false;
        }finally {
			session.close();
		}
    }

    @Override
    public Factura readRecord(Integer idModel) {
        try {
            return session.get(Factura.class, idModel);
        } catch (Exception e) {
            
            return null;
        }finally {
			session.close();
		}
    }

    @Override
    public boolean updateRecord(Factura model, Integer idModel) {
        Transaction transaction = null;
        model.setIdFac(idModel);
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
        }finally {
			session.close();
		}
    }

    @Override
    public boolean deleteRecord(Integer idModel) {
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Factura factura = session.get(Factura.class, idModel);
            if (factura != null) {
                session.delete(factura);
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

    @Override
    public List<Factura> readRecords() {
        try {
            return session.createQuery("FROM Factura", Factura.class).list();
        } catch (Exception e) {
            
            return null;
        }finally {
			session.close();
		}
    }
    
    public List<Factura> readRecords(int id) {
    	List<Factura> l = null;
    	List listaDevolver = new ArrayList<>();
        try {
            l= session.createQuery("FROM Factura", Factura.class).list();
            for(Factura lis:l) {
            	if(lis.getCompras().getIdCom() == id) {
            		listaDevolver.add(lis);
            	}
            }
        } catch (Exception e) {
           
            return null;
        }finally {
			session.close();
		}
        
        return listaDevolver;
    }
    
}
