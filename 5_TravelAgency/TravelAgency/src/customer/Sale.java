package customer;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
public class Sale {
    public static String customer_name;
    private String payment_type;
    public static TravelPackage sale_package;
    
    public Sale(){
     
    }
    
    public Sale(String nome_cliente) {
        this.customer_name = nome_cliente;
        this.payment_type = "cash";
    }
    
    public double convertUSD_BRL(double dollar_quote, double real_value, double USD_BRL){
      USD_BRL = real_value * dollar_quote;
      return USD_BRL;
    }
    
    
    public double totalPackageBRL_USD(double totalPackage,double totalAccommodation,double profit,double totalDollarPackage,double totalAccommodationDollar,double totalLucroDolar, double profit_margin,double convert){
      //show the total of the travel package in dollars and reais on the screen.
      System.out.println("Total Package Value: $" + totalPackage + " (R$" + totalDollarPackage + " in reais.)"
                            + "\nTotal accommodation price: $" + totalAccommodation + " (R$" + totalAccommodationDollar + " in reais.)" 
                            + "\nProfit on the package: $" + profit + " (R$" + totalLucroDolar + " in reais.)" 
                            + "\nProfit Margin:" + profit_margin + "%");
      
      return convert;
    }
}
