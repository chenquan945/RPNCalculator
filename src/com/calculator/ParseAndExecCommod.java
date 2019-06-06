package com.calculator;


import com.calculator.operator.Operator;
import com.calculator.operator.impl.UndoOperator;
import com.calculator.util.StackUtil;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Stack;

/**
 * 解析并执行输入的命令
 */
public class ParseAndExecCommod {
    public static final String ADD = "+";
    public static final String SUB = "-";
    public static final String MULTI = "*";
    public static final String DIV = "/";
    public static final String SQRT = "sqrt";
    public static final String CLEAR = "clear";
    public static final String UNDO = "undo";
    //当前命令是否参数不足标志位:true(不足)，false(满足)
    public static boolean flag = false;
    //当前命令的索引
    public static int position = 0;
    private Stack<String> stack;
    //所有操作的集合
    private Map<String, Operator> operatorMap;

    public ParseAndExecCommod(Stack<String> stack, Map<String, Operator> operatorMap) {
        this.stack = stack;
        this.operatorMap = operatorMap;
    }

    public void parseAndExecCommod(String commod){
        //切割命令
        String[] arr = commod.split("\\s+");
        //逐个解析并调用相应的操作执行命令
        for(int i=0;i<arr.length;i++){
            //保存当前命令的索引
            ParseAndExecCommod.position = i;
            //保存最近一次的Stack状态
            Stack preStack = new Stack();
            preStack.addAll(stack);
            String str = arr[i];
            //判断操作类型
            if(str.equals(ParseAndExecCommod.ADD)){
                operatorMap.get(ParseAndExecCommod.ADD).exec();
            }else if(str.equals(ParseAndExecCommod.SUB)){
                operatorMap.get(ParseAndExecCommod.SUB).exec();
            }else if(str.equals(ParseAndExecCommod.MULTI)){
                operatorMap.get(ParseAndExecCommod.MULTI).exec();
            }else if(str.equals(ParseAndExecCommod.DIV)){
                operatorMap.get(ParseAndExecCommod.DIV).exec();
            }else if(str.equals(ParseAndExecCommod.SQRT)){
                operatorMap.get(ParseAndExecCommod.SQRT).exec();
            }else if(str.equals(ParseAndExecCommod.CLEAR)){
                operatorMap.get(ParseAndExecCommod.CLEAR).exec();
            }else if(str.equals(ParseAndExecCommod.UNDO)){
                operatorMap.get(ParseAndExecCommod.UNDO).exec();
            }else{
                try {
                    BigDecimal bigDecimal = new BigDecimal(str);
                }catch(Exception exception){
                    //非数值类型，跳出循环，结束本次命令
                    System.out.println("The number entered is incorrect:"+str);
                    break;
                }
                //数值类型，直接压栈
                stack.push(str);
            }

            //判断当前操作是否参数不足
            if(ParseAndExecCommod.flag){
                ParseAndExecCommod.flag = false;
                //参数不足，跳出循环，结束本次命令
                break;
            }
            //将最近一次的Stack添加到列表中，以便后续返回操作
            if(!str.equals(ParseAndExecCommod.UNDO)){
                ((UndoOperator)operatorMap.get(ParseAndExecCommod.UNDO)).getDoneList().add(preStack);
            }

        }
        //命令执行结束，打印当前Stack
        StackUtil.printStack(stack);
    }
}
