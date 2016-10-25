package tw.lobo.pos.test;

import java.util.Map;

/**
 * Created by Lobo on 2016/10/25.
 */
public class Catalog {
    private final Map<String, String> pricesByBarcode;

    public Catalog( Map<String, String> pricesByBarcode) {
        this.pricesByBarcode = pricesByBarcode;
    }



    public String findPrice(String barcode) {
        return pricesByBarcode.get(barcode);
    }
}
