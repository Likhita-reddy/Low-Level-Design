import java.util.List;

public class ExactExpense extends Expense{

    public ExactExpense(double totalAmount, User paidBy, List<User> participants, List<Split> splits) {
        super(totalAmount, paidBy, participants);
        this.splits = splits;
    }

    @Override
    List<Split> generateSplits() {
        double totalSplitAmount = 0;
        for(Split split: splits){
            totalSplitAmount += split.getAmount();
        }
        if(totalSplitAmount != totalAmount){
            throw new IllegalArgumentException("Total split amount does not match total expense amount.");
        }
        return splits;
    }
}
