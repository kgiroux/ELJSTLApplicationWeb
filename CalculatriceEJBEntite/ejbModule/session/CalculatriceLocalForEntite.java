package session;

import java.util.List;
import java.util.Map;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import entite.Bonus;

/**
 * Session Bean implementation class CalculatriceLocalForEntite
 */
@Stateless
@LocalBean
public class CalculatriceLocalForEntite implements CalculatriceLocalForEntiteLocal {
    /**
     * Default constructor. 
     */
    public CalculatriceLocalForEntite() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "CalculatriceEJBEntite")
    private EntityManager em;

	public void creer(Bonus bonus) {
	        em.persist(bonus);
	}

    
    @Override
    public List<Map<String,String>> calculateBonusAndCreate(List<Map<String,String>> parameters){
		for(Map<String,String> couple : parameters){
			if(couple.get("Multiplier") != "")
				couple.put("Bonus", String.valueOf(Integer.parseInt(couple.get("Multiplier"))*100));
			else
				couple.put("Bonus", "Bonus vide !");
			couple.remove("Multiplier");
			creer(new Bonus(couple.get("SSN"),couple.get("Bonus")));
		}
		return parameters;
	}
    
}
