package account;

class Account {

    int id;
    String name;
    double balance;

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    //no para
    public Account() {
    }

    //with para
    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }
}
