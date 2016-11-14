package jufou.info;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Created by HQ on 10/18/16.
 */
public class SessionListener implements HttpSessionListener {
    public void sessionCreated(HttpSessionEvent se) {
        System.out.println("==== Session is created ====");
        se.getSession().setMaxInactiveInterval(60*60);

    }
    public void sessionDestroyed(HttpSessionEvent se) {

    }
}
