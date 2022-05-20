package erasmushub.repo;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import erasmushub.entity.Studente;

public interface StudenteRepo extends JpaRepository<Studente, Integer>{
	//JPQL: Cerca uno studente tramite id
	@Query("SELECT s FROM Studente s WHERE s.id = ?1")
	Studente findById(int id);
	
	//JPQL: Elimina uno studente tramite id
	@Modifying
	@Query("DELET FROM Studente s WHERE s.id = ?1")
	int deleteById(int id);
	
	//SQL: Cerca uno studente tramite l'id di un ticket
	@Query(
			value ="SELECT studente.email, studente.password, studente.nome, studente.cognome, studente.matricola, studente.paese, studente.facolta, studente.foto " +
			"FROM studente " +
			"INNER JOIN ticket " +
			"ON ticket.id_studente = studente.id " +
			"WHERE ticket.id = :id_ticket", nativeQuery = true)
	Studente findStudenteByTicket(@Param("id_ticket") int id_ticket);
	
	  //SQL: Inserisci uno studente
	  @Modifying
	  @Query(
	  value = "INSERT INTO studente (email, password, nome, cognome, matricola, paese, facolta, foto) "
	           + "VALUES (:email, :password, :nome, :cognome, :matricola, :paese, :facolta, :foto)", nativeQuery = true)
	  int insertAssociazione(
			  @Param("email") String email, 
			  @Param("password") String password, 
	          @Param("nome") String nome, 
	          @Param("cognome") String cognome,
	          @Param("matricola") String matricola,
	          @Param("paese") String paese,
	          @Param("facolta") String facolta,
	          @Param("foto") String foto);
	  
	  //JPQL: Aggiorna uno studente tramite il suo id
	  @Modifying
	  @Query("UPDATE Studente s SET email = :email, password = :password, nome = :nome, cognome = :cognome, "
	           + "matricola = :matricola, paese = :paese, facolta = :facolta, foto = :foto WHERE s.id = :id")
	  int updateAssociazione(
			  @Param("email") String email, 
			  @Param("password") String password, 
	          @Param("nome") String nome, 
	          @Param("cognome") String cognome, 
	          @Param("matricola") String matricola,
	          @Param("paese") String paese, 
	          @Param("facolta") String facolta,
	          @Param("foto") String foto,
	          @Param("id") int id);
}
