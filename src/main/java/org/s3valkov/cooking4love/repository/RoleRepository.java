package org.s3valkov.cooking4love.repository;

import org.s3valkov.cooking4love.domain.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role,String> {

    Role findByAndAuthority(String authority);
}
