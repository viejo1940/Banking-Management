package BankingProject.testBank;

import BankingProject.Admin;
import BankingProject.Bank;
import BankingProject.LoginSystem;
import BankingProject.User;

import java.util.Scanner;
import java.util.UUID;

class TestBank {

    private static Bank bank;
    Admin admin;
    static Scanner scanner = new Scanner(System.in);

    public static String generateAccountId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "").substring(0, 16).toUpperCase();
    }

    public static void main(String[] args) {
        if (bank == null) {
            bank = new Bank("STB", "Jara", 404);
        }
        LoginSystem loginSystem = new LoginSystem(bank);
        Scanner scanner = new Scanner(System.in);
        while (loginSystem.getLoggedAdmin() == null) {
            System.out.println("Enter Admin ID: ");
            String adminId = scanner.nextLine();
            System.out.println("Enter Admin password :");
            String password = scanner.next();
            System.out.println(loginSystem.loginAdmin(adminId, password));

        }
        displayMainMenu(bank, loginSystem, args);
    }


    private static void createAccount(Admin admin) {

        String accountNumber = generateAccountId();
        System.out.print("Enter account holder name: ");
        String accountHolder = scanner.next();
        System.out.println("Enter phone number :");
        int phoneNumber = scanner.nextInt();
        System.out.println("Enter your email:");
        String emailUser = scanner.next();
        User user = new User(accountNumber, accountHolder, phoneNumber, emailUser);
        admin.getBankInstance().addUser(user);

    }

    private static void deposit(Admin admin) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        User user = admin.getBankInstance().findUser(accountNumber);
        if (user == null) {
            System.out.println("Sorry user was not found in our system");
        } else {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            admin.getBankInstance().depositMoy(user, amount);

        }

    }

    private static void withdraw(Admin admin) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        User user = admin.getBankInstance().findUser(accountNumber);
        if (user == null) {
            System.out.println("Sorry user was not found in our system");
        } else {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            admin.getBankInstance().withdrawMoy(user, amount);

        }

    }

    private static void checkBalance(Admin admin) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        User user = admin.getBankInstance().findUser(accountNumber);
        if (user == null) {
            System.out.println("Sorry user was not found in our system");
        } else {
            admin.getBankInstance().getBalanceInfo(user);


        }

    }

    private static void modifyInformations(Admin admin) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        User user = admin.getBankInstance().findUser(accountNumber);

        if (user == null) {
            System.out.println("Sorry, user was not found in our system");
            return;
        }

        System.out.println("Enter new name (or press Enter to skip): ");
        String newName = scanner.nextLine().trim();
        newName = newName.isEmpty() ? null : newName;

        System.out.println("Enter new phone number (or press Enter to skip): ");
        String phoneInput = scanner.nextLine().trim();
        Integer newNumberPhone = null;
        if (!phoneInput.isEmpty()) {
            try {
                newNumberPhone = Integer.parseInt(phoneInput);
            } catch (NumberFormatException e) {
                System.out.println("Invalid phone number. Skipping phone number update.");
            }
        }
        System.out.println("Enter new email (or press Enter to skip): ");
        String newEmail = scanner.nextLine().trim();
        newEmail = newEmail.isEmpty() ? null : newEmail;

        user.modifyPersonalInfo(newName, newNumberPhone, newEmail);
        System.out.println("User information updated successfully.");
    }

    private static void deleteAccount(Admin admin) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        User user = admin.getBankInstance().findUser(accountNumber);
        if (user == null) {
            System.out.println("Sorry user was not found in our system");
        } else {
            admin.getBankInstance().deleteAcct(user);
        }
    }

    private static void viewPersonalInfo(Admin admin) {

        System.out.print("Enter account number: ");
        String accountNumber = scanner.next();
        User user = admin.getBankInstance().findUser(accountNumber);
        if (user == null) {
            System.out.println("Sorry user was not found in our system");
        } else {
            System.out.println(user.viewPersonalInfo());
        }
    }

    private static void displaySystemMenu(Admin admin, LoginSystem system, String[] args) {


        boolean stillInMenu = true;
        while (stillInMenu) {
            System.out.println("1. Add Admin");
            System.out.println("2. View Admins");
            System.out.println("3. Logout Admin");
            System.out.println("4. Exit");
            scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter new admin ID: ");
                    String adminId = scanner.next();
                    System.out.println("Enter new admin password: ");
                    String password = scanner.next();
                    Admin newAdmin = new Admin(adminId, password);
                    admin.getBankInstance().addAdmin(newAdmin);
                    break;
                case 2:
                    for (Admin adminInfo : admin.getBankInstance().getAdmins()) {
                        System.out.println("admin :" + adminInfo.getAdminId());
                    }
                    break;

                case 3:
                    system.logoutAdmin();
                    system.setLoggedAdmin(null);
                    main(args);
                    stillInMenu = false;
                    break;
                case 4:
                    System.out.println("information saved successfully");
                    stillInMenu = false;
                    break;

            }
        }
    }

    private static void displayMainMenu(Bank bank, LoginSystem loginSystem, String[] args) {
        while (true) {
            System.out.println("\n welcome to the  bank " + bank.getName());
            System.out.println("1.create Account");
            System.out.println("2.Deposit");
            System.out.println("3.Withdraw");
            System.out.println("4.Check Balance");
            System.out.println("5.View Personal information");
            System.out.println("6.modify Information");
            System.out.println("7.Delete Account");
            System.out.println("8.Delete Operation");
            System.out.println("10.Exit");
            System.out.println("11.switch to system settings");
            System.out.println("Enter your choice :");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createAccount(loginSystem.getLoggedAdmin());
                    break;
                case 2:
                    deposit(loginSystem.getLoggedAdmin());
                    break;
                case 3:
                    withdraw(loginSystem.getLoggedAdmin());

                    break;
                case 4:
                    checkBalance(loginSystem.getLoggedAdmin());
                    break;

                case 5:
                    viewPersonalInfo(loginSystem.getLoggedAdmin());
                    break;
                case 6:
                    modifyInformations(loginSystem.getLoggedAdmin());
                    break;
                case 7:
                    deleteAccount(loginSystem.getLoggedAdmin());
                    break;
                case 10:
                    System.out.println("Thank you for using our banking system. Goodbye!");
                    System.exit(0);
                case 11:
                    displaySystemMenu(loginSystem.getLoggedAdmin(), loginSystem, args);
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");


            }
        }
    }


}
