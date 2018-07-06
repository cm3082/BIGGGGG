package com.cm.activemq;

import javax.jms.ConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.config.SimpleJmsListenerContainerFactory;
import org.springframework.stereotype.Service;

@Service
public class Subscriber {
	
	@JmsListener(destination = "test.topic", containerFactory = "myJmsContainerFactory")
	public void subscriber(String text) {
		System.out.println("<<<<<<<<========收到订阅的消息：" + text);
	}
	
	@Bean
	JmsListenerContainerFactory<?> myJmsContainerFactory(ConnectionFactory connectionFactory){
		SimpleJmsListenerContainerFactory factory = new SimpleJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory);
		factory.setPubSubDomain(true);
		return factory;
		
	}
}
