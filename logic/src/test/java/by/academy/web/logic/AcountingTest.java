package by.academy.web.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class AccountingTest {
    private Accounting accounting;

    @BeforeEach
    void setUp() {
        accounting = new Accounting();
    }

    @ParameterizedTest
//    @ValueSource(ints = {6, 8})  -- the first options
//    @CsvSource({                 -- the second options
//            "6, 8, 7",
//            "5, 6, 5.5"
//    })
    @MethodSource("intIntBigDecimal")
        //the only fits here
    void averageInteger(int a, int b, BigDecimal expectedAverage) {
        //given
        List<Integer> integers = List.of(a, b);
        //when
        BigDecimal actualAverage = accounting.average(integers);
        //then
        assertEquals(expectedAverage, actualAverage);
    }

    private static Stream<Arguments> intIntBigDecimal() {
        return Stream.of(
                arguments(6, 8, BigDecimal.valueOf(7)),
                arguments(5, 6, BigDecimal.valueOf(5.5))
        );
    }


}