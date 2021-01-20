package by.academy.web.logic;

import java.math.BigDecimal;
import java.util.List;

public class Accounting {
    public BigDecimal average(List<Integer> integers) {
        double average = integers.stream()
                .mapToInt(i -> i)
                .average()
                .orElse(0.0);
        return new BigDecimal(average);
    }
}
