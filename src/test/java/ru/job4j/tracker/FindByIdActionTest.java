package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {

    @Test
    public void whenFindByIdActionThenSuccess() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(),
                is("=== Find item by id ===" + ln + item + ln));
        assertThat(tracker.findAll().get(0).getName(), is("new item"));
    }

    @Test
    public void whenFindByIdActionThenFail() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item("new item");
        tracker.add(item);
        FindByIdAction findByIdAction = new FindByIdAction(out);
        Input input = mock(Input.class);
        int idToFind = 10;
        when(input.askInt(any(String.class))).thenReturn(idToFind);
        findByIdAction.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(),
                is("=== Find item by id ===" + ln
                        + "Заявка с введенным id: "
                        + idToFind
                        + " не найдена." + ln));
    }
}
