package org.example;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BoardTest {

    @Test
    void propagateUserWithOneFriend() {
        Person person = new Person("Mr. Blue");
        person.secret(new Secret("Gossip1"));
        Person friend = new Person("Mr. Pink");
        person.talksWith(friend);
        List<Person> people = List.of(person, friend);

        new Board(people).propagate();

        assertEquals(person.ask(), "");
        assertEquals(friend.ask(), "Gossip1");
    }

    @Test
    void propagateUserWithMoreFriends() {
        Person person = new Person("Mr. Blue");
        person.secret(new Secret("Gossip2"));
        Person friend1 = new Person("Mr. Pink");
        person.talksWith(friend1);
        Person friend2 = new Person("Mr. Brown");
        person.talksWith(friend2);
        List<Person> people = List.of(person, friend1, friend2);

        new Board(people).propagate();

        assertEquals(person.ask(), "Gossip2");
        assertEquals(friend1.ask(), "Gossip2");
        assertEquals(friend2.ask(), "");
    }

    @Test
    void propagateTwiceUserWithMoreFriends() {
        Person person = new Person("Mr. Blue");
        person.secret(new Secret("Gossip2"));
        Person friend1 = new Person("Mr. Pink");
        person.talksWith(friend1);
        Person friend2 = new Person("Mr. Brown");
        person.talksWith(friend2);
        person.shareSecretWithFriend();
        List<Person> people = List.of(person, friend1, friend2);

        new Board(people).propagate();

        assertEquals(person.ask(), "");
        assertEquals(friend1.ask(), "");
        assertEquals(friend2.ask(), "Gossip2");
    }
}