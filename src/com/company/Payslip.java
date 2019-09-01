package com.company;

public class Payslip {
    String name;
    String payPeriod;
    int grossIncome;
    int incomeTax;
    int netIncome;
    int superAmount;

    public Payslip(String name, String payPeriod, int grossIncome, int incomeTax, int netIncome, int superAmount) {
        this.name = name;
        this.payPeriod = payPeriod;
        this.grossIncome = grossIncome;
        this.incomeTax = incomeTax;
        this.netIncome = netIncome;
        this.superAmount = superAmount;
    }

    public Payslip() {

    }

    public int calculateGrossIncome(int salary) {
        return Math.round(salary / 12);
    }

    public int calculateNetIncome(int grossIncome, int incomeTax) {
        return Math.round(grossIncome - incomeTax);
    }

    public int calculateSuper(int grossIncome, int superRate) {
        float rate = superRate;
        double result = (grossIncome * rate) / 100;
        return (int) result;
    }

    public static int calculateTax(int wage) {
        long taxToPay = 0;
        boolean threshold1 = (wage < 18200);
        boolean threshold2 = ((wage >= 18201) && (wage <= 37000));
        boolean threshold3 = ((wage >= 37001) && (wage <= 90000));
        boolean threshold4 = ((wage >= 90001) && (wage <= 180000));
        boolean threshold5 = (wage <= 180000);
//        income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12 = 921.9375 (round up) = 922


        if (threshold1) {
        } else if (threshold2) {
            taxToPay = Math.round(((wage - 18200) * (.19)) / 12);
        } else if (threshold3) {
            taxToPay = Math.round(((wage - 37000) * (.325) + (3572)) / 12);
        } else if (threshold4) {
            taxToPay = Math.round(((wage - 90000) * (.37) + (20797)) / 12);
        } else if (threshold5) {
            taxToPay = Math.round(((wage - 180000) * (.45) + (54097)) / 12);
        }
        return (int) taxToPay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPayPeriod() {
        return payPeriod;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public int getGrossIncome() {
        return grossIncome;
    }

    public void setGrossIncome(int grossIncome) {
        this.grossIncome = grossIncome;
    }

    public int getIncomeTax() {
        return incomeTax;
    }

    public void setIncomeTax(int incomeTax) {
        this.incomeTax = incomeTax;
    }

    public int getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(int netIncome) {
        this.netIncome = netIncome;
    }

    public int getSuperAmount() {
        return superAmount;
    }

    public void setSuperAmount(int superAmount) {
        this.superAmount = superAmount;
    }

    public void constructPayslip(Person user) {
        this.setName(user.getName());
        this.setPayPeriod(user.getStartDate().toString() + " - " + user.getEndDate().toString());
        this.setGrossIncome(calculateGrossIncome(user.annualSalary));
        this.setIncomeTax(calculateTax(user.annualSalary));
        this.setNetIncome(calculateNetIncome(grossIncome, incomeTax));
        this.setSuperAmount(calculateSuper(grossIncome, user.superRate));
    }

    @Override
    public String toString() {
        return "Your payslip has been generated:\n" + '\'' +
                "Name: " + name +
                ",\n Pay Period: '" + payPeriod +
                ",\n Gross Income: " + grossIncome +
                ",\n Income Tax: " + incomeTax +
                ",\n Net Income: " + netIncome +
                ",\n Super: " + superAmount;
    }
}