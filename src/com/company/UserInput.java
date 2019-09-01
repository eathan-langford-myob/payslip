package com.company;

import java.util.HashMap;
import java.util.Scanner;

public class UserInput {
    static Scanner userInput = new Scanner(System.in);
    static String[] questionsArr = {
            "Please input your name",
            "Please input your surname",
            "Please enter your annual salary",
            "Please enter your super rate",
            "Please enter your payment start date eg: Day Month",
            "Please enter your payment end date eg: Day Month"
    };

//    static String[][] stringQuestions = {
//            {"Please input your name","name"},
//            {"Please input your surname","surname"},
//    };
//
//    static String[][] integerQuestions = {
//            {"Please enter your annual salary","salary"},
//            {"Please enter your super rate","rate"},
//    };
//
//    static String[][] dateQuestions = {
//            {"Please enter your payment start date eg: dd/mm/yy","startDate"},
//            {"Please enter your payment end date eg: dd/mm/yy", "endDate"}
//    };

    public static void askQuestion(String question){
        System.out.println(question + ": \n");
    }
    public static Person constructUser(String[] array){
        Person User = new Person();
        User.setName(array[0]);
        User.setSurename(array[1]);
        User.setAnnualSalary(array[2]);
        User.setStartDate(array[5]);
        User.setSuperRate(array[3]);
        User.setEndDate(array[4]);


        return User;
    }

    public static boolean validateString(String response) {
        return response.chars().allMatch(Character::isLetter);
    }

    public static boolean validateNumbers(String response) {
        return response.chars().allMatch(Character::isDigit);
    }

    public static String getInput(){
        boolean validated;

        String response=userInput.nextLine();
        validated = (validateString(response)||validateNumbers(response));

        while(!validated){
            String[] splitResponse = response.split(" ");
            if((splitResponse.length>1)&&(validateNumbers(splitResponse[0])&&validateString(splitResponse[1]))){
                        validated=true;
                    }else{
            System.out.println("Sorry, invalid input. Try again: ");
            response = userInput.nextLine();
            validated = (validateString(response)||validateNumbers(response));
            }
        }
        return response;
    }



}
