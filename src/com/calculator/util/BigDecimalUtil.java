package com.calculator.util;

import java.math.BigDecimal;

public class BigDecimalUtil {

    /**
     * 给数值设置精度并将小数点后多余的零去掉
     * @param bigDecimal
     * @return
     */
    public static BigDecimal setScaleAndStripZeros(BigDecimal bigDecimal){
        if(bigDecimal.scale()>10){
            return bigDecimal.setScale(10, BigDecimal.ROUND_HALF_UP).stripTrailingZeros();
        }
        return bigDecimal;
    }
}
