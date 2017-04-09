package controllers;

import entities.Person;
import entities.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jerieshasmith on 4/2/17.
 */
@RestController
@RequestMapping("/rest/")
public class JsonRestController {

    @Autowired
    private PersonDao personDao;

    @RequestMapping("/")
    public String index() {
        return "<h1>Greetings from Spring Boot!</h1>" +
                "Use the following Commands:<br><br>" +
                "CREATE Person /rest/createPerson?name=[name]&address=[address]&phone=[phone]&birthDay=[birthDay]&email=[email]<br>" +
                "GET ALL People: /rest/getAllPeople<br>" +
                "GET Person BY ID: /rest/getPerson?id=[id]<br>" +
                "GET Person BY EMAIL: /rest/getPersonByEmail?email=[email]<br>" +
                "UPDATE Person: /rest/updatePerson?id=[id]&email=[email]&name=[name]<br>" +
                "DELETE Person: /rest/deletePerson?id=[id]<br><br><br><br>";
    }

    @RequestMapping("createPerson")
    public String create(String name, String address,String phone,String birthDay,String email) {
        try {
            Person person = new Person(name,address,phone,birthDay,email);
            personDao.save(person);
            return "person "+person.getId()+" created!";
        }
        catch (Exception e) {
            return "Error creating person: " + e.toString();
        }
    }

    @RequestMapping("getAllPeople")
    public Iterable<Person> getPerson() {
        return personDao.findAll();
    }

    @RequestMapping("getPerson")
    public Person getPerson(long id) {
        return personDao.findOne(id);
    }

    @RequestMapping("getPersonByEmail")
    public Person getByEmail(String email) {
        return personDao.findByEmail(email);
    }

    @RequestMapping("updatePerson")
    public String updatePerson(long id, String name, String address, String phone, String birthday, String email) {
        try {
            Person person = personDao.findOne(id);
            person.setName(name);
            person.setAddress(address);
            person.setPhone(phone);
            person.setBirthDay(birthday);
            person.setEmail(email);
            personDao.save(person);

            return "Person "+id+" updated!";
        }
        catch (Exception e) {
            return "Error updating person: " + e.toString();
        }
    }

    @RequestMapping("deletePerson")
    public String deleteUser(long id) {
        try {
            personDao.delete(personDao.findOne(id));
            return "Person "+id+" deleted!";
        }
        catch (Exception e) {
            return "Error deleting person:" + e.toString();
        }
    }
}

