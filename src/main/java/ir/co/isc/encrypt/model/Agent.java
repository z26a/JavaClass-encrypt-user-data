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

    public void setId(long id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Agent{" + "firstName=" + firstName + ", lastName=" + lastName + '}';
    }

}

