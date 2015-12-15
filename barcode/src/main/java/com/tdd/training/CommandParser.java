package com.tdd.training;

public class CommandParser implements InputEventListener
{
    private final PointOfSaleListener pointOfSaleListener;
    private final CheckoutListener checkoutListener;

    public CommandParser(PointOfSaleListener pointOfSaleListener, CheckoutListener checkoutListener)
    {
        this.pointOfSaleListener = pointOfSaleListener;
        this.checkoutListener = checkoutListener;
    }

    @Override
    public void onEvent(SystemInputEvent event)
    {
        if ("t".equals(event.getValue())) checkoutListener.onCheckout();
        else pointOfSaleListener.onEvent(event);
    }
}
