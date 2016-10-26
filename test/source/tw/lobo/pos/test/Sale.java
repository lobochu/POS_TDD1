package tw.lobo.pos.test;

/**
 * Created by Lobo on 2016/10/23.
 */
public class Sale {
    private final Catalog catalog;
    private Display display;
    private String price;

    public Sale(Catalog catalog, Display display) {
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
        price = catalog.findPrice(barcode);
        //2. If didn't get one, display product not found
        if (price == null) {
            display.displayProductNotFoundMessage(barcode);
            //3. If I did get one, diplay the price.
        } else {
            display.displayPrice(price);
        }
    }

    public void onTotal() {
        if (price == null)
            display.displayNoSaleInProgressMessage();
        else
            display.displayPurchaseTotal(price);
    }

}
