package session;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculatrice
 */
@Stateless
public class Calculatrice implements CalculatriceRemote {

    /**
     * Default constructor. 
     */
    public Calculatrice() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public List<Map<String,String>> calculateBonus(List<Map<String,String>> parameters){
		for(Map<String,String> couple : parameters){
			if(couple.get("Multiplier") != "")
				couple.put("Bonus", String.valueOf(Integer.parseInt(couple.get("Multiplier"))*100));
			else
				couple.put("Bonus", "Bonus vide !");
			couple.remove("Multiplier");
		}
		return parameters;
	}
}
