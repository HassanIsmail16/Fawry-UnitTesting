package example.store;

import example.account.AccountManager;
import example.account.Customer;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for the {@link StoreImpl} class.
 * <br>
 * Test naming scheme: {methodName}_{condition}_{expectedOutcome}
 */
public class StoreTest {

    @Test
    void buy_sufficientBalanceAndStock_shouldReduceProductQuantity() {
        // Arrange
        AccountManager accountManager = mock(AccountManager.class);
        when(accountManager.withdraw(any(), anyInt())).thenReturn("success");
        Store store = new StoreImpl(accountManager);
        Product product = new Product();
        product.setQuantity(4);
        Customer customer = new Customer();

        // Act
        store.buy(product, customer);

        // Assert
        Assertions.assertThat(product.getQuantity()).isEqualTo(3);
    }
}
