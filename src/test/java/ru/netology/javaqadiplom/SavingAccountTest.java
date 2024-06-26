package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SavingAccountTest {

    @Test
    public void shouldAddLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(3_000);

        Assertions.assertEquals(2_000 + 3_000, account.getBalance());
    }

    @Test
    public void shouldAddMoreThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(9_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldAddNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.add(-5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayMoreThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldPayLessThanMinBalance() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(500);

        Assertions.assertEquals(1_500, account.getBalance());
    }

    @Test
    public void shouldPayNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                5
        );

        account.pay(-5_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldYearPercent() {
        SavingAccount account = new SavingAccount(
                2_000,
                1_000,
                10_000,
                20
        );

        account.yearChange();

        Assertions.assertEquals(400, account.yearChange());
    }

    @Test
    public void shouldBalanceWithYearPercentLessThanMaxBalance() {
        SavingAccount account = new SavingAccount(
                5_000,
                1_000,
                10_000,
                0
        );

        account.yearChange();

        Assertions.assertEquals(0, account.yearChange());
    }

    @Test
    public void shouldNotPayNegative() {
        SavingAccount account = new SavingAccount(
                2_000,
                2_000,
                10_000,
                5
        );

        account.pay(-3_000);

        Assertions.assertEquals(2_000, account.getBalance());
    }

    @Test
    public void shouldInitialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    -2_000,
                    2_000,
                    10_000,
                    5);

        });
    }


    @Test
    public void shouldInitialBalanceMoreThanMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(
                    15_000,
                    2_000,
                    10_000,
                    5);
        });
    }

    @Test
    public void shouldThrowIfRateNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(5_000, 1_000, 10_000, -10);
        });
    }

    @Test
    public void shouldThrowIfMinBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(5_000, -1_000, 10_000, 10);
        });
    }

    @Test
    public void shouldThrowIfinitialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(-5_000, 1_000, 10_000, 10);
        });
    }

    @Test
    public void shouldThrowIfMinBalanceMoreThanMaxBalance() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            SavingAccount account = new SavingAccount(5_000, 10_000, 1_000, 10);
        });
    }
}