package erasmushub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import erasmushub.entity.Post2Studente;
import erasmushub.service.Post2StudenteService;

@RestController
@RequestMapping("/poststudente")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class Post2StudenteController {
	@Autowired
	private final Post2StudenteService poststudenteService;

	@Autowired
	public Post2StudenteController(Post2StudenteService poststudenteService) {
		this.poststudenteService = poststudenteService;
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Post2Studente>> findAll() {
		try {
			List<Post2Studente> poststudenteList = poststudenteService.findAll();
			return new ResponseEntity<>(poststudenteList, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Post2Studente> findById(@PathVariable("id") int id) {
		try {
			Post2Studente poststudente = poststudenteService.findById(id);
			return new ResponseEntity<>(poststudente, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable("id") int id) {
		try {
			Integer id_poststudente = poststudenteService.deleteById(id);
			return new ResponseEntity<>(id_poststudente, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<Integer> insert(@RequestBody Post2Studente poststudente) {
		try {
			Integer id_poststudente = poststudenteService.insert(poststudente);
			return new ResponseEntity<>(id_poststudente, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody Post2Studente poststudente) {
		try {
			Integer id_poststudente = poststudenteService.insert(poststudente);
			return new ResponseEntity<>(id_poststudente, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
