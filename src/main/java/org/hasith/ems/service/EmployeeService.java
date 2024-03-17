package org.hasith.ems.service;

import org.hasith.ems.dto.EmployeeDTO;
import org.hasith.ems.entity.Employee;
import org.hasith.ems.entity.User;
import org.hasith.ems.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {

    public void insertEmployee(Employee employee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(employee);
        transaction.commit();
        session.close();
    }

    public void deleteEmployee(String id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        Employee entityToDelete = session.get(Employee.class,id);

        if (entityToDelete != null){
            session.delete(entityToDelete);
            transaction.commit();
        }

    }

    public boolean updateEmployee(int employee_id , EmployeeDTO updatedEmployee){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try{
            transaction = session.beginTransaction();
            Employee  employee = session.get(Employee.class,employee_id);

            if (employee != null){
                employee.setName(updatedEmployee.getName());
                employee.setPosition(updatedEmployee.getPosition());
                employee.setDepartment(updatedEmployee.getDepartment());
                employee.setHire_date(updatedEmployee.getHire_date());
                employee.setSalary(updatedEmployee.getSalary());

                session.update(employee);
                transaction.commit();
                return true;
            }else {
                return false;
            }

        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        finally {
            session.close();
        }
    }

    public List<Employee> searchEmployee(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        try{

            String hql = "FROM Employee";

            org.hibernate.query.Query<Employee> query = session.createQuery(hql, Employee.class);

            List<Employee> employees = query.getResultList();
            System.out.println(employees);

            return employees;

        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<>();
        } finally {
            //HibernateUtil.close();
        }
    }




}
