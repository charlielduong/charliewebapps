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
        String[] formatInput = request.getParameterValues("dateFormat");
        String[] dateInput = request.getParameterValues("data");

        // First parse the received data
        int selection = 0;
        String[] months = { "January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December" };
        switch (formatInput[0]) {
            case "MM-DD-YYYY":
                selection = 1;
                break;
            case "Month-DD-YYYY":
                selection = 2;
                break;
            case "DD-Month-YYYY":
                selection = 3;
                break;
            case "DD-Month":
                selection = 4;
                break;
            case "M/DD/YY":
                selection = 5;
                break;
            default:
                selection = 0;
        }

        if (selection == 0) {
            return;
        }

        String[] dateArray = dateInput[0].split("-");
        int YYYY = Integer.parseInt(dateArray[0]);
        int YY = Integer.parseInt(String.valueOf(YYYY).substring(0, 2));
        int DD = Integer.parseInt(dateArray[2]);
        int MM = Integer.parseInt(dateArray[1]);
        String month = null;

        int temp = MM - 1;
        for (int i = 0; i < 12; i++) {
            if (temp == 0) {
                month = months[i];
                break;
            }
        }

        // Parsing done, now printing the results
        out.println("<div style='background-color: lightgrey; border-radius: 5px; width: 50%; margin: auto;'>");

        if (selection == 1) {
            out.println("<p>The date is: " + MM + "/" + DD + "/" + YYYY + "</p>");
        } else if (selection == 2) {
            out.println("<p>The date is: " + month + " " + DD + ", " + YYYY + "</p>");
        } else if (selection == 3) {
            out.println("<p>The date is: " + DD + " " + month + ", " + YYYY + "</p>");
        } else if (selection == 4) {
            out.println("<p>The date is: " + DD + "-" + month + "</p>");
        } else if (selection == 5) {
            out.println("<p>The date is: " + MM + "/" + DD + "/" + YYYY + "</p>");
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
