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

import erasmushub.entity.Studente;
import erasmushub.service.StudenteService;

@RestController
@RequestMapping("/studente")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class StudenteController {
	@Autowired
	private final StudenteService studenteService;

	@Autowired
	public StudenteController(StudenteService studenteService) {
		this.studenteService = studenteService;
	}
	
	@PostMapping("/login")
	public ResponseEntity<Studente> login(@RequestBody ArrayList<String> loginData) {
		try {
			Studente studenteLogin = studenteService.login(loginData.get(0), loginData.get(1));
			return new ResponseEntity<>(studenteLogin, HttpStatus.OK);
			
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
		}
	}


	@GetMapping("/findAll")
	public ResponseEntity<List<Studente>> findAll() {
		try {
			List<Studente> studenteList = studenteService.findAll();
			return new ResponseEntity<>(studenteList, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findByMatricola/{mat}")
	public ResponseEntity<Studente> findByMatricola(@PathVariable("mat") String matricola) {
		try {
			Studente studente = studenteService.findByMatricola(matricola);
			return new ResponseEntity<>(studente, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteByMatricola/{mat}")
	public ResponseEntity<String> deleteByMatricola(@PathVariable("mat") String matricola) {
		try {
			String mat_studente = studenteService.deleteByMatricola(matricola);
			return new ResponseEntity<>(mat_studente, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<String> insert(@RequestBody Studente studente) {
		try {
			String mat_studente = studenteService.insert(studente);
			return new ResponseEntity<>(mat_studente, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<String> update(@RequestBody Studente studente) {
		try {
			String mat_studente = studenteService.insert(studente);
			return new ResponseEntity<>(mat_studente, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
