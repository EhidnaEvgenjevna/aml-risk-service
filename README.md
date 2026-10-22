# AML Risk Service

A training service: assesses the risk class `LOW / MEDIUM / HIGH` of a customer based on their total monetary exposure
(currently `currentAccountBalance`; deposits are added in task 1).

A new customer has risk class `UNDEFINED`. `RiskService.classify` only calculates the class,
`RiskService.assess` calculates it and stores it on the customer.

| Amount              | Class  |
|---------------------|--------|
| < 10,000            | LOW    |
| 10,000 – 49,999.99  | MEDIUM |
| ≥ 50,000            | HIGH   |

## Stack
Java 21, Gradle, Lombok, JUnit 5, Spotless (Palantir Java Format).

## Commands
```bash
./gradlew spotlessApply   # format the code — run before every commit
./gradlew build           # compile + tests + format check
./gradlew test            # tests only
./gradlew run             # run the demo (org.tl.Main)
```

## IntelliJ IDEA
- Install the Lombok plugin (usually bundled).
- Settings → Build → Compiler → Annotation Processors → **Enable annotation processing**.

## CI
GitHub Actions (`.github/workflows/ci.yml`) runs on every push to `main` and on every PR:
1. `./gradlew spotlessCheck` — the code is formatted;
2. `./gradlew build` — the project compiles and tests pass.

Tasks to complete are in [TASKS.md](TASKS.md).
