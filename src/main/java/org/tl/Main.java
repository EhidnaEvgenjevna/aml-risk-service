package org.tl;

import java.math.BigDecimal;
import java.util.List;
import org.tl.aml.Customer;
import org.tl.aml.Residency;
import org.tl.aml.RiskClass;
import org.tl.aml.RiskService;

public class Main {
    public static void main(String[] args) {
        RiskService riskService = new RiskService();

        List<Customer> customers = List.of(
                new Customer("c-1", "John", "Smith", new BigDecimal("500"), Residency.EU),
                new Customer("c-2", "Anna", "Tamm", new BigDecimal("25000"), Residency.US),
                new Customer("c-3", "Mark", "Kask", new BigDecimal("120000"),Residency.NON_EU));

        for (Customer customer : customers) {
            RiskClass before = customer.getRiskClass();
            riskService.assess(customer);
            System.out.println(customer.getFirstName() + " " + customer.getLastName() + " "
                    + customer.getTotalMonetaryExposure() + ": " + before + " -> " + customer.getRiskClass());
        }
    }
}
