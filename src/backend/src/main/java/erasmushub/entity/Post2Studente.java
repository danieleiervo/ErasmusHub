package erasmushub.entity;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "poststudente")
public class Post2Studente implements Serializable {
	//ID serializzazione
	private static final long serialVersionUID = 5L;
	
	//Attributi
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String mat_studente;
	private int id_post;
	
	public Post2Studente() {}

	public Post2Studente(String mat_studente, int id_post) {
		this.mat_studente = mat_studente;
		this.id_post = id_post;
	}

	public String getmat_studente() {
		return mat_studente;
	}

	public void setmat_studente(String mat_studente) {
		this.mat_studente = mat_studente;
	}

	public int getId_post() {
		return id_post;
	}

	public void setId_post(int id_post) {
		this.id_post = id_post;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

}
