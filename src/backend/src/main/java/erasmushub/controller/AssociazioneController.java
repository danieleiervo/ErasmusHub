package erasmushub.controller;

import java.util.ArrayList;
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

import erasmushub.entity.Associazione;
import erasmushub.service.AssociazioneService;

@RestController
@RequestMapping("/associazione")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AssociazioneController {
	@Autowired
	private final AssociazioneService associazioneService;

	@Autowired
	public AssociazioneController(AssociazioneService associazioneService) {
		this.associazioneService = associazioneService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Associazione> login(@RequestBody ArrayList<String> loginData) {
		try {
			Associazione associazioneLogin = associazioneService.login(loginData.get(0), loginData.get(1));
			return new ResponseEntity<>(associazioneLogin, HttpStatus.OK);
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Associazione>> findAll() {
		try {
			List<Associazione> associazioneList = associazioneService.findAll();
			return new ResponseEntity<>(associazioneList, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Associazione> findById(@PathVariable("id") int id) {
		try {
			Associazione associazione = associazioneService.findById(id);
			return new ResponseEntity<>(associazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable("id") int id) {
		try {
			Integer id_associazione = associazioneService.deleteById(id);
			return new ResponseEntity<>(id_associazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<Integer> insert(@RequestBody Associazione associazione) {
		try {
			Integer id_associazione = associazioneService.insert(associazione);
			return new ResponseEntity<>(id_associazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody Associazione associazione) {
		try {
			Integer id_associazione = associazioneService.insert(associazione);
			return new ResponseEntity<>(id_associazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("findAssociazioneByPost/{id}")
	public ResponseEntity<Associazione> findAssociazioneByPost(@PathVariable("id") int id_post) {
		try {
			Associazione associazione = associazioneService.findAssociazioneByPost(id_post);
			return new ResponseEntity<>(associazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
