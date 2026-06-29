import java.util.ArrayList;
public class TestCafe {
    public static void main(String[] args){
        CafeUtil appTest = new CafeUtil();
        System.out.print("\n---Streak Goal Test---\n");
        System.out.println("Purchases needed by week 10 is ="+ appTest.getStreakGoal());
        double[] orders = {1,5,8,14};
        System.out.println("the total of orders is:"+appTest.getOrderTotal(orders));
        System.out.println("Display menu Items:");
        ArrayList<String> menu = new ArrayList<String>();
        menu.add("Coffee");
        menu.add("Tea");
        menu.add("Late");
        menu.add("French Vanil");
        appTest.displayMenu(menu);
        System.out.println("Adding customers");
        ArrayList<String> customers = new ArrayList<String>();
        for (int i =0; i<4;i++){
            appTest.addCustomer(customers);
            System.out.println();
        }
    }
}
