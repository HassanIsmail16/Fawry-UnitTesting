package example.account;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Unit tests for the {@link AccountManagerImpl} class.
 * <br>
 * Test naming scheme: given{precondition}_when{action}_then{expectedOutcome}
 */
public class AccountManagerTest {

    @Test
    void givenCustomerWithSufficientBalance_whenWithdraw_thenSucceed() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(1000);

        // Act
        String result = am.withdraw(c, 500);

        // Assert
        Assertions.assertThat(result).isEqualTo("success");
        Assertions.assertThat(c.getBalance()).isEqualTo(500);
    }

    @Test
    void givenCustomerWithInsufficientBalanceAndNoCreditNorVIP_whenWithdraw_thenInsufficientBalance() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        c.setCreditAllowed(false);
        c.setVip(false);

        // Act
        String result = am.withdraw(c, 200);

        // Assert
        Assertions.assertThat(result).isEqualTo("insufficient account balance");
        Assertions.assertThat(c.getBalance()).isEqualTo(100);
    }

    @Test
    void givenCustomerWithInsufficientBalanceAndCreditAllowed_whenWithdraw_thenSucceed() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        c.setCreditAllowed(true);
        c.setVip(false);

        // Act
        String result = am.withdraw(c, 200);

        // Assert
        Assertions.assertThat(result).isEqualTo("success");
        Assertions.assertThat(c.getBalance()).isEqualTo(-100);
    }

    @Test
    void givenCustomerWithInsufficientBalanceAndCreditLimitExceeded_whenWithdraw_thenSucceed() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        c.setCreditAllowed(true);

        // Act
        String result = am.withdraw(c, 2000);

        // Assert
        Assertions.assertThat(result).isEqualTo("maximum credit exceeded");
        Assertions.assertThat(c.getBalance()).isEqualTo(100);
    }

    @Test
    void givenCustomerWithInsufficientBalanceAndVip_whenWithdraw_thenSucceed() {
        // Arrange
        AccountManager am = new AccountManagerImpl();
        Customer c = new Customer();
        c.setBalance(100);
        c.setCreditAllowed(true);
        c.setVip(true);

        // Act
        String result = am.withdraw(c, 2000);

        // Assert
        Assertions.assertThat(result).isEqualTo("success");
        Assertions.assertThat(c.getBalance()).isEqualTo(-1900);
    }
}
