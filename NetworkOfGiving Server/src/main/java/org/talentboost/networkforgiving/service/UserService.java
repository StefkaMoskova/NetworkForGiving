package org.talentboost.networkforgiving.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talentboost.networkforgiving.model.User;
import org.talentboost.networkforgiving.repository.IUserRepository;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(int id) {
        return userRepository.getOne(id);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.getByUsername(username);
    }

    @Override
    public void deleteUser(int id) { userRepository.deleteById(id); }
}
