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


    public String findThenFormatPrice(String barcode) {
        return priceAsTextByBarcode.get(barcode);
    }
}
