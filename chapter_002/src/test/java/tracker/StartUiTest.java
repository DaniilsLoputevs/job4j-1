package tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.tracker.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.collection.IsArrayContainingInAnyOrder.arrayContainingInAnyOrder;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;


public class StartUiTest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private static final String ls = System.lineSeparator();
    private static final StringBuilder sb = new StringBuilder("0 : -----Добавление новой заявки-----.").append(ls)
            .append("1 : -----Отобразить все заявки в системе------.").append(ls)
            .append("2 : -----Редактирование заявки------.").append(ls)
            .append("3 : -----Удаление заявки------.").append(ls)
            .append("4 : -----Поиск заявки по уникальному ID------").append(ls)
            .append("5 : ------Поиск заявок по имени.------").append(ls)
            .append("6 : ------Выход из программы.------");

    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }

        @Override
        public String toString() {
            return out.toString();
        }
    };


    private final Tracker tracker = new Tracker();
    public Item item = new Item("TestName", "Test");

    @Before
    public void beforeTest() {
        Item item = this.item;
        this.tracker.add(item);

    }

    @After
    public void afterTest() {
        this.tracker.delete(this.item.getId());
        this.item = null;
    }

    /**
     * Тест на добавление заявки в трекер.
     * ключ в меню : 0.
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Input input = new StubInput(new String[]{"0", "TestName", "TestDesc", "6", "6", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(item.getName(), is("TestName")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Тест на редактирование заявки на основе уникального ID
     * ключ в меню : 3
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6", "6", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    /**
     * Тест на удаление заявки из трекера.
     * ключ в меню : 3.
     */
    @Test
    public void whenDeleteItemById() {
        Input input = new StubInput(new String[]{"3", item.getId(), "6", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    /**
     * Тест на поиск заявки по имени в трекере.
     * ключ в меню : 5.
     */
    @Test
    public void whenFindByName() {
        Input input = new StubInput(new String[]{"5", item.getName(), "6", "6", "y"});
        new StartUI(input, tracker, output).init();
        Item[] result = tracker.findByName("TestName").toArray(new Item[0]);
        Item[] expect = {item};
        assertThat(result, arrayContainingInAnyOrder(expect));
    }

    /**
     * Тест на отображение заявок в трекере.
     * Ключ в меню : 1
     */
    @Test
    public void whenFindAllItem() {
        Input input = new StubInput(new String[]{"1", "6", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().size(), is(1));
    }

    /**
     * Тест на отображение заявки в трекере по ID
     * Ключ в меню : 4
     */
    @Test
    public void whenFindById() {
        Input input = new StubInput(new String[]{"4", item.getId(), "6", "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()), is(item));
    }

    @Test
    public void whenTestingFindByIdinOutput() {
        String[] actions = new String[]{"4", item.getId(), "6", "6", "y"};
        new StartUI(new StubInput(actions), tracker, output).init();


    }

    @Test
    public void displayAllItems() {
        Input input = new StubInput(new String[]{"1", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(output.toString(), is(sb.toString() + ls +
                "------Все заявки в системе------" + ls +
                "Task:" +
                item.toString() + ls +
                sb.toString() + ls +
                "-----Выход из программы-----" + ls
        ));
    }

    @Test
    public void displayExitProgram() {
        Input input = new StubInput(new String[]{"6"});
        new StartUI(input, tracker, output).init();
        assertThat(output.toString(), is(sb.toString() + ls +
                "-----Выход из программы-----" + ls));
    }

    @Test
    public void displayFindbyNameTest() {
        Input input = new StubInput(new String[]{"5", "TestName", "6"});
        new StartUI(input, tracker, output).init();
        assertThat(output.toString(), is(sb.toString() + ls +
                "Ваша заявка" + "[" +
                item.toString() + "]" + ls +
                sb.toString() + ls +
                "------Выход из программы.------" + ls
        ));
    }

}

