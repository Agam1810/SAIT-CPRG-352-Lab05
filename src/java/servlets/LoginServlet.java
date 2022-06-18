
package servlets;

import Services.AccountService;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // creates the new session 
        HttpSession session = request.getSession();
        String logOut = request.getParameter("logout");
        
        if(logOut!= null){
            session.invalidate();
            String message ="You have been successfully logged out.";
            request.setAttribute("message",message);
        
       
    // load the JSP and stop the code call
    getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
    }
        
        if(session.getAttribute("username")!= null){
            response.sendRedirect("home");
            return;
     }   
   getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
      return;
        
 }   
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        
        HttpSession session = request.getSession();
        
 
        User user = new AccountService().login(username, password);
        
      
         if (username == null || username.equals("") || password == null || password.equals("") || user==null) {
            request.setAttribute("message", "Please Enter the correct username and password.");
            request.setAttribute("username", username);
            request.setAttribute("password", password);
            
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        return;
        } 
         
         
         
         else if (user!=null) {
            
                session.setAttribute("username", username);
                response.sendRedirect("home");
                 return;
            }
        
    }
    }

    
   
    