package by.academy.web.logic;

import by.academy.web.model.Teacher;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(value = "/average-salary")
public class AverageSalary extends HttpServlet {
    private Accounting accounting;
    private List<Teacher> teachers;

    @Override
    public void init() throws ServletException {
        super.init();
        accounting = new Accounting();
        teachers = initModel();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType( "text/html" );
        resp.setCharacterEncoding( "UTF-8" );
        PrintWriter writer = resp.getWriter();
        writer.write( "<p><span style='color: blue;'>Средняя зарплата следующих преподавателей: "
                + averageSalary( teachers ) + "</span></p>" );
        teachers.forEach( teacher -> writer.write( teacher.getInfo() + "</p>" ) );
    }

    private BigDecimal averageSalary(List<Teacher> teachers) {
        List<Integer> salaries = teachers.stream()
                .map( Teacher::getSalary )
                .collect( Collectors.toList() );
        return accounting.average( salaries ).setScale( 2, RoundingMode.HALF_UP );
    }

    private List<Teacher> initModel() {
        return List.of(
                new Teacher( "Siarhey", 30, 7000 ),
                new Teacher( "Maxim", 27, 1900 ),
                new Teacher( "Dima", 13, 12 )
        );
    }
}