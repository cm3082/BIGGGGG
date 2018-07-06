package com.cm.activemq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class Publisher {

	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	public void publish(String destinationName, String message) {
		System.out.println("==============>>>>>>>> 发送topic消息" + message);
		Destination destination = new ActiveMQTopic(destinationName);
		jmsMessagingTemplate.convertAndSend(destination, message);
	}
}
