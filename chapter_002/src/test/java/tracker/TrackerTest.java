package tracker;


import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("test1", "testDescription", 123L);
        tracker.add(item);
        assertThat(tracker.findAll().get(0), is(item));
    }

    @Test
    public void whenReplaceNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", 123L);
        // Добавляем заявку в трекер. Теперь в объект проинициализирован id.
        tracker.add(previous);
        // Создаем новую заявку.
        Item next = new Item("test2", "testDescription2", 1234L);
        // Проставляем старый id из previous, который был сгенерирован выше.
        next.setId(previous.getId());
        // Обновляем заявку в трекере.
        tracker.replace(previous.getId(), next);
        // Проверяем, что заявка с таким id имеет новые имя test2.
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }

    @Test
    public void whenFindAll() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstTestItem", "firstTestDesc", 123L);
        Item secondItem = new Item("secondTestItem", "secondTestDesc", 234L);
        tracker.add(firstItem);
        tracker.add(secondItem);
        assertThat(tracker.findAll().size(), is(2));

    }

    @Test
    public void deleteItem() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstTestItem", "firstTestDesc", 123L);
        Item secondItem = new Item("secondTestItem", "secondTestDesc", 234L);
        Item thirdItem = new Item("thirdTestItem", "thirdTestDesc", 235L);
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        tracker.delete(firstItem.getId());
        Item expect = null;
        assertThat(tracker.findById(firstItem.getId()), is(expect));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstTestItem", "firstTestDesc", 123L);
        Item secondItem = new Item("secondTestItem", "secondTestDesc", 234L);
        Item secondItem2 = new Item("secondTestItem", "secondTestDesc", 234L);
        Item thirdItem = new Item("secondTestItem", "secondTestDesc", 445L);
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(secondItem2);
        tracker.add(thirdItem);
        Item[] result = tracker.findByName("secondTestItem").toArray(new Item[0]);
        Item[] expect = {secondItem, secondItem2, thirdItem};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item firstItem = new Item("firstTestItem", "firstTestDesc", 123L);
        Item secondItem = new Item("secondTestItem", "secondTestDesc", 234L);
        Item thirdItem = new Item("thirdTestItem", "thirdTestDesc", 235L);
        tracker.add(firstItem);
        tracker.add(secondItem);
        tracker.add(thirdItem);
        assertThat(tracker.findById(thirdItem.getId()), is(thirdItem));

    }

}