package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import beans.Data;

public class BonusDAO extends DAO<Data, String> {
	private static BonusDAO instanceCompteDAO;

	private BonusDAO() {
		super();
	}

	public boolean create(Data obj) {
		try {
			PreparedStatement st = null;
			st = connect
					.prepareStatement("insert into bonus (ssn,bonus) values(?,?)");
			st.setString(1, obj.getSsn());
			st.setString(2, obj.getBonus());
			st.executeUpdate();
			connect.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean delete(Data obj) {
		return false;
	}

	public boolean update(Data obj) {
		return false;
	}

	public Data find(String id) {
		Data compte = null;
		return compte;
	}

	public static BonusDAO getInstance() {
		if (null == instanceCompteDAO) { // Premier appel
			instanceCompteDAO = new BonusDAO();
		}
		return instanceCompteDAO;
	}

}