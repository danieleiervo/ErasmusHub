package erasmushub.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ticketassociazione")
public class Ticket2Associazione implements Serializable {
	//ID serializzazione
	private static final long serialVersionUID = 4L;

	//Attributi
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private int id_associazione;
	private int id_ticket;
	private String risposta;
	private Date data_risposta;

	public Ticket2Associazione() {}

	public Ticket2Associazione(int id_associazione, int id_ticket, String risposta, Date data_risposta) {
		this.id_associazione = id_associazione;
		this.id_ticket = id_ticket;
		this.risposta = risposta;
		this.data_risposta = data_risposta;
	}

	public int getId_associazione() {
		return id_associazione;
	}

	public void setId_associazione(int id_associazione) {
		this.id_associazione = id_associazione;
	}

	public int getId_ticket() {
		return id_ticket;
	}

	public void setIt_ticket(int id_ticket) {
		this.id_ticket = id_ticket;
	}

	public String getRisposta() {
		return risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public Date getData_risposta() {
		return data_risposta;
	}

	public void setData_risposta(Date data_risposta) {
		this.data_risposta = data_risposta;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

}
