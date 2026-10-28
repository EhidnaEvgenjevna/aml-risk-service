package org.tl.aml;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    // @Disabled("TODO")
    // @DisplayName("Total exposure is the current account balance")
    void totalMonetaryExposureIsCurrentAccountBalance() {
        Customer customer = new Customer("c-1", "John", "Smith", new BigDecimal("1500.50"), Residency.EU);
        BigDecimal totalMoney = customer.getTotalMonetaryExposure();
        assertEquals(new BigDecimal("1500.50"), totalMoney);
        // TODO: customer with current account 1500.50 -> total exposure 1500.50
    }

    @Test
    @DisplayName("New customer has UNDEFINED risk class")
    void newCustomerHasUndefinedRiskClass() {
        // given
        Customer customer = new Customer("c-1", "John", "Smith", new BigDecimal("1500.50"), Residency.EU);

        // when
        RiskClass riskClass = customer.getRiskClass();

        // then
        assertEquals(RiskClass.UNDEFINED, riskClass);
    }

    @Test
    // @Disabled("TODO (task 1)")
    // @DisplayName("Total exposure is current account plus deposits")
    void totalMonetaryExposureIsSumOfBalances() {
        Customer customer = new Customer("c-1", "John", "Smith", new BigDecimal("1500.50"), Residency.NON_EU);
        customer.addDeposit(new BigDecimal("2500"));
        BigDecimal totalMoney = customer.getTotalMonetaryExposure();
        assertEquals(new BigDecimal("4000.50"), totalMoney);

        // TODO: current account 1500.50 + deposits 2500 -> total exposure 4000.50
    }
}
