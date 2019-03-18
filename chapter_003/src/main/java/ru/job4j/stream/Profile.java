package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;


/**
 * @author Sergey Bolshanin (dinospb@gmail.com)
 * @version 0.1$
 * @since 13.03.2019
 */
public class Profile {
    /**
     * Поле обьект класса Adress - содержит адрес клиента.
     */
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    public Profile() {
    }

    /**
     * Метод возвращает структуру данных со списком адресов клиентов
     *
     * @param profiles структура данных с карточками клиентов.
     * @return результат введенный с помощью потока
     */
    List<Address> collect(List<Profile> profiles) {

        return profiles.stream().map(profile -> profile.address).collect(Collectors.toList());
    }

    /**
     * Метод возвращает структуру данных со списком уникальных данных отсортированных
     *
     * @param profiles структура данных с карточками клиентов
     * @return результат введенный с помошью потока
     */
    List<Address> collectUnique(List<Profile> profiles) {
        return profiles.stream().sorted((o1, o2) -> {
            return o1.getAddress().getCity().compareToIgnoreCase(o2.getAddress().getCity());
        }).map(profile -> profile.address).distinct().collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Profile{"
                +
                "address="
                + address
                +
                '}';
    }
}
