package erasmushub.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import erasmushub.entity.Associazione;

public interface AssociazioneRepo extends JpaRepository<Associazione, Integer>{
	//JPQL: Cerca un'associazione tramite id
	@Query("SELECT a FROM Associazione a WHERE a.id = ?1")
	Associazione findById(int id);
	
	//JPQL: Elimina un'associazione tramite id
	@Modifying
	@Query("DELET FROM Associazione a WHERE a.id = ?1")
	int deleteById(int id);
	
	//SQL: Cerca un'associazione tramite l'id di un post
	@Query(
			value ="SELECT associazione.id, associazione.email, associazione.password, associazione.nome, associazione.dipartimento, associazione.risposte, associazione.punteggio, associazione.foto " +
			"FROM associazione " +
			"INNER JOIN post " +
			"ON post.id_associazione = associazione.id " +
			"WHERE post.id = :id_post", nativeQuery = true)
	Associazione findAssociazioneByPost(@Param("id_post") int id_post);
	
	  //SQL: Inserisci un'associazione
	  @Modifying
	  @Query(
	  value = "INSERT INTO associazione (email, password, nome, dipartimento, risposte, punteggio, foto) "
	           + "VALUES (:email, :password, :nome, :dipartimento, :risposte, :punteggio, :foto)", nativeQuery = true)
	  int insertAssociazione(
			  @Param("email") String email, 
			  @Param("password") String password, 
	          @Param("nome") String nome, 
	          @Param("dipartimento") String dipartimento,
	          @Param("risposte") int risposte,
	          @Param("punteggio") int punteggio,
	          @Param("foto") String foto);
	  
	  //JPQL: Aggiorna un'associazione tramite il suo id
	  @Modifying
	  @Query("UPDATE Associazione a SET email = :email, password = :password, nome = :nome, dipartimento = :dipartimento, "
	           + "risposte = :risposte, punteggio = :punteggio, foto = :foto WHERE a.id = :id")
	  int updateAssociazione(
			  @Param("email") String email, 
			  @Param("password") String password, 
	          @Param("nome") String nome, 
	          @Param("dipartimento") String dipartimento, 
	          @Param("risposte") String vat,
	          @Param("punteggio") String descrizione, 
	          @Param("logo") String logo,
	          @Param("foto") String foto,
	          @Param("id") int id);
}
