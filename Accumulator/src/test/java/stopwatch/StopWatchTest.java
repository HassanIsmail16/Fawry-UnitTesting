package stopwatch;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test class for StopWatch.
 * <br>
 * Test naming scheme: {methodName}_{condition}_{expectedOutcome}
 */
public class StopWatchTest {

    @Test
    void getMinutes_positiveValueRecorded_shouldEqual14() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.record(14);
        int minutes = stopWatch.getMinutes();
        Assertions.assertEquals(14, minutes);
    }

    @Test
    void getMinutes_negativeValueRecorded_shouldEqual0() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.record(-5);
        int minutes = stopWatch.getMinutes();
        if (minutes != 0) {
            Assertions.fail("Invalid value");
        }
    }

}
