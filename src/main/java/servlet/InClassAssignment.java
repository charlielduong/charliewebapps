package servlet;

// Simple example servlet from slides
import javax.servlet.*; // servlet library
import javax.servlet.http.*; // servlet library
import java.io.*;
import javax.servlet.annotation.WebServlet;

// The @WebServletannotation is used to declare a servlet
@WebServlet(name = "InClassAssignment", urlPatterns = { "/InClassAssignment" })

public class InClassAssignment extends HttpServlet // Inheriting from HttpServlet makes this a servlet
{
    // Location of servlet.
    // static String Domain = "cs.gmu.edu:8443";
    // static String Path = "/offutt/servlet/";
    // static String Servlet = "twoButtons";

    // Button labels
    static String OperationAdd = "Add";
    static String OperationSub = "Subtract";

    // Other strings.
    static String Style = "STYLEFOLDERPATH";

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Float rslt = new Float(0.0);
        Float lhsVal = new Float(0.0);
        Float rhsVal = new Float(0.0);
        String operation = request.getParameter("Operation");
        String lhsStr = request.getParameter("LHS");
        String rhsStr = request.getParameter("RHS");
        if ((lhsStr != null) && (lhsStr.length() > 0))
            lhsVal = new Float(lhsStr);
        if ((rhsStr != null) && (rhsStr.length() > 0))
            rhsVal = new Float(rhsStr);

        if (operation.equals(OperationAdd)) {
            rslt = new Float(lhsVal.floatValue() + rhsVal.floatValue());
        } else if (operation.equals(OperationSub)) {
            rslt = new Float(lhsVal.floatValue() - rhsVal.floatValue());
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHeader(out);
        printBody(out, lhsStr, rhsStr, rslt.toString());
        printTail(out);

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
        out.println("");

        out.println("<head>");
        out.println("<title>Two buttons example</title>");
        out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"" + Style + "\">");
        out.println("</head>");
        out.println("");
    }

    private void printBody(PrintWriter out, String lhs, String rhs, String rslt) {
        out.println("<body>");
        out.println("<p>");
        out.println("A simple example that demonstrates how to operate with");
        out.println("multiple submit buttons.");
        out.println("</p>");
        out.print("<form method='post' action='InClassAssignment'>");
        out.println("");
        out.println(" <table>");
        out.println("  <tr>");
        out.println("   <td>First value:");
        out.println("   <td><input type=\"text\" name=\"LHS\" value=\"" + lhs + "\" size=5>");
        out.println("  </tr>");
        out.println("  <tr>");
        out.println("   <td>Second value:");
        out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + rhs + "\" size=5>");
        out.println("  </tr>");
        out.println("  <tr>");
        out.println("   <td>Result:");
        out.println("   <td><input type=\"text\" name=\"RHS\" value=\"" + rslt + "\" size=6>");
        out.println("  </tr>");
        out.println(" </table>");
        out.println(" <br>");
        out.println(" <br>");
        out.println(" <input type=\"submit\" value=\"" + OperationAdd + "\" name=\"Operation\">");
        out.println(" <input type=\"submit\" value=\"" + OperationSub + "\" name=\"Operation\">");
        out.println(" <input type=\"reset\" value=\"Reset\" name=\"reset\">");
        out.println("</form>");
        out.println("");
        out.println("</body>");
    }

    private void printBody(PrintWriter out) {
        printBody(out, "", "", "");
    }

    private void printTail(PrintWriter out) {
        out.println("");
        out.println("</html>");
    } // End PrintTail
}