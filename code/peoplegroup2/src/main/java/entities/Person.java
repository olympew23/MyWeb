package entities;

import javax.persistence.*;

/**
 * Created by jerieshasmith on 4/2/17.
 */
@Entity
@Table(name = "people")
public class Person {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String name;


    private String address;


    private String phone;


    private String birthDay;


    private String email;


    public Person(){
    }
    public Person(long id){this.id = id;}
    public Person(String name, String address, String phone, String birthDay, String email) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.birthDay = birthDay;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}