package com.tong.javaee.servlet;

import com.tong.javaee.servlet.websocket.UserWebSocketCreator;
import org.eclipse.jetty.websocket.servlet.WebSocketServlet;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

/**
 * Created by IDEA.
 * User: tjj.
 * Date : 2015/1/9
 * Time : 23:17
 */
public class FileUpAndDownloadWebServlet extends WebSocketServlet {
    @Override
    public void configure(WebSocketServletFactory factory) {
        factory.setCreator(new UserWebSocketCreator());
    }
}
