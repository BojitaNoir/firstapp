package mx.edu.utez.firstapp.controllers.user;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mx.edu.utez.firstapp.models.user.DaoUser;
import mx.edu.utez.firstapp.models.user.User;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "users", urlPatterns = {
        "/user/users",
        "/user/user",
        "/user/user-view",
        "/user/save",
        "/user/user-view-update",
        "/user/update",
        "/user/delete"
})
public class ServletUser extends HttpServlet {
    private String action;
    private String redirect = "/user/users";
    private String id,name, surname, lastname, username, birthday, status;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        action = req.getServletPath();
        switch (action) {
            case "/user/users":
                List<User> users = new DaoUser().findAll();
                req.setAttribute("users", users);
                redirect = "/views/user/index.jsp";
                break;
            case "/user/user-view":
                redirect = "/views/user/create.jsp";
                break;
            case "/user/user-view-update":
                id =req.getParameter("id");
                User user=new DaoUser().findOne(id !=null ? Long.parseLong(id):0);
                    if( user !=null){
                        req.setAttribute("user",user);
                        redirect="/views/user/update.jsp";
                    } else{
                    redirect="/user/users?result"+false+"$message="+URLEncoder.encode("",StandardCharsets.UTF_8);
            }
                break;
            default:
                System.out.println(action);
        }
        req.getRequestDispatcher(redirect).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        action = req.getServletPath();
        switch (action) {
            case "/user/user-view-update":
                String id = req.getParameter("id");
                User user = new DaoUser().findOne(
                        id != null ? Long.parseLong(id) : 0
                );
                if (user != null) {
                    req.setAttribute("user", user);
                    redirect = "/views/user/update.jsp";
                } else {
                    redirect = "/user/users";
                }
                break;
            case "/user/save":
                name = req.getParameter("name");
                surname = req.getParameter("surname");
                lastname = req.getParameter("lastname");
                username = req.getParameter("username");
                birthday = req.getParameter("birthday");
                User user1 = new User(0L, name, surname, lastname,birthday, username, "ACTIVO");
                boolean result = new DaoUser().save(user1);
                if (result) {
                    redirect = "/user/users?result" + result + "&message=" + URLEncoder.encode
                            ("Usuario registrado correctamente", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/users?result" + result + "&message=" + URLEncoder.encode
                            ("Error Usuario no registrado correctamente", StandardCharsets.UTF_8);
                }
                break;
            case "/user/update":
                id = req.getParameter("id");
                name = req.getParameter("name");
                surname = req.getParameter("surname");
                lastname = req.getParameter("lastname");
                username = req.getParameter("username");
                birthday = req.getParameter("birthday");
                status = req.getParameter("status");
                user = new User(Long.parseLong(id), name, surname, lastname,birthday, username, status);
                if (new DaoUser().update(user)) {
                    redirect = "/user/users?result" + true + "&message=" + URLEncoder.encode
                            ("Usuario actualizado correctamente", StandardCharsets.UTF_8);
                } else {
                    redirect = "/user/users?result" + true + "&message=" + URLEncoder.encode
                            ("Error Usuario no actualizado correctamente", StandardCharsets.UTF_8);
                }
                break;
            case "/user/delete":
                id = req.getParameter("id");
                if (new DaoUser().delete(Long.parseLong(id))) {
                    redirect = "/user/users?result="+true+"&message="+ URLEncoder.encode("¡Exito! Usuario eliminado correctamente.", StandardCharsets.UTF_8);
                }else
                    redirect = "/user/users?result="+false+"&message="+ URLEncoder.encode("¡ERROR! Usuario no eliminado.", StandardCharsets.UTF_8);

                break;
            default:
                redirect = "/user/users";
        }
        resp.sendRedirect(req.getContextPath() + redirect);
    }

}