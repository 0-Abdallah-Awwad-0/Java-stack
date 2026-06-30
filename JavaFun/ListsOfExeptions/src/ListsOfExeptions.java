import java.util.ArrayList;

public class ListsOfExeptions {

    public static void main(String[] args) {

        ArrayList<Object> myList = new ArrayList<Object>();

        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");


        for (int i = 0; i < myList.size(); i++) {

            try {

                Integer castedValue = (Integer) myList.get(i);

                System.out.println("Casted value: " + castedValue);

            } catch (ClassCastException e) {

                System.out.println("Error: " + e);
                System.out.println("Index where error happened: " + i);
                System.out.println("Value that caused the error: " + myList.get(i));
                System.out.println();

            }

        }

    }

}