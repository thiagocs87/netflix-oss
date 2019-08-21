package br.com.client.service;

import java.util.List;

import br.com.client.persistence.entity.Client;
import br.com.client.service.dto.ClientDto;

public interface ClientService {

	public Client save(ClientDto client);
	public Client update(ClientDto client, Long id);
	public Client get(Long id);
	public List<Client> list();
	public List<Client> list(String name);
	public boolean delete(Long id);
	
	public default Client transformDto(ClientDto client) {
		return new Client(client.getName(), client.getSurename(), client.getCity(), client.getState().name());
	}

}