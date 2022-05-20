package erasmushub.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erasmushub.entity.Associazione;
import erasmushub.repo.AssociazioneRepo;

@Service
@Transactional
public class AssociazioneService {
	@Autowired
	private final AssociazioneRepo repo;
	
	@Autowired
	public AssociazioneService(AssociazioneRepo repo) {
		this.repo = repo;
	}
	
	//Return di tutte le associazioni
	public List<Associazione> findAll() {
		return repo.findAll();
	}
	
	//Return associazione per id
	public Associazione findById(int id) {
		return repo.findById(id);
	}
	
	//Cancella un'associazione e return l'id se cancellata
	public int deleteById(int id) {
		return repo.deleteById(id);
	}
	
	//Insert di un'associazione e return dell'id se inserita
	public int insert(Associazione a) {
		return repo.saveAndFlush(a).getId();
	}
	
	//Update di un'associazione e return dell'id se aggiornata
	public int update(Associazione a) {
		return repo.updateAssociazione(
				a.getEmail(), 
				a.getPassword(), 
				a.getNome(), 
				a.getDipartimento(), 
				a.getRisposte(), 
				a.getPunteggio(), 
				a.getFoto(), 
				a.getId());
	}
	
	//Return di un'associazione per id di un post
	public Associazione findAssociazioneByPost(int id_post) {
		return repo.findAssociazioneByPost(id_post);
	}
	
}
