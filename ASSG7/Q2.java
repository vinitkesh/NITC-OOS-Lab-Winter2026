// Imagine you are developing a payment processing system for an e-commerce platform.
// The system must support different ways to pay, such as credit card, google pay, BHIM
// UPI. Assume that the payment gateway gets different transactions (can be stored in an
// array). These transactions are one of the above ways which means instances of credit
// card, or google pay or BHIM UPI.. Payment gateway calls process payment method
// associated with each transaction. Take appropriate design decisions.

interface PaymentMethod {
    void processPayment();
}

class PaymentGateway {
    public void processPayment(PaymentMethod paymentMethod) {
        paymentMethod.processPayment();
    }
}

class CreditCardPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing credit card payment...");
    }
}

class GooglePayPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing Google Pay payment...");
    }
}

class BhimUpiPayment implements PaymentMethod {
    @Override
    public void processPayment() {
        System.out.println("Processing BHIM UPI payment...");
    }
}

public class Q2 {
    public static void main(String[] args) {
        PaymentGateway paymentGateway = new PaymentGateway();

        PaymentMethod creditCardPayment = new CreditCardPayment();
        PaymentMethod googlePayPayment = new GooglePayPayment();
        PaymentMethod bhimUpiPayment = new BhimUpiPayment();

        paymentGateway.processPayment(creditCardPayment);
        paymentGateway.processPayment(googlePayPayment);
        paymentGateway.processPayment(bhimUpiPayment);
    }
}
