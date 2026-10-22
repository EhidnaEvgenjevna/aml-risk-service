# Tasks

Code lives in `src/main/java/org/tl/aml/`, tests in `src/test/java/org/tl/aml/`.
Reference examples: `RiskServiceTest.classifySmallExposureAsLow` and `CustomerTest.newCustomerHasUndefinedRiskClass` —
the only implemented tests.

## Task 0. Test stubs
All other tests in `RiskServiceTest` and `CustomerTest` are stubs marked `@Disabled("TODO")`.
Implement each one following the reference example and remove `@Disabled`.
Stubs marked `@Disabled("TODO (task N)")` belong to task N below.

## Task 1. Deposits
Customers can have money not only on the current account but also on deposits.

1. Add a `depositBalance` field (`BigDecimal`) to `Customer`.
2. `getTotalMonetaryExposure()` must return `currentAccountBalance + depositBalance`.
3. Add `depositBalance` as a parameter of the `Customer` constructor and fix existing tests and `Main`.

Tests: total exposure is the sum of both balances (`CustomerTest`); `classify` uses the total,
e.g. current account 30,000 + deposits 25,000 → `HIGH`, while each balance alone would be `MEDIUM`.

## Task 2. Validation in `classify`
Throw `IllegalArgumentException` if:
- `customer == null`;
- a balance is `null`;
- a balance is negative.

Tests: one per case using `assertThrows`. Zero balances are still `LOW`.

## Task 3. Residency
1. Fill the enum `Residency` (stub already exists) with values `UNDEFINED`, `EU`, `US`, `NON_EU`.
2. Add a `residency` field to `Customer`, `UNDEFINED` by default (set in the constructor).
3. In `classify`: if residency is anything except `EU`, return `HIGH` regardless of the amount.
   EU residents are classified by amount as before.

Tests: EU resident with 500 → `LOW`; `US`, `NON_EU` and `UNDEFINED` residents with 500 → `HIGH`.

## How to submit
1. Create a branch per task, e.g. `git checkout -b task-1-deposits`.
2. Implement the code and tests.
3. `./gradlew spotlessApply build` — must end with `BUILD SUCCESSFUL`.
4. Open a Pull Request. The task is done when CI is green.
