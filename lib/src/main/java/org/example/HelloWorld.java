package org.example;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.http.*;

public class HelloWorld extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        Properties props = new Properties();
        try (InputStream in = getClass().getResourceAsStream("/hello.properties")) {
            props.load(in);
        }
        resp.setContentType("text/html");
        resp.getWriter().write("<p>" + props.getProperty("message") + "</p>");
    }
}
