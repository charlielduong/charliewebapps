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
        String[] test = request.getParameterValues("data");
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        printHeader(out);
        out.println("<div style='text-align: center;'>" +
                "<h1>SWE 432-001 Final Exam</h1>" +
                "<h2>Charlie Duong G01191814</h2>" +
                "<br>" +
                "<h3>Output</h3>");

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
        // out.println("<link rel='stylesheet' type='text/css'
        // href='/styles/FinalExam.css'/>");
        // out.println("<link rel='stylesheet' type='text/css'
        // href='/styles/default.css'/>");

        out.println("<script src='js/FinalExam.js'></script>");

        out.println("</head>");
    }

    private void printBody(PrintWriter out) {
        out.println("<body>");

        String title = "<div style='text-align: center'>" +
                "<h1>SWE 432-001 Final Exam</h1>" +
                "<h2>Charlie Duong G01191814</h2>" +
                "</div>";

        out.println(title);

        String dateDiv = "<div style='position:relative; right:158px; top:10px'>" +
                "<label> Date: </label>" +
                "<input type='date'/>" +
                "</div>";
        String selectDiv = "<div style='position:relative; right:200px; top:10px'>" +
                "<label> Choose date format: </label>" +
                "<select name='dateFormat' id='dateFormat' required>" +
                "<option value='MM-DD-YYYY'>MM/DD/YYYY</option>" +
                "<option value='Month-DD-YYYY'>Month DD YYYY</option>" +
                "<option value='DD-Month-YYYY'>DD Month YYYY</option>" +
                "<option value='DD-Month'>DD-Month</option>" +
                "<option value='M/DD/YY'>M/DD/YY</option>" +
                "</select>" +
                "</div>";

        out.println("<div style='background-color: grey; border-radius: 5px; width: 50%; margin: auto;'>");
        out.println("<form action='/FinalExam' name='data' style='text-align: center; margin-top: 5%' method='POST'>");
        out.println(dateDiv);
        out.println(selectDiv);
        out.println("<input style='position:relative; left:50px; top: -20px;' type='submit'/>");
        out.println("   </form>");
        out.println("</div>");
        out.println("</body>");
    }

    private void printTail(PrintWriter out) {
        out.println("");
        out.println("</html>");
    }
}