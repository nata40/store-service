/*All methods and queries to connect to the database   */

package pl.danielsiwulec.dao;

import pl.danielsiwulec.model.Product;
import pl.danielsiwulec.util.ConnectionProvider;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDao {
    private final static String CREATE_ORDER = "INSERT INTO products(firstname,lastname,productname,todaydate) " +
            "VALUES(?,?,?,?);";
    private final static String PRINT_RECORD = "SELECT firstname,lastname,productname,todaydate,idproducts FROM products;";
    private final static String SEARCH_DATA = "SELECT firstname, lastname, productname, todaydate FROM products WHERE idproducts = ?;";
    private final static String UPDATE_PRODUCT = "UPDATE products SET firstname=?, lastname=?, productname=?, todaydate=? WHERE idproducts = ?;";
    private final static String DELETE_PRODUCT = "DELETE FROM products WHERE idproducts =?;";
    private final static String PRINT_ALL_PRODUCT = "SELECT productname,idproducts FROM products;";
    private final static String PRINT_ALL_ID = "SELECT idproducts FROM products;";





    public void createOrder(Product product) throws SQLException {
        try(Connection conection = ConnectionProvider.getConnection();
            PreparedStatement preparedStatement = conection.prepareStatement(CREATE_ORDER)){
            preparedStatement.setString(1,product.getFirstName());
            preparedStatement.setString(2,product.getLastName());
            preparedStatement.setString(3,product.getProductName());
            preparedStatement.setString(4,product.getTodayDate());
            preparedStatement.executeUpdate();
            System.out.println("dodano produkt");

        }
    }
    /* additional option to print all Record in db */
   public List<Product> allRecordPrint() throws SQLException, ClassNotFoundException{
        List<Product> productList;

        try(Connection connection = ConnectionProvider.getConnection();
        PreparedStatement prepStmt = connection.prepareStatement(PRINT_RECORD)){
            ResultSet resultSet = prepStmt.executeQuery();
            String firstName;
            String lastName;
            String productName;
            String todayDate;
            int idNumber;
            productList = new ArrayList<>();
            while (resultSet.next()){

                firstName = resultSet.getString("firstname");
                lastName = resultSet.getString("lastname");
                productName = resultSet.getString("productname");
               todayDate = resultSet.getString("todaydate");
                idNumber = resultSet.getInt("idproducts");
                Product product = new Product(firstName,lastName,productName,todayDate,idNumber);
               productList.add(product);

            }

        }
        return productList;
    }
    public List<Product> allProductsList() throws SQLException{
        List<Product> productList;

        try(Connection connection = ConnectionProvider.getConnection();
            PreparedStatement prepStmt = connection.prepareStatement(PRINT_ALL_PRODUCT)){
            ResultSet resultSet = prepStmt.executeQuery();
            String productName;
            int idNumber;
            productList = new ArrayList<>();
            while (resultSet.next()){

                productName = resultSet.getString("productname");
                idNumber = resultSet.getInt("idproducts");
                Product product = new Product(productName,idNumber);
                productList.add(product);

            }

        }
        return productList;
    }
    public List<Integer> listAllID() throws SQLException{
        List<Integer> idList;
        try(Connection connection = ConnectionProvider.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(PRINT_ALL_ID)){
            ResultSet resultSet = preparedStatement.executeQuery();
            int idNumber;
            idList = new ArrayList<>();
            while (resultSet.next()){
                idNumber = resultSet.getInt("idproducts");
                idList.add(idNumber);
            }
        }
        return idList;

    }

    public Product searchProductID(int id) throws SQLException {

        String firstName;
        String lastName;
        String productName;
        String todayDate;

        Product product = null;
        try(Connection connection = ConnectionProvider.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(SEARCH_DATA)){
            preparedStatement.setInt(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                firstName = resultSet.getString("firstname");
                lastName = resultSet.getString("lastname");
                productName = resultSet.getString("productname");
                todayDate = resultSet.getString("todaydate");
                product = new Product(firstName, lastName, productName, todayDate);
            }

        }
        return product;
    }

    public void updateProduct(Product product, int id) throws SQLException {
        try(Connection connection = ConnectionProvider.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_PRODUCT)){
            preparedStatement.setInt(5,id);
            preparedStatement.setString(1,product.getFirstName());
            preparedStatement.setString(2,product.getLastName());
            preparedStatement.setString(3,product.getProductName());
            preparedStatement.setString(4,product.getTodayDate());
            preparedStatement.executeUpdate();

        }

    }
    public void deleteProduct(int id) throws SQLException{
        try(Connection connection= ConnectionProvider.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_PRODUCT)){
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        }
    }


}
