package ex14;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.MultiPartEmail;

public class EtcServiceImpl implements EtcService {

	private static EtcService etcService;

	private EtcServiceImpl(){
	}

	public static EtcService sharedInstance(){
		if(etcService == null)
			etcService = new EtcServiceImpl();
		return etcService;
	}

	@Override
	public boolean mailSend(HttpServletRequest request) {
		boolean result = false;
		try {
			String sender = request.getParameter("sender");
			String receiver = request.getParameter("receiver");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			Part part = request.getPart("file");
			String contentDisposition = part.getHeader("content-disposition");
			String[] contentSplitStr = contentDisposition.split(";");
			int firstQutosIndex = contentSplitStr[2].indexOf("\"");
			int lastQutosIndex = contentSplitStr[2].lastIndexOf("\"");
			String uploadFileName = contentSplitStr[2].substring(firstQutosIndex + 1, lastQutosIndex);
			System.out.println(uploadFileName);
			MultiPartEmail email = new MultiPartEmail();
			// Smtp 서버 연결 설정.
			email.setHostName("smtp.naver.com");
			email.setSmtpPort(465);
			email.setAuthentication("ggangpae11", "cyberadam");
			String rt = "";
			// Smtp SSL, TLS 설정
			email.setSSLOnConnect(true);
			email.setStartTLSEnabled(true);						
			email.setCharset("utf-8");
			// 받는 사람 설정
			email.addTo(receiver, "받는 이", "utf-8");
			// 보내는 사람 설정
			email.setFrom(sender, "박문석", "utf-8");

			// 제목 설정
			email.setSubject(subject);
			// 본문 설정
			email.setMsg(content);

			if (uploadFileName.length() != 0) {
				File f = new File("/Users/munseokpark/Downloads/" + uploadFileName);
				part.write(uploadFileName);
				EmailAttachment attach = new EmailAttachment();
				attach.setName("");
				attach.setPath(f.getPath());
				email.attach(attach);
			}
			email.send();
			result = true;

		} catch (Exception e) {
			System.out.println("메일 보내기 실패:" + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public String download(HttpServletRequest request, HttpServletResponse response) {
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(request.getParameter("addr"));
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			if (conn != null) {
				conn.setConnectTimeout(20000);
				conn.setUseCaches(false);
				if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
					InputStreamReader isr = new InputStreamReader(conn.getInputStream());
					BufferedReader br = new BufferedReader(isr);
					while (true) {
						String line = br.readLine();
						if (line == null) {
							break;
						}
						sb.append(line + "\n");
					}

					br.close();
					conn.disconnect();
				}
			}
		} catch (Exception e) {
			System.out.println("가져오기 실패:" + e.getMessage());
		}
		return sb.toString();
	}

	public void push(HttpServletRequest request, HttpServletResponse response) {
		PrintWriter writer = null;
		try {
			response.setContentType("text/event-stream");
			response.setCharacterEncoding("UTF-8");
			writer = response.getWriter();
			Random r = new Random();
			writer.write("data: " + (r.nextInt(46)+1) + "\n\n");
			Thread.sleep(5000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		writer.close();
	}


}

