package com.ugo.uchegbu.model;

import java.io.Serializable;

/**
 * Created by Ugo on 11/04/2015.
 */

public class User extends BaseModel implements Serializable {

    private String firstName;
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString(){
        return "Name: "+ this.firstName +" Last Name: "+this.lastName+" Id: "+ super.getUserId();
    }
}
