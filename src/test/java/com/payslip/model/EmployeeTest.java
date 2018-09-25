package com.payslip.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class EmployeeTest {

    @Test
    public void shouldReturnEmployeeObjectNonNull() {
        Employee employee = new Employee();

        assertNotNull(employee);
    }

    @Test
    public void shouldReturnEmployeeObjectDetails() {
        Employee employee = new Employee.Builder()
                .setFirstName("David")
                .setLastName("Rudd").build();

        assertNotNull(employee);
        assertEquals("David", employee.getFirstName());
        assertEquals("Rudd", employee.getLastName());
    }
}
