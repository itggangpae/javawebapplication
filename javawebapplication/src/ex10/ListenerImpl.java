package ex10;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.*;

@WebListener
public class ListenerImpl implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("웹 애플리케이션 제거");

	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("웹 애플리케이션 시작");
	}

}
