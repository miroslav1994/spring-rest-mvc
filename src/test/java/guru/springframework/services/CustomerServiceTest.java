package guru.springframework.services;

import guru.springframework.api.v1.mapper.CategoryMapper;
import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CustomerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.hibernate.mapping.Array;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedConstruction;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CustomerServiceTest {

    private static final Long ID = 1L;
    private static final String firstName = "Miroslav";
    private static final String lastName = "Perović";


    CustomerService customerService;

    @Mock
    CustomerRepository customerRepository;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        customerService = new CustomerServiceImpl(customerRepository, CustomerMapper.INSTANCE);

    }

    @Test
    void getAllCustomers() {

        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setFirstName("Miroslav");
        c1.setLastName("Perović");

        Customer c2 = new Customer();
        c2.setId(2L);
        c2.setFirstName("Marko");
        c2.setLastName("Marković");

        List<Customer> customers = Arrays.asList(c1, c2);

        when(customerRepository.findAll()).thenReturn(customers);

        List<CustomerDTO> customersDTO = customerService.getAllCustomers();

        assertEquals(2, customersDTO.size());
    }

    @Test
    void getCustomerById() {

        Customer c = new Customer();
        c.setId(1L);
        c.setFirstName("Miroslav");
        c.setLastName("Perović");

        Optional<Customer> customer = Optional.of(c);

        when(customerRepository.findById(anyLong())).thenReturn(customer);

        CustomerDTO customerDTO = customerService.getCustomerById(1L);

        assertEquals(ID, customerDTO.getId());
        assertEquals(firstName, customerDTO.getFirstName());
        assertEquals(lastName, customerDTO.getLastName());
    }

    void createNewCustomer() throws Exception {

        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        CustomerDTO savedCustomerDTO = customerService.createNewCustomer(customerDTO);

        assertEquals(customerDTO.getFirstName(), savedCustomerDTO.getFirstName());
        assertEquals("/api/v1/customer/1", savedCustomerDTO.getCustomerUrl());

    }

    @Test
    public void saveCustomerByDTO() throws Exception {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setFirstName("Jim");

        Customer savedCustomer = new Customer();
        savedCustomer.setFirstName(customerDTO.getFirstName());
        savedCustomer.setLastName(customerDTO.getLastName());
        savedCustomer.setId(1l);

        when(customerRepository.save(any(Customer.class))).thenReturn(savedCustomer);

        //when
        CustomerDTO savedDto = customerService.saveCustomerByDTO(1L, customerDTO);

        //then
        assertEquals(customerDTO.getFirstName(), savedDto.getLastName());
        assertEquals("/api/v1/customer/1", savedDto.getCustomerUrl());
    }

    @Test
    public void deleteCustomerById() throws Exception {

        Long id = 1L;

        customerService.deleteCustomerById(id);

        verify(customerRepository, times(1)).deleteById(anyLong());
    }
}