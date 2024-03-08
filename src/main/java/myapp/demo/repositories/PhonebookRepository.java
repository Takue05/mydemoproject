package myapp.demo.repositories;

import myapp.demo.models.Phonebook;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhonebookRepository extends CrudRepository<Phonebook, String>{
    Phonebook findByPhone(String phone);
    Phonebook findByFirstname(String firstname);

    Phonebook findBySurname(String surname);

    Phonebook findByAddress(String address);

    void deleteByPhone(String phone);

    void updateBy(String phone);
}
