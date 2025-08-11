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



}
