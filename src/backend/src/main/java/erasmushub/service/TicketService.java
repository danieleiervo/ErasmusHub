package erasmushub.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erasmushub.entity.Ticket;
import erasmushub.repo.TicketRepo;

@Service
@Transactional
public class TicketService {
	@Autowired
	private final TicketRepo repo;

	@Autowired
	public TicketService(TicketRepo repo) {
		this.repo = repo;
	}

	// Return di tutti i ticket
	public List<Ticket> findAll() {
		return repo.findAll();
	}

	// Return ticket per id
	public Ticket findById(int id) {
		return repo.findById(id);
	}

	// Cancella un ticket e return id
	public int deleteById(int id) {
		return repo.deleteById(id);
	}

	// Insert di un ticket e return id
	public int insert(Ticket t) {
		return repo.saveAndFlush(t).getId();
	}

	// Update di un ticket e return id
	public int updateTicket(Ticket t) {
		return repo.updateTicket(t.getMat_studente(), t.getId_associazione_best(), t.getTitolo(), t.getTesto(), t.getDataApertura(), t.getId());
	}
	
	// Return tutti i ticket di uno studente
	public List<Ticket> findAllTicketByStudente(String mat_studente) {
		return repo.findAllTicketByStudente(mat_studente);
	}

}
