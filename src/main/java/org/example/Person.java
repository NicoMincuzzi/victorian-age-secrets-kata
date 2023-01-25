package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Person {
    private final String name;
    private final List<Person> friends = new ArrayList<>();
    private Secret secret;
    private final Set<Person> sharedFriends = new HashSet<>();

    public Person(String name) {
        this.name = name;
    }

    public List<Person> talksWith(Person person) {
        friends.add(person);
        return friends;
    }

    public void secret(Secret secret) {
        this.secret = secret;
    }

    public String ask() {
        if (secret == null)
            return "";
        return secret.getCurrentSecret();
    }

    public boolean hasFriends() {
        return !friends.isEmpty();
    }

    public void shareSecretWithFriend() {
        for (Person friend : friends) {
            if (sharedFriends.contains(friend)) {
                continue;
            }
            friend.secret(new Secret(secret.getCurrentSecret()));
            sharedFriends.add(friend);
            break;
        }

        if (isSharedSecretWithAll()) {
            secret = new Secret("");
        }
    }

    private boolean isSharedSecretWithAll() {
        return friends.size() == sharedFriends.size();
    }
}
