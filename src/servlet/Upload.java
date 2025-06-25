package servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import database.Database;

public class Upload extends HttpServlet {

    private static final int maxLenP = 100, maxLenT = 21500;
    private static Database data = new Database();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String txt = request.getParameter("text");
        String password = request.getParameter("password");
        if (password == null) password = "";
        if (txt == null || password.length() > maxLenP || txt.length() > maxLenT) {
            response.getWriter().print(0);
            return ;
        }
        int fileId = 0;
        try {
            fileId = data.getFileId() + 1;
        } catch (Exception e) {
            response.getWriter().print(0);
            return ;
        }
        try {
            data.set(txt, password);
        } catch (Exception ex) {
            response.getWriter().print(0);
            return ;
        }
        response.getWriter().print(fileId);
        return ;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}