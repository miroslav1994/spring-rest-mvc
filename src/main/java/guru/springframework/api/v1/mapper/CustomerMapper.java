package guru.springframework.api.v1.mapper;

import guru.springframework.api.v1.model.CustomerDTO;
import guru.springframework.domain.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDTOToCustomer(CustomerDTO customerDTO);
}
