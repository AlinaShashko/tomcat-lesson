package by.academy.web.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {
    private List<Integer> marks;

    {
        marks = new ArrayList<>();
    }

    public Student() {

    }

    public Student(String name, int age) {
        super( name, age );
    }

    @Override
    public String getInfo() {
        return null;
    }
}
