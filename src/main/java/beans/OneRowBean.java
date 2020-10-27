package beans;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.persistence.*;
import java.io.Serializable;

@Named("oneRowBean")
@SessionScoped
@Entity
@Table
public class OneRowBean implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    private Double X = 0d;
    private Double Y;
    private Double R = 1d;
    private String currTime;
    private String hit;
    private String execTime;

    public OneRowBean(){}

    public String getCurrTime() {return currTime;}
    public String getHit() {return hit;}
    public String getExecTime() {return execTime;}
    public Double getX() {return X;}
    public Double getY() {return Y;}
    public Double getR() {return R;}
    public int getId(){return id;}


    public void setR(Double r) {R = r;}
    public void setX(Double x) {X = x;}
    public void setY(Double y) {Y = y;}
    public void setCurrTime(String currTime) {this.currTime = currTime;}
    public void setHit(String hit) {this.hit = hit;}
    public void setExecTime(String execTime) {this.execTime = execTime;}
    public void setId(int id1){id=id1;}
}
