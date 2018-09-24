package com.sriram.web.firstapp;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static com.sriram.web.firstapp.FirstServlet.HTML_END;
import static com.sriram.web.firstapp.FirstServlet.HTML_START;

@Slf4j
@WebServlet(
        description = "Second Servlet",
        urlPatterns = {
            "/SecondServlet",
            "/SecondServlet.do"
        },
        initParams = {
            @WebInitParam(name = "name", value = "Sriram"),
            @WebInitParam(name = "id", value = "2")
        }
)
public class SecondServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        log.debug("Iniside init method of SecondServlet.");
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Inside doGet method of SecondServlet");
        PrintWriter out = resp.getWriter();
        val headers = req.getHeaderNames();
        while (headers.hasMoreElements()) {
            String header = headers.nextElement();
            val values = req.getHeaders(header);
            while (values.hasMoreElements()) {
                log.debug(header + " : " + values.nextElement());
            }
        }
        out.println(HTML_START + "<h2>Hi There!</h2><br/><h3>Timestamp = " + System.currentTimeMillis() + "</h3>"+HTML_END);
    }

    @Override
    public void destroy() {
        log.debug("Inside destroy method of SecondServlet");
        super.destroy();
    }
}
