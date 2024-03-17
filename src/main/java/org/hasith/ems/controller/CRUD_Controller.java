package org.hasith.ems.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.hasith.ems.dto.EmployeeDTO;
import org.hasith.ems.entity.Employee;
import org.hasith.ems.service.EmployeeService;
import org.hasith.ems.service.UserService;
import org.hasith.ems.service.Validator;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

@Path("/employee-manage")
public class CRUD_Controller {

    @Context
    HttpServletRequest request;

    @Context
    HttpServletResponse response;

    @POST
    @Produces("application/json")
    public Response manageUsers(EmployeeDTO employeeDTO) {

//        System.out.println(employeeDTO.getName());
//        System.out.println(employeeDTO.getPosition());
//        System.out.println(employeeDTO.getDepartment());
//        System.out.println(employeeDTO.getHire_date());
//        System.out.println(employeeDTO.getHire_date().getClass());
//        System.out.println(employeeDTO.getSalary());

        boolean is_all_present = Validator.isPresent(employeeDTO);

        EmployeeService employeeService = new EmployeeService();
        LocalDate localDate;
        try {
            localDate = employeeDTO.getHire_date().toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();
        } catch (NullPointerException nullPointerException) {
            LocalDate today = LocalDate.now();
            LocalDate tomorrow = today.plusDays(1);
            Date tomorrowDate = Date.from(tomorrow.atStartOfDay(ZoneId.systemDefault()).toInstant());
            localDate = tomorrow;
            employeeDTO.setHire_date(tomorrowDate);
        }

        //System.out.println(is_all_present);

        if (
                is_all_present &&
                        Validator.validate_name(employeeDTO.getName()) &&
                        Validator.validate_position(employeeDTO.getPosition()) &&
                        Validator.validate_department(employeeDTO.getDepartment()) &&
                        Validator.validate_hire_date(localDate) &&
                        Validator.validate_salary(Float.toString(employeeDTO.getSalary()))
        ) {

            Employee employee = new Employee();
            employee.setName(employeeDTO.getName());
            employee.setPosition(employeeDTO.getPosition());
            employee.setDepartment(employeeDTO.getDepartment());
            employee.setHire_date(employeeDTO.getHire_date());
            employee.setSalary(employeeDTO.getSalary());

            employeeService.insertEmployee(employee);

            return Response.ok("\"{\\\"message\\\": \\\"success\\\"}\"", MediaType.APPLICATION_JSON_TYPE).build();

        } else {
            System.out.println("validation error");
            return Response.status(Response.Status.BAD_REQUEST).entity("\"{\\\"message\\\": \\\"Enter Valid Data for Employee\\\"}\"").type(MediaType.APPLICATION_JSON).build();
        }

    }

    @GET
    public Response searchUsers() {
        System.out.println("Searching Users");
        EmployeeService employeeService = new EmployeeService();
        List emploList = employeeService.searchEmployee();

        ObjectMapper objectMapper = new ObjectMapper();

        String JSONResp = null;
        try {
            JSONResp = objectMapper.writeValueAsString(emploList);
            System.out.println(JSONResp);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return Response.ok().entity(JSONResp).build();
    }

    @DELETE
    @Path("/{employeeId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteUser(@PathParam("employeeId") int employeeId){
       EmployeeService employeeService = new EmployeeService();
       employeeService.deleteEmployee(Integer.toString(employeeId));
    }

    @PUT
    @Path("/{employeeId}")
    public void update_user(@PathParam("employeeId") int employeeId, EmployeeDTO employeeDTO){
        EmployeeService employeeService = new EmployeeService();
        employeeService.updateEmployee(employeeId,employeeDTO);
    }

}
