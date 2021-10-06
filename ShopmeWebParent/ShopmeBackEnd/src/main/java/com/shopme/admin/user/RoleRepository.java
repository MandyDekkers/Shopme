package com.shopme.admin.user;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.shopme.site.Role;


@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
}
