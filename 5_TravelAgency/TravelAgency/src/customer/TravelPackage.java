package customer;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
import logistics.Lodge;
import logistics.Transport;

public class TravelPackage {
     public static Transport customer_transport;
     public static Lodge customer_lodge;
     public String destination;
     int quantity_days;
     
     public TravelPackage(String destination, int quantity_days){
         this.destination = destination;
         this.quantity_days = quantity_days;
        }
    //values in this class are considered in dollar
    
    public double calculateTotalAccommodation(double booking_price, int quantity_days,double transport_price, double totalAccommodation){
        //calcular o total de hospedagem a partir do número de dias e o valor da diária
        totalAccommodation = (booking_price * quantity_days) + transport_price;
        
        return totalAccommodation;
    }
    
    public double calculateProfit(double profit_margin, double totalPackageValue,double profit){
        //calculate profit value based on an informed margin (percentage) and informed value. The result returned must be the value + margin applied to the value.
        profit = (profit_margin * totalPackageValue) / 100;
        return profit;
    }
    
    public double calculateTotalPackage(double totalAccommodation, double profit,double totalPackage){
        //calculate and return the total package, adding transportation, total accommodation and additional values informed – profit margin (percentage) and additional fees (monetary value).
        totalPackage = totalAccommodation + profit;
      
        return totalPackage;
    }
}
