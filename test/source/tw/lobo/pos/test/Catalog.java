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


    public Integer findPrice(String barcode) {
        return priceInCentByBarCode.get(barcode);
    }
}
