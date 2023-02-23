import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import Factory.StackFactory;
import interfaces.IStack;
import models.Calculator;

public class App {
    	

    Scanner in = new Scanner(System.in);
    StackFactory<Character> stackfactory = new StackFactory<Character>();
    StackFactory<Integer> stackfactoryNumber = new StackFactory<Integer>();
    IStack stack;
    IStack stackNumber;
    private Calculator calculator;
    String postfix = "";

    public static void main(String[] args) throws Exception {
        App main = new App();
        main.start();
    }

    public void start(){
        menu();
    }


    public void menu(){
        calculator = Calculator.getInstance();
        int ans =0;
        while(ans != 4){
            System.out.println("ELIJA EL STACK QUE NECESITE USAR:");
            System.out.println("1. ARRAY");
            System.out.println("2. ARRAYLIST");
            System.out.println("3. LIST");
            System.out.println("4. SALIR");
            ans =  in.nextInt();
            switch (ans) {
                case 1:
                
                    stack = stackfactory.createStack("ARRAY");
                    stackNumber = stackfactoryNumber.createStack("ARRAY");
                    
                    break;
                case 2:
                    stack = stackfactory.createStack("ARRAYLIST");
                    stackNumber = stackfactoryNumber.createStack("ARRAYLIST");

                    break;
                case 3:
                    System.out.println("1. SIMPLE");
                    System.out.println("2. DOUBLE");
                    int ansList = in.nextInt();
                    menuList(ansList);
                    break;
                case 4:
                    System.out.println("GRACIAS POR USAR EL PROGRAMA");
                    break;
                default:
                    System.out.println("OPCIÓN INVALIDA");
                    break;
            }
            if(ans!=4){
                readFile();
                String[] splited = postfix.split(" ");
                for (String string : splited) {
                    char character = string.charAt(0);
                    validateCharacter(character);
                }
                System.out.println("TU RESULTADO ES: "+stackNumber.peek());
            }
        }
    }

    public void menuList(int ans){
        switch (ans) {
            case 1:
                stack = stackfactory.createStack("LIST");
                stackNumber = stackfactoryNumber.createStack("LIST");

                break;
            case 2:
                stack = stackfactory.createStack("DOUBLE");
                stackNumber = stackfactoryNumber.createStack("DOUBLE");
                break;
            default:
                System.out.println("OPCIÓN INVALIDA");
            break;
        }
    }



    public void readFile(){
        postfix = "";
        File file = new File("src/assets/file.txt");
        // Note:  Double backquote is to avoid compiler
        // interpret words
        // like \test as \t (ie. as a escape sequence)
 
        // Creating an object of BufferedReader class
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            // Declaring a string variable
            String st;
            // Condition holds true till
            // there is character in a string
            
            String data = br.readLine();
            convertPostfix(data);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println(e);
            System.out.println("ARCHIVO NO ENCONTRADO");
        }
    }


    public void validateCharacter(char character){
        if(Character.isDigit(character)){
            String numString = Character.toString(character);;
            float number = Float.parseFloat(numString);
            stackNumber.push(number);
        }else{
            menuOperations(character);
        }
    }

    public void menuOperations(char operator){
        float a,b,result=0;
        switch(operator){
            case '+':
                a  = (float) stackNumber.pop();
                b  = (float) stackNumber.pop();
                result = calculator.add(a,b);
            break;
            case '-':
                a  = (float) stackNumber.pop();
                b  = (float) stackNumber.pop();
                result = calculator.subtraction(a,b);
            break;
            case '/':
                a  = (float) stackNumber.pop();
                b  = (float) stackNumber.pop();
                result = calculator.division(a,b);
            break;
            case '*':
                a  = (float) stackNumber.pop();
                b  = (float) stackNumber.pop();
                result = calculator.multiplication(a,b);
            break;
            default:
            System.out.println("OPERADOR INVALIDO");
        }
        stackNumber.push(result);
    }


    public void convertPostfix(String infix){
        stack.push('#');          
        
        String[] splited =  infix.split("");

        for (String string : splited) {
            char character = string.charAt(0);
            
            if(Character.isDigit(character)){
                if(!postfix.equals("")){
                    postfix += " "+character;
                }else{
                    postfix += character;
                }
            }else if(character == '('){
                stack.push(character);
            }else if(character =='^'){
                stack.push(character);
            }else if(character == ')'){
                while((Character)stack.peek() != '#' &&  (Character)stack.peek() != '(') {
                    postfix += " "+stack.peek(); 
                    stack.pop();
                }
                 stack.pop();   
            }else{
                if(validateSign(character) > validateSign((Character)stack.peek()))
                    stack.push(character);
                else {
                    while((Character)stack.peek() != '#' &&  validateSign(character) <= validateSign((Character)stack.peek())) {
                        postfix += " "+stack.peek();        
                        stack.pop();
                    }
                    stack.push(character);
                }
            }
        }

        while((Character)stack.peek() != '#') {
            postfix += " "+stack.peek();      
            stack.pop();
        }
        System.out.println("POSTFIX:"+ postfix);
    }



    int validateSign(char ch) {
        if(ch == '+' || ch == '-') {
           return 1;              
        }else if(ch == '*' || ch == '/') {
           return 2;            
        }else if(ch == '^') {
           return 3;            
        }else {
           return 0;
        }
     }

    
}
