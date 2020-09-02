package com.calculator.operator.impl;


import com.calculator.ParseAndExecCommod;
import com.calculator.operator.Operator;
import com.calculator.util.BigDecimalUtil;
import com.calculator.util.StackUtil;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 乘法操作
 */
public class MultiOperator implements Operator {

    /**
     * 用于存放输入及操作后返回的数值
     */
    private Stack<String> stack;

    public MultiOperator(Stack<String> stack) {
        this.stack = stack;
    }

    /**
     * 从栈顶取出两个数进行乘法运算，并将操作结果压栈
     */
    @Override
    public void exec() {
        if (!StackUtil.checkStackSize(stack, 2, ParseAndExecCommod.MULTI)) {
            BigDecimal para1 = new BigDecimal(stack.pop());
            BigDecimal para2 = new BigDecimal(stack.pop());
            BigDecimal result = para2.multiply(para1);
            result = BigDecimalUtil.setScaleAndStripZeros(result);
            stack.push(result.toString());
        }

    }
}
