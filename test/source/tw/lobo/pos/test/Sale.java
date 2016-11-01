package tw.lobo.pos.test;

/**
 * Created by Lobo on 2016/10/23.
 */
public class Sale {
    private final Catalog catalog;
    private Display display;
    private String scannedPrice;

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

        //1. Find scannedPrice.
        scannedPrice = catalog.findThenFormatPrice(barcode);
//        scannedPrices.add(scannedPrice);
        //2. If didn't get one, display product not found
        if (scannedPrice == null) {
            display.displayProductNotFoundMessage(barcode);
            //3. If I did get one, diplay the scannedPrice.
        } else {
            display.displayPrice(formatMonetaryAmount(scannedPrice));
        }
    }

    private String formatMonetaryAmount(String priceAsText) {
        return priceAsText;
    }

    public void onTotal() {
        //Reverse conditional logic to normal path
        boolean saleInProgress = (scannedPrice != null);
        if (saleInProgress) {
            display.displayPurchaseTotal(formatMonetaryAmount(scannedPrice));
        } else {
            display.displayNoSaleInProgressMessage();
        }
    }

}
