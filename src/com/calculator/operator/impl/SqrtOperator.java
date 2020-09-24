package com.calculator.operator.impl;

import com.calculator.ParseAndExecCommod;
import com.calculator.operator.Operator;
import com.calculator.util.StackUtil;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Stack;

/**
 * 平方根操作
 */
public class SqrtOperator implements Operator {

    /**
     * 用于存放输入及操作后返回的数值
     */
    private Stack<String> stack;

    public SqrtOperator(Stack<String> stack) {
        this.stack = stack;
    }

    /**
     * 从栈顶取出一个数进行平方根运算，并将操作结果压栈
     */
    @Override
    public void exec() {

        if (!StackUtil.checkStackSize(stack, 1, ParseAndExecCommod.SQRT)) {
            BigDecimal para1 = new BigDecimal(stack.pop());
            BigDecimal result = sqrt(para1);
            if (result.scale() > 10) {
                result = result.setScale(10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
            }
            stack.push(result.toString());
        }

    }

    private BigDecimal sqrt(BigDecimal num) {

        if (num.compareTo(BigDecimal.ZERO) < 0) {
            return BigDecimal.ZERO;
        }
        BigDecimal x = num.divide(new BigDecimal("2"), MathContext.DECIMAL128);
        while (x.subtract(x = sqrtIteration(x, num)).abs().compareTo(new BigDecimal("0.0000000000000000000001")) > 0) ;
        return x;
    }

    private BigDecimal sqrtIteration(BigDecimal x, BigDecimal n) {
        return x.add(n.divide(x, MathContext.DECIMAL128)).divide(new BigDecimal("2"), MathContext.DECIMAL128);
    }
}
