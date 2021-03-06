
package servlet;
// Import Servlet Libraries
import javax.servlet.*;
import javax.servlet.http.*;

// Import Java Libraries
import java.io.*;
import java.util.Enumeration;

import javax.servlet.annotation.WebServlet;

@WebServlet(name = "attributeServlet", urlPatterns = {"/attributeServlet"})
public class attributeServlet extends HttpServlet
{
public void doGet (HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException
{
   // Get session object
   HttpSession session = request.getSession();

   String name   = request.getParameter("attrib_name");
   String value  = request.getParameter("attrib_value");
   String value2  = request.getParameter("attrib_value2");
   String remove = request.getParameter("attrib_remove");

   if (remove != null && remove.equals("on"))
   {
      session.removeAttribute("att_name");
      session.removeAttribute("att_value");
      session.removeAttribute("att_value2");
   }
   else
   {
      if (name != null && name.length() > 0){
          session.setAttribute("att_name",name);
      }
      if(value != null && value.length() > 0){
        session.setAttribute("att_value",value);
      }
      if(value2 != null && value2.length() > 0){
        session.setAttribute("att_value2",value2);
      }
   }

   response.setContentType("text/html");
   PrintWriter out = response.getWriter();

   out.println("<html>");
   // no-cache lets the page reload by clicking on the reload link
   out.println("<meta http-equiv=\"Pragma\" content=\"no-cache\">");
   out.println("<head>");
   out.println(" <title>Session lifecycle</title>");
   out.println("</head>");
   out.println("");

   out.println("<body>");
   out.println("<h1><center>Session attributes</center></h1>");

   out.println("Enter name and value of an attribute");

   // String url = response.encodeURL ("offutt/servlet/attributeServlet");
   String url = response.encodeURL("attributeServlet");
   out.println("<form action=\"" + url + "\" method=\"GET\">");
   out.println(" Name: ");
   out.println(" <input type=\"text\" size=\"10\" name=\"attrib_name\">");

   out.println(" Value: ");
   out.println(" <input type=\"text\" size=\"10\" name=\"attrib_value\">");

   out.println(" Second Value: ");
   out.println(" <input type=\"text\" size=\"10\" name=\"attrib_value2\">");

   out.println(" <br><input type=\"checkbox\" name=\"attrib_remove\">Remove");
   out.println(" <input type=\"submit\" name=\"update\" value=\"Update\">");
   out.println("</form>");
   out.println("<hr>");

   out.println("Attributes in this session:");
   Enumeration e = session.getAttributeNames();
   if (e.hasMoreElements())
   {
      String att_name  = (String) session.getAttribute("att_name");
      String att_value = (String) session.getAttribute("att_value");
      String att_value2 = (String) session.getAttribute("att_value2");

      out.print  ("<br><b>Name:</b> ");
      out.println(att_name);
      out.print  ("<br><b>Value:</b> ");
      out.println(att_value);
      out.print  ("<br><b>Second Value:</b> ");
      out.println(att_value2);
   } //end while

   out.println("</body>");
   out.println("</html>");
   out.close();
} // End doGet
} //End  SessionLifeCycle
