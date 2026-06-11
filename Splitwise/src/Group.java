import java.util.List;

public class Group {
    public String name;
    private List<User> members;
    private List<Expense> expenses;

    public Group(String name, List<User> members, List<Expense> expenses) {
        this.name = name;
        this.members = members;
        this.expenses = expenses;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public List<User> getMembers() {
        return members;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
