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
import br.com.client.service.exceptions.AddressException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ClientServiceImpl implements ClientService {

	@Autowired
	private ClientPersistenceImpl persistence;

	@Autowired
	private PostalCodeFeignInterface postalFeign;

	public Client save(ClientDto client) {
		Address address;
		try {
			address = findAddress(client.getPostalCode());
		} catch (Exception e) {
			log.warn("c='ClientServiceImpl', m='save', client={}, msg='Error trying to find client address.', exception={}", client,e);
			throw new AddressException();
		}
		return persistence.save(transformClientDto(client, address));
	}

	@Override
	public Client update(ClientDto client, Long id) {
		Address address;
		try {
			address = findAddress(client.getPostalCode());
		} catch (Exception e) {
			log.warn("c='ClientServiceImpl', m='update', client={}, msg='Error trying to find client address.', exception={}", client,e);
			throw new AddressException();
		}
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
