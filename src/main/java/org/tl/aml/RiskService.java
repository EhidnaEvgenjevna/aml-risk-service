package org.tl.aml;

import java.math.BigDecimal;

public class RiskService {

    static final BigDecimal MEDIUM_THRESHOLD = new BigDecimal("10000");
    static final BigDecimal HIGH_THRESHOLD = new BigDecimal("50000");

    /**
     * Calculates the risk class based on the customer's total monetary exposure: below 10,000 is
     * LOW, from 10,000 to 49,999.99 is MEDIUM, 50,000 and above is HIGH. Does not change the
     * customer.
     *
     * TODO (task 2): add validation. If customer == null or currentAccountBalance is null or
     * negative, throw IllegalArgumentException.
     *
     * TODO (task 3): return HIGH for every residency except EU, regardless of the amount.
     */
    public RiskClass classify(Customer customer) {
        // TODO (task 3): if customer residency is not EU, return RiskClass.HIGH here

        BigDecimal exposure = customer.getTotalMonetaryExposure();

        if (exposure.compareTo(MEDIUM_THRESHOLD) < 0) {
            return RiskClass.LOW;
        }
        if (exposure.compareTo(HIGH_THRESHOLD) < 0) {
            return RiskClass.MEDIUM;
        }
        return RiskClass.HIGH;
    }

    /** Calculates the risk class and stores it on the customer. */
    public void assess(Customer customer) {
        customer.setRiskClass(classify(customer));
    }
}
