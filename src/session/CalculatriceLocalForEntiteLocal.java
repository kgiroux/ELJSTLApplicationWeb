package session;

import java.util.List;
import java.util.Map;

import javax.ejb.Remote;

import model.Bonus;


@Remote
public interface CalculatriceLocalForEntiteLocal {
	public List<Map<String,String>> calculateBonusAndCreate(List<Map<String,String>> parameters);
	public List<Bonus> liste_bonus();
	public Bonus get_bonus(String _ssn);
}
