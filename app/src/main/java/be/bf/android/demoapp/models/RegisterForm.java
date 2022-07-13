package be.bf.android.demoapp.models;

import android.util.Log;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
public class RegisterForm implements FormModel {
    @Required @MinLength(size = 4)
    private String firstName;
    @Required @MinLength(size = 4)
    private String lastName;
    @Required @MinLength(size = 10)
    private String birthDate;
    @Required @MinLength(size = 2)
    private String username;
    @Required @MinLength(size = 4)
    private String password;

    public String getFirstName() {
        return firstName;
    }

    public RegisterForm setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public RegisterForm setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public RegisterForm setBirthDate(String birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public RegisterForm setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public RegisterForm setPassword(String password) {
        this.password = password;
        return this;
    }

//    public boolean isValid() {
//        if (firstName == null) return false;
//        if (firstName.equals("")) return false;
//
//        if (lastName == null) return false;
//        if (lastName.equals("")) return false;
//
//
//        if (birthDate == null) return false;
//        if (birthDate.equals("")) return false;
//        //if(!birthDate.matches("../../....")) return false;
//
//        if (password == null) return false;
//        if (password.equals("")) return false;
//        if (password.length() < 4) return false;
//        if (password.length() > 12) return false;
//
//        return true;
//    }

}
