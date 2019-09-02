package com.cjhm.api.domain.projection;

import org.springframework.data.rest.core.config.Projection;

import com.cjhm.api.domain.User;

@Projection(name = "getOnlyUsername", types = { User.class })
public interface UserOnlyContainName {

	String getUsername();

	String getLoginId();
}
