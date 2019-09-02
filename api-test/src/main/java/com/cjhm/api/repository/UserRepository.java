package com.cjhm.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.cjhm.api.domain.User;
import com.cjhm.api.domain.projection.UserOnlyContainName;

@RepositoryRestResource(excerptProjection=UserOnlyContainName.class)
public interface UserRepository extends JpaRepository<User, Long>{

}
 