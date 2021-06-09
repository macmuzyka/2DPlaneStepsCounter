import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Maciej Muzyka
 * on 09.06.2021
 */

class StepsCounterTest {

    @Test
    void shouldReturnSevenSteps() {
        int[][] testArray = new int[][] {{1,1},{3,4},{-1,0}};
        assertEquals(7, StepsCounter.execute(testArray));
    }

    @Test
    void shouldReturnMinusOneAsAnErrorIndicatorAsSinglePointWasPassed() {
        int[][] testArray = new int[][] {{3,5}};
        assertEquals(-1, StepsCounter.execute(testArray));
    }
    @Test
    void nullAsInputStillShouldReturnMinusOneAsErrorIndicator() {
        assertEquals(-1, StepsCounter.execute(null));
    }

}
