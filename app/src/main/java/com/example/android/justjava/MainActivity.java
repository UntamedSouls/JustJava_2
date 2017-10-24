import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.android.justjava.R;
/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    /**
     * This method is called when the order button is clicked.
     */
    public void increment(View view) {
        int quantity = 3;
        quantity = quantity + 1;
        display(quantity);
    }

        /**
         * This method is called when the order button is clicked.
         */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
    }

        /**
         * This method is called when the order button is clicked.
         */
    public void submitOrder(View view) {
       CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkbox);
       boolean hasWhippedCream = whippedCreamCheckBox.isChecked();
        Log.v("MainActivity", "Has whipped cream: " + hasWhippedCream);
       int price = quantity * 5;
        String priceMessage = createOrderSummary(price, hasWhippedCream);
        displayMessage(priceMessage);
    }

    /**
     * Calculates the price of the order.
     *
     * @return total price
     */
    private int calculatePrice() { return quantity * 5; }

    /**
     * Create summary of the order.
     *
     * @param price of the order
     * @param addWhippedCream is whether or not the user wants whipped cream topping
     * @return text summary
     */
   private String createOrderSummary(int price, boolean addWhippedCream) {
       String priceMessage = "Name: Jack";
       priceMessage += "Add whipped cream? " + addWhippedCream;
       priceMessage += "\nQuantity: " + quantity;
       priceMessage += "\nTotal: $" + price;
       priceMessage += "\nThank you!";
       return priceMessage;
   }

    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }
}