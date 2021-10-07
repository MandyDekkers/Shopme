package com.shopme.admin.user;

import com.shopme.site.Role;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

@DataJpaTest
@Rollback(false)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RoleRepositoryTest {

    @Autowired
    private RoleRepository repo;

    @Test
    public void testCreateFirstRole() {
        Role roleAdmin = new Role("Admin", "manage everything");
        Role savedRole = repo.save(roleAdmin);

        Assertions.assertThat(savedRole.getId()).isGreaterThan(0);
    }

    @Test
    public void testCreateRestRoles() {
        Role roleSalesPerson = new Role("Salesperson", "manage prodcut price, " + "customers, shipping, orders and sales report");
        Role roleEditor = new Role("Editor", "manage categories, brands " + "products, articles and menus");
        Role roleShipper = new Role("Shipper", "view products, " + "view orders " + "and update order and status");
        Role roleAssistent = new Role("Assistent", "manage questions and reviews");

        repo.saveAll(List.of(roleSalesPerson, roleEditor, roleShipper, roleAssistent));
    }
}
