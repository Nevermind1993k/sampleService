package ch.efg.sample.api.services.impl;

import ch.efg.sample.api.entities.IUser;
import ch.efg.sample.api.repositories.UserRepository;
import ch.efg.sample.api.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class IUserServiceImpl implements IUserService<IUser, String> {

    private final UserRepository userRepository;

    @Autowired
    public IUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<IUser> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<IUser> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public <S extends IUser> List<S> saveAll(Iterable<S> iterable) {
        return userRepository.saveAll(iterable);
    }

    @Override
    public <S extends IUser> S save(S userToSave) {
        return userRepository.save(userToSave);
    }

    @Override
    public IUser delete(String id) {
        return userRepository.delete(id);
    }

    @Override
    public Map<String, List<IUser>> findAllGroupByGroupId() {
        return userRepository.findAllGroupByGroupId();
    }
}
