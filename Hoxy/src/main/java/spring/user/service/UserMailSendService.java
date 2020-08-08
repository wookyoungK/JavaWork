package com.lec.spring.user.service;

import com.lec.spring.user.persistence.UserDAO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Service
public class UserMailSendService {

    private JavaMailSender mailSender;

    @Autowired
    private SqlSessionTemplate sessionTemplate;

    private UserDAO userDAO;

    // 이메일 난수 만드는 메서드
    private String init() {
        Random ran = new Random();
        StringBuffer sb = new StringBuffer();
        int num = 0;

        do {
            num = ran.nextInt(75) + 48;
            if ((num >= 48 && num <= 57) || (num >= 65 && num <= 90) || (num >= 97 && num <= 122)) {
                sb.append((char) num);
            } else {
                continue;
            }

        } while (sb.length() < size);
        if (lowerCheck) {
            return sb.toString().toLowerCase();
        }
        return sb.toString();
    }

    // 난수를 이용한 키 생성
    private boolean lowerCheck;
    private int size;

    public String getKey(boolean lowerCheck, int size) {
        this.lowerCheck = lowerCheck;
        this.size = size;
        return init();
    }

    // 회원가입 발송 이메일(인증키 발송)
    public void mailSendWithUserKey(String u_email, String u_id, HttpServletRequest request) {
        mailSender = new JavaMailSenderImpl();
        String key = getKey(false, 20);
        userDAO = sessionTemplate.getMapper(UserDAO.class);
        userDAO.GetKey(u_id, key);
        MimeMessage mail = mailSender.createMimeMessage();
        System.out.println(mail);
        System.out.println(u_email);
        System.out.println(u_id);
        System.out.println(key);
        String htmlStr = "<h2>안녕하세요 MS :p 민수르~ 입니다!</h2><br><br>"
                + "<h3>" + u_id + "님</h3>" + "<p>인증하기 버튼을 누르시면 로그인을 하실 수 있습니다 : "
                + "<a href='http://localhost:8084" + request.getContextPath() + "/user/key_alter?user_id="+ u_id +"&user_key="+key+"'>인증하기</a></p>"
                + "(혹시 잘못 전달된 메일이라면 이 이메일을 무시하셔도 됩니다)";
        try {
            mail.setSubject("[본인인증] MS :p 민수르님의 인증메일입니다", "utf-8");
            mail.setText(htmlStr, "utf-8", "html");
            mail.addRecipient(MimeMessage.RecipientType.TO, new InternetAddress(u_email));
            mailSender.send(mail);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    //public int alter_userKey_service(String u_id, String u_key){
    //    int res = 0;

    //    userDAO = sessionTemplate.getMapper(UserDAO.class);
    //    res = userDAO.alter_userKey(u_id, u_key);

    //    return res;
    //}
}
