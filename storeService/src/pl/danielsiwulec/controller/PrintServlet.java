package pl.danielsiwulec.controller;

import org.w3c.dom.ls.LSOutput;
import pl.danielsiwulec.dao.OrderDao;
import pl.danielsiwulec.model.Product;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/PrintServlet")
public class PrintServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


    /* Print allProduct list  */
        try{
            OrderDao dao = new OrderDao();
            List<Product> productList = dao.allProductsList();
            request.setAttribute("productList",productList);
            request.getRequestDispatcher("productList.jsp").forward(request,response);

        } catch (SQLException throwables) {
            throwables.printStackTrace();

        }


    }



}
