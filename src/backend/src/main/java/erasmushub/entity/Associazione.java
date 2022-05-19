package erasmushub.entity;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "associazione")
public class Associazione implements Serializable {
	//ID serializzazione
	private static final long serialVersionUID = 2L;
	
	//Attributi
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String email;
	private String password;
	private String nome;
	private String dipartimento;
	private int risposte;
	private int punteggio;
	
	
	public Associazione() {}


	public Associazione(String email, String password, String nome, String dipartimento, int risposte, int punteggio) {
		this.email = email;
		this.password = password;
		this.nome = nome;
		this.dipartimento = dipartimento;
		this.risposte = risposte;
		this.punteggio = punteggio;
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


	public String getDipartimento() {
		return dipartimento;
	}


	public void setDipartimento(String dipartimento) {
		this.dipartimento = dipartimento;
	}


	public int getRisposte() {
		return risposte;
	}


	public void setRisposte(int risposte) {
		this.risposte = risposte;
	}


	public int getPunteggio() {
		return punteggio;
	}


	public void setPunteggio(int punteggio) {
		this.punteggio = punteggio;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public int getId() {
		return id;
	}
	
}
