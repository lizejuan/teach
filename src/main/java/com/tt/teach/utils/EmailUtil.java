package com.tt.teach.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

/**
 *@作者:lizejuan
 *@时间:2018/12/22 10:48
 *@描述:邮箱的工具类
 */
public class EmailUtil {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String from;
    //发送邮箱的方法
    public void sendEmailPlus( String email, String title, String context, MultipartFile file) throws MessagingException {
        //1.创建一封信
        MimeMessage mimeMessage =javaMailSender.createMimeMessage();
        //2.找个信封，把信放在里边
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
        //3.在信封上边写给谁发，主题是，内容是，附件是
        helper.setFrom(from);
        helper.setTo(email);
        helper.setSubject(title);
        helper.setText(context);
        String fileName = file.getOriginalFilename();
        helper.addAttachment(fileName,file);
        //4.将信封交给邮局(java邮局)发送出去
        javaMailSender.send(mimeMessage);
    }
}
