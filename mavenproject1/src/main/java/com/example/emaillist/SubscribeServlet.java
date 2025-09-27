package com.example.emaillist;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.ServletContext;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@WebServlet(name = "SubscribeServlet", urlPatterns = {"/subscribe"})
public class SubscribeServlet extends HttpServlet {

    @SuppressWarnings("unchecked")
    private Set<String> getEmailSet(ServletContext ctx) {
        Object obj = ctx.getAttribute("EMAIL_SET");
        if (obj == null) {
            Set<String> set = new HashSet<>();
            ctx.setAttribute("EMAIL_SET", set);
            return set;
        }
        return (Set<String>) obj;
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");

        String email = req.getParameter("email");
        String first = req.getParameter("firstName");
        String last = req.getParameter("lastName");

        // Validate r?t c? b?n
        if (email == null || email.isBlank()
                || first == null || first.isBlank()
                || last == null || last.isBlank()) {

            req.setAttribute("message",
                    "Please fill out all three text boxes.");
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        // Ki?m tra trùng email (in-memory)
        Set<String> emails = getEmailSet(getServletContext());
        if (emails.contains(email.trim().toLowerCase())) {
            req.setAttribute("message",
                    "This email address already exists.<br/>Please enter another email address.");
            // ?? l?i d? li?u ng??i dùng ?ã nh?p
            req.setAttribute("email", email);
            req.setAttribute("firstName", first);
            req.setAttribute("lastName", last);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
            return;
        }

        // L?u (demo: ch? l?u vào Set trong b? nh?)
        emails.add(email.trim().toLowerCase());

        // Chuy?n sang trang thành công
        req.setAttribute("firstName", first);
        req.getRequestDispatcher("/success.jsp").forward(req, resp);
    }
}
