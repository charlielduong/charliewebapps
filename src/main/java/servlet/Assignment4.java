package servlet;

// Simple example servlet from slides
import javax.servlet.*; // servlet library
import javax.servlet.http.*; // servlet library
import java.io.*;
import javax.servlet.annotation.WebServlet;

// The @WebServletannotation is used to declare a servlet
@WebServlet(name = "Assignment4Servlet", urlPatterns = { "/Assignment4" })

public class Assignment4 extends HttpServlet // Inheriting from HttpServlet makes this a servlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String operation = request.getParameter("GenerateTable");

        if(operation.equals("Generate")) {

        } 
        // GENERATE
        // RESET BUTTON
        // CHECKINPUTS
        // SUBMIT
        // SCRAP??
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html"); // Tells the web container what we're sending back
        PrintWriter out = response.getWriter(); // Make it appear as if we're "writing" to the browser window
        printHeader(out);
        printBody(out);
        out.close();
    } // end doGet()

    private void printHeader(PrintWriter out) {
        out.println("<html>");
        out.println("<head>");
        out.println("<title>SWE 432-001 Assignment 4</title>");
        out.println("<meta name='description' content='SWE 432-001 Assignment 4'>");
        out.println("<meta name='author' content='Charlie Duong, Khai Nguyen, Jesse Tran'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        // out.println("<link rel='icon' href='../assets/icon.png'>");

        // CSS FILES MUST BE WITHIN "WEBAPP" FOLDER
        out.println("<link rel='stylesheet' type='text/css' href='/styles/assignment3.css'/>");
        out.println("<link rel='stylesheet' type='text/css' href='/styles/default.css'/>");

        out.println("<script src='js/Assignment4.js'></script>");

        out.println("</head>");
    }

    private void printBody(PrintWriter out) {
        out.println("<body>");

        out.println("<div>");
        out.println("   <div style='text-align: center;'>");
        out.println("       <h1 style='margin-bottom: 0px; padding-top: 5%;'>SWE 432-001 ASSIGNMENT #4</h1>");
        out.println("       <h2>Charlie Duong &nbsp; | &nbsp; Khai Nguyen &nbsp; | &nbsp; Jesse Tran</h2>");
        out.println("</div>");

        out.println("<div style='background-color: white; border-radius: 5px; width: 50%; margin: auto;'>");
        out.println("<form method='post' action='https://cs.gmu.edu:8443/offutt/servlet/formHandler'>");
        out.println("<table id='form' style='text-align: right; margin: auto; margin-top: 5%; width: 100% !important;'>");
        out.println("<tr>");
        out.println("<td>Enter Positive Number of Inputs:</td>");
        out.println("<td>");
        out.println("<input style='width: 100%;' type='number' min='1' id='totalInputs' placeholder='1' autofocus required>");
        out.println("</td>");
        out.println("<td>");
        out.println("<input style='width: 100%;' id='gen' type='button' class='primary' value='Generate' style='width: 100%;' onclick='generateButton()'>");
        out.println("</td>");
        out.println("</tr>");

        // GENERATED TABLE SHOULD GO HERE


        out.println("<tr>");
        out.println("<td></td>");
        out.println("<td></td>");
        out.println("<td style='text-align: right;'>");
        out.println("<input type='reset' class='secondary' value='Reset' style='width: fit-content; width: 100%;' name='reset'>");
        out.println("<input type='submit' class='primary' value='Submit' style='width: fit-content; width: 100%;' onclick='checkInputs();'>");
        out.println("</td>");
        out.println("</tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</div>");

        out.println("<br></br>");
        out.println("<hr>");
        out.println("</hr>");
        out.println("<br></br>");

        // COLLABORATION SUMMARY  
        out.println("<div style='background-color: white; border-radius: 5px; width: 50%; margin: auto;'>");
        out.println("<div style='padding: 10px'>");
        out.println("<h3>Collaboration Summary:</h3>");
        out.println("<p>Khai Nguyen: Converted assignment 3 frontend to java servlet.</p>");
        out.println("<p>Jesse Tran: Implemented backend GET request.</p>");
        out.println("<p>Charlie Duong: Deployment testing.</p>");
        out.println("</div>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }


    
}

