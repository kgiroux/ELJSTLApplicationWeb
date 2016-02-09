package session;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;


@Local
public interface CalculatriceLocalForEntiteLocal {
	public List<Map<String,String>> calculateBonusAndCreate(List<Map<String,String>> parameters);
}
