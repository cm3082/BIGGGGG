package com.cm;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cm.activemq.Producer;
import com.cm.activemq.Publisher;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonTechnologiesSpringbootApplicationTests {

	@Resource
	private Producer producer;
	
	@Resource
	private Publisher publisher;
	
	@Test
	public void contextLoads() {
		for(int i = 0; i < 10; i++) {
			producer.sendMsg("test.queue", "||第" + i + "次发送队列消息");
		}
	}

	@Test
	public void test() {
		for(int i = 0; i < 10; i++) {
			publisher.publish("test.topic", "||第" + i + "次发送主题消息");
		}
	}
}
