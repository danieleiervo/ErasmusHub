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
	
	//Return studente per matricola
	public Studente findByMatricola(String matricola) {
		return repo.findByMatricola(matricola);
	}
	
	//Cancella uno studente e return matricola
	public String deleteByMatricola(String matricola) {
		return repo.deleteByMatricola(matricola);
	}
	
	//Insert di uno studente e return della matricola
	public String insert(Studente s) {
		return repo.saveAndFlush(s).getMatricola();
	}
	
	//Update di uno studente e return dell'id se aggiornata
	public int update(Studente s) {
		return repo.updateStudente(
				s.getEmail(), 
				s.getPassword(), 
				s.getNome(), 
				s.getCognome(), 
				s.getPaese(), 
				s.getFacolta(),
				s.getFoto(),
				s.getBusTickets(),
				s.getMatricola());
	}
	
}
