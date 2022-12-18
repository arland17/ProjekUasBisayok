package id.ac.umn.projekuasbisayok;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {

    float x1, y1, x2, y2;
//    RecyclerView recyclerView;
//    Button btnUpload;
//    ArrayList<Uri> uri = new ArrayList<>();
//    RecyclerAdapter adapter;
//    private static final int Read_Permission = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

//        btnUpload = findViewById(R.id.btnUpload);
//        recyclerView = findViewById(R.id.recycler_view_image);
//
//        adapter = new RecyclerAdapter(uri);
//        recyclerView.setLayoutManager(new GridLayoutManager(PaymentActivity.this, 4));
//        recyclerView.setAdapter(adapter);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar_payment);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.blue)));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//
//        if (ContextCompat.checkSelfPermission(PaymentActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(PaymentActivity.this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},Read_Permission);
//        }
//
//        btnUpload.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent();
//                intent.setType("image/*");
//                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                    intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
//                }
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1);
//            }
//        });
//    }

//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
//            if (data.getClipData() != null) {
//                int x = data.getClipData().getItemCount();
//
//                for (int i = 0 ; i < x; i++) {
//                    uri.add(data.getClipData().getItemAt(i).getUri());
//                }
//                adapter.notifyDataSetChanged();
//            } else if (data.getData() != null) {
//                String imageURL = data.getData().getPath();
//                uri.add(Uri.parse(imageURL));
//            }
//        }
//    }
    }

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if(x1 < x2){
                    Intent i = new Intent(PaymentActivity.this,HomeActivity.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}