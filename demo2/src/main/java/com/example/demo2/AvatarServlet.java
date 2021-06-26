package com.example.demo2;

import com.talanlabs.avatargenerator.Avatar;
import com.talanlabs.avatargenerator.TriangleAvatar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/1")
public class AvatarServlet extends HelloServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Avatar avater= TriangleAvatar.newAvatarBuilder().build();
        byte[] bytes =avater.createAsPngBytes(123456L);
        response.getOutputStream().write(bytes);
    }
}
