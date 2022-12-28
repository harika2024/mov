import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.Time;
public class logout extends HttpServlet{
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException{
        HttpSession hs=req.getSession(false);
        PrintWriter output=res.getWriter();
        if(hs!=null){
            output.println("successfully logout");
            Time st=(Time) hs.getAttribute("time");
            Time end=new Time(hs.getLastAccessedTime());
            output.println("<br> Start time:"+st);
            output.println("<br> End time:"+end);
            hs.invalidate();
        }
        else{
            output.println("session expired");
            output.println("<br><a href=login.html>Relogin</a>");
        }
    }
}
