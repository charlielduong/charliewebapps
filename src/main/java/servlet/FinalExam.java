package servlet;

// Simple example servlet from slides
import javax.servlet.*; // servlet library
import javax.servlet.http.*; // servlet library
import java.io.*;
import javax.servlet.annotation.WebServlet;

// The @WebServletannotation is used to declare a servlet
@WebServlet(name = "FinalExamServlet", urlPatterns = { "/FinalExam" })

public class FinalExam {

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); // Tells the web container what we're sending back
        PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window

        out.println("<html> " +
                "<head>" +
                "<title> SWE 432-001 Final Exam</title>" +
                "<link rel='stylesheet' type='text/css' href='/styles/FinalExam.css'/>" +
                "<link rel='stylesheet' type='text/css' href='/styles/default.css'/>" +
                "</head>" +
                "<body>" +
                "<h1>final exam!</h1>" +
                "</body>" +
                "</html>");
        out.close();
    } // end doGet()
}
