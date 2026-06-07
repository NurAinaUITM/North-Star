package controller;

import dao.UserDAO;
import model.UserBean;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. Get data from login.html form
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        // 2. Put data into the Model
        UserBean user = new UserBean();
        user.setEmail(email);
        user.setPassword(password);
        
        // 3. Send to DAO for validation
        UserDAO dao = new UserDAO();
        
        if (dao.validateLogin(user)) {
            // 4. Create Session upon success
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            
            // 5. Redirect User to Dashboard
            response.sendRedirect("DashboardServlet"); // Or directly to dashboard.jsp
        } else {
            // Fail: Redirect back to login with an error
            response.sendRedirect("login.html?error=invalid");
        }
    }
}
