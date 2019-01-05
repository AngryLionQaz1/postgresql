package com.snow.postgresql.common.repository;

import com.snow.postgresql.common.pojo.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {
}
