package org.spring.springboot.service.ServiceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Properties;

@Component
public class EmailClient {
    @Resource
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;

    private static int cnt = 0;
    private String[] mailArray = {"1375090938@qq.com","13121001661@qq.com","1154892415@qq.com"};
    private String[] passwordArray = {"xsxdvkbmsvkebadc","dfueevndrgunfdgj","ngrkgvjxvfxqgeje"};


    /**
     * 发送纯文本邮件.
     *
     * @param to      目标email 地址
     * @param subject 邮件主题
     * @param text    纯文本内容
     */
    public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        try {
            javaMailSender.send(message);
        }catch (Exception e){
            e.printStackTrace();
        }

//        int index = (int)(Math.random()*mailArray.length);
//        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        sender.setHost("smtp.qq.com");
//        sender.setPort(465);
//        System.out.println(mailArray[index]);
//        System.out.println(passwordArray[index]);
//        sender.setUsername(mailArray[index]);
//        sender.setPassword(passwordArray[index]);
//        Properties p = new Properties();
//        p.setProperty("mail.smtp.ssl.enable","true");
//        p.setProperty("mail.smtp.auth","true");
//        sender.setJavaMailProperties(p);
//        sender.send(message);
    }
}
