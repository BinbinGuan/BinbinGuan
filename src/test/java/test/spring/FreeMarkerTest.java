package test.spring;

import com.idcos.Application;
import com.idcos.export.item.MailAuthenticator;
import com.sun.mail.util.MailSSLSocketFactory;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.security.GeneralSecurityException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author GuanBin
 * @version FreeMarkerTest.java, v1 2018/5/2 上午11:04 GuanBin Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootConfiguration
@SpringBootTest(classes = Application.class)
public class FreeMarkerTest {
    @Autowired
    Configuration                   configuration;

    private transient Authenticator authenticator;

    @Test
    public void testFreeMarker() throws Exception {
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("time", new Date());
        model.put("message", "这是测试的内容。。。");
        model.put("toUserName", "张三");
        model.put("fromUserName", "老许");

        Template t = configuration.getTemplate("test.html"); // freeMarker template
        String content = FreeMarkerTemplateUtils.processTemplateIntoString(t, model);

        sendMail(content);


        //mailService.sendHtmlMail(to, "主题：html邮件", content);

    }

    public void sendMail(String content) {
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

        properties.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        properties.setProperty("mail.smtp.host", host);   // 发件人的邮箱的 SMTP 服务器地址
        properties.setProperty("mail.smtp.auth", "true");            // 需要请求认证
        authenticator = new MailAuthenticator("guanbinbin@idcos.com", "GuanBin123");
        Session session = Session.getInstance(properties);
        try {

            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setFrom();
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject("This is the Subject Line");
            message.setText(content);
//            Transport transport = session.getTransport();
//            transport.connect("guanbinbin@idcos.com","GuanBin123");
            Transport.send(message);
            System.out.println("Sent message successfully...");
        } catch (Exception mex) {
            mex.printStackTrace();
        }

    }

}
