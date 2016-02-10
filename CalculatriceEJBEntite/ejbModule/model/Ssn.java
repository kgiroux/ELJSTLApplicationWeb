package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ssn database table.
 * 
 */
@Entity
@NamedQuery(name="Ssn.findAll", query="SELECT s FROM Ssn s")
public class Ssn implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ssn;

	//bi-directional many-to-one association to BonusMultiple
	@OneToMany(mappedBy="ssnBean")
	private List<BonusMultiple> bonusMultiples;

	public Ssn() {
	}

	public String getSsn() {
		return this.ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public List<BonusMultiple> getBonusMultiples() {
		return this.bonusMultiples;
	}

	public void setBonusMultiples(List<BonusMultiple> bonusMultiples) {
		this.bonusMultiples = bonusMultiples;
	}

	public BonusMultiple addBonusMultiple(BonusMultiple bonusMultiple) {
		getBonusMultiples().add(bonusMultiple);
		bonusMultiple.setSsnBean(this);

		return bonusMultiple;
	}

	public BonusMultiple removeBonusMultiple(BonusMultiple bonusMultiple) {
		getBonusMultiples().remove(bonusMultiple);
		bonusMultiple.setSsnBean(null);

		return bonusMultiple;
	}

}