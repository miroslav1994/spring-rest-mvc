package guru.springframework.bootstrap;

import guru.springframework.api.v1.mapper.CustomerMapper;
import guru.springframework.domain.Category;
import guru.springframework.domain.Customer;
import guru.springframework.repositories.CategoryRepository;
import guru.springframework.repositories.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Bootstrap implements CommandLineRunner {

    private final CategoryRepository categoryRespository;
    private final CustomerRepository customerRepository;

    public Bootstrap(CategoryRepository categoryRespository, CustomerRepository customerRepository) {
        this.categoryRespository = categoryRespository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Category fruits = new Category();
        fruits.setName("Fruits");

        Category dried = new Category();
        dried.setName("Dried");

        Category fresh = new Category();
        fresh.setName("Fresh");

        Category exotic = new Category();
        exotic.setName("Exotic");

        Category nuts = new Category();
        nuts.setName("Nuts");

        categoryRespository.save(fruits);
        categoryRespository.save(dried);
        categoryRespository.save(fresh);
        categoryRespository.save(exotic);
        categoryRespository.save(nuts);

        Customer c1 = new Customer();
        c1.setId(1L);
        c1.setFirstName("Miroslav");
        c1.setLastName("Perović");

        customerRepository.save(c1);

        Customer c2 = new Customer();
        c2.setId(2L);
        c2.setFirstName("Miso");
        c2.setLastName("Radonjic");

        customerRepository.save(c2);

        System.out.println("Data Loaded = " + categoryRespository.count() );
    }

}