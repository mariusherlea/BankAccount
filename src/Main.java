public class Main {
    public static void main(String[] args) {


        Customer marius=new Customer("Marius","ma@df.re",12344567);

        Customer ion=new Customer("Ion","ma@df.re",12344567);
        Account ionAccount = new Account(ion);
        Account MariusAccount = new Account(marius);
        MariusAccount.depozit(100);


        MariusAccount.checkBalance();
        ionAccount.checkBalance();

        MariusAccount.transfer(ionAccount,120);



    }
}
