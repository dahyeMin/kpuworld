package makeit;

import com.fasterxml.jackson.databind.ObjectMapper;
import makeit.util.push.SendGCM;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = KpuworldProjectApplication.class)
@WebAppConfiguration
public class KpuworldProjectApplicationTests {

	@Autowired
	WebApplicationContext wac;

	@Autowired
	ObjectMapper objectMapper;

	MockMvc mockMvc;

	@Autowired
	SendGCM sendGCM;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}

	@Test
	public void contextLoads() throws Exception {

//		String key = "dulD30RlFf0:APA91bEHkgZgr70Hmw4u0jGqW8RRxIuK7sZnLyy4A1_zdGlYhnnLrcYPI_GoHpf8PgCl0dukCATp2W5bU8uxjXbAQ2NS7fXVoDETxRVFHftrm31_m8lVWWn8Xxy5LE6UypIvdJX9ICQq";
//		sendGCM.sendMessage(key);

	}

}
