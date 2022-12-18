package id.ac.umn.projekuasbisayok;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity2 extends AppCompatActivity {

    private ImageView imageViewStatusPayment, imageViewDisbursement, imageViewHistoriDisbursement, imageViewBuyerMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        imageViewStatusPayment = findViewById(R.id.imageViewStatusPayment);
        imageViewDisbursement = findViewById(R.id.imageViewDisbursement);
        imageViewHistoriDisbursement = findViewById(R.id.imageViewHistoriDisbursement);
        imageViewBuyerMode = findViewById(R.id.imageViewBuyerMode);

        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        imageViewStatusPayment.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity2.this,StatusPaymentSellerActivity.class);
            startActivity(intent);
        });

        imageViewDisbursement.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity2.this, DisbursementActivity.class);
            startActivity(intent);
        });

        imageViewHistoriDisbursement.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity2.this, HistoriDisbursementActivity.class);
            startActivity(intent);
        });

        imageViewBuyerMode.setOnClickListener(view -> {
            Intent intent = new Intent(HomeActivity2.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}