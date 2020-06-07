package org.talentboost.networkforgiving.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.talentboost.networkforgiving.model.User;

public interface IUserRepository extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username = :username")
    public User getByUsername(@Param("username") String username);
}
