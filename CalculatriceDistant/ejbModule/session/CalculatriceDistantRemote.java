package session;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import beans.DataTP7;

@Remote
public interface CalculatriceDistantRemote {
	public DataTP7 calculateBonus(List<Map<String,String>> parameters);
}
