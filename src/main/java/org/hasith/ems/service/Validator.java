package org.hasith.ems.service;

import org.hasith.ems.dto.EmployeeDTO;
import org.hasith.ems.dto.UserDTO;

import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static boolean validate_name(String name){
        Pattern pattern = Pattern.compile("^[A-Za-z ]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();

    }
    public static boolean validate_position(String position){
        Pattern pattern = Pattern.compile("^[A-Za-z]+$|^[A-Za-z]*-[A-Za-z]*$");
        Matcher matcher = pattern.matcher(position);
        return matcher.matches();
    }
    public static boolean validate_department(String department){
        Pattern pattern = Pattern.compile("^[A-Za-z]+$|^[A-Za-z]*-[A-Za-z]*$");
        Matcher matcher = pattern.matcher(department);
        return matcher.matches();
    }
    public static boolean validate_hire_date(LocalDate givenDate){
        LocalDate currentDate = LocalDate.now();
        return givenDate.isEqual(currentDate) || givenDate.isBefore(currentDate);
    }
    public static boolean validate_salary(String number){

        Pattern pattern = Pattern.compile("^[1-9]\\d*(\\.\\d{1,2})?$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }

    public static boolean isPresent(EmployeeDTO employeeDTO){
        if (
                !employeeDTO.getName().equals("") &&
                !employeeDTO.getPosition().equals("") &&
                !employeeDTO.getDepartment().equals("") &&
                employeeDTO.getHire_date() != null &&
                        employeeDTO.getSalary() != 0.0
        ){
            return true;
        }else {
            return false;
        }
    }
}
