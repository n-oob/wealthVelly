import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PolicyHolderManagementApp {

    // PolicyHolder class to hold individual policy details
   private static class PolicyHolder {
        private String policyId;
        private String name;
        private double investmentAmount;
        private int yearsInForce;

        // Constructor
        public PolicyHolder(String policyId, String name, double investmentAmount, int yearsInForce) {
            this.policyId = policyId;
            this.name = name;
            this.investmentAmount = investmentAmount;
            this.yearsInForce = yearsInForce;
        }

        // Getters and Setters
        public String getPolicyId() {
            return policyId;
        }

        public void setPolicyId(String policyId) {
            this.policyId = policyId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getInvestmentAmount() {
            return investmentAmount;
        }

        public void setInvestmentAmount(double investmentAmount) {
            this.investmentAmount = investmentAmount;
        }

        public int getYearsInForce() {
            return yearsInForce;
        }

        public void setYearsInForce(int yearsInForce) {
            this.yearsInForce = yearsInForce;
        }

        // Method to calculate maturity value (future value)
        public double calculateMaturityValue() {
            return investmentAmount * Math.pow(1 + 0.08, yearsInForce);
        }

        @Override
        public String toString() {
            return "PolicyHolder [policyId=" + policyId + ", name=" + name + ", investmentAmount=" + investmentAmount
                    + ", yearsInForce=" + yearsInForce + ", maturityValue=" + calculateMaturityValue() + "]";
        }
    }

    // Main application logic
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<PolicyHolder> policyHolders = new ArrayList<>();

        // Adding some sample policy holders
        policyHolders.add(new PolicyHolder("P001", "Alice", 50000, 5));
        policyHolders.add(new PolicyHolder("P002", "Bob", 150000, 10));
        policyHolders.add(new PolicyHolder("P003", "Charlie", 200000, 15));
        policyHolders.add(new PolicyHolder("P004", "David", 90000, 7));

        // Main menu
        int choice;
        do {
            System.out.println("\n--- Policy Holder Management ---");
            System.out.println("1. Calculate Maturity Value");
            System.out.println("2. Find High Value Policies");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    calculateMaturityValue(policyHolders);
                    break;
                case 2:
                    findHighValuePolicies(policyHolders);
                    break;
                case 3:
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    // Method to calculate and display maturity values for all policy holders
    public static void calculateMaturityValue(List<PolicyHolder> policyHolders) {
        System.out.println("\n--- Maturity Values ---");
        for (PolicyHolder holder : policyHolders) {
            double maturityValue = holder.calculateMaturityValue();
            System.out.printf("Policy ID: %s, Name: %s, Investment Amount: %.2f, Maturity Value: %.2f%n",
                    holder.getPolicyId(), holder.getName(), holder.getInvestmentAmount(), maturityValue);
        }
    }

    // Method to find and display policies with investment greater than 100000
    public static void findHighValuePolicies(List<PolicyHolder> policyHolders) {
        System.out.println("\n--- High Value Policies ---");
        for (PolicyHolder holder : policyHolders) {
            if (holder.getInvestmentAmount() > 100000) {
                System.out.println(holder);
            }
        }
    }
}

