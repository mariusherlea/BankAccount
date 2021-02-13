import java.util.ArrayList;

public class Account {
    private Customer customer;
    private float balance = 0;
    private ArrayList<String> eventArray = new ArrayList<>();


    public Account(Customer customer) {
        this.customer = customer;
        System.out.println("Account for " + customer.getName() + " was created. " + this.balance + " is initial balance");

    }

    private void insertIntoEventArray(String operation) {
        eventArray.add(operation);

    }

    public void exposeEventArray() {
        System.out.println(customer.getName() + " has do the following operation");
        for (int x = 0; x < eventArray.size(); x++) {
            System.out.println(eventArray.get(x));
        }
    }

    public void depozit(float amount) {
        if (amount > 0) {
            this.balance += amount;
            System.out.println(customer.getName() + " debozit " + amount);
            insertIntoEventArray("depozit");
        } else {
            System.out.println("Invalid amount");
        }

    }

    public void witdraw(float amount) {
        if (balance < amount) {
            System.out.println(customer.getName() + " dont have enough funds to witdraw " + amount);

        } else {
            this.balance -= amount;
            System.out.println(customer.getName() + " witdraw " + amount);
            insertIntoEventArray("witdraw");
        }

    }


    public void transfer(Account target, float amount) {
        if (amount < balance) {
            witdraw(amount);
            target.depozit(amount);
            System.out.println(amount + " was successful transfer from " + customer.getName() + " to " + target.customer.getName());
            insertIntoEventArray("transfer");
        } else {
            System.out.println("nu sunt bani");
        }


    }


    public void checkBalance() {
        System.out.println(customer.getName() + " has a " + getBalance() + " balance");
    }


    public float getBalance() {
        return balance;
    }


}
