import java.util.ArrayList;
import java.util.List;

public class EqualExpense extends Expense{

    public EqualExpense(double totalAmount, User paidBy, List<User> participants) {
        super(totalAmount, paidBy, participants);
    }

    @Override
    List<Split> generateSplits() {
        double splitAmount = totalAmount/(participants.size());
        List<Split> splits = new ArrayList<>();
        for(User user: participants){
            splits.add(new Split(user, splitAmount));
        }
        return this.splits = splits;
    }
}
