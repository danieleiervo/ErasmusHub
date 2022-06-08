package erasmushub.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import erasmushub.entity.Studente;

public interface StudenteRepo extends JpaRepository<Studente, Integer>{
	//JPQL: Cerca uno studente tramite matricola
	@Query("SELECT s FROM Studente s WHERE s.matricola = :matricola")
	Studente findByMatricola(
			@Param("matricola") String matricola);
	
	//JPQL: Elimina uno studente tramite matricola
	@Modifying
	@Query("DELETE FROM Studente s WHERE s.matricola = :matricola")
	String deleteByMatricola(
			@Param("matricola") String matricola);
	
	//SQL: Cerca uno studente tramite l'id di un ticket
	@Query(
			value ="SELECT studente.matricola, studente.email, studente.password, studente.nome, studente.cognome, studente.paese, studente.facolta, studente.foto, studente.bus_tickets " +
			"FROM studente " +
			"INNER JOIN ticket " +
			"ON ticket.mat_studente = studente.matricola " +
			"WHERE ticket.id = :id_ticket", nativeQuery = true)
	Studente findStudenteByTicket(@Param("id_ticket") int id_ticket);
	
	  //SQL: Inserisci uno studente
	  @Modifying
	  @Query(
	  value = "INSERT INTO studente (matricola, email, password, nome, cognome, paese, facolta, foto) "
	           + "VALUES (:matricola, :email, :password, :nome, :cognome, :paese, :facolta, :foto)", nativeQuery = true)
	  int insertAssociazione(
			  @Param("matricola") String matricola,
			  @Param("email") String email, 
			  @Param("password") String password, 
	          @Param("nome") String nome, 
	          @Param("cognome") String cognome,	        
	          @Param("paese") String paese,
	          @Param("facolta") String facolta,
	          @Param("foto") String foto);
	  
	  //JPQL: Aggiorna uno studente 
	  @Modifying
	  @Query("UPDATE Studente s SET email = :email, password = :password, nome = :nome, cognome = :cognome, "
	           + "paese = :paese, facolta = :facolta, foto = :foto, bus_tickets = :bus_tickets WHERE s.matricola = :matricola")
	  int updateStudente(
			  @Param("email") String email, 
			  @Param("password") String password, 
	          @Param("nome") String nome, 
	          @Param("cognome") String cognome, 
	          @Param("paese") String paese, 
	          @Param("facolta") String facolta,
	          @Param("foto") String foto,
	          @Param("bus_tickets") int bus_tickets,
	          @Param("matricola") String matricola);
}
