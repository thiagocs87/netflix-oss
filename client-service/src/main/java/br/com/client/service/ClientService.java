package br.com.client.service;

import java.util.List;

import org.springframework.hateoas.Link;

import br.com.client.integration.external.dto.AddressDto;
import br.com.client.persistence.entity.Address;
import br.com.client.persistence.entity.Client;
import br.com.client.service.dto.ClientDto;

public interface ClientService {

	public Client save(ClientDto client);
	public Client update(ClientDto client, Long id);
	public Client get(Long id);
	public List<Client> list();
	public List<Client> list(String name);
	public boolean delete(Long id);
	public Address findAddress(String postalCode);
	
	public default Client transformClientDto(ClientDto client, Address address) {
		return new Client(client.getName(), client.getSurename(), address);
	}
	
	public default Address transformAddressDto(AddressDto address) {
		return new Address(address.getCep(), address.getLogradouro(), address.getComplemento(), address.getBairro(), address.getLocalidade(), address.getUf());
	}

}