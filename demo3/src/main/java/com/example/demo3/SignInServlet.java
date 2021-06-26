package com.example.demo3;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "SignInServlet", value = "/sign-in")
public class SignInServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("sign-in.html").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("inputName");
        String pwd = req.getParameter("inputPassword");

        Map<String,String> map=new HashMap<>();
        File file=new File("D:\\2.txt");
        Path path=file.toPath();

        try(Stream<String>lines= Files.lines(path)){
            lines.forEach(line->{
                String[] iteams=line.split(" ");
                map.put(iteams[0],iteams[1]);
                    });
        }

        if(map.containsKey(name)&&map.get(name).equals(pwd)){
        req.getSession().setAttribute("user", name);
        resp.sendRedirect("index");
    }else{
            resp.sendRedirect("sign-up.jsp");
        }
    }
}
