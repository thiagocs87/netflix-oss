package br.com.client.persistence;

import java.util.List;

import br.com.client.persistence.entity.Client;

public interface ClientPersistence{
	
	public Client save(Client place);
	public Client update(Client place, Long id);
	public Client get(Long id);
	public List<Client> list();
	public List<Client> list(String name);
	public boolean delete(Long id);	

	public default void merge(Client founded, Client client) {
		founded.setCity(client.getCity());
		founded.setName(client.getName());
		founded.setSurename(client.getSurename());
		founded.setState(client.getState());
	}

}