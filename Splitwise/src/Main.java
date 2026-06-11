import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String args[]){
        User alice = new User("Alice", "1");
        User bob = new User("Bob", "2");
        User charlie = new User("Charlie", "3");

        Group group = new Group("Goa Trip", List.of(alice,bob,charlie),new ArrayList<>());

        Expense equalExpense = new EqualExpense(1200,alice,List.of(alice,bob,charlie));
        equalExpense.generateSplits();
        System.out.println(equalExpense);
    }
}