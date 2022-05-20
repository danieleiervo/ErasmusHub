package erasmushub.entity;


import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "post")
public class Post implements Serializable {
	//ID serializzazione
	private static final long serialVersionUID = 5L;
	
	//Attributi
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int id_associazione;
	private String img;
	private String nome;
	private String descrizione;
	private Date data_pubblicazione;
	private Date data_evento;
	
	public Post() {}

	public Post(int id_associazione, String img, String nome, String descrizione, Date data_pubblicazione,
			Date data_evento) {
		this.id_associazione = id_associazione;
		this.img = img;
		this.nome = nome;
		this.descrizione = descrizione;
		this.data_pubblicazione = data_pubblicazione;
		this.data_evento = data_evento;
	}

	public int getId_associazione() {
		return id_associazione;
	}

	public void setId_associazione(int id_associazione) {
		this.id_associazione = id_associazione;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getData_pubblicazione() {
		return data_pubblicazione;
	}

	public void setData_pubblicazione(Date data_pubblicazione) {
		this.data_pubblicazione = data_pubblicazione;
	}

	public Date getData_evento() {
		return data_evento;
	}

	public void setData_evento(Date data_evento) {
		this.data_evento = data_evento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}
	
}
