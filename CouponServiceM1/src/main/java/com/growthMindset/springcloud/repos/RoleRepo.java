package com.growthMindset.springcloud.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.growthMindset.springcloud.model.Role;

public interface RoleRepo extends JpaRepository<Role	, Long> {

}
