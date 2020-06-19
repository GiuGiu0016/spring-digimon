package it.spring.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Digimon {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private double hp;
	private double atk;
	private double def;
	private double res;
	private String evo;
	private Customers c;
	
	public Customers getC() {
		return c;
	}

	public void setC(Customers c) {
		this.c = c;
	}

	public Digimon() {
	}

	public Digimon(Long id, String name, double hp, double atk, double def, double res, String evo, Customers c) {
		super();
		this.id = id;
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
		this.res = res;
		this.evo = evo;
		this.c = c;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getHp() {
		return hp;
	}

	public void setHp(double hp) {
		this.hp = hp;
	}

	public double getAtk() {
		return atk;
	}

	public void setAtk(double atk) {
		this.atk = atk;
	}

	public double getDef() {
		return def;
	}

	public void setDef(double def) {
		this.def = def;
	}

	public double getRes() {
		return res;
	}

	public void setRes(double res) {
		this.res = res;
	}

	public String getEvo() {
		return evo;
	}

	public void setEvo(String evo) {
		this.evo = evo;
	}


}


