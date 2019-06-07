package com.calculator.operator.impl;


import com.calculator.operator.Operator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 返回操作
 */
public class UndoOperator implements Operator {

    /**
     * 用于存放输入及操作后返回的数值
     */
    private Stack<String> stack;
    /**
     * 依次存放每一步的Stack状态
     */
    private List<Stack> doneList;

    public UndoOperator(Stack<String> stack) {
        this.stack = stack;
        this.doneList = new ArrayList<>();
    }

    @Override
    public void exec() {
        //如果当前没有最近一次的Stack，则提示信息
        if (doneList.size() == 0) {
            System.out.println("There is currently no operation to cancel！");
        } else {
            //取出最近一次的Stack，并将其赋给当前的Stack
            Stack preStack = doneList.get(doneList.size() - 1);
            stack.clear();
            stack.addAll(preStack);
            //赋值完成后从列表里清除
            doneList.remove(preStack);
        }
    }

    public List<Stack> getDoneList() {
        return doneList;
    }
}
