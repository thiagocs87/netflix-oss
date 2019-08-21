package br.com.client.persistence;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.client.persistence.entity.Client;
import br.com.client.persistence.exception.ErrorOnTryGetClientException;
import br.com.client.persistence.exception.ErrorOnTryListClientException;
import br.com.client.persistence.exception.ErrorOnTryRemoveClientException;
import br.com.client.persistence.exception.ErrorOnTrySaveClientException;
import br.com.client.persistence.exception.ClientNotFoundException;
import br.com.client.persistence.repository.ClientRepository;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class ClientPersistenceImpl implements ClientPersistence {

	@Autowired
	private ClientRepository repository;

	@Override
	public Client save(Client client) {
		try {
			return repository.save(client);
		} catch (RuntimeException e) {
			log.warn("c='ClientPersistenceImpl', m='save', client={}, msg='Error on saving client.', exception={}", client,
					e);
			throw new ErrorOnTrySaveClientException();
		}
	}

	@Override
	public Client update(Client client, Long id) {
		try {
			Client founded = repository.findById(id).orElseThrow(ClientNotFoundException::new);
			this.merge(founded, client);
			return repository.save(founded);
		}catch (ClientNotFoundException e) {
			log.warn("c='ClientPersistenceImpl', m='delete', client={}, msg='Trying to update a unexisting client.', exception={}", client, e);
			return null;
		} catch (RuntimeException e) {
			log.warn("c='ClientPersistenceImpl', m='update', client={}, msg='Error on updating client.', exception={}",
					client, e);
			throw new ErrorOnTrySaveClientException();
		}
	}

	@Override
	public Client get(Long id) {
		try {
			return repository.findById(id).orElseThrow(ClientNotFoundException::new);
		}catch (ClientNotFoundException e) {
			log.warn("c='ClientPersistenceImpl', m='get', id={}, msg='Trying to find a unexisting client.', exception={}", id, e);
			return null;
		} catch (RuntimeException e) {
			log.warn("c='ClientPersistenceImpl', m='get', id={}, msg='Error on geting specific client.', exception={}", id, e);
			throw new ErrorOnTryGetClientException();
		}

	}

	@Override
	public List<Client> list() {
		try {
			return repository.findAll();
		} catch (RuntimeException e) {
			log.warn("c='ClientPersistenceImpl', m='list', msg='Error on listing clients.', exception={}", e);
			throw new ErrorOnTryListClientException();
		}
	}

	@Override
	public List<Client> list(String name) {
		try {
			return repository.findByNameContaining(name);
		} catch (RuntimeException e) {
			log.warn("c='ClientPersistenceImpl', m='list', name={}, msg='Error on listing clients by name.', exception={}", name, e);
			throw new ErrorOnTryListClientException();
		}
	}

	@Override
	public boolean delete(Long id) {
		try {
			Client founded = repository.findById(id).orElseThrow(ClientNotFoundException::new);
			repository.delete(founded);
			return true;
		}catch (ClientNotFoundException e) {
			log.warn("c='ClientPersistenceImpl', m='delete', msg='Trying to delete a unexisting client.', exception={}", e);
			return false;
		} catch (RuntimeException e) {
			log.warn("c='ClientPersistenceImpl', m='delete', msg='Error on deleting client.', exception={}", e);
			throw new ErrorOnTryRemoveClientException();
		}
	}

}
