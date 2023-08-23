import java.util.HashMap;
import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        AtmOp obj = new AtmOp();
    }
}

class Data {
    float balance;
}

class AtmOp {
    Scanner sc = new Scanner(System.in);
    HashMap<Integer, Data> mp = new HashMap<>();

    AtmOp() {
        System.out.println("Welcome! How can I help you?");
        op();
    }

    public void op() {
        System.out.println("*********************************************");
        System.out.println("Enter Your Pin:");
        int pin = sc.nextInt();
        if (mp.containsKey(pin)) {
            Data obj = mp.get(pin);
            Menu(obj);
        } else {
            System.out.println("Create your Account first");
            System.out.println("Set your pin");
            int pinCode = sc.nextInt();
            Data obj = new Data();
            mp.put(pinCode, obj);
            Menu(obj);
        }
    }

    // Menu bar for all transactions
    public void Menu(Data obj) {
        System.out.println("*********************************************");
        System.out.println("Please enter a valid number");
        System.out.println("1: Withdraw Money");
        System.out.println("2: Check Balance");
        System.out.println("3: Deposit Money");
        System.out.println("4: Check another Account");
        System.out.println("5: Exit");

        int num = sc.nextInt();

        switch (num) {
            case 1:
                withdrawMoney(obj);
                break;
            case 2:
                checkBalance(obj);
                break;
            case 3:
                depositBalance(obj);
                break;
            case 4:
                op();
                break;
            case 5:
                System.out.println("Thank you!");
                break;
            default:
                System.out.println("Please Enter a Valid Number");
                Menu(obj);
                break;
        }
    }

    public void checkBalance(Data obj) {
        System.out.println("Your Balance is: " + obj.balance);
        Menu(obj);
    }

    public void depositBalance(Data obj) {
        System.out.println("**********************************************");
        System.out.println("Enter your amount");
        float amount = sc.nextFloat(); // Changed nextFloat() to sc.nextFloat()
        obj.balance += amount;
        System.out.println("Amount Deposited Successfully");
        Menu(obj);
    }

    public void withdrawMoney(Data obj) {
        System.out.println("*********************************************");
        System.out.println("Enter the amount to withdraw");
        float amount = sc.nextFloat(); // Changed nextFloat() to sc.nextFloat()
        if(obj.balance>amount){
           obj.balance -= amount;
         System.out.println("Amount Withdrawn Successfully");
        }
        else System.out.println("Insufficent Balance");
        Menu(obj);
    }
}
