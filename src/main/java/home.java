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

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // auto generated method
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String storedToken = (String) session.getAttribute("csrfToken");
        String token = req.getParameter("tokenval");

		/* If the received CSRF token valid alert Sucess Message */
        if (storedToken.equals(token)) {

            PrintWriter out = resp.getWriter();
            out.print("<script language='JavaScript'>alert('Success');</script>");

        } else {

            PrintWriter out = resp.getWriter();
            out.print("<script language='JavaScript'>alert('Error');</script>");
        }
    }
}
