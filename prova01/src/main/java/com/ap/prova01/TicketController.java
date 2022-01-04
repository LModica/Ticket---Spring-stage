package com.ap.prova01;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

	private final TicketRepository ticketRepository;
	
	TicketController(TicketRepository repository) {
		ticketRepository = repository;
	}
	
	@GetMapping("/tickets")
	Iterable<Ticket> getTickets(){
		return ticketRepository.findAll();
	}
	
	@GetMapping("/tickets/{ticketId}")
	Ticket getTicket(@PathVariable Long ticketId){
		return ticketRepository.findById(ticketId).orElseThrow();
	}
	
	@PostMapping("/tickets")
	Ticket createTicket(@RequestBody Ticket newTicket) {
		return ticketRepository.save(newTicket);
	}
	
	@PutMapping("/tickets/{ticketId}")
	Ticket updateTicket(@PathVariable Long ticketId, @RequestBody Ticket ticketDto) {
		Ticket ticketToUpdate = ticketRepository.findById(ticketId).orElseThrow();
		ticketToUpdate.setTitle(ticketDto.getTitle());
		ticketToUpdate.setContent(ticketDto.getContent());
		return ticketRepository.save(ticketToUpdate);
	}
	
	@DeleteMapping("/tickets/{ticketId}")
	void deleteTicket(@PathVariable Long ticketId){
		Ticket ticket = ticketRepository.findById(ticketId).orElseThrow();
		ticketRepository.delete(ticket); 
	}
	
}
