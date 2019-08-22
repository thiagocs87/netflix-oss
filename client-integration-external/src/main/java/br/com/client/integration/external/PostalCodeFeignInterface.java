package br.com.client.integration.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.client.integration.external.dto.AddressDto;


@FeignClient(value = "postalCodeFeign", url = "${url-postal-code-api}")
public interface PostalCodeFeignInterface {

	@RequestMapping(method = RequestMethod.GET, path = "/{postalCode}/json")
	AddressDto getAddressInformation(@PathVariable(name = "postalCode") String postalCode);
}
