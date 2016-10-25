package tw.lobo.pos.test;

/**
 * Created by Lobo on 2016/10/23.
 */
public class Sale {
    private final ScanOneItemTest.Catalog catalog;
    private Display display;

    public Sale(ScanOneItemTest.Catalog catalog, Display display) {
        this.display = display;
        //introduce lookup table
        this.catalog = catalog;
    }

    public void onBarcode(String barcode) {
        //SMELL Refused bequest; move this up the call stack?
        if ("".equals(barcode)) {
            display.displayEmptyBarcodeMessage();
            return;//guard clause
        }

        //1. Find price.
        String priceAsText = catalog.findPrice(barcode);
        //2. If didn't get one, display product not found
        if (priceAsText == null) {
            display.displayProductNotFoundMessage(barcode);
            //3. If I did get one, diplay the price.
        } else {
            display.displayPrice(priceAsText);
        }
    }

    public void onTotal() {
        display.displayNoSaleInProgressMessage();
    }

}
