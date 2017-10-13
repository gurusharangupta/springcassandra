package com.cog.springcassandra.serviceImpl;

import java.io.File;
import java.util.Base64;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cog.springcassandra.data.User;
import com.cog.springcassandra.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender mailSender;

	public String sendMail(User user) {
		String mailStatus = null;
		try {
			MimeMessage message = mailSender.createMimeMessage();
			// InternetAddress internetAddress =new InternetAddress(user.getEmail());
			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(user.getEmail());

			helper.setValidateAddresses(true);
			helper.setTo(user.getEmail());
			helper.setSubject(user.getUserName() + " Account registration confirmation");
			String encodedString = Base64.getEncoder().encodeToString(user.getEmail().getBytes());
			System.out.println(encodedString);
			helper.setText("Dear User, Please sign and upload attached pdf at the following link for confirmation\n"
					+ " http://localhost:8090/gni-email-confirm/"+encodedString);

			// attach the file
			FileSystemResource file = new FileSystemResource(new File(
					"C:\\Users\\hiresmart\\workspace\\springcassandra\\springcassandra\\src\\main\\resources\\static\\pdf\\sample.pdf"));
			helper.addAttachment(user.getUserName() + "", file);// image will be sent by this name

			try {
				mailSender.send(message);
				mailStatus = "{\"message\": \"OK\"}";
			} catch (MailException e) {
				e.printStackTrace();
				mailStatus = "{\"message\": \"Error\"}";
			}

		} catch (Exception e) {
			e.printStackTrace();
			mailStatus = "{\"message\": \"Error\"}";
		}
		return mailStatus;
	}

	public String sendConfirmationMail(String email) {
		String mailStatus = null;
		try {
			MimeMessage message = mailSender.createMimeMessage();

			MimeMessageHelper helper = new MimeMessageHelper(message, true);
			helper.setFrom(email);
			helper.setTo(email);
			helper.setValidateAddresses(true);
			helper.setSubject("Dear User, Account created successfully.");

			helper.setText("Dear User, your account has been created successfully. Please login back in 3 days to operate your account");

			try {
				mailSender.send(message);
				mailStatus = "{\"message\": \"OK\"}";
			} catch (Exception e) {
				e.printStackTrace();
				mailStatus = "{\"message\": \"Error\"}";
			}
		} catch (Exception e) {
			e.printStackTrace();
			mailStatus = "{\"message\": \"Error\"}";
		}
		return mailStatus;
	}

	private boolean validateEmail(String email) {
		boolean isValid = false;
		try {

			InternetAddress internetAddress = new InternetAddress(email);
			internetAddress.validate();
			isValid = true;
		} catch (AddressException e) {
			e.printStackTrace();
		}
		System.out.println("" + isValid);
		return isValid;
	}
}
