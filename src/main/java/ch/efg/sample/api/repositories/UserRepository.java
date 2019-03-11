package ch.efg.sample.api.repositories;

import ch.efg.sample.api.entities.IUser;
import ch.efg.sample.api.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class UserRepository {

    private List<IUser> db;

    @Autowired
    public UserRepository() {
        db = new ArrayList<>();
        db.add(new User("1", "Vasia", "1"));
        db.add(new User("2", "Petya", "1"));
        db.add(new User("3", "Roma", "2"));
        db.add(new User("4", "Nastya", "2"));
        db.add(new User("5", "Elena", "3"));
    }

    public List<IUser> findAll() {
        return db;
    }

    public List<IUser> findById(String id) {
        Assert.notNull(id, "The given id must not be null!");
        return db.stream().filter(user -> user.getId().equals(id)).collect(Collectors.toList());
    }

    public <S extends IUser> S save(S userToSave) {
        Assert.notNull(userToSave, "Entity must not be null!");

        if (isNew(userToSave)) {
            db.add(userToSave);
        } else {
            //find user in db by id and update his info
            for (IUser userFromDb : db) {
                if (userFromDb.getId().equals(userToSave.getId())) {
                    ((User) userFromDb).setName(userToSave.getName());
                    ((User) userFromDb).setGroupId(userToSave.getGroupId());
                }
            }
        }
        return userToSave;
    }

    private <S extends IUser> boolean isNew(S user) {
        for (IUser userFromDb : db) {
            if (userFromDb.getId().equals(user.getId())) {
                return false;
            }
        }
        return true;
    }

    public <ID> IUser delete(ID id) {
        Assert.notNull(id, "The given id must not be null!");
        IUser toReturn = db.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);
        db.remove(toReturn);
        return toReturn;
    }

    public <S extends IUser> List<S> saveAll(Iterable<S> iterable) {
        Assert.notNull(iterable, "The given Iterable of entities not be null!");
        List<S> result = new ArrayList<>();

        for (S anIterable : iterable) {
            User user = (User) anIterable;
            result.add(this.save((S) user));
        }
        return result;
    }

    public Map<String, List<IUser>> findAllGroupByGroupId() {
        return db.stream().collect(Collectors.groupingBy(IUser::getGroupId));
    }

}
