package org.ShapeShifter420.webapp.mailsender;
import org.springframework.context.annotation.PropertySource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

@PropertySource("classpath:src/application.properties")
public class MailSender {
    private static final String username = "";
    private static final String password = "";
    private final Properties props;
    public MailSender() {
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.ssl.enable", "true");
        props.put("mail.smtp.host", "smtp.yandex.ru");
        props.put("mail.smtp.port", 465);
        //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        //try{
        //FileInputStream fileInputStream = new FileInputStream("src/application.properties");
        //Properties property = new Properties();
       // property.load(fileInputStream);
        //username  = property.getProperty("MailSender.username");
        //password  = property.getProperty("MailSender.password");
        //fileInputStream.close();
        //} catch (IOException e) {
        //    e.printStackTrace();
        //}

    }

    public String send(String subject, String text, String toEmail) throws UnsupportedEncodingException {
        //Session session = Session.getInstance(props, new Authenticator() {
        //    protected PasswordAuthentication getPasswordAuthentication() {
        //        return new PasswordAuthentication(username, password);
        //    }
        //});
        //final String usr = new String(username.getBytes(),"cp1251");
        //final String psw = new String(password.getBytes(),"cp1251");
        //final String sub = new String(subject.getBytes(),"cp1251");
        //final String txt = new String(text.getBytes(),"cp1251");
        //final String email = new String(toEmail.getBytes(),"cp1251");
        Session session = Session.getDefaultInstance(props,
                //Аутентификатор - объект, который передает логин и пароль
                new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            Message message = new MimeMessage(session);
            //от кого
            message.setFrom(new InternetAddress(username));
            //кому
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            //Заголовок письма
            message.setSubject(subject);
            //Содержимое
            message.setText(text);
            //message.setSentDate(new Date());

            //Отправляем сообщение
            Transport.send(message);
            return ("Успех");
        } catch (MessagingException e) {
            System.out.println(e.toString());
            throw new RuntimeException(e);
        }
    }
}
