package accumulator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

/**
 * Test class for Accumulator.
 * <br>
 * Test naming scheme: {methodName}_{condition}_{expectedOutcome}
 */
public class AccumulatorRealTest {
    @Test
    void add_valueGreaterThanLimit_shouldReturn0() {
        // Arrange
        Accumulator accumulator = new Accumulator();

        // Act
        int result = accumulator.add(20);

        // Assert
        Assertions.assertThat(result).isEqualTo(0);
    }

    @Test
    void add_valueLessThanLimit_shouldReturnValue() {
        // Arrange
        Accumulator accumulator = new Accumulator();

        // Act
        int result = accumulator.add(5);

        // Assert
        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    void add_multipleValuesAccumulatedAboveLimit_shouldReturn1() {
        // Arrange
        Accumulator accumulator = new Accumulator();

        // Act
        int result = accumulator.add(5);
        result = accumulator.add(6);

        // Assert
        Assertions.assertThat(result).isEqualTo(1);
    }
}
