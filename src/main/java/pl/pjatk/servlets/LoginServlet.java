package pl.pjatk.servlets;



import pl.pjatk.hibernate_mds.models.EtlProcessLogModel;
import pl.pjatk.hibernate_mds.services.EtlProcessesLogModelService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@WebServlet(urlPatterns = "/login.do")
public class LoginServlet extends HttpServlet {


    EtlProcessesLogModelService lol = new EtlProcessesLogModelService();
    List<EtlProcessLogModel> procs =  new ArrayList<>();




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        Calendar cal = Calendar.getInstance();
        String tday = new SimpleDateFormat("dd-MMM").format(cal.getTime());
        tday = tday.toUpperCase();
        procs = lol.findByDate(tday);
        //procs = lol.findAll();
        request.setAttribute("procs", procs);
        request.setAttribute("today", tday);
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

}