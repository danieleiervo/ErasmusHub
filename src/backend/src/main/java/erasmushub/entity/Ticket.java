package erasmushub.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket implements Serializable {
	//ID serializzazione
	private static final long serialVersionUID = 3L;
	
	//Attributi
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int id_studente;
	private int id_associazione_best;
	private String titolo;
	private String testo;
	private Date data_apertura;
	
	public Ticket() {}

	public Ticket(int id_studente, int id_associazione_best, String titolo, String testo, Date data_apertura) {
		this.id_studente = id_studente;
		this.id_associazione_best = id_associazione_best;
		this.titolo = titolo;
		this.testo = testo;
		this.data_apertura = data_apertura;
	}

	public int getId_studente() {
		return id_studente;
	}

	public void setId_studente(int id_studente) {
		this.id_studente = id_studente;
	}

	public int getId_associazione_best() {
		return id_associazione_best;
	}

	public void setId_associazione_best(int id_associazione_best) {
		this.id_associazione_best = id_associazione_best;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public String getTesto() {
		return testo;
	}

	public void setTesto(String testo) {
		this.testo = testo;
	}
	
	public Date getDataApertura() {
		return data_apertura;
	}
	
	public void setDataApertura(Date data_apertura) {
		this.data_apertura = data_apertura;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

}
