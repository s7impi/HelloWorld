package controller;

import model.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author asmolik
 */
@WebServlet(name = "hello", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet HelloServlet</title>");
        out.println("</head>");
        out.println("<body>");

        try {
            HttpSession session = req.getSession(false);
            User user = (User) session.getAttribute("user");
            String logout = req.getParameter("logout");
            if (logout != null && logout.equals("Logout")) {
                session.invalidate();
                resp.sendRedirect("/pik/login");
            } else {
                out.println("Hello " + user.getName() + "!");
                out.println("<form method=\"get\">");
                out.println("<input type=\"submit\" name = \"logout\" value=\"Logout\">");
                out.println("</form>");
            }
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}
