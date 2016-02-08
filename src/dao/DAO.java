package dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class DAO<T, T1> {
	public Connection connect = null;
	T metier;

	public DAO() {
		try {
			this.connect = DBManager.getConnect();
		} catch (SQLException ex) {
			Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public abstract boolean create(T obj);

	public abstract boolean delete(T obj);

	public abstract boolean update(T obj);

	public abstract T find(T1 id);
}
