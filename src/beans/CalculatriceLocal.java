package beans;

import java.util.List;
import java.util.Map;

import javax.ejb.Local;

@Local
public interface CalculatriceLocal {
	public DataTP7 calculateBonus(List<Map<String,String>> parameters);
}
