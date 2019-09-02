package com.cjhm.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.cjhm.api.domain.App;
import com.cjhm.api.domain.projection.AppOnlyContainTitle;

@RepositoryRestResource(excerptProjection=AppOnlyContainTitle.class)
public interface AppRepogitory extends JpaRepository<App, Long> {

	@RestResource(path="query")
	List<App> findByTitle(@Param("title") String title);
}
