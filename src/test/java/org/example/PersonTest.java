package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    public void checkAddingFriend() {
        Person friend = new Person("Mr. Pink");

        List<Person> friends = new Person("Mr. Blue").talksWith(friend);

        assertEquals(friends.size(), 1);
    }


    @Test
    public void unidirectionalFriendship() {
        Person friend = new Person("Mr. Pink");

        new Person("Mr. Blue").talksWith(friend);

        assertEquals(friend.hasFriends(), false);
    }

    @Test
    public void createAndRetrieveSecret() {
        Secret secret = new Secret("Gossip1");
        Person person = new Person("Mr. Blue");

        person.secret(secret);

        assertEquals(person.ask(), "Gossip1");
    }

    @Test
    public void retrieveAnEmptySecret() {
        Person person = new Person("Mr. Pink");

        String result = person.ask();

        assertEquals(result, "");
    }
}