package app;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProductDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProductsDTO> list = new ArrayList<>();
    ConnectDAO des = new ConnectDAO();

    public void registerProduct(ProductsDTO product) {
        int status;
        //connect database
        conn = new ConnectDAO().connectDB();

        try {
            prep = conn.prepareStatement("INSERT INTO products VALUES(?,?,?,?)");

            prep.setString(1, Integer.toString(product.getId()));
            prep.setString(2, product.getName());
            prep.setString(3, Integer.toString(product.getPrice()));
            prep.setString(4, product.getStatus());
            status = prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product registered successfully!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error registering product: " + ex.getMessage());
        }

        des.desconnectDB();

    }

    public ArrayList<ProductsDTO> listProducts() {

        try {
            conn = new ConnectDAO().connectDB();
            prep = conn.prepareStatement("SELECT * FROM products;");
            resultset = prep.executeQuery();

            while (resultset.next()) {
                ProductsDTO product = new ProductsDTO();

                //Consultar id
                product.setId(resultset.getInt("id"));
                //Consultar nome
                product.setName(resultset.getString("name"));
                //Consultar valor
                product.setPrice(resultset.getInt("price"));
                //Consultar status
                product.setStatus(resultset.getString("status"));

                list.add(product);
                des.desconnectDB();
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error querying data: " + ex.getMessage());
        }

        return list;
    }

    public void sellProduct(Integer id) {
        try {
            conn = new ConnectDAO().connectDB();
            prep = conn.prepareStatement("UPDATE products SET status= 'Sold' WHERE id=?;");

            prep.setInt(1, id);

            prep.executeUpdate();
            JOptionPane.showMessageDialog(null, "Product sold successfully!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Unable to sell product: " + e.getMessage());
        }

    }

    public ArrayList<ProductsDTO> listProductsSold() {

        ArrayList<ProductsDTO> productsSold = new ArrayList<>();

        try {
            conn = new ConnectDAO().connectDB();
            prep = conn.prepareStatement("SELECT * FROM products WHERE status = 'Sold';");

            resultset = prep.executeQuery();

            while (resultset.next()) {
                ProductsDTO product = new ProductsDTO();

                product.setId(resultset.getInt(1));
                product.setName(resultset.getString(2));
                product.setPrice(resultset.getInt(3));
                product.setStatus(resultset.getString(4));

                productsSold.add(product);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Unable to view products sold: " + ex.getMessage());
        }

        return productsSold;

    }

}
