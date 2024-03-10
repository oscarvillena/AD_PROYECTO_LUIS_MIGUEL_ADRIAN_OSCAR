package Tablas;

import logica.IDAO;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;
import jakarta.persistence.Query;
import java.sql.Date;
import java.util.ArrayList;

public class ReservaDao implements IDAO<Reserva, Integer> {

	Session session;

	public ReservaDao() {
		session = HibernateUtils.getSessionFactory().openSession();
	}

	@Override
	public boolean createRecord(Reserva model) {
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
		} finally {
			session.close();
		}
	}

	@Override
	public Reserva readRecord(Integer idModel) {
		try {
			return session.get(Reserva.class, idModel);
		} catch (Exception e) {
		
			return null;
		} finally {
			session.close();
		}
	}

	@Override
	public boolean updateRecord(Reserva model, Integer idModel) {
		Transaction transaction = null;
		model.setIdRes(idModel);
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
			Reserva reserva = session.get(Reserva.class, idModel);
			if (reserva != null) {
				session.delete(reserva);
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
	public List<Reserva> readRecords() {
		try {
			return session.createQuery("FROM Reserva", Reserva.class).list();
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}

	public void updateRecord(int idModel, Date fechaBaja, String tipo) {
		String hql = "from Reserva WHERE idRes =: idRes";
		Query query = session.createQuery(hql);
		query.setParameter("idRes", idModel);
		Transaction tx = session.beginTransaction();
		query.setMaxResults(1);
		Reserva modi = (Reserva) query.getSingleResult();
		modi.setFbaja(fechaBaja);
		modi.setTipo(tipo);
		session.update(modi);
		tx.commit();
		session.close();
	}

	public List<Reserva> readRecord(Usuario idUse) {
		try {
			String hql = "from Reserva where usuario = :usuario";
			Query query = session.createQuery(hql);
			query.setParameter("usuario", idUse);
			List<Reserva> reservasUsuario = (ArrayList<Reserva>) query.getResultList();
			session.close();
			return reservasUsuario;
		} catch (Exception e) {
			return null;
		} finally {
			session.close();
		}
	}
}
