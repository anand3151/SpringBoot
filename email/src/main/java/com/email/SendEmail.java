package com.email;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import javax.activation.DataSource;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@Service
public class SendEmail {

	@Autowired
	private JavaMailSender javaMailSender;

	void sendEmail() {

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("anand3151@gmail.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");
		System.out.println("javaMailSender " + javaMailSender);
		javaMailSender.send(msg);

	}

	void sendEmailWithAttachment() throws Exception {

		MimeMessage msg = javaMailSender.createMimeMessage();

		// true = multipart message
		MimeMessageHelper helper = new MimeMessageHelper(msg, true);
		helper.setTo("anand3151@gmail.com");

		helper.setSubject("Testing from Spring Boot");

		// default = text/plain
		// helper.setText("Check attachment for image!");

		// true = text/html
		helper.setText(
				"<h1><a class=\"social-button facebook\" href=\"https://www.facebook.com/BajajAllianz\" target=\"_blank\"><img src=\"https://media.bajajallianz.com/BagicMedia/commhub_bancs/facebook.png\"></a>\r\n"
						+ "                    <a class=\"social-button twitter\" href=\"https://twitter.com/BajajAllianz\" target=\"_blank\"><img src=\"https://media.bajajallianz.com/BagicMedia/commhub_bancs/twitter.png\"></a>\r\n"
						+ "                    <a class=\"social-button linkedin\" href=\"https://www.linkedin.com/company/bajaj-allianz-general-insurance-co--ltd-\" target=\"_blank\"><img src=\"https://media.bajajallianz.com/BagicMedia/commhub_bancs/linkedin.png\"></a>\r\n"
						+ "					 <a class=\"social-button instagram\" href=\"https://instagram.com/bajajallianzgeneral/\" target=\"_blank\"><img src=\"https://media.bajajallianz.com/BagicMedia/commhub_bancs/Instagram.png\"></a>\r\n"
						+ "                    <a class=\"social-button youtube\" href=\"https://www.youtube.com/user/BajajAllianzGIC\" target=\"_blank\"><img src=\"https://media.bajajallianz.com/BagicMedia/commhub_bancs/youtube.png\"></a>",
				true);

		// FileSystemResource file = new FileSystemResource(new
		// File("classpath:android.png"));

		// Resource resource = new ClassPathResource("android.png");
		// InputStream input = resource.getInputStream();

		// ResourceUtils.getFile("classpath:android.png");
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		writePdf(outputStream);
		byte[] bytes = outputStream.toByteArray();

		DataSource dataSource = new ByteArrayDataSource(bytes, "application/pdf");

		helper.addAttachment("my_photo.png", new ClassPathResource("android.png"));

		helper.addAttachment("test.pdf", dataSource);

		javaMailSender.send(msg);

	}

	public void writePdf(OutputStream outputStream) throws Exception {
		Document document = new Document();
		PdfWriter.getInstance(document, outputStream);

		document.open();

		document.addTitle("Test PDF");
		document.addSubject("Testing email PDF");
		document.addKeywords("iText, email");
		document.addAuthor("Jee Vang");
		document.addCreator("Jee Vang");

		Paragraph paragraph = new Paragraph();
		paragraph.add(new Chunk("hello!"));
		document.add(paragraph);

		document.close();
	}

}
