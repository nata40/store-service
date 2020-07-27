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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /* download today Date and setting Date format */
        Date nowdate = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        String nowDateString  = simpleDateFormat.format(nowdate);
        /*  attribution request to variable */
        String id = request.getParameter("updateid");
        request.setCharacterEncoding("UTF-8");
        String firstName = request.getParameter("firstname");
        String lastName = request.getParameter("lastname");
        String nameOrder = request.getParameter("productname");
        /* download all id List */
        List<Integer> idList = new ArrayList<>();
        OrderDao dao = new OrderDao();
        try{

            idList = dao.listAllID();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        Integer idInt = 0;

        if(!id.equals("")){
            idInt = Integer.parseInt(id);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }



        /* update product */
        for (int i = 0; i < idList.size(); i++) {
            try {
                    if(!(firstName.equals("") || lastName.equals("") || nameOrder.equals("") || id.equals("")) && idInt.equals(idList.get(i))) {
                        dao = new OrderDao();
                        Product product = null;
                        product = new Product(firstName, lastName, nameOrder, nowDateString);
                        dao.updateProduct(product, idInt);
                        request.getRequestDispatcher("finished.jsp").forward(request, response);
                    }
                } catch (SQLException e) {
                    e.printStackTrace();

                }
        }
        request.getRequestDispatcher("error.jsp").forward(request,response);






    }



}

