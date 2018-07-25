package tracker;

import org.junit.Test;
import ru.job4j.tracker.*;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;


public class StartUiTest {
    /**
     * Тест на добавление заявки в трекер.
     * ключ в меню : 0.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "6"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Тест на редактирование заявки на основе уникального ID
     * ключ в меню : 2.
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тест на удаление заявки из трекера.
     * ключ в меню : 3.
     */
    @Test
    public void whenDeleteItemById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("TestName", "TestDesc"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    /**
     * Тест на поиск заявки по имени в трекере.
     * ключ в меню : 5.
     */
    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item testItem = tracker.add(new Item("RandomName", "TestDesc"));
        Input input = new StubInput(new String[]{"5", testItem.getName(), "6"});
        new StartUI(input, tracker).init();
        Item[] result = tracker.findByName("RandomName");
        Item[] expect = {testItem};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * Тест на отображение заявок в трекере.
     * Ключ в меню : 1
     */
    @Test
    public void whenFindAllItem() {
        Tracker tracker = new Tracker();
        Item firstItem = tracker.add(new Item("FirstName", "FirstDesc"));
        Item secondItem = tracker.add(new Item("SecondTestName", "SecondDesc"));
        Item thirdItem = tracker.add(new Item("RandomName", "ThirdDesc"));
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll().length, is(3));
    }

    /**
     * Тест на отображение заявки в трекере по ID
     * Ключ в меню : 4
     */
    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("TestName", "TestDesc"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

}
