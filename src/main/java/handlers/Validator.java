package handlers;

public class Validator {
    public boolean validate(Double x, Double y, Double r){
        System.out.println("валидация");
        return inInterval(x, -2d, 2d) && inInterval(y, -5d, 3d) && checkInMass(r, new Double[]{1d, 2d, 3d, 4d, 5d});
    }
    private boolean inInterval(Double param, Double min, Double max){
        try {
            return (param>=min && param<=max);
        }catch (Exception e){
            return false;
        }
    }
    private boolean checkInMass(Double a, Double[] mass) {
        for (Double db : mass) {
            if (a.equals(db)) {
                return true;
            }
        }
        return false;
    }
}
