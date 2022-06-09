package erasmushub.repo;

import java.sql.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import erasmushub.entity.Ticket2Associazione;

public interface Ticket2AssociazioneRepo extends JpaRepository<Ticket2Associazione, Integer> {
	// JPQL: Cerca tramite id
	@Query("SELECT t FROM Ticket2Associazione t WHERE t.id = ?1")
	Ticket2Associazione findById(int id);

	// JPQL: Elimina tramite id
	@Modifying
	@Query("DELETE FROM Ticket2Associazione t WHERE t.id = ?1")
	int deleteById(int id);

	// JPQL: Aggiorna tramite id
	@Modifying
	@Query("UPDATE Ticket2Associazione t SET id_associazione = :id_associazione, id_ticket = :id_ticket, risposta = :risposta, data_risposta = :data_risposta WHERE t.id = :id")
	int updateTicket2Associazione(@Param("id_associazione") int id_associazione, @Param("id_ticket") int id_ticket,
			@Param("risposta") String risposta, @Param("data_risposta") Date data_risposta, @Param("id") int id);

}
