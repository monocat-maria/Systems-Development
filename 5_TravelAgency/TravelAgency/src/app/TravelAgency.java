package app;

/**
 *
 * @author monocat-maria <github.com/monocat-maria>
 */
import customer.TravelPackage;
import customer.Sale;
import logistics.*;
import java.util.Scanner;

public class TravelAgency {
    
    public static void main(String args[]){    
        Scanner input = new Scanner(System.in);
        
        //Cadastrar Venda pelo console
        String customer_name;
        String destination;
        String transport_type;
        String lodge_description;
        int quantity_days;
        
        System.out.println("\t--Travel Agency--");
        System.out.println("Enter the customer's name:");
        customer_name = input.nextLine();
        
        System.out.println("Enter your travel destination:");
        destination = input.nextLine();
        
        System.out.println("Enter the transport type:");
        transport_type = input.nextLine();
        
        System.out.println("Enter the name of the lodge:");
        lodge_description = input.nextLine();
        
        System.out.println("Enter the number of days for the trip:");
        quantity_days = input.nextInt();
        
        System.out.println("\nTravel Package created successfully!");
        System.out.println("Customer: " + customer_name 
                + "\nDestination: " + destination 
                + "\nTransport type: " + transport_type 
                + "\nLodge Description: " + lodge_description
                + "\nTravel days: " + quantity_days + " day(s).");

//Scanner to receive user information for creating sales
        double booking_price;
        double transport_price;
        double dollar_quote;
        double profit_margin;
        
        System.out.println("\n\t--Travel Package Sale--");
              
        System.out.println("Enter the logde's booking price in USD:");
        booking_price = input.nextDouble();
        
        System.out.println("Enter transportation value in USD:");
        transport_price = input.nextDouble();
        
        System.out.println("\nEnter profit margin on the package (%):");
        profit_margin = input.nextDouble();
        
        //Scanner for the user to inform the dollar exchange rate for the day.
        System.out.println("Enter the current dollar rate (USD):");
        dollar_quote = input.nextDouble();
        
        //Travel Package object created and association of objects between the attributes of the created classes
        TravelPackage travel = new TravelPackage(destination,quantity_days);
        
        Transport transport_input = new Transport(transport_type,transport_price);
        TravelPackage.customer_transport = transport_input;
        
        Lodge lodge_input = new Lodge(lodge_description,booking_price);
        TravelPackage.customer_lodge = lodge_input;
        
        Sale customer = new Sale(customer_name);
        Sale.sale_package = travel;
        
        //Configurando para calcular as informações e printar no console
        double totalAccommodationValue = travel.calculateTotalAccommodation(booking_price, quantity_days,transport_price,0);
        double profit = travel.calculateProfit(profit_margin, totalAccommodationValue, 0);
        double totalPackageValue = travel.calculateTotalPackage(totalAccommodationValue,profit,0);
        
        //Fazendo conversao de BRL para USD
        double totalPackageDollarValue = customer.convertUSD_BRL(dollar_quote, totalPackageValue, 0);
        double totalAccommodationDollarValue  =  customer.convertUSD_BRL(dollar_quote, totalAccommodationValue,0);
        double dollarProfit = customer.convertUSD_BRL(dollar_quote, profit,0);
        
        //Informações do pacote criado e informar uma margem de lucro(porcentagem)
        //Sout informações quando finalizar de preencher os dados e fazer a compra. Mostrando o valor em dolar e real
        System.out.println("--Informações da Venda--");
        System.out.println(customer.totalPackageBRL_USD(totalPackageValue, totalAccommodationValue,profit, totalPackageDollarValue, totalAccommodationDollarValue, dollarProfit, profit_margin,0));
                 
    }

}
