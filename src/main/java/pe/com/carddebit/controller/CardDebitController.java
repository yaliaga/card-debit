package pe.com.carddebit.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.com.carddebit.model.CardDebit;
import pe.com.carddebit.repository.CardDebitRepository;


@RestController
@RequestMapping("/cards")
public class CardDebitController {
	
	@Autowired
	private CardDebitRepository cardDebitRepository;

	public CardDebitController(CardDebitRepository cardDebitRepository) {
		this.cardDebitRepository = cardDebitRepository;
	}

	@GetMapping("/cards")
	public Map<String, CardDebit> findAll() {
		return cardDebitRepository.findAll();
	}

	@GetMapping("/cards/{id}")
	public CardDebit findById(@PathVariable String id) {
		return cardDebitRepository.findById(id);
	}

	@PostMapping("/create")
	public void createCardDebit(@RequestBody CardDebit cardDebit) {
		cardDebitRepository.save(cardDebit);
	}

}
