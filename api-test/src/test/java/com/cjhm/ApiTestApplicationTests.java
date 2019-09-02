package com.cjhm;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cjhm.api.domain.App;
import com.cjhm.api.repository.AppRepogitory;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApiTestApplication.class)
@AutoConfigureTestDatabase
public class ApiTestApplicationTests {

	private TestRestTemplate testRestTemplate = new TestRestTemplate("havi", "test");
	@Autowired
	private AppRepogitory appRepogitory;

	@Test
	public void 저장후에_sysout_호출여부() {
//		App app = App.builder().title("title...").content("temp_content").build();
//		System.out.println("저장전 : " + app);
//		app = appRepogitory.save(app);
//		System.out.println("저장후 : " + app);
		System.out.println("createApp ::: ");
		App app = createApp();
		System.out.println("결과... "+app);
	}

	private App createApp() {
		App app = App.builder().title("title...").content("temp_content").build();

		String url="http://127.0.0.1:8080/api/apps";
		return testRestTemplate.postForObject(url, app, App.class); 
	}
}
