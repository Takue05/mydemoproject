package myapp.demo.Controllers;

import myapp.demo.models.Phonebook;
import myapp.demo.services.PhonebookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/phonebook")
public class PhonebookController {

    private final PhonebookService phonebookService;

    public PhonebookController(PhonebookService phonebookService) {
        this.phonebookService = phonebookService;
    }
    @ResponseBody
    @PostMapping(value = "/create", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> create(@RequestBody Phonebook phonebook) {
        Phonebook returnedData =  phonebookService.createPhoneDetails(phonebook);
        return ResponseEntity.ok(returnedData);}


    @DeleteMapping(value = "/delete/{phone}", produces = "application/json")
    public ResponseEntity<String> deletePhoneDetails(@PathVariable String phone) {
        try {
            phonebookService.deletePhoneDetails(phone);
            return ResponseEntity.ok("Contact deleted successfully");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @PutMapping(value = "/update/{phone}", produces = "application/json", consumes = "application/json")
    public ResponseEntity<Object> updatePhoneDetails(@PathVariable String phone, @RequestBody Phonebook phonebook) {
        try {
            Phonebook updatedPhonebook = phonebookService.updatePhoneDetails(phone);
            return ResponseEntity.ok(updatedPhonebook);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
    @GetMapping("/get/{phone}")
    public ResponseEntity<Phonebook> readPhonebookByPhone(@PathVariable String phone) {
        try {
            Phonebook phonebook = phonebookService.readPhonebookByPhone(phone);
            return ResponseEntity.ok(phonebook);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }

}


