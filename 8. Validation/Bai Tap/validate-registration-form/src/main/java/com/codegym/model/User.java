package com.codegym.model;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;


@Component
public class User {

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[\\D]*",message = "Tên phải là Chữ")
    @Pattern(regexp = "^[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][\\D]*"
            ,message = "Tên phải viết hoa chữ đầu")
    @Pattern(regexp = "^\\S*[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][\\D]*"
            ,message = "Tên không được có khoảng cách đầu dòng ")
    private String firstName;

    @NotBlank(message = "Tên không được để trống")
    @Pattern(regexp = "^[\\D]*",message = "Tên phải là Chữ")
    @Pattern(regexp = "^[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][\\D]*"
            ,message = "Tên phải viết hoa chữ đầu")
    @Pattern(regexp = "^\\S*[A-ZÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰỲỴÝỶỸ][\\D]*"
            ,message = "Tên không được có khoảng cách đầu dòng ")
    private String lastName;

    @NotBlank(message = "Số điện thoại không được bỏ trống")
//@Pattern(regexp = "^(0\\d{9,11})$",message = "Số điện thoại phải là số và bắt đầu từ số 0 và phải từ 10 tới 11 số")
    @Pattern(regexp = "^\\d*",message = "Số điện thoại phải là số")
    @Pattern(regexp = "^0\\d*",message = "Số điện thoại phải bắt đầu từ số 0")
    @Pattern(regexp = "^(\\d{10})*",message = "Số điện thoại phải đủ 10 số")
    private String phoneNumber;


    @Min(value = 18, message = "Tuổi phải trên 18")
    private int age;

    @NotBlank(message = "Email không được để trống")
    @Pattern(regexp = "^\\D([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message = "Email không đúng định dạng")
    @Pattern(regexp = "^\\D([a-z0-9_\\.-]{5,})@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$",
            message = "Email phải có trên 5 kí tự")
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

//    @Override
//    public boolean supports(Class<?> clazz) {
//        return User.class.isAssignableFrom(clazz);
//    }
//
//    @Override
//    public void validate(Object target, Errors errors) {
//
//        User user = (User) target;
//        String phoneNumber = user.getPhoneNumber();
//        ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "phoneNumber.empty");
//        if (phoneNumber.length() > 11 || phoneNumber.length() < 10) {
//            errors.rejectValue("phoneNumber", "phoneNumber.length");
//        }
//        if (!phoneNumber.startsWith("0")) {
//            errors.rejectValue("phoneNumber", "phoneNumber.startsWith");
//        }
//        if (!phoneNumber.matches("(^$|[0-9]*$)")) {
//            errors.rejectValue("phoneNumber", "phoneNumber.matches");
//        }
//    }
}
