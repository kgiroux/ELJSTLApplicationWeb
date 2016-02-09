package entite;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bonus database table.
 * 
 */
@Entity
@NamedQuery(name="Bonus.findAll", query="SELECT b FROM Bonus b")
public class Bonus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ssn;

	private String bonus;

	public Bonus() {
	}

	public Bonus(String ssn, String bonus){
		this.bonus = bonus;
		this.ssn = ssn;
	}
	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getBonus() {
		return this.bonus;
	}

	public void setBonus(String bonus) {
		this.bonus = bonus;
	}

}