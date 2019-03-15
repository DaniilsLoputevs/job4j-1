package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfileTest {

    @Test
    public void collect() {
        List<Profile> profileList = new ArrayList<>();
        profileList.add(new Profile(new Address("NY", "38-street", 1, 96)));
        profileList.add(new Profile(new Address("NY", "39-street", 2, 106)));
        Profile profiletest = new Profile();
        List<Address> expected = new ArrayList<>();
        expected.add(new Address("NY", "38-street", 1, 96));
        expected.add(new Address("NY", "39-street", 2, 106));
        assertThat(profiletest.collect(profileList), is(expected));


    }
}