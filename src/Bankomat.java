public class Bankomat {
    private int id;
    private double currentBalance;
    private double minWithdrawal;
    private double maxWithdrawal;
    
    private static int atmCount = 0;

    public Bankomat(int id, double currentBalance, double minWithdrawal, double maxWithdrawal) { 
        this.id = id;
        this.currentBalance = currentBalance;
        this.minWithdrawal = minWithdrawal;
        this.maxWithdrawal = maxWithdrawal;
        atmCount++;
    }

    public Bankomat() { 
        this(0, 0.0, 50.0, 5000.0);
    }

    public void initializeATM(int id, double initialBalance, double minWithdrawal, double maxWithdrawal) {
        this.id = id;
        this.currentBalance = initialBalance;
        this.minWithdrawal = minWithdrawal;
        this.maxWithdrawal = maxWithdrawal;
    }

    public void loadMoney(double amount) {
        if (amount > 0) {
            this.currentBalance += amount;
            System.out.println("Bankomat loaded with: " + amount);
        } else {
            System.out.println("Invalid amount. Cannot load money.");
        }
    }

    public boolean withdrawMoney(double amount) {
        if (amount < minWithdrawal || amount > maxWithdrawal) {
            System.out.println("Amount must be between " + minWithdrawal + " and " + maxWithdrawal);
            return false;
        } else if (amount > currentBalance) {
            System.out.println("Insufficient funds in the bankomat.");
            return false;
        } else {
            currentBalance -= amount;
            System.out.println("You have withdrawn: " + amount);
            return true;
        }
    }

    @Override
    public String toString() {
        return "Bankomat ID: " + id + ", Balance: " + currentBalance +
               ", Min Withdrawal: " + minWithdrawal + ", Max Withdrawal: " + maxWithdrawal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        
        Bankomat bankomat = (Bankomat) obj;
        return id == bankomat.id && currentBalance == bankomat.currentBalance &&
               minWithdrawal == bankomat.minWithdrawal && maxWithdrawal == bankomat.maxWithdrawal;
    }

    public static int getATMCount() {
        return atmCount;
    }

    public static void main(String[] args) {
        Bankomat atm1 = new Bankomat(101, 10000.0, 100.0, 5000.0);
        System.out.println(atm1);

        Bankomat atm2 = new Bankomat();
        atm2.initializeATM(102, 20000.0, 50.0, 4000.0);
        System.out.println(atm2);

        atm1.loadMoney(5000.0);
        System.out.println(atm1);

        atm1.withdrawMoney(3000.0);
        System.out.println(atm1);

        atm2.withdrawMoney(6000.0);

        System.out.println(atm1.equals(atm2));

        System.out.println("Total ATMs: " + Bankomat.getATMCount());
    }
}
