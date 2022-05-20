package erasmushub.service;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erasmushub.entity.Studente;
import erasmushub.repo.StudenteRepo;

@Service
@Transactional
public class StudenteService {
	@Autowired
	private final StudenteRepo repo;
	
	@Autowired
	public StudenteService(StudenteRepo repo) {
		this.repo = repo;
	}
	
	//Return di tutte gli studenti
	public List<Studente> findAll() {
		return repo.findAll();
	}
	
	//Return studente per id
	public Studente findById(int id) {
		return repo.findById(id);
	}
	
	//Cancella uno studente e return l'id se cancellata
	public int deleteById(int id) {
		return repo.deleteById(id);
	}
	
	//Insert di uno studente e return dell'id se inserita
	public int insert(Studente s) {
		return repo.saveAndFlush(s).getId();
	}
	
	//Update di uno studente e return dell'id se aggiornata
	public int update(Studente s) {
		return repo.updateStudente(
				s.getEmail(), 
				s.getPassword(), 
				s.getNome(), 
				s.getCognome(), 
				s.getMatricola(), 
				s.getPaese(), 
				s.getFacolta(),
				s.getFoto(),
				s.getId());
	}
	
}
