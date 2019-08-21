package br.com.client.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.client.persistence.ClientPersistenceImpl;
import br.com.client.persistence.entity.Client;
import br.com.client.service.dto.ClientDto;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientPersistenceImpl persistence;
	
	public Client save(ClientDto client) {
		return persistence.save(transformDto(client));
	}
	
	@Override
	public Client update(ClientDto client, Long id) {
		return persistence.update(transformDto(client), id);
	}

	@Override
	public Client get(Long id) {
		return persistence.get(id);
	}
	
	@Override
	public List<Client> list() {
		return persistence.list();
	}
	
	@Override
	public List<Client> list(String name) {
		return persistence.list(name);
	}
	
	@Override
	public boolean delete(Long id) {
		return persistence.delete(id);
	}	
}
