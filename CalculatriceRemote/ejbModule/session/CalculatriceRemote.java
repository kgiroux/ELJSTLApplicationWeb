package session;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;


@Remote
public interface CalculatriceRemote {
	public List<Map<String,String>> calculateBonus(List<Map<String,String>> parameters);

}
