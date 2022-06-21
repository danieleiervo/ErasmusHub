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

import erasmushub.entity.Ticket2Associazione;
import erasmushub.service.Ticket2AssociazioneService;

@RestController
@RequestMapping("/ticketassociazione")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Ticket2AssociazioneController {
	@Autowired
	private final Ticket2AssociazioneService ticketassociazioneService;

	@Autowired
	public Ticket2AssociazioneController(Ticket2AssociazioneService ticketassociazioneService) {
		this.ticketassociazioneService = ticketassociazioneService;
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Ticket2Associazione>> findAll() {
		try {
			List<Ticket2Associazione> ticketassociazioneList = ticketassociazioneService.findAll();
			return new ResponseEntity<>(ticketassociazioneList, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Ticket2Associazione> findById(@PathVariable("id") int id) {
		try {
			Ticket2Associazione ticketassociazione = ticketassociazioneService.findById(id);
			return new ResponseEntity<>(ticketassociazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable("id") int id) {
		try {
			Integer id_ticketassociazione = ticketassociazioneService.deleteById(id);
			return new ResponseEntity<>(id_ticketassociazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<Integer> insert(@RequestBody Ticket2Associazione ticketassociazione) {
		try {
			Integer id_ticketassociazione = ticketassociazioneService.insert(ticketassociazione);
			return new ResponseEntity<>(id_ticketassociazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody Ticket2Associazione ticketassociazione) {
		try {
			Integer id_ticketassociazione = ticketassociazioneService.insert(ticketassociazione);
			return new ResponseEntity<>(id_ticketassociazione, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
