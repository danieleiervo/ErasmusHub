package erasmushub.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import erasmushub.entity.Post;
import erasmushub.repo.PostRepo;

@Service
@Transactional
public class PostService {
	@Autowired
	private final PostRepo repo;

	@Autowired
	public PostService(PostRepo repo) {
		this.repo = repo;
	}

	// Return di tutti i post
	public List<Post> findAll() {
		return repo.findAll();
	}

	// Return post per id
	public Post findById(int id) {
		return repo.findById(id);
	}

	// Cancella un post e return id
	public int deleteById(int id) {
		return repo.deleteById(id);
	}

	// Insert di un post e return id
	public int insert(Post p) {
		return repo.saveAndFlush(p).getId();
	}

	// Update di un post e return id
	public int update(Post p) {
		return repo.updatePost(p.getId_associazione(), p.getImg(), p.getNome(), p.getDescrizione(),
				p.getData_pubblicazione(), p.getData_evento(), p.getId());
	}

	// Return tutti i post di un'associazione
	public List<Post> findAllPostByAssociazione(int id_associazione) {
		return repo.findAllPostByAssociazione(id_associazione);
	}

}
