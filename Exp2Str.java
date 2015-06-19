import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
public class Exp2Str extends EvalFunc<String>{
    
    //public int precision;
//    public Exp2Str(Tuple precision) {
//        this.precision = 2;//Integer.parseInt(precision.toString());
//    }
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public String exec(Tuple input) throws IOException {
        if (input == null || input.size() == 0)
            return null;
        try{
            String str = (String)input.get(0);
            double d = Double.valueOf(str).doubleValue();
            round(d, 2);
            String ret = Double.toString(d);
            return ret;
        }catch(Exception e){
            throw new IOException("Caught exception processing input row ", e);
        }
    }
}

