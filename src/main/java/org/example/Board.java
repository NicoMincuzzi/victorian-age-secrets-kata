package org.example;

import java.util.List;
import java.util.stream.Collectors;

public class Board {
    private final List<Person> people;

    public Board(List<Person> people) {
        this.people = people;
    }

    public void propagate() {
        List<Person> userWithFriends = people.stream()
                .filter(it -> it.hasFriends() || !it.ask().equals(""))
                .collect(Collectors.toList());

        for (Person person : userWithFriends) {
            person.shareSecretWithFriend();
        }
    }
}
