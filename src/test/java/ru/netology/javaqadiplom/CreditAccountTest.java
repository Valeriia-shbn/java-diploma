package ru.netology.javaqadiplom;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CreditAccountTest {

    @Test
    public void shouldAddToPositiveBalance() {
        CreditAccount account = new CreditAccount(
                1_000,
                5_000,
                15
        );

        account.add(3_000);

        Assertions.assertEquals(4_000, account.getBalance());
    }

    @Test
    public void shouldNotAddNegativeAmount() {
        CreditAccount account = new CreditAccount(
                1000,
                5000,
                15
        );

        account.add(-3000);

        Assertions.assertEquals(1000, account.getBalance());
    }

    @Test
    public void shouldThrowIfInitialBalanceNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(-100, 100, 10);
        });

    }

    @Test
    public void shouldThrowIfRateNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(100, 100, -10);
        });

    }

    @Test
    public void shouldThrowIfCreditLimitNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            CreditAccount account = new CreditAccount(100, -100, 10);
        });

    }

    @Test
    public void shouldPay() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        account.pay(500);
        int actual = account.getBalance();
        int expected = 500;
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void shouldNotPayIfAmountNegative() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        account.pay(-500);
        int actual = account.getBalance();
        int expected = 1000;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotPayIfBalanceGoesBelowLimit() {
        CreditAccount account = new CreditAccount(1000, 2000, 10);
        account.pay(5000);
        int actual = account.getBalance();
        int expected = 1000;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldAssertYearChange() {
        CreditAccount account = new CreditAccount(100, 2000, 15);
        account.pay(250);
        int actual = account.yearChange();
        int expected = account.getBalance() * account.rate / 100;
        Assertions.assertEquals(expected, actual);
    }
}



