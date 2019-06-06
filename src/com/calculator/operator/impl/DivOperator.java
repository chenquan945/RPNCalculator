package com.calculator.operator.impl;

import com.calculator.ParseAndExecCommod;
import com.calculator.operator.Operator;
import com.calculator.util.BigDecimalUtil;
import com.calculator.util.StackUtil;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Stack;

/**
 * 除法操作
 */
public class DivOperator implements Operator {

    /**
     * 用于存放输入及操作后返回的数值
     */
    private Stack<String> stack;

    public DivOperator(Stack<String> stack) {
        this.stack = stack;
    }

    /**
     * 从栈顶取出两个数进行除法运算，并将操作结果压栈
     */
    @Override
    public void exec() {
        if(!StackUtil.checkStackSize(stack,2, ParseAndExecCommod.DIV)){
            BigDecimal para1 = new BigDecimal(stack.pop());
            BigDecimal para2 = new BigDecimal(stack.pop());
            BigDecimal result;
            try{
                result = para2.divide(para1);
            }catch(Exception exception){
                result = para2.divide(para1,15, RoundingMode.UP);
            }
            result = BigDecimalUtil.setScaleAndStripZeros(result);
            stack.push(result.toString());
        }

    }
}
