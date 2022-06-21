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

import erasmushub.entity.Ticket;
import erasmushub.service.TicketService;

@RestController
@RequestMapping("/ticket")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class TicketController {
	@Autowired
	private final TicketService ticketService;

	@Autowired
	public TicketController(TicketService ticketService) {
		this.ticketService = ticketService;
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Ticket>> findAll() {
		try {
			List<Ticket> ticketList = ticketService.findAll();
			return new ResponseEntity<>(ticketList, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Ticket> findById(@PathVariable("id") int id) {
		try {
			Ticket ticket = ticketService.findById(id);
			return new ResponseEntity<>(ticket, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/deleteById/{id}")
	public ResponseEntity<Integer> deleteById(@PathVariable("id") int id) {
		try {
			Integer id_ticket = ticketService.deleteById(id);
			return new ResponseEntity<>(id_ticket, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/insert")
	public ResponseEntity<Integer> insert(@RequestBody Ticket ticket) {
		try {
			Integer id_ticket = ticketService.insert(ticket);
			return new ResponseEntity<>(id_ticket, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/update")
	public ResponseEntity<Integer> update(@RequestBody Ticket ticket) {
		try {
			Integer id_ticket = ticketService.insert(ticket);
			return new ResponseEntity<>(id_ticket, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("findAllTicketByStudente/{mat}")
	public ResponseEntity<List<Ticket>> findAllTicketByStudente(@PathVariable("mat") String matricola) {
		try {
			List<Ticket> listTicket = ticketService.findAllTicketByStudente(matricola);
			return new ResponseEntity<>(listTicket, HttpStatus.OK);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
