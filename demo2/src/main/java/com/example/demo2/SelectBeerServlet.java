package com.example.demo2;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "SelectBeerServlet", value = "/SelectBeerServlet")
public class SelectBeerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String body = request.getParameter("body");
        if (request.getParameter("amount") == null || request.getParameter("amount").equals("")) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>The amount is null.try again</h1>");
            out.println("</body><ml>");
        } else {
            int amount = Integer.parseInt(request.getParameter("amount")) + 2;
            String[] sizes = request.getParameterValues("sizes");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>This is get response</h1>");
            out.println("<p>body: " + body + "</p>");
            out.println("<p>amount: " + amount + "</p>");
            for (String s : sizes) {
                out.println("<p>sizes: " + s + "</p>");
            }
            out.println("</body></html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String body = request.getParameter("body");
        if((request.getParameter("amount")==null||request.getParameter("amount").equals(""))) {
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>The amount is null.try again</h1>");
            out.println("</body><ml>");
        }else {


            int amount = Integer.parseInt(request.getParameter("amount")) + 1;
            String[] sizes = request.getParameterValues("sizes");
            PrintWriter out = response.getWriter();
            out.println("<html><body>");
            out.println("<h1>This is post response</h1>");
            out.println("<p>body: " + body + "</p>");
            out.println("<p>amount: " + amount + "</p>");
            for (String s : sizes) {
                out.println("<p>sizes: " + s + "</p>");
            }
            out.println("</body></html>");
        }
    }
}
