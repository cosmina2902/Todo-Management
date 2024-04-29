package net.javaspring.todomanagement_backend.repository;

import net.javaspring.todomanagement_backend.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByName(String name);

}
