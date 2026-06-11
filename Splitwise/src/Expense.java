import java.util.List;

public abstract class Expense {
    protected double totalAmount;
    protected User paidBy;
    protected List<User> participants;
    protected List<Split> splits;

    public Expense(double totalAmount, User paidBy, List<User> participants) {
        this.totalAmount = totalAmount;
        this.paidBy = paidBy;
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "totalAmount=" + totalAmount +
                ", paidBy=" + paidBy +
                ", participants=" + participants +
                ", splits=" + splits +
                '}';
    }

    abstract List<Split> generateSplits();
}
