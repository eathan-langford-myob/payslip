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

    public Payslip(){

    }

    public int calculateGrossIncome(int salary){
        return Math.round(salary/12);
    }

    public int calculateNetIncome(int grossIncome, int incomeTax){
        return Math.round(grossIncome-incomeTax);
    }

    public int calculateSuper(int grossIncome, int superRate){
        float rate = superRate;
        double result = (grossIncome*rate)/100;
        return (int)result;
    }

    public static int calculateTax(int wage) {
        long taxToPay = 0;
        boolean threshold1 = (wage < 18200);
        boolean threshold2 = ((wage >= 18201) && (wage <= 37000));
        boolean threshold3 = ((wage >= 37001) && (wage <= 90000));
        boolean threshold4 = ((wage >= 90001) && (wage <= 180000));
        boolean threshold5 = (wage <= 180000);
//        income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12 = 921.9375 (round up) = 922


        if(threshold1) {
        } else if (threshold2) {
            taxToPay = Math.round(((wage - 18200)*(.19))/12);
        } else if (threshold3) {
            taxToPay = Math.round(((wage - 37000)*(.325)+(3572))/12);
        } else if (threshold4) {
            taxToPay = Math.round(((wage - 90000)*(.37)+(20797))/12);
        } else if (threshold5) {
            taxToPay = Math.round(((wage - 180000)*(.45)+(54097))/12);
        }
        return (int)taxToPay;
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

    public void constructPayslip (Person user){
        this.setName(user.getName());
        this.setPayPeriod(user.getStartDate().toString()+" - "+user.getEndDate().toString());
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
    //        System.out.println(DAYS.between(User.startDate, User.endDate));

//        for (String question:UserInput.questionsArr){
//            UserInput.askQuestion(question);
//            String userAnswer=UserInput.getInput();
//            userAnswers[0]=userAnswer;
//        }
//        for (String answer:userAnswers){
//            System.out.println(answer);
//        }
        /*
----------------------------------------------------------------------------------------------------------

    Pay period = per calendar month
    Gross income = annual salary / 12 months
    //CHECK TO SEE IF DAYS BETWEEN EQUALS 28-31
    Income tax = based on the tax table provided below
    Net income = gross income - income tax
    Super = gross income x super rate
    All calculation results should be rounded to the whole dollar. If >= 50 cents round up to the next dollar increment, otherwise round down.

----------------------------------------------------------------------------------------------------------
Taxable Income	Tax on this Income
$0 - $18,200	    Nil
$18,201 - $37,000	19c for each $1 over $18,200
$37,001 - $87,000	$3,572 plus 32.5c for each $1 over $37,000
$87,001 - $180,000	$19,822 plus 37c for each $1 over $87,000
$180,001 and over	$54,232 plus 45c for each $1 over $180,000
----------------------------------------------------------------------------------------------------------

For example, the payment in March for an employee with an annual salary of $60,050 and a super rate of 9% is:

pay period = Month of March (01 March to 31 March)
gross income = 60,050 / 12 = 5,004.16666667 (round down) = 5,004
income tax = (3,572 + (60,050 - 37,000) x 0.325) / 12 = 921.9375 (round up) = 922
net income = 5,004 - 922 = 4,082
super = 5,004 x 9% = 450.36 (round down) = 450

----------------------------------------------------------------------------------------------------------

    SAMPLE:
Welcome to the payslip generator!

Please input your name: John
Please input your surname: Doe
Please enter your annual salary: 60050
Please enter your super rate: 9
Please enter your payment start date: 1 March
Please enter your payment end date: 31 March

Your payslip has been generated:

Name: John Doe
Pay Period: 01 March – 31 March
Gross Income: 5004
Income Tax: 922
Net Income:4082
Super: 450

Thank you for using MYOB!
----------------------------------------------------------------------------------------------------------

         */
}
