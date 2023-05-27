package in.ashokit.util;

import javax.mail.internet.MimeMessage;

import org.hibernate.engine.internal.AbstractEntityEntry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {
	
	@Autowired
	JavaMailSender mailSender;
	
	public boolean sendEmail(String to, String subject, String body){ 
		boolean isSent=false;
		try {
			
		MimeMessage mimeMassage= mailSender.createMimeMessage();
		MimeMessageHelper helper= new MimeMessageHelper(mimeMassage);
		
		    helper.setTo(to);
	        helper.setSubject(subject);
		    helper.setText(body, true);
		    
		    mailSender.send(mimeMassage);
		    
		    isSent=true;
		}
		catch(Exception e) { 
			e.printStackTrace();
		}
		return isSent;
	}
}