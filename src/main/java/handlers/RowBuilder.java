package handlers;

import beans.OneRowBean;

import java.text.SimpleDateFormat;
import java.util.Date;

public class RowBuilder {
    HitCalculator hitCalc = new HitCalculator();
    Validator validator = new Validator();

    public OneRowBean build(int id1, Double x, Double y, Double r, Long start) {
        if (true) {
            OneRowBean bean = new OneRowBean();
            bean.setX(x);
            bean.setY(y);
            bean.setR(r);
            bean.setId(id1);
            Long execTime = System.nanoTime() - start;
            bean.setExecTime(execTime.toString() + "ns");
            bean.setCurrTime(new SimpleDateFormat("dd:MM:yyyy  HH:mm").format(new Date()));
            bean.setHit(hitCalc.calculate(x.toString(), y.toString(), r.toString()) ? "hit" : "miss");
            return bean;
        } else return null;
    }
}
