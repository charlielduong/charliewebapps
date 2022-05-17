package servlet;

// Simple example servlet from slides
import javax.servlet.*; // servlet library
import javax.servlet.http.*; // servlet library
import java.io.*;
import javax.servlet.annotation.WebServlet;

// The @WebServletannotation is used to declare a servlet
@WebServlet(name = "FinalExamServlet", urlPatterns = { "/FinalExam" })

public class FinalExam extends HttpServlet // Inheriting from HttpServlet makes this a servlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHeader(out);

        out.println(
                "<body>" +
                        "<h1> Final Exam </h1>" +
                        "</body>");

        printTail(out);
        out.close();

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); // Tells the web container what we're sending back
        PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
        printHeader(out);
        printBody(out);
        printTail(out);
        out.close();
    } // end doGet()

    private void printHeader(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SWE 432-001 Final Exam </title>");
        out.println("<link rel='stylesheet' type='text/css' href='/styles/FinalExam.css'/>");
        out.println("<link rel='stylesheet' type='text/css' href='/styles/default.css'/>");

        out.println("<script src='js/FinalExam.js'></script>");

        out.println("</head>");
    }

    private void printBody(PrintWriter out) {
        out.println("<body>");
        out.println("<h1> Final Exam </h1>");
        out.println("</body>");
    }

    private void printTail(PrintWriter out) {
        out.println("");
        out.println("</html>");
    }
}