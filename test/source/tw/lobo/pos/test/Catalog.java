package tw.lobo.pos.test;

import java.util.Map;

/**
 * Created by Lobo on 2016/10/25.
 */
public class Catalog {
    private Map<String, Integer> priceInCentByBarCode;


    public Catalog(Map<String, String> priceAsTextByBarcode, Map<String, Integer> priceInCentByBarCode) {
        this.priceInCentByBarCode = priceInCentByBarCode;
    }

    //SMELL Move this behavior somewhere else
    public static String format(int priceInCents) {
        return String.format("$%,.2f",
                priceInCents / 100.0d);
    }


    public String findThenFormatPrice(String barcode) {
        Integer priceInCents = priceInCentByBarCode.get(barcode);
        if (priceInCents == null)
            return null;
        else
            return format(priceInCents);
    }
}
