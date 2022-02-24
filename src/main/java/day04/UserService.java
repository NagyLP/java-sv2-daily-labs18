package day04;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class UserService {

    private List<User> user = List.of(
            new User("John Doe"),
            new User("Jane Doe"),
            new User("Jack Doe")
    );

    public List<User> getLengthAvarage(){
        return user.stream()
                .filter(u->u.getName().endsWith("Doe"))
                .sorted(Comparator.comparing(u->u.getName()))
                .toList();
    }

    public static void main(String[] args) {
        UserService us = new UserService();
        Set<User> user = new TreeSet<>();
        user.add(new User("John Doe"));
        user.add(new User("Jane Doe"));
        System.out.println(user);
    }
}
