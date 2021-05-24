package guru.springframework.repositories;

import guru.springframework.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.function.Consumer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Customer findByFirstName(String firstName);
    Customer findByLastName(String lastName);
    Customer findByCustomerUrl(String customerUrl);
}
