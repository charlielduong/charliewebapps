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
        out.println("<div style='text-align: center;'>" +
                "<h1>SWE 432-001 Final Exam</h1>" +
                "<h2>Charlie Duong G01191814</h2>" +
                "<br>" +
                "<h3>Output</h3>");
        printResults(request, response);
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

    public void printResults(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); // Tells the web container what we're sending back
        PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
        String[] dateInput = request.getParameterValues("dateFormat");
        String[] formatInput = request.getParameterValues("data");

        // First parse the received data
        int month = day = year = 0;
        int selection = 0;

        dateInput[0].deleteCharAt(0);
        dateInput[0].deleteCharAt(dateInput[0].length() - 1);

        String[] dateArray = dateInput[0].split("-");
        out.println("<div style='background-color: lightgrey; border-radius: 5px; width: 50%; margin: auto;'>");

        for (String s : dateArray) {
            out.println("<p>[ " + s + "]</p>");
        }
        for (String s : formatInput) {
            out.println("<p>[ " + s + "]</p>");
        }

        out.println("</div>");

        out.close();
    } // end printResults()

    private void printHeader(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SWE 432-001 Final Exam </title>");
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
                "<input type='date' name='data'/>" +
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

        out.println("<div style='background-color: lightgrey; border-radius: 5px; width: 50%; margin: auto;'>");
        out.println("<form action='/FinalExam' style='text-align: center; margin-top: 5%' method='POST'>");
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
