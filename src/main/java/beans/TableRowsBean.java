package beans;

import DAO.OracleDAO;
import handlers.RowBuilder;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;

@Named("tableBean")
@SessionScoped
public class TableRowsBean implements Serializable {

    @Inject
    private OneRowBean rowBean;

    @Inject
    private OracleDAO oracle;

    @PostConstruct
    void init(){
        RowsList.addAll(oracle.getAllPoints());
    }
    private final ArrayList<OneRowBean> RowsList = new ArrayList<>();

    RowBuilder builder = new RowBuilder();

    public ArrayList<OneRowBean> getRowsList() {return RowsList;}

    public void addTableRow() {
        Double x = rowBean.getX();
        Double y = rowBean.getY();
        Double r = rowBean.getR();
        OneRowBean bean = builder.build(rowBean.getId(), x, y, r, System.nanoTime());
        if(!(bean==null)) {
            RowsList.add(0, bean);
            oracle.addPoint(bean);
        }
    }
}