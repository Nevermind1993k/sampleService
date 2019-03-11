package ch.efg.sample.api;

import ch.efg.sample.api.entities.User;
import ch.efg.sample.api.repositories.UserRepository;
import ch.efg.sample.api.services.impl.IUserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UserApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);

        /*IUserServiceImpl impl = new IUserServiceImpl(new UserRepository());
        System.out.println(impl.findById("1"));
        System.out.println(impl.findAll());
        System.out.println(impl.save(new User("2", "Vitalik", "4")));
        System.out.println(impl.findAll());
        System.out.println(impl.delete("1"));
        System.out.println(impl.findAll());

        List<User> users = new ArrayList<>();
        users.add(new User("25", "Sveta", "4"));
        users.add(new User("26", "Kolya", "4"));
        users.add(new User("1", "Bogdan", "4"));
        System.out.println(impl.saveAll(users));
        System.out.println(impl.findAll());

        System.out.println(impl.findAllGroupByGroupId());*/
    }
}
