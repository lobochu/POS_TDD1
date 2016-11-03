package tw.lobo.pos.test;

import java.util.Map;

/**
 * Created by Lobo on 2016/10/25.
 */
public class Catalog {
    private Map<String, String> priceAsTextByBarcode;
    private Map<String, Integer> priceInCentByBarCode;


    public Catalog(Map<String, String> priceAsTextByBarcode, Map<String, Integer> priceInCentByBarCode) {

        this.priceAsTextByBarcode = priceAsTextByBarcode;
        this.priceInCentByBarCode = priceInCentByBarCode;
    }

    // SMELL Move this behavior somewhere else, why author think about that..??
    public static String format(int priceInCents) {
        return String.format("$%,.2f",
                priceInCents / 100.0d);
    }


    public Integer findPrice(String barcode) {
        return priceInCentByBarCode.get(barcode);
    }
}
