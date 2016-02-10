package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the bonus_multiple database table.
 * 
 */
@Entity
@Table(name="bonus_multiple")
@NamedQuery(name="BonusMultiple.findAll", query="SELECT b FROM BonusMultiple b")
public class BonusMultiple implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ID_BONUS")
	private int idBonus;

	private int valeur;

	//bi-directional many-to-one association to Ssn
	@ManyToOne
	@JoinColumn(name="SSN")
	private Ssn ssnBean;

	public BonusMultiple() {
	}

	public int getIdBonus() {
		return this.idBonus;
	}

	public void setIdBonus(int idBonus) {
		this.idBonus = idBonus;
	}

	public int getValeur() {
		return this.valeur;
	}

	public void setValeur(int valeur) {
		this.valeur = valeur;
	}

	public Ssn getSsnBean() {
		return this.ssnBean;
	}

	public void setSsnBean(Ssn ssnBean) {
		this.ssnBean = ssnBean;
	}

}