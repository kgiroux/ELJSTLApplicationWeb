package session;

import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;

import beans.DataTP7;

/**
 * Session Bean implementation class CalculatriceDistant
 */
@Stateless
public class CalculatriceDistant implements CalculatriceDistantRemote {

    /**
     * Default constructor. 
     */
    public CalculatriceDistant() {
        // TODO Auto-generated constructor stub
    }
    @Override
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
