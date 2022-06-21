package erasmushub.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erasmushub.entity.Ticket2Associazione;
import erasmushub.repo.Ticket2AssociazioneRepo;

@Service
@Transactional
public class Ticket2AssociazioneService {
	@Autowired
	private final Ticket2AssociazioneRepo repo;

	@Autowired
	public Ticket2AssociazioneService(Ticket2AssociazioneRepo repo) {
		this.repo = repo;
	}

	// Return di tutti i ticket
	public List<Ticket2Associazione> findAll() {
		return repo.findAll();
	}

	// Return ticket per id
	public Ticket2Associazione findById(int id) {
		return repo.findById(id);
	}

	// Cancella un ticket e return id
	public int deleteById(int id) {
		return repo.deleteById(id);
	}

	// Insert di un ticket e return id
	public int insert(Ticket2Associazione t) {
		return repo.saveAndFlush(t).getId();
	}

	// Update di un ticket e return id
	public int update(Ticket2Associazione t) {
		return repo.updateTicket2Associazione(t.getId_associazione(), t.getId_ticket(), t.getRisposta(), t.getData_risposta(),
				t.getId());
	}

}
