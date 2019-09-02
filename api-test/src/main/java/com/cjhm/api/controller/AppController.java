package com.cjhm.api.controller;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjhm.api.domain.App;
import com.cjhm.api.repository.AppRepogitory;
import com.cjhm.api.utils.PageUtils;

@RepositoryRestController
@RequestMapping("/api/apps")
public class AppController {	
 
	private AppRepogitory appRepogitory;

	public AppController(AppRepogitory appRepogitory) {
		this.appRepogitory = appRepogitory;
	}

	@GetMapping
	public @ResponseBody Resources<App> getApps(@PageableDefault Pageable pageable) {
		
		Page<App> apps = appRepogitory.findAll(pageable); 
		PageMetadata pageMetadata = new PageMetadata(pageable.getPageSize(), pageable.getPageNumber(), apps.getTotalElements());
		ControllerLinkBuilder appController  =linkTo(methodOn(this.getClass()).getApps(pageable));
		
		return PageUtils.makeLink(apps,pageMetadata,pageable, appController);
	}
	
	
}
