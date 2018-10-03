import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class home extends HttpServlet {

    public home(){
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // auto generated method
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String storedToken = (String) session.getAttribute("csrfToken");
        String token = request.getParameter("tokenval");

		/* If the received CSRF token valid alert Sucess Message */
        if (storedToken.equals(token)) {

            PrintWriter out = response.getWriter();
            out.print("<script language='JavaScript'>alert('Success');</script>");

        } else {

            PrintWriter out = response.getWriter();
            out.print("<script language='JavaScript'>alert('Error');</script>");
        }
    }
}
