package org.tl.aml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RiskServiceTest {

    private final RiskService riskService = new RiskService();

    private static Customer createNewCustomer(String currentAccountBalance) {
        return new Customer("c-1", "John", "Smith", new BigDecimal(currentAccountBalance));
    }

    @Test
    @DisplayName("Small exposure is LOW")
    void classifySmallExposureAsLow() {
        // given
        Customer customer = createNewCustomer("500");

        // when
        RiskClass result = riskService.classify(customer);

        // then
        assertEquals(RiskClass.LOW, result);
    }

    @Test
    @DisplayName("Medium exposure is MEDIUM")
    void classifyMediumExposureAsMedium() {
        Customer customer = createNewCustomer("25000");
        RiskClass result = riskService.classify(customer);
        assertEquals(RiskClass.MEDIUM, result);
    }

    @Test
    @DisplayName("Large exposure is HIGH")
    void classifyLargeExposureAsHigh() {
        Customer customer = createNewCustomer("120000");
        RiskClass result = riskService.classify(customer);
        assertEquals(RiskClass.HIGH, result);
        // TODO: customer with 120000 -> HIGH
    }

    @Test
    @Disabled("TODO")
    @DisplayName("Exposure exactly at the MEDIUM threshold is MEDIUM")
    void classifyExposureAtMediumThresholdAsMedium() {
        // TODO: customer with 10000 -> MEDIUM
    }

    @Test
    @Disabled("TODO")
    @DisplayName("Exposure exactly at the HIGH threshold is HIGH")
    void classifyExposureAtHighThresholdAsHigh() {
        // TODO: customer with 50000 -> HIGH
    }

    @Test
    @DisplayName("Assess stores the risk class on the customer")
    void assessStoresRiskClass() {
        Customer customer = createNewCustomer("130000");
        riskService.assess(customer);
        assertEquals(RiskClass.HIGH, customer.getRiskClass());

    }

    @Test
    @Disabled("TODO")
    @DisplayName("Classify does not change the customer")
    void classifyDoesNotChangeCustomer() {
        // TODO: after classify(), customer still has risk class UNDEFINED
    }

    @Test
    @Disabled("TODO (task 1)")
    @DisplayName("Classify uses current account plus deposits")
    void classifyUsesTotalExposureWithDeposits() {
        // TODO: current account 30000 + deposits 25000 -> HIGH
    }

    @Test
    @Disabled("TODO (task 2)")
    @DisplayName("Classify rejects null customer")
    void classifyRejectsNullCustomer() {
        // TODO: assertThrows(IllegalArgumentException.class, ...)
    }

    @Test
    @Disabled("TODO (task 2)")
    @DisplayName("Classify rejects null balance")
    void classifyRejectsNullBalance() {
        // TODO: assertThrows(IllegalArgumentException.class, ...)
    }

    @Test
    @Disabled("TODO (task 2)")
    @DisplayName("Classify rejects negative balance")
    void classifyRejectsNegativeBalance() {
        // TODO: assertThrows(IllegalArgumentException.class, ...)
    }

    @Test
    @Disabled("TODO (task 3)")
    @DisplayName("EU resident is classified by amount")
    void classifyEuResidentByAmount() {
        // TODO: EU resident with 500 -> LOW
    }

    @Test
    @Disabled("TODO (task 3)")
    @DisplayName("Non-EU residency is HIGH")
    void classifyNonEuResidencyAsHigh() {
        // TODO: US, NON_EU and UNDEFINED residents with 500 -> HIGH
    }
}
