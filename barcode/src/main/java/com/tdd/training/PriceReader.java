package com.tdd.training;

public class PriceReader implements PointOfSaleListener
{
    private final PriceConsumer priceConsumer;
    private final PriceCatalog catalog;
    private final PriceNotFoundFormatter notFoundFormatter;

    public PriceReader(PriceCatalog catalog, PriceConsumer priceConsumer, PriceNotFoundFormatter notFoundFormatter)
    {
        this.catalog = catalog;
        this.priceConsumer = priceConsumer;
        this.notFoundFormatter = notFoundFormatter;
    }

    @Override
    public void onEvent(SystemInputEvent event)
    {
        Price price = catalog.findPrice(event.getValue());

        if (price == null)
        {
            notFoundFormatter.showNotFound(event.getValue());
        }
        else
        {
            priceConsumer.consumePrice(price);
        }
    }
}
