package com.shopme.admin.user;

import com.shopme.site.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
