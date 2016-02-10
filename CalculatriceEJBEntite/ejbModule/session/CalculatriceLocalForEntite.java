package session;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import model.Bonus;

/**
 * Session Bean implementation class CalculatriceLocalForEntite
 */
@Stateless
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
    
    public List<Bonus> liste_bonus() {
        List<Bonus> liste_bonus = new ArrayList<Bonus> ();
        Query q = em.createNamedQuery("Bonus.findAll");
        liste_bonus =(List<Bonus>) q.getResultList();
        return liste_bonus;
    }
    
    public Bonus get_bonus(String _ssn) {
    	Bonus bonus_cherche = new Bonus();
        Query q = em.createQuery("SELECT b FROM Bonus b WHERE b.ssn = :ssn");
        q.setParameter("ssn", _ssn);
        bonus_cherche = (Bonus) q.getSingleResult();
        return bonus_cherche;
    }
}
