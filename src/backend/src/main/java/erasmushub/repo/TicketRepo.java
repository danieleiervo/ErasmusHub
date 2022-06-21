package erasmushub.repo;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import erasmushub.entity.Ticket;

public interface TicketRepo extends JpaRepository<Ticket, Integer> {
	// JPQL: Cerca un ticket tramite id
	@Query("SELECT t FROM Ticket t WHERE t.id = ?1")
	Ticket findById(int id);

	// JPQL: Elimina un ticket tramite id
	@Modifying
	@Query("DELETE FROM Ticket t WHERE t.id = ?1")
	int deleteById(int id);

	// JPQL: Aggiorna un ticket tramite il suo id
	@Modifying
	@Query("UPDATE Ticket t SET mat_studente = :mat_studente, id_associazione_best = :id_associazione_best, titolo = :titolo, testo = :testo, "
			+ "data_apertura = :data_apertura WHERE t.id = :id")
	int updateTicket(@Param("mat_studente") String mat_studente, @Param("id_associazione_best") int id_associazione_best,
			@Param("titolo") String titolo, @Param("testo") String testo, @Param("data_apertura") Date data_apertura,
			@Param("id") int id);

	// SQL: Cerca tutti i ticket di uno studente
	@Query(value = "SELECT ticket.id, ticket.mat_studente, ticket.id_associazione_best, ticket.titolo, ticket.testo, ticket.data_apertura "
			+ "FROM ticket INNER JOIN studente ON studente.matricola = ticket.mat_studente "
			+ "WHERE studente.matricola = :mat_studente", nativeQuery = true)
	List<Ticket> findAllTicketByStudente(@Param("mat_studente") String mat_studente);
}
