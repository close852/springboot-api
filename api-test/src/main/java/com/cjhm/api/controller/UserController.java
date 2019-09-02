package com.cjhm.api.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resources;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cjhm.api.domain.User;
import com.cjhm.api.repository.UserRepository;

@RepositoryRestController
@RequestMapping("/users")
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@GetMapping
	public @ResponseBody Resources<User> getUsers(@PageableDefault Pageable pageable) {
		Page<User> users = userRepository.findAll(pageable);
		PageMetadata pageMetadata = new PageMetadata(pageable.getPageSize(), pageable.getPageNumber(),
				users.getTotalElements());
		PagedResources<User> resources = new PagedResources<User>(users.getContent(), pageMetadata);
		resources.add(linkTo(methodOn(AppController.class).getApps(pageable)).withSelfRel());
		return resources;

	}
}
