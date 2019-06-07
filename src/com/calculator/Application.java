package com.calculator;

import com.calculator.operator.Operator;
import com.calculator.operator.impl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Application {
    public static void main(String[] args) {
        Stack<String> stack = new Stack<>();
        Map<String, Operator> operatorMap = new HashMap<>();
        //加法操作
        Operator addOperator = new AddOperator(stack);
        //减法操作
        Operator subOperator = new SubOperator(stack);
        //乘法操作
        Operator multiOperator = new MultiOperator(stack);
        //除法操作
        Operator divOperator = new DivOperator(stack);
        //平方根操作
        Operator sqrtOperator = new SqrtOperator(stack);
        //清空操作
        Operator clearOperator = new ClearOperator(stack);
        //返回操作
        Operator undoOperator = new UndoOperator(stack);
        operatorMap.put(ParseAndExecCommod.ADD, addOperator);
        operatorMap.put(ParseAndExecCommod.SUB, subOperator);
        operatorMap.put(ParseAndExecCommod.MULTI, multiOperator);
        operatorMap.put(ParseAndExecCommod.DIV, divOperator);
        operatorMap.put(ParseAndExecCommod.SQRT, sqrtOperator);
        operatorMap.put(ParseAndExecCommod.CLEAR, clearOperator);
        operatorMap.put(ParseAndExecCommod.UNDO, undoOperator);
        ParseAndExecCommod parseAndExecCommod = new ParseAndExecCommod(stack, operatorMap);
        System.out.println("*******************RPN Calculator*******************");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String str = scanner.nextLine();
            //如果什么也没输入，则跳过本次循环
            if (str.trim().equals("")) {
                continue;
            }
            //将输入的命令前后空格过滤掉，防止切割出现多余的空格
            parseAndExecCommod.parseAndExecCommod(str.trim());
        }
    }

}
