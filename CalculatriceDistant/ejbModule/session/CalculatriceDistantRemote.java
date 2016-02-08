package session;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

import beans.DataTP7;

@Local
public interface CalculatriceDistantRemote {
	public DataTP7 calculateBonus(List<Map<String,String>> parameters);
}
