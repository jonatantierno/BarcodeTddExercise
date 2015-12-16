package com.tdd.training;

public class CheckoutCart implements CheckoutListener
{
    private final ShoppingCart cart;
    private final DisplayFormatter formatter;

    public CheckoutCart(ShoppingCart shoppingCart, DisplayFormatter formatter)
    {
        this.cart = shoppingCart;
        this.formatter = formatter;
    }

    @Override
    public void onCheckout()
    {
        formatter.checkout(cart.getTotal());
    }
}
