package com.example.mayur.mycalculator;

import java.util.Arrays;
import java.util.Stack;

public class InfixToPostfix {

    boolean check_error = false; //check the first char is positive or negative, check error

    public String standardizeDouble(double num) {
        int a = (int) num;
        if(a == num)
            return Integer.toString(a);
        else
            return Double.toString(num);
    }

    public boolean isNum(char c) {
        if(Character.isDigit(c)) return true;
        else return false;
    }

    public String numToString(double num) {
        return standardizeDouble(num);
    }

    public boolean isOperator(char c) {
        char operator[] = {'+', '-', '/', '*', '~', '@', '^', '!', '(', ')'};  // ~ is instance of negative , @ is square root

        Arrays.sort(operator);
        if(Arrays.binarySearch(operator, c) > -1)
            return true;
        else
            return false;
    }

    public int priority(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '~':
                return 3;
            case '@':
            case '^':
            case '!':
                return 4;
            default:
            return 0;
        }
    }

    public boolean isOpeMath(char c) {
        if(c=='@' || c=='(')
            return true;
        else
            return false;
    }

    public String standardize(String s) {
        String s1="";
        s = s.trim();
        s = s.replace("\\s+", " ");

        int open=0, close=0;
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c=='(') open++;
            if(c==')') close++;
        }

        for(int i=0; i<(open-close); i++)     // auto append ')'
            s += ")";

        for(int i=0; i<s.length(); i++) {
            if(i>0 && isOpeMath(s.charAt(i)) && (s.charAt(i-1) == ')' || isNum(s.charAt(i-1))))
                s1 = "*";   //fix  ...)(...   to   ...)*(...
            if((i==0 || (i>0 && !isNum(s.charAt(i-1))))  &&  s.charAt(i) == '-'  &&  isNum(s.charAt(i+1)))
                s1 += "~";  //check negative
            else
                s1 = s1 + s.charAt(i);
        }

        return s1;
    }

    public String[] processString(String sMath) {
        String s1 = "", elementMath[]=null;
        sMath = standardize(sMath);
        InfixToPostfix ITP = new InfixToPostfix();

        for(int i=0; i<sMath.length(); i++) {
            char c = sMath.charAt(i);
            if(!ITP.isOperator(c))
                s1 = s1 + c;
            else
                s1 = s1 + " " + c + " ";
        }

        s1 =s1.trim();
        s1.replaceAll("\\s+", " ");
        elementMath = s1.split(" ");

        return elementMath;
    }

    public String[] postfix(String[] elementMath) {
        InfixToPostfix ITP = new InfixToPostfix();
        String s1="", E[];
        Stack<String> S = new Stack<String>();

        for(int i=0; i<elementMath.length; i++) {
            char c = elementMath[i].charAt(0);     // c is first character of each element
            if(!ITP.isOperator(c))                 // if c is not an operator
                s1 = s1 + elementMath[i] + " ";    // s1 = element
            else {
                if(c == '(')                        // if c is operator
                    S.push(elementMath[i]);         // push c to stack
                else {
                    if(c == ')') {
                        char c1;
                        do {
                            c1 = S.peek().charAt(0);
                            if(c1 != '(')
                                s1 = s1 + S.peek() + " ";
                            S.pop();
                        }while (c1 != '(');
                    }
                    else {
                        // Stack is not null and while elements in Stack have priority >= this element
                        while( !S.isEmpty() && ITP.priority(S.peek().charAt(0)) >= ITP.priority(c))
                            s1 = s1 + S.pop() + " ";
                        S.push(elementMath[i]);     // push this element to stack
                    }
                }
            }

        }

        // Push all the remaining elements to the stack
        while(!S.isEmpty())
            s1 = s1 + S.pop() + " ";
        E = s1.split(" ");
        return E;
    }

    public String eval(String[] elementMath) {
        Stack<Double> S = new Stack<>();
        InfixToPostfix ITP = new InfixToPostfix();
        double num = 0.0;

        for(int i=0; i<elementMath.length; i++) {
            char c = elementMath[i].charAt(0);
            if(!ITP.isOperator(c))
                S.push(Double.parseDouble(elementMath[i]));
            else {
                double num1 = S.pop();
                switch (c) {
                    case '~': num = -num1; break;

                    case '@':
                        if(num1 > 0)
                            num = Math.sqrt(num1);
                        else
                            check_error = true;
                        break;

                    case '!': {
                        if(num1 >= 0 && (int) num1 == num1) {
                            num = 1;
                            for(int j=1; j<= (int) num1; j++)
                                num = num*j;
                        }
                        else
                            check_error = true;
                    }
                    default: break;
                }

                if(!S.isEmpty()) {
                    double num2  =S.peek();
                    switch (c) {
                        case '+': num = num2 + num1; S.pop(); break;
                        case '-': num = num2 - num1; S.pop(); break;
                        case '*': num = num2 * num1; S.pop(); break;
                        case '/': {
                            if(num1 != 0) num = num2 / num1;
                            else check_error = true;
                            S.pop();
                        }
                        break;
                        case '^': num = Math.pow(num2 , num1); S.pop(); break;
                    }
                }
                S.push(num);
            }
        }
        return numToString(S.pop());
    }


}
