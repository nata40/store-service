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
import java.util.ArrayList;
import java.util.List;


@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        System.out.println("SearchServlet");
        List<Integer> idList = new ArrayList<>();
        OrderDao dao = new OrderDao();

        /* download idList from the database */
        /* this prevents you from entering an incorrect ID*/

        try{
            idList = dao.listAllID();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        String id = request.getParameter("id");
        Integer idInt = 0;


         /*protection against empty id */
        if(!id.equals("")){
            idInt = Integer.parseInt(id);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }

        /* search for a product by iD */

        for (int i = 0; i < idList.size(); i++) {
            try{
                if(idInt.equals(idList.get(i))){
                    dao = new OrderDao();
                    Product product;
                    product = dao.searchProductID(idInt);
                    request.setAttribute("product",product);
                    request.getRequestDispatcher("result.jsp").forward(request,response);
                }

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        /* if everything is wrong, redirect  */

        request.getRequestDispatcher("error.jsp").forward(request,response);
    }



}
