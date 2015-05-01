package controller;

import model.dao.UserDao;
import model.entity.User;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author asmolik
 */
@WebServlet(name = "login", loadOnStartup = 1, urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    @EJB
    UserDao userDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        processRequest(req, resp);
    }

    protected void processRequest(
            HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();
        // Output the results
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Servlet LoginServlet</title>");
        out.println("</head>");
        out.println("<body>");
        out.println(
                "<h1>Servlet LoginServlet at " + request.getContextPath()
                        + "</h1>");

        try {
            String name = request.getParameter("name");
            String password = request.getParameter("password");

            if ((name != null) && (name.length() > 0) &&
                    (password != null) && (password.length() > 0)) {
                User user = userDao.find(name, password);
                if (user != null) {
                    request.getSession().setAttribute("user", user);
                    response.sendRedirect("/pik/hello");
                } else {
                    response.sendRedirect("/pik/login");
                }
            } else {
                out.println("<p>Enter user name:</p>");
                out.println("<form method=\"get\">");
                out.println(
                        "<p><input type=\"text\" name=\"name\" size=\"25\"></p>");
                out.println("<br/>");
                out.println("<p>Enter password:</p>");
                out.println(
                        "<p><input type=\"password\" name=\"password\" size=\"25\"></p>");
                out.println("<br/>");
                out.println(
                        "<input type=\"submit\" value=\"Submit\">"
                                + "<input type=\"reset\" value=\"Reset\">");
                out.println("</form>");
            }
        } finally {
            out.println("</body>");
            out.println("</html>");
            out.close();
        }
    }
}
