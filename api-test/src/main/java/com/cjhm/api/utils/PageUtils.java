package com.cjhm.api.utils;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.PagedResources.PageMetadata;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

public class PageUtils {

	
	
	public static <T> Resources<T> makeLink(Page<T> pages,PageMetadata pageMetadata,Pageable pageable,ControllerLinkBuilder controller){

		PagedResources<T> resources = new PagedResources<T>(pages.getContent(), pageMetadata);
		
		String firstParam="?page="+pageable.first().getPageNumber()+"&size="+pageable.first().getPageSize();
		resources.add(controller.slash(firstParam).withRel("first"));
		if(pageable.hasPrevious()) {
			String previousParam="?page="+pageable.previousOrFirst().getPageNumber()+"&size="+pageable.previousOrFirst().getPageSize();
			resources.add(controller.slash(previousParam).withRel("prev"));
		}
		resources.add(controller.withSelfRel());
		
		if(pageable.next().getPageNumber()<(pages.getTotalPages()-1)) {
			String nextParam="?page="+pageable.next().getPageNumber()+"&size="+pageable.next().getPageSize();
			resources.add(controller.slash(nextParam).withRel("next"));
		}
		
		String lastParam="?page="+(pages.getTotalPages()-1)+"&size="+pageable.getPageSize();
		resources.add(controller.slash(lastParam).withRel("last"));
		

		return resources;
	}
}
