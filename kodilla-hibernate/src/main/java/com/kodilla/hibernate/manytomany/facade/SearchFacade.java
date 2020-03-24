package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchFacade {

    private static final Logger LOGGER = LoggerFactory.getLogger(SearchFacade.class);

    @Autowired
    CompanyDao companyDao;

    @Autowired
    EmployeeDao employeeDao;

    public List<Company> searchCompany(String nameFragment) throws SearchException {
        if (nameFragment.length() == 0) {
            LOGGER.error(SearchException.ERR_NAME_FRAGMENT_IS_NULL);
            throw new SearchException(SearchException.ERR_NAME_FRAGMENT_IS_NULL);
        }

        LOGGER.info("Searching for Companies which names contains: " + nameFragment);
        List<Company> listOfCompaniesFound = companyDao.retrieveCompaniesThatContains(nameFragment);
        if (listOfCompaniesFound.size() == 0) {
            LOGGER.info("No companies found where name contains: " + nameFragment);
        }
        for (Company company : listOfCompaniesFound) {
            LOGGER.info("Company that matches the criteria: " + company.getName());
        }
        LOGGER.info("End of searching process.");

        return listOfCompaniesFound;
    }

    public List<Employee> searchEmployee(String nameFragment) throws SearchException {
        if (nameFragment.length() == 0) {
            LOGGER.error(SearchException.ERR_NAME_FRAGMENT_IS_NULL);
            throw new SearchException(SearchException.ERR_NAME_FRAGMENT_IS_NULL);
        }

        LOGGER.info("Searching for employees which last names contains: " + nameFragment);
        List<Employee> listOfEmployeesFound = employeeDao.findEmployeesThatContains(nameFragment);
        if (listOfEmployeesFound.size() == 0) {
            LOGGER.info("No employees found which last name contains: " + nameFragment);
        }
        for (Employee employee : listOfEmployeesFound) {
            LOGGER.info("Employees that matches the criteria: " +employee.getFirstname()+" "+ employee.getLastname());
        }
        LOGGER.info("End of searching process.");

        return listOfEmployeesFound;
    }
}
