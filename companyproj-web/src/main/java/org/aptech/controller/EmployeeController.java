package org.aptech.controller;

import org.aptech.entities.Company;
import org.aptech.entities.Employee;
import org.aptech.services.EmployeeService;

import javax.ejb.EJB;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(urlPatterns = "/employee")
public class EmployeeController extends HttpServlet {



    @EJB
    EmployeeService<Employee> employeeService;
    @EJB
    EmployeeService<Company> companyService;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getServletContext().getRequestDispatcher("WEB-INF/Insert.jsp").forward(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String empId = request.getParameter("empId");
        String empName = request.getParameter("empName");
        String comId = request.getParameter("comId");
        String comIdName = request.getParameter("comIdName");
        String comName= request.getParameter("comName");


        Company newCompany = new Company();
        newCompany.setCompanyId(comIdName);
        newCompany.setCompanyName(comName);

        companyService.addEntity(newCompany);


        Company company = new Company();
        company.setCompanyId(comIdName);

        Set<Company> companies = new HashSet<>();
        companies.add(company);
        companies.add(newCompany);

        Employee employee = new Employee();
        employee.setEmployeeId(empId);
        employee.setEmployeeName(empName);
        employee.setCompanies(companies);

        if (employeeService.addEntity(employee)){
            response.getWriter().write("Insert employee Succes");
        }else {
            response.getWriter().write("Insert employee Fail.");
        }


    }
}
