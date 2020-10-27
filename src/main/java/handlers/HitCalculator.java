package handlers;

import java.math.BigDecimal;

public class HitCalculator {
    public boolean calculate(String x, String y, String r){
        BigDecimal xDec = getBD(x);
        BigDecimal yDec = getBD(y);
        BigDecimal rDec = getBD(r);
        if (xDec.compareTo(BigDecimal.ZERO) >= 0 && xDec.compareTo(rDec) <= 0
                && yDec.compareTo(BigDecimal.ZERO) <= 0 && yDec.compareTo(rDec.divide(BigDecimal.valueOf(2).multiply(BigDecimal.valueOf(-1)))) >= 0) {
            return true;
        }
        if (xDec.compareTo(BigDecimal.ZERO) <= 0 && yDec.compareTo(BigDecimal.ZERO) <= 0
                && (xDec.pow(2).add(yDec.pow(2))).compareTo(rDec.pow(2)) <= 0) {
            return true;
        }
        if (xDec.compareTo(BigDecimal.ZERO) >= 0 && yDec.compareTo(BigDecimal.ZERO) >= 0
                && yDec.compareTo((xDec.multiply(BigDecimal.valueOf(-1))).add(rDec.divide(BigDecimal.valueOf(2)))) <= 0) {
            return true;
        }
        return false;
    }
    public BigDecimal getBD(String param){
        return new BigDecimal(param);
    }
}
