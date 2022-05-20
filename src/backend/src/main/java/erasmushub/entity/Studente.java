package erasmushub.entity;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "studente")
public class Studente implements Serializable {
	//ID serializzazione
	private static final long serialVersionUID = 1L;
	
	//Attributi
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	private String password;
	private String nome;
	private String cognome;
	private String matricola;
	private String paese;
	private String facolta;
	private String foto;
	
	public Studente() {}
	
	public Studente(String email, String password, String nome, String cognome, String matricola, String paese, String facolta, String foto) {
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.paese = paese;
		this.facolta = facolta;
		this.foto = foto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}

	public String getPaese() {
		return paese;
	}

	public void setPaese(String paese) {
		this.paese = paese;
	}
	
	public String getFacolta() {
		return facolta;
	}
	
	public void setFacolta(String facolta) {
		this.facolta = facolta;
	}
	
	public String getFoto() {
		return foto;
	}
	
	public void setFoto(String foto) {
		this.foto = foto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}
	
}
