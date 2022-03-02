package pe.com.carddebit.repository;

import java.util.Map;

import pe.com.carddebit.model.CardDebit;


public interface CardDebitRepository {
 Map<String, CardDebit> findAll();
	 
     CardDebit findById(String id);
	 
	 void save(CardDebit cardYanki);
	  
}
