import java.util.ArrayList;
import java.util.Scanner;
public class CafeUtil {
    public int getStreakGoal(){
        int total=0;
        for(int i = 0 ; i <= 10 ; i++){
            total+=i;
        }
        return total;
    }
    public double getOrderTotal(double[]prices){
        double orderTotal=0;
        for (int i=0;i<prices.length;i++){
            orderTotal+=prices[i];
        }
        return orderTotal;
    }
    public void displayMenu(ArrayList<String>menuItems){
        for (int i=0;i<menuItems.size();i++){
            System.out.println(i+"the item is : "+menuItems.get(i));
        }
    }
    public void addCustomer(ArrayList<String>Customers){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your name please");
        String username = input.nextLine();
        System.out.println("Hello" + username+ "!");
        System.out.println("There is " + Customers.size()+" People in front of you");
        Customers.add(username);
        System.out.println(Customers);
    }
}
