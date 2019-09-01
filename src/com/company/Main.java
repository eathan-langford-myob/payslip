package com.company;

import java.net.PasswordAuthentication;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

import static java.time.temporal.ChronoUnit.DAYS;

public class Main {
    public static String capitalize(String word){
        String[] inputSplit = word.split(" ");
        String monthFromInput = inputSplit[1];
        String capitalized = monthFromInput.substring(0, 1).toUpperCase() + monthFromInput.substring(1);
        inputSplit[1] = capitalized;
        word = Arrays.toString(inputSplit);
        return word.substring(1, word.length()-1).replace(",", "");
    }
    public static void validateMonth(Person user) {
        boolean valid = false;
        while (!valid) {
            int daysInPayPeriod = (int)(DAYS.between(user.startDate, user.endDate));
            if ((daysInPayPeriod<=31)&&(daysInPayPeriod>=28)){
                valid = true;
            }else{
                System.out.println("Sorry invalid calendar month!");

                UserInput.askQuestion(UserInput.questionsArr[4]);
                String userStartDate=UserInput.getInput();
                user.setStartDate(userStartDate);
                UserInput.askQuestion(UserInput.questionsArr[5]);
                String userEndDate=UserInput.getInput();
                user.setEndDate(userEndDate);
            }
        }
    }

        public static void main(String[] args) {
        String[] userAnswers = new String[6];
        Person User = new Person();

        for (int i = 0; i < UserInput.questionsArr.length; i++) {
            UserInput.askQuestion(UserInput.questionsArr[i]);
            String response=UserInput.getInput();
            userAnswers[i]=response;
        }
        User.constructPersonDetails(userAnswers, User);
            validateMonth(User);
            Payslip generatedPayslip = new Payslip();
        generatedPayslip.constructPayslip(User);
//        System.out.println(ChronoUnit.MONTHS.between(User.getStartDate(), User.getEndDate()));
        System.out.println(generatedPayslip.toString());


    }
}
