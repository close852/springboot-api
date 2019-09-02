package com.cjhm;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import com.cjhm.api.domain.App;
import com.cjhm.api.domain.User;
import com.cjhm.api.event.AppEventHandler;
import com.cjhm.api.repository.AppRepogitory;
import com.cjhm.api.repository.UserRepository;

@SpringBootApplication
public class ApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTestApplication.class, args);
	}

	@Bean
	public static CommandLineRunner context(UserRepository userRepository, AppRepogitory appRepogitory) {
		return (args) -> {
			User user = User.builder().loginId("mwuser").password("a").username("이름").build();
			userRepository.save(user);

			for (int i = 1; i <= 89; i++) {
				App app = App.builder().title("title" + i).content("app" + i).user(user).build();
				appRepogitory.save(app);
			}
		};
	}

	@Bean
	AppEventHandler appEventHandler() {
		System.out.println("appEventHandler 등록!");
		return new AppEventHandler();
	}

}
