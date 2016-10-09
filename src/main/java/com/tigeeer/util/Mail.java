package com.tigeeer.util;


import com.tigeeer.pojo.Config;
import com.tigeeer.pojo.Receive;

import javax.mail.Authenticator;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * Created by tigeeer on 2016/10/9.
 */
public class Mail {

    public static void send(Receive receive) throws MessagingException {
        // ���÷����ʼ��Ļ�������
        final Properties props = new Properties();
        /*
         * ���õ����ԣ� mail.store.protocol / mail.transport.protocol / mail.host /
         * mail.user / mail.from
         */
        // ��ʾSMTP�����ʼ�����Ҫ���������֤
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.host", Config.smtp);
        // �����˵��˺�
        props.put("mail.user", Config.user);
        // ����SMTP����ʱ��Ҫ�ṩ������
        props.put("mail.password", Config.password);

        // ������Ȩ��Ϣ�����ڽ���SMTP���������֤
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                // �û���������
                String userName = props.getProperty("mail.user");
                String password = props.getProperty("mail.password");
                return new PasswordAuthentication(userName, password);
            }
        };
        // ʹ�û������Ժ���Ȩ��Ϣ�������ʼ��Ự
        Session mailSession = Session.getInstance(props, authenticator);
        // �����ʼ���Ϣ
        MimeMessage message = new MimeMessage(mailSession);
        // ���÷�����
        InternetAddress form = new InternetAddress(
                props.getProperty("mail.user"));
        message.setFrom(form);

        // �����ռ���
        InternetAddress to = new InternetAddress(receive.getToMail());
        message.setRecipient(RecipientType.TO, to);

/*        // ���ó���
        InternetAddress cc = new InternetAddress("1606088706@qq.com");
        message.setRecipient(RecipientType.CC, cc);

        // �������ͣ��������ռ��˲��ܿ������͵��ʼ���ַ
        InternetAddress bcc = new InternetAddress("aaaaa@163.com");
        message.setRecipient(RecipientType.CC, bcc);*/

        // �����ʼ�����
        message.setSubject(receive.getTitle());

        // �����ʼ���������
        message.setContent(receive.getContent(), "text/html;charset=UTF-8");

        // �����ʼ�
        Transport.send(message);
    }
}