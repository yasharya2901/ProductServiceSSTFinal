# Payments

## How payment workflow works?
- Order
- Idempotency
- Payment
- Callback and Webhook URL

## Payment Workflow
1. Product is added to the cart
2. Select the address
3. Confirm the details and creates order
4. Payment is done

When an order is created, amazon initiates the payment process for the respective order and sends the order id to the payment gateway. 

Amazon redirects us to the payment gateway page to complete the payment and sends the status back to Amazon.
If the payment is not completed, then amazon marks the order as pending else the order is confirmed.

