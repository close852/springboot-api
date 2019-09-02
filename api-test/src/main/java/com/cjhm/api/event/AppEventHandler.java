package com.cjhm.api.event;

import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import com.cjhm.api.domain.App;

@RepositoryEventHandler
public class AppEventHandler {

	static {
		System.out.println("AppEventHandler ..... ");
	}
	@HandleAfterSave
	public void afterSaveApp(App app) {
		System.out.println("afterSaveApp 결재상태 확인 다음액션은?"); 
	}
	
	@HandleBeforeSave
	public void beforeSaveApp(App app) {
		System.out.println("beforeSaveApp 결재상태 확인 다음액션은?"); 

	}
	
	@HandleBeforeCreate
	public void beforeCreateApp(App app) {
		System.out.println("beforeCreateApp 결재상태 확인 다음액션은?"); 

	}
	
}
