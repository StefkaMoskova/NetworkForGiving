package org.talentboost.networkforgiving.service;

import org.talentboost.networkforgiving.model.User;

public interface IUserService {
    public User createUser(User user);

    public User updateUser(User user);

    public User getById(int id);

    public User getByUsername(String username);

    public void deleteUser(int id);
}
