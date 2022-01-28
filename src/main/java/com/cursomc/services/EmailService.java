package com.cursomc.services;

import org.springframework.mail.SimpleMailMessage;

import com.cursomc.models.Pedido;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Pedido obj);
	
	void sendEmail(SimpleMailMessage msg);
}
