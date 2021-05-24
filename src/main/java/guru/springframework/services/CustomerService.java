package guru.springframework.services;

import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CustomerService {

    List<CustomerDTO> getAllCustomers();

    CustomerDTO getCustomerByFirstName(String firstName);
    CustomerDTO getCustomerByLastName(String lastName);
    CustomerDTO getCustomerByCustomerUrl(String customerUrl);
    CustomerDTO getCustomerById(Long id);

    CustomerDTO createNewCustomer(CustomerDTO customerDTO);

    CustomerDTO saveCustomerByDTO(Long id, CustomerDTO customerDTO);

    CustomerDTO patchCustomer(Long id, CustomerDTO customerDTO);

    void deleteCustomerById(Long id);
}
