package com.calculator.operator.impl;

import com.calculator.operator.Operator;

import java.util.Stack;

/**
 * 清空所有数据操作
 */
public class ClearOperator implements Operator {

    /**
     * 用于存放输入及操作后返回的数值
     */
    private Stack<String> stack;

    public ClearOperator(Stack<String> stack) {
        this.stack = stack;
    }

    /**
     * 清空当前Stack
     */
    @Override
    public void exec() {
        stack.clear();
    }
}
