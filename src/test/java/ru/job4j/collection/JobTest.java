package ru.job4j.collection;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.Matchers.lessThan;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(
                new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorAscByName() {
        List<Job> src = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Last task", 2)
        );
        List<Job> exp = List.of(
                new Job("Fix bug", 1),
                new Job("Impl task", 0),
                new Job("Last task", 2)
        );
        Collections.sort(src, new JobAscByName());
        assertEquals(exp, src);
    }

    @Test
    public void whenComparatorDescByName() {
        List<Job> src = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Last task", 2)
        );
        List<Job> exp = List.of(
                new Job("Last task", 2),
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        Collections.sort(src, new JobDescByName());
        assertEquals(exp, src);
    }

    @Test
    public void whenComparatorAscByPriority() {
        List<Job> src = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Last task", 2)
        );
        List<Job> exp = List.of(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Last task", 2)
                );
        Collections.sort(src, new JobAscByPriority());
        assertEquals(exp, src);
    }

    @Test
    public void whenComparatorDescByPriority() {
        List<Job> src = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 1),
                new Job("Last task", 2)
        );
        List<Job> exp = List.of(
                new Job("Last task", 2),
                new Job("Fix bug", 1),
                new Job("Impl task", 0)
                );
        Collections.sort(src, new JobDescByPriority());
        assertEquals(exp, src);
    }

    @Test
    public void whenComparatorByNameThenAscByPriority() {
        List<Job> src = Arrays.asList(
                new Job("Last task", 1),
                new Job("Last task", 0),
                new Job("Last task", 2)
        );
        List<Job> exp = List.of(
                new Job("Last task", 0),
                new Job("Last task", 1),
                new Job("Last task", 2)
        );
        Comparator<Job> cmp = new JobAscByName().thenComparing(
                new JobAscByPriority());
        Collections.sort(src, cmp);
        assertEquals(exp, src);
    }

    @Test
    public void whenComparatorAscByPriorityTheByName() {
        List<Job> src = Arrays.asList(
                new Job("Impl task", 0),
                new Job("Fix bug", 0),
                new Job("Last task", 0)
        );
        List<Job> exp = List.of(
                new Job("Fix bug", 0),
                new Job("Impl task", 0),
                new Job("Last task", 0)
        );
        Comparator<Job> cmp = new JobAscByPriority().thenComparing(
                new JobAscByName());
        Collections.sort(src, cmp);
        assertEquals(exp, src);
    }
}
