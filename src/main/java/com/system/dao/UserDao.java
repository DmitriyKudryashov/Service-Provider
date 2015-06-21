package com.system.dao;

import com.system.domain.User;

import java.util.List;

/**
 * Created by home on 21.06.15.
 */

public interface UserDao {

    public void add(User user);

    public void update();

    public List<User> gets();

}
