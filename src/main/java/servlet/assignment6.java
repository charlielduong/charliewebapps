package servlet;

// Simple example servlet from slides
import javax.servlet.*; // servlet library
import javax.servlet.http.*; // servlet library
import java.io.*;
import javax.servlet.annotation.WebServlet;

// The @WebServletannotation is used to declare a servlet
@WebServlet(name = "Assignment6Servlet", urlPatterns = { "/assignment6" })

public class assignment6 extends HttpServlet // Inheriting from HttpServlet makes this a servlet
{
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHeader(out);
        String[] characteristic = request.getParameterValues("characteristicName");
        String[] values = request.getParameterValues("blocks");

        out.println("<body>");

        out.println("<div>");
        out.println("  <div style='text-align: center;'>");
        out.println("    <h1 style='margin-bottom: 0px; padding-top: 5%;'>SWE 432-001 ASSIGNMENT #6</h1>");
        out.println("    <h2>Charlie Duong &nbsp; | &nbsp; Khai Nguyen &nbsp; | &nbsp; Jesse Tran</h2><br>");
        out.println("    <h3>Characteristics and their blocks</h3>");
        out.println("  </div>");

        out.println("  <div style='background-color: white; border-radius: 5px; width: 50%; margin: auto; padding: 1em;'>");

        //out.println("<p> " + values.length + " " + characteristic.length +"</p>");
        printCharacteristics(request, out);
        printEC(request, out);
        // for(String s : values) {
        //     String line = "";
        //     line += "<p>[ ";

        //     int value = Integer.parseInt(s);
        //     for(int i = 1; i <= value; i++) {
        //         line += characteristic[i-1] + "-" + i;
        //         if (i < value) {
        //             line += ",";
        //         }
        //         line += " ";
        //     }

        //     line += "]</p>";
        //     out.println(line);
        // }

        out.println("  </div>");
        out.println("</div>");

        out.println("</body>");

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
        out.println("<title>SWE 432-001 Assignment 6</title>");
        out.println("<meta name='description' content='SWE 432-001 Assignment #6'>");
        out.println("<meta name='author' content='Charlie Duong, Khai Nguyen, Jesse Tran'>");
        out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        // out.println("<link rel='icon' href='../assets/icon.png'>");

        // CSS FILES MUST BE WITHIN "WEBAPP" FOLDER
        out.println("<link rel='stylesheet' type='text/css' href='/styles/assignment3.css'/>");
        out.println("<link rel='stylesheet' type='text/css' href='/styles/default.css'/>");

        out.println("<script src='js/assignment6.js'></script>");

        out.println("</head>");
    }

    private void printBody(PrintWriter out) {
        out.println("<body>");

        out.println("<div>");
        out.println("  <div style='text-align: center;'>");
        out.println("    <h1 style='margin-bottom: 0px; padding-top: 5%;'>SWE 432-001 ASSIGNMENT #6</h1>");
        out.println("    <h2>Charlie Duong &nbsp; | &nbsp; Khai Nguyen &nbsp; | &nbsp; Jesse Tran</h2>");
        out.println("  </div>");

        out.println("  <div style='background-color: white; border-radius: 5px; width: 50%; margin: auto;'>");
        out.println("    <form method='post' action='assignment6'>");
        out.println("      <table id='form' style='text-align: right; margin: auto; margin-top: 5%; width: 100% !important;'>");
        out.println("        <tr>");
        out.println("          <td style='text-align:center;'>Enter a positive number of characteristics: </td>");
        out.println("          <td>");
        out.println("            <input style='width: 100%;' type='number' min='1' id='totalInputs' placeholder='1' autofocus required>");
        out.println("          </td>");
        out.println("          <td>");
        out.println("            <input style='width: 100%;' id='gen' type='button' class='primary' value='Generate' onclick='generateButton()'>");
        out.println("          </td>");
        out.println("        </tr>");

        // GENERATED TABLE SHOULD GO HERE

        out.println("        <tr>");
        out.println("          <td></td>");
        out.println("          <td></td>");
        out.println("          <td style='text-align: right;'>");
        out.println("            <input type='submit' class='primary' value='Submit' style='width: fit-content; width: 100%; margin-bottom: 5px;' onclick='checkInputs();'>");
        out.println("            <br>");
        out.println("            <input type='reset' class='secondary' value='Reset' style='width: fit-content; width: 100%;' onclick='resetButton();'>");
        out.println("          </td>");
        out.println("        </tr>");
        out.println("      </table>");
        out.println("    </form>");
        out.println("  </div>");

        out.println("  <br></br>");
        out.println("  <hr>");
        out.println("  </hr>");
        out.println("  <br></br>");

        // COLLABORATION SUMMARY  
        out.println("  <div style='background-color: white; border-radius: 5px; width: 50%; margin: auto;'>");
        out.println("    <div style='padding: 10px'>");
        out.println("      <h3>Collaboration Summary:</h3>");
        out.println("        <p>Khai Nguyen: Converted assignment 3 frontend to java servlet and relinked necessary files i.e. css and js.</p>");
        out.println("        <p>Jesse Tran: Contributed towards reorganized doGet method and implementing getpost. redid form data.</p>");
        out.println("        <p>Charlie Duong: Contributed towards implementation of getPost, output formatting, and integrated javascript file into doGet.</p>");
        out.println("    </div>");
        out.println("  </div>");
        out.println("</div>");

        out.println("</body>");
    }   

    private void printTail(PrintWriter out) {
        out.println("");
        out.println("</html>");
    }

    private void printCharacteristics(HttpServletRequest request, PrintWriter out) {
        String[] characteristic = request.getParameterValues("characteristicName");
        String[] values = request.getParameterValues("blocks");
        
        int curr = 0;
        for(String s : values) {
            String line = "";
            line += "<p>[ ";
            int value = Integer.parseInt(s);
            for(int i = 0; i < value; i++) {
                line += characteristic[curr] + "-" + (i+1);
                if (i < value-1) {
                    line += ",";
                }
                line += " ";
            }

            line += "]</p>";
            
            out.println(line);
            curr++;
        }
    }

    private void printEC(HttpServletRequest request, PrintWriter out){
        String[] characteristic = request.getParameterValues("characteristicName");
        String[] values = request.getParameterValues("blocks");

        

        //Find maximum # of blocks among the characteristics
        int maxCharacteristics = 0;
        for(int i=0; i<characteristic.length; i++){
            if(Integer.parseInt(characteristic[i]) > maxCharacteristics){ maxCharacteristics = i; }
        }

        //Find
        out.println("<p> " + maxCharacteristics + " Each-Choice Abstract Tests: ");

        // Printing each ECC
        for(int i=0; i<maxCharacteristics; i++){ 
            String line = "<p>[ ";
            for(int j=0; j<characteristic.length; j++){
                line += characteristic[i] + "-" + (j+1);
                // if (i < value-1) {
                //     line += ",";
                // }
                line += " ";
            }
            out.println(line);
        }

        out.println("</p>");
        
    }

    private void printBC(){

    }
}