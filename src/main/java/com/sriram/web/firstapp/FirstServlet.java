package com.sriram.web.firstapp;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Enumeration;

@Slf4j
@WebServlet(
        description = "First Servlet",
        urlPatterns = {
                "/FirstServlet",
                "/FirstServlet.do"
        },
        initParams = {
                @WebInitParam(name = "id", value = "1"),
                @WebInitParam(name = "name", value = "Sriram")
        }
)
public class FirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public static final String HTML_START = "<html><body>";
    public static final String HTML_END = "</body></html>";

    public FirstServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("inside  doGet of FirstServlet");
        PrintWriter out = resp.getWriter();
        Date date = new Date();
        Enumeration<String> headers = req.getHeaderNames();
        while(headers.hasMoreElements()) {
            String header = headers.nextElement();
            Enumeration<String> values = req.getHeaders(header);
            while (values.hasMoreElements()) {
                log.debug(header + " : " + values.nextElement());
            }
        }
        out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Date="+date +"</h3>"+HTML_END);
    }
}
