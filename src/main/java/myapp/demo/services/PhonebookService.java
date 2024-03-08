package myapp.demo.services;

import lombok.AllArgsConstructor;
import myapp.demo.models.Phonebook;
import myapp.demo.repositories.PhonebookRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PhonebookService {

    private final PhonebookRepository phonebookRepository;

    public Phonebook createPhoneDetails(Phonebook phonebook){

        Phonebook alreadyExistingPhone = phonebookRepository.findByPhone(phonebook.getPhone());
        Phonebook alreadyExistingFirstname = phonebookRepository.findByFirstname(phonebook.getFirstname());
        Phonebook alreadyExistingSurname = phonebookRepository.findBySurname(phonebook.getSurname());
        Phonebook alreadyExistingAddress = phonebookRepository.findByAddress(phonebook.getAddress());

        if(alreadyExistingPhone != null |alreadyExistingAddress!=null| alreadyExistingFirstname !=null || alreadyExistingSurname!=null){

            throw new RuntimeException("The number already exists") ;
        }

        return phonebookRepository.save(phonebook);


    }
    public void deletePhoneDetails(String phone) {
        Phonebook alreadyExistingPhone = phonebookRepository.findByPhone(phone);

        if (alreadyExistingPhone != null) {
            phonebookRepository.deleteByPhone(phone);
        } else {
            throw new RuntimeException("There is no such contact");
        }
    }
    public Phonebook updatePhoneDetails(String phone){
        Phonebook alreadyExistingPhone = phonebookRepository.findByPhone(phone);
        if (alreadyExistingPhone != null) {
            phonebookRepository.updateBy(phone);
        } else {
            throw new RuntimeException("There is no such contact");
        }
        return alreadyExistingPhone;

    }

    public Phonebook readPhonebookByPhone(String phone) {
        Phonebook alreadyexistingPhonebook = phonebookRepository.findByPhone(phone);

        if (alreadyexistingPhonebook != null) {
            return alreadyexistingPhonebook;
        } else {
            throw new RuntimeException("There is no such contact.");
        }

    }

}