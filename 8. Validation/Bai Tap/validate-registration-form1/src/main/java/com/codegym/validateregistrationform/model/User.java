package com.codegym.validateregistrationform.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


@Component
public class User implements Validator {
    @NotBlank
    @Size(min = 5, max = 45, message = "First Name có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String firstName;
    @NotBlank
    @Size(min = 5, max = 45, message = "Last Name có độ dài tối thiểu 5, tối đa 45 ký tự")
    private String lastName;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    @Min(value = 18, message = "Phải trên 18 tuổi")
    private int age;
    @NotBlank
    @Email
    private String email;

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        User user = (User) target;
        String number = user.getPhoneNumber();
        ValidationUtils.rejectIfEmpty(errors, "number", "number.empty");
        if (number.length() > 11 || number.length() < 10) {
            errors.rejectValue("number", "number.length");
        }
        if (!number.startsWith("0")) {
            errors.rejectValue("number", "number.startsWith");
        }
        if (!number.matches("(^$|[0-9]*$)")) {
            errors.rejectValue("number", "number.matches");
        }
    }
}
