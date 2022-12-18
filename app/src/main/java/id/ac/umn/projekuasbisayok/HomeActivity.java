package id.ac.umn.projekuasbisayok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    ImageView imageViewTransfer, imageViewHistori, imageViewPayment, imageViewSellerMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        imageViewTransfer = findViewById(R.id.imageViewTransfer);
        imageViewHistori = findViewById(R.id.imageViewHistori);
        imageViewPayment = findViewById(R.id.imageViewPayment);
        imageViewSellerMode = findViewById(R.id.imageViewSellerMode);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        imageViewTransfer.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, TransferActivity.class);
            startActivity(intent);
        });

        imageViewHistori.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, HistoriPaymentActivity.class);
            startActivity(intent);
        });


        imageViewPayment.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, PaymentActivity.class);
            startActivity(intent);
        });

        imageViewSellerMode.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity.this, HomeActivity2.class);
            startActivity(intent);
        });
    }
}