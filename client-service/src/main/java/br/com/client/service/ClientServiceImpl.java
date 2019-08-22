package br.com.client.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.hateoas.Link;
import org.springframework.stereotype.Service;

import br.com.client.integration.external.PostalCodeFeignInterface;
import br.com.client.integration.external.dto.AddressDto;
import br.com.client.persistence.ClientPersistenceImpl;
import br.com.client.persistence.entity.Address;
import br.com.client.persistence.entity.Client;
import br.com.client.service.dto.ClientDto;

@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientPersistenceImpl persistence;
	
	@Autowired
	private PostalCodeFeignInterface postalFeign;
	
	public Client save(ClientDto client) {
		Address address = findAddress(client.getPostalCode());
		return persistence.save(transformClientDto(client, address));
	}
	
	@Override
	public Client update(ClientDto client, Long id) {
		Address address = findAddress(client.getPostalCode());
		return persistence.update(transformClientDto(client, address), id);
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

	@Override
	public Address findAddress(String postalCode) {
		return transformAddressDto(postalFeign.getAddressInformation(postalCode));
		
	}

}
