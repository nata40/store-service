package pl.danielsiwulec.controller;

import pl.danielsiwulec.dao.OrderDao;
import pl.danielsiwulec.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* download today Date and setting Date format */
        Date nowdate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String nowDateString  = simpleDateFormat.format(nowdate);
        /*  attribution request to variable */
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String nameOrder = request.getParameter("nameorder");
        /* Create product and add to database */
        if(!(firstName.equals("") || lastName.equals("") || nameOrder.equals(""))){
            try{
                OrderDao dao = new OrderDao();
                Product product = null;
                product = new Product(firstName,lastName,nameOrder,nowDateString);
                dao.createOrder(product);
                request.getRequestDispatcher("finished.jsp").forward(request,response);

            }catch (SQLException e){
                e.printStackTrace();
            }
        }else{
            request.getRequestDispatcher("error.jsp").forward(request,response);

        }

    }

}