package com.recetA.controller;

import java.io.IOException;
import javax.mail.Transport;
import javax.mail.Message;
import javax.mail.Address;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Session;
import com.recetA.domain.SMTPAuthenticator;
import javax.mail.Authenticator;
import java.util.Properties;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class QnaCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		String from = "nikovella@naver.com";
		String q_content = request.getParameter("content");
		String to = "smhrdrecetA@gmail.com";
		String subject = request.getParameter("title");
		
		Properties p = new Properties();
		
		p.put("mail.smtp.host", "smtp.naver.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable", "true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465");
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		p.put("mail.smtp.socketFactory.fallback", "false");
		// SMTP 서버에 접속하기 위한 정보들

		try{
		    Authenticator auth = new SMTPAuthenticator();
		    Session ses = Session.getInstance(p, auth);
		    
		    ses.setDebug(true);
		    
		    MimeMessage msg = new MimeMessage(ses); // 메일의 내용을 담을 객체
		    msg.setSubject(subject); // 제목
		    
		    Address fromAddr = new InternetAddress(from);
		    msg.setFrom(fromAddr); // 보내는 사람
		    
		    Address toAddr = new InternetAddress(to);
		    msg.addRecipient(Message.RecipientType.TO, toAddr); // 받는 사람
		    
		    msg.setContent(q_content, "text/html;charset=UTF-8"); // 내용과 인코딩
		    
		    Transport.send(msg); // 전송
		} catch(Exception e){
		    e.printStackTrace();
		    out.println("<script>alert('메일을 전송을 못했습니다..');history.back();</script>");
		    // 오류 발생시 뒤로 돌아가도록
		   
		    return;
		}

		out.println("<script>alert('문의 주셔서 감사합니다. 빠른 시일 이내 답변 드리겠습니다!');location.href='main.jsp';</script>");
		
		//response.sendRedirect("main.jsp");
	}
}
