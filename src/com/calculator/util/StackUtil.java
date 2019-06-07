package com.calculator.util;

import com.calculator.ParseAndExecCommod;

import java.util.Iterator;
import java.util.Stack;

public class StackUtil {

    /**
     * 打印Stack的信息
     *
     * @param stack
     */
    public static void printStack(Stack stack) {
        System.out.print("stack:");
        for (Iterator<String> it = stack.iterator(); it.hasNext(); ) {
            String str = it.next();
            System.out.print(str + " ");
        }
        System.out.println();
    }

    /**
     * 进行运算操作前检查Stack里面的参数是否足够
     *
     * @param stack    当前的Stack
     * @param size     需要的参数个数
     * @param operator 进行的运算
     * @return
     */
    public static boolean checkStackSize(Stack stack, int size, String operator) {
        if (stack.size() < size) {
            System.out.print("operator " + operator + " (position:" + ParseAndExecCommod.position + "):insufficient parameters ");
            StackUtil.printStack(stack);
            ParseAndExecCommod.flag = true;
            return true;
        }
        return false;
    }
}
