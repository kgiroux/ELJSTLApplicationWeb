package beans;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculatrice
 */
@Stateless
public class Calculatrice implements CalculatriceLocal {

    /**
     * Default constructor. 
     */
    public Calculatrice() {}
    
	public DataTP7 calculateBonus(List<Map<String,String>> parameters){
		for(Map<String,String> couple : parameters){
			if(couple.get("Multiplier") != "")
				couple.put("Bonus", String.valueOf(Integer.parseInt(couple.get("Multiplier"))*100));
			else
				couple.put("Bonus", "Bonus vide !");
			couple.remove("Multiplier");
		}
		return new DataTP7(parameters);
	}
}
