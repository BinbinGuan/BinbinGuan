package test;

import com.idcos.Application;
import com.idcos.export.item.MailAuthenticator;
import com.sun.mail.util.MailSSLSocketFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Properties;

/**
 * @author GuanBin
 * @version TestMail.java, v1 2017/12/6 上午12:02 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class TestMail {
    private transient Authenticator authenticator;

    @Test
    public void sendMail() {
        MailSSLSocketFactory sf = null;
        try {
            sf = new MailSSLSocketFactory();
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }
        sf.setTrustAllHosts(true);
        String to = "guanbinbin@idcos.com";
        String from = "guanbinbin@idcos.com";
        String host = "smtp.mxhichina.com";
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", host);
        properties.put("mail.smtp.auth", "true");

        //腾讯邮箱服务器可以用ssl加密方式
//        properties.put("mail.smtp.ssl.enable", "true");//设置是否使用ssl安全连接
//        properties.put("mail.smtp.ssl.socketFactory", sf);

        authenticator = new MailAuthenticator("guanbinbin@idcos.com", " GuanBin123");

        Session session = Session.getDefaultInstance(properties, authenticator);
        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is the Subject Line");
            message.setText("This is the Actural messge");
            Transport.send(message);
            System.out.println("Sent message successfully...");
        } catch (MessagingException mex) {
            mex.printStackTrace();
        }

    }
}
