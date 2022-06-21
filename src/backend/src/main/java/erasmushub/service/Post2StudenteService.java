package erasmushub.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erasmushub.entity.Post2Studente;
import erasmushub.repo.Post2StudenteRepo;

@Service
@Transactional
public class Post2StudenteService {
	@Autowired
	private final Post2StudenteRepo repo;

	@Autowired
	public Post2StudenteService(Post2StudenteRepo repo) {
		this.repo = repo;
	}

	// Return di tutti i post
	public List<Post2Studente> findAll() {
		return repo.findAll();
	}

	// Return post per id
	public Post2Studente findById(int id) {
		return repo.findById(id);
	}

	// Cancella un post e return id
	public int deleteById(int id) {
		return repo.deleteById(id);
	}

	// Insert di un post e return id
	public int insert(Post2Studente p) {
		return repo.saveAndFlush(p).getId();
	}

	// Update di un post e return id
	public int update(Post2Studente p) {
		return repo.updatePost2Studente(p.getmat_studente(), p.getId_post(), p.getId());
	}

}
