public class PriceReader implements BarcodeListener
{
    private final Display display;
    private final PriceCatalog catalog;

    public PriceReader(PriceCatalog catalog, Display display)
    {
        this.catalog = catalog;
        this.display = display;
    }

    @Override
    public void onBarcode(String barcode)
    {
        String price = catalog.findPrice(barcode);

        if (price == null) display.showPriceNotFound(barcode);
        else display.showPrice(price);
    }
}
