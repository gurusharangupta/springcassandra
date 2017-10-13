package com.cog.springcassandra.serviceImpl;

import java.io.File;  

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
public class EmailServiceImpl implements EmailService{
	
	@Autowired
	private JavaMailSender mailSender;  
	
	
       
    public String sendMail(User user) 
    {  
    	String mailStatus = null;
        try{  
	        MimeMessage message = mailSender.createMimeMessage();  
	        //InternetAddress internetAddress =new InternetAddress(user.getEmail());
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);  
	        helper.setFrom("mailto9a@gmail.com");
	        
	        helper.setValidateAddresses(true);
	        helper.setTo(user.getEmail());  
	        helper.setSubject(user.getUserName()+" Account registration confirmation");  
	        String confirmationUrl = "/accountConfirmation.html?uid=" + user.getId();
	        helper.setText("Dear User, Please sign and upload attached pdf at the following link for confirmation\n"+" http://localhost:8090/gni-email-confirm");  
	  
	        // attach the file  
	        FileSystemResource file = new FileSystemResource(new File("C:\\Users\\hiresmart\\workspace\\springcassandra\\springcassandra\\src\\main\\resources\\static\\pdf\\sample.pdf"));  
	        helper.addAttachment(user.getUserName()+"", file);//image will be sent by this name  
	        
	        	try { 
	        	mailSender.send(message); 
	        	mailStatus = "{\"message\": \"OK\"}";
	        	}
	        	catch (MailException e) {
        		e.printStackTrace();
        		mailStatus = "{\"message\": \"Error\"}";
	        	} 
	   
        }  
	        catch(Exception e){
	        	e.printStackTrace();
	        	mailStatus = "{\"message\": \"Error\"}";
	        }  
        return mailStatus;
    } 
    
    public String sendConfirmationMail(User user) 
    {  
    	String mailStatus = null;
        try{  
	        MimeMessage message = mailSender.createMimeMessage();  
	  
	        MimeMessageHelper helper = new MimeMessageHelper(message, true);         
	        helper.setTo(user.getEmail());  
	        helper.setSubject(user.getUserName()+" Account created successfully");  
	        
	        helper.setText("Dear" +user.getUserName()+", your account has been created successfully"); 
	         
	        try { 
	        	mailSender.send(message); 
	        	mailStatus = "{\"message\": \"OK\"}";
	        	} catch (Exception e) {
	        		e.printStackTrace();
	        		mailStatus = "{\"message\": \"Error\"}";
	        	} 
	        }
	        catch(Exception e){
	        	e.printStackTrace();
	        	mailStatus = "{\"message\": \"Error\"}";
	        }  
        return mailStatus;
    }
    
    private boolean validateEmail(String email) 
    {
    	boolean isValid = false;
    	try {
    
         InternetAddress internetAddress = new InternetAddress(email);
         internetAddress.validate();
         isValid = true;
    	} 
    	catch (AddressException e) {
    		e.printStackTrace();
    	}
    	System.out.println(""+isValid);
    	return isValid; 
    }
}


