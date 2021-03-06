package ru.job4j.stream;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ProfilesTest {
    @Test
    public void collect() {
        Profiles profiles = new Profiles();
        Address addr1 = new Address("Moscow", "Red Square", 1, 1);
        Address addr2 = new Address("St.Petersburg", "Palace Square", 10, 10);
        Address addr3 = new Address("Novosibirsk", "Lenin Square", 100, 100);
        Profile prof1 = new Profile(addr1);
        Profile prof2 = new Profile(addr2);
        Profile prof3 = new Profile(addr3);
        List<Profile> profileList = List.of(prof1, prof2, prof3);
        List<Address> rsl = profiles.collect(profileList);
        List<Address> exp = List.of(addr1, addr3, addr2);
        assertThat(rsl, is(exp));
    }

    @Test
    public void collectDistinct() {
        Profiles profiles = new Profiles();
        Address addr1 = new Address("Moscow", "Red Square", 1, 1);
        Address addr2 = new Address("St.Petersburg", "Palace Square", 10, 10);
        Address addr3 = new Address("Novosibirsk", "Lenin Square", 100, 100);
        Address addr4 = new Address("Novosibirsk", "Lenin Square", 100, 100);
        Address addr5 = new Address("Novosibirsk", "Lenin Square", 100, 100);
        Profile prof1 = new Profile(addr1);
        Profile prof2 = new Profile(addr2);
        Profile prof3 = new Profile(addr3);
        Profile prof4 = new Profile(addr4);
        Profile prof5 = new Profile(addr5);
        List<Profile> profileList = List.of(prof1, prof2, prof3, prof4, prof5);
        List<Address> rsl = profiles.collect(profileList);
        List<Address> exp = List.of(addr1, addr3, addr2);
        assertThat(rsl, is(exp));
    }
}
