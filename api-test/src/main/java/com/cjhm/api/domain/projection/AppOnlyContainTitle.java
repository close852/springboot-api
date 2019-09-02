package com.cjhm.api.domain.projection;

import org.springframework.data.rest.core.config.Projection;

import com.cjhm.api.domain.App;

@Projection(name = "getOnlyTitle", types = { App.class })
public interface AppOnlyContainTitle {
	String getTitle();

}
