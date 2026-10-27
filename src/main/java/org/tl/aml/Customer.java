package org.tl.aml;

import java.math.BigDecimal;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Customer {

    private String id;
    private String firstName;
    private String lastName;
    private BigDecimal currentAccountBalance;
    private BigDecimal depositBalance;
    private Residency residency;

    // TODO (task 1): add depositBalance field

    // TODO (task 3): add residency field (see Residency), UNDEFINED by default

    /** Risk class assigned by the last assessment, UNDEFINED until the customer is assessed. */
    private RiskClass riskClass;

    public Customer(String id, String firstName, String lastName, BigDecimal currentAccountBalance, Residency residency) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.currentAccountBalance = currentAccountBalance;
        this.riskClass = RiskClass.UNDEFINED;
        this.depositBalance = BigDecimal.ZERO;
        this.residency = residency;
    }

    public void addDeposit(BigDecimal moneyForDeposit) {
        depositBalance = depositBalance.add(moneyForDeposit);
    }
    /**
     * Total amount the bank is exposed to by this customer.
     *
     * TODO (task 1): include depositBalance, total = currentAccountBalance + depositBalance.
     */
    public BigDecimal getTotalMonetaryExposure() {
        BigDecimal totalMoney = currentAccountBalance.add(depositBalance);
        return totalMoney;
    }
}
