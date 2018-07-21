package com.cs.messagesource;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageSourceDemo {

	@Autowired
	MessageSource messageSource;
	
	public MessageSource getMessageSource() {
		return messageSource;
	}

	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void printMessages() {
		 Long currentTimeMillis = System.currentTimeMillis();
		 String messageEN = messageSource.getMessage("greeting", new String[] {currentTimeMillis.toString(), "Good Morning"}, "default Greeting", Locale.ENGLISH);
		 String messageFR = messageSource.getMessage("greeting", null, "default Greeting", Locale.FRENCH);
	     System.out.println(messageEN);
	     System.out.println(messageFR);
	}
	
}