package by.academy.web.logic;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/hello")
public class Start extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType( "text/html" );
        resp.setCharacterEncoding( "UTF-8" );
        PrintWriter writer = resp.getWriter();
        writer.write( "<p><span style='color: blue;'>Привет мир!</span></p>" );
    }
}
