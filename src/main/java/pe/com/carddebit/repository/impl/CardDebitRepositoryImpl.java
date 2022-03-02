package pe.com.carddebit.repository.impl;

import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import pe.com.carddebit.model.CardDebit;
import pe.com.carddebit.repository.CardDebitRepository;

@Repository
public class CardDebitRepositoryImpl implements CardDebitRepository {
	
	private static final String KEY = "CardDebit";

	private RedisTemplate<String, CardDebit> redisTemplate;
	private HashOperations hashOperations;

	public CardDebitRepositoryImpl(RedisTemplate<String, CardDebit> redisTemplate) {
		this.redisTemplate = redisTemplate;
	}

	@PostConstruct
	private void init() {
		hashOperations = redisTemplate.opsForHash();
	}

	@Override
	public Map<String, CardDebit> findAll() {
		return hashOperations.entries(KEY);
	}

	@Override
	public CardDebit findById(String id) {
		return (CardDebit) hashOperations.get(KEY, id);
	}

	@Override
	public void save(CardDebit cardDebit) {
		 hashOperations.put(KEY, UUID.randomUUID().toString(), cardDebit);
	}

//	@Override
//	public Mono<CardYanki> save(CardYanki cardYanki) {
//		hashOperations.put(KEY, UUID.randomUUID().toString(), cardYanki);
//
//	}

}
