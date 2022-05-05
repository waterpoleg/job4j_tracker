package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {

    @Test
    public void whenFindByNameActionThenSuccess() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(out);
        Input input = mock(Input.class);
        when(input.askStr(any(String.class))).thenReturn(item.getName());
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find items by name ===" + ln + item + ln));
        assertThat(tracker.findAll().get(0).getName(), is("new item"));
    }

    @Test
    public void whenFindByNameActionThenFail() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        FindByNameAction findByNameAction = new FindByNameAction(out);
        Input input = mock(Input.class);
        String nameToFind = "name";
        when(input.askStr(any(String.class))).thenReturn(nameToFind);
        findByNameAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(),
                is("=== Find items by name ===" + ln
                        + "Заявки с именем: "
                        + nameToFind
                        + " не найдены." + ln));
    }
}
