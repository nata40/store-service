package pl.danielsiwulec.controller;

import com.mysql.cj.x.protobuf.MysqlxCrud;
import pl.danielsiwulec.dao.OrderDao;

import javax.print.DocFlavor;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = request.getParameter("deleteid");
        Integer idInt = 0;
        
        if(!id.equals("")){
            idInt = Integer.parseInt(id);
        } else {
            request.getRequestDispatcher("error.jsp").forward(request,response);
        }
        

        /* download idList from the database */
        /* this prevents you from entering an incorrect ID*/
        List<Integer> idList = new ArrayList<>();
        OrderDao dao = new OrderDao();
        try{

            idList = dao.listAllID();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }

        /* deleted product after ID */
        for (int i = 0; i < idList.size(); i++) {

                try{
                    if(idInt.equals(idList.get(i))) {
                        dao.deleteProduct(idInt);
                        request.getRequestDispatcher("finished.jsp").forward(request, response);
                    }

                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }


            }
        /* if everything is wrong, redirect  */
        request.getRequestDispatcher("error.jsp").forward(request,response);
        }

    }

