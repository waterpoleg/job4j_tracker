package ru.job4j.stream;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ConverterL2MTest extends TestCase {
    @Test
    public void testConvert() {
        List<Student> students = List.of(
                new Student(1, "Student1"),
                new Student(2, "Student2"),
                new Student(3, "Student3"),
                new Student(4, "Student2"),
                new Student(5, "Student2")
        );
        ConverterL2M l2m = new ConverterL2M();
        Map<String, Student> rsl = l2m.convert(students);
        Map<String, Student> expected = Map.of(
                "Student1", new Student(1, "Student1"),
                "Student2", new Student(2, "Student2"),
                "Student3", new Student(3, "Student3"));
        assertThat(rsl, is(expected));
    }
}
