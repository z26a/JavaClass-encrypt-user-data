package ir.co.isc.encrypt.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import lombok.Setter;


/**
 * @author rbabaei
 */

@Slf4j
@Setter
@Getter
public class Agent {

    private long id;
    private String firstName;
    private String lastName;

    public Agent(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

//    public Agent() {
//    }

//    public long getId() {
//        return id;
//    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Agent{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}

