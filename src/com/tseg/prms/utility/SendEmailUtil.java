package com.tseg.prms.utility;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.log4j.Logger;

public class SendEmailUtil {
    private static final Logger log = Logger.getLogger(SendEmailUtil.class);
    static final String from = "tseg_prms@126.com";
    static final String passwd = "tseg666";
    
    public static boolean sendMail(String emailAddr,String title,String message){
        Properties props = new Properties();
        props.put( "mail.smtp.auth",   "true");
        props.put("mail.smtp.host", "smtp.126.com");
        props.put("mail.smtp.port", 25); 
        try {
            Session session = Session.getDefaultInstance(props,
                    new Authenticator() {
                        protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                            return new javax.mail.PasswordAuthentication(from,
                                    passwd);
                        }
                    });
            session.setDebug(true);
            InternetAddress fromAddr = new InternetAddress(from);
            InternetAddress toAddr = new InternetAddress(emailAddr);

            
            MimeMessage msg = new MimeMessage(session);
            msg.setFrom(fromAddr);
            msg.addRecipient(Message.RecipientType.TO, toAddr);
            msg.setSubject(title);
            msg.setSentDate(new Date());
            msg.setContent(message, "text/html;charset=utf-8");
            Transport.send(msg);
            return true;
        } catch (MessagingException mex) {
            if(log.isDebugEnabled()) {
                log.error("send failed, exception: " + mex);
            }
            return false;
        }
    }
    
    
    static String TSEG_ACTIVE_TEXT;
    static{
    	TSEG_ACTIVE_TEXT = 
            "USER_NAME，你好！" +
            "<br/>" +
            "<div>" +
            "任务通知" +
            "<br/>" +
            "这是一封来自	TSEG项目报告管理系统</b>——PROJECT_NAME	的任务信，" +
            "请你按时按量完成以下任务:" +"<br/>" +
            "TASK_CONTENT"
            +"<br/>" +
            "感谢您的支持，祝你工作顺利！" +
            "</div>" +
            "<br/>" +
            "<div style=''>TSEG_PRMS开发团队</div>" +
            "<br/>" +
            "这是一封系统邮件，请勿回复" +
            "<br/>" +
            "——————————————————————————————" +"<br/>" +
            "系统主页：59.64.156.92/prms/" +
            "<br/>" +
            "客服信箱：756110664@QQ.COM" +
            "<br/>" +
            "客服QQ：756110664";
    }
    // email, name , taskContent
    public static boolean sendTaskMail(String email,String name,String projectName,String taskContent){
        if(log.isDebugEnabled()) log.debug("发送任务邮件");
        String text = TSEG_ACTIVE_TEXT;
        text = text.replaceAll("USER_NAME", name);
        text = text.replaceAll("TASK_CONTENT", taskContent);
        text = text.replace("PROJECT_NAME", projectName);
        return SendEmailUtil.sendMail(email, "TSEG项目任务信", text);
    }

}
