package app;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */

public class ProductsDTO {
    private Integer id = 0;
    private String name;
    private Integer price;
    private String status;
    
    ProductsDTO(){
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setStatus(String status) {
        this.status = status;
    }
      
}
