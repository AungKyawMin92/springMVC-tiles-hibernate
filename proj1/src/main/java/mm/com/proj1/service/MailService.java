package mm.com.proj1.service;

import java.io.File;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.velocity.VelocityEngineUtils;

@Service
@Transactional
public class MailService {
	@Value("#{mailSender.username}")
	private String from;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private VelocityEngine velocityEngine;

	private final Logger logger = LogManager.getLogger(this.getClass());
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	public void sendMail(final InternetAddress[] to, final InternetAddress[] cc, final String subject, final Map<String, Object> model,
			 final String templateFileName, final String[] attachmentFileNames, final List<byte[]> attachmentByteArrayList, final File file) {
		logger.debug("Mail Sending Started");
		logger.debug("Subject: " + subject);

		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				MimeMessage message = mailSender.createMimeMessage();
				try {
					MimeMessageHelper helper = new MimeMessageHelper(message, true);
					helper.setFrom(from);
					helper.setTo(to);
					
					if (cc != null) {
						helper.setCc(cc);
					}
					helper.setSubject(subject);
		
					String text = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateFileName, "UTF-8", model);
					helper.setText(text, true);
					if (file != null) {
						helper.addInline("logo", file);
					}
					
					//logger.debug("Email body: " + text + "\n");
		
					if (attachmentFileNames != null && attachmentByteArrayList != null) {
						for(int i=0;i<attachmentFileNames.length;i++){
							helper.addAttachment(attachmentFileNames[i], new ByteArrayResource(attachmentByteArrayList.get(i)));
						}
					}
		
					mailSender.send(message);
		
				} catch (Exception e) {
					e.printStackTrace();
					logger.debug("DEBUG-ERROR -" + e.getMessage(), e);
					logger.error(e.getMessage(), e);
				}
				logger.debug("Mail Sending Completed\n\n");
			}
		});
		thread.start();
	}
}
