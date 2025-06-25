package servlet;

import database.Database;
import database.PairString;
import java.io.IOException;
import java.util.regex.Pattern;

import javax.servlet.*;
import javax.servlet.http.*;

public class Download extends HttpServlet {

    private static final int maxLen = 100;
    private static final Database data = new Database();

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileIdSting = request.getParameter("fileId");
        String passwordString = request.getParameter("password");
        if (passwordString == null) passwordString = "";
        if (fileIdSting == null || passwordString.length() > maxLen || !isInteger(fileIdSting)) {
            response.getWriter().print("");
            return ;
        }

        int fileId = Integer.parseInt(fileIdSting);
        if (fileId <= 0) {
            response.getWriter().print("");
            return ;
        }
        PairString res;
        try {
            res = data.get(fileId);
        } catch (Exception e) {
            response.getWriter().print("");
            return ;
        }
        if (res.password == null
                || !res.password.equals(passwordString)) {
            response.getWriter().print("");
            return ;
        }
        response.setContentType("text/html; charset=UTF-8");
        response.getWriter().print(res.fileName);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}