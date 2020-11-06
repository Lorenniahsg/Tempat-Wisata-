package stud.develops.tempatwisata;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import de.hdodenhof.circleimageview.CircleImageView;

public class DataDetail extends AppCompatActivity {
    private Context context;
    ImageView gambar;
    TextView nama,detail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail);

        gambar = findViewById(R.id.img_item_photo);
        nama = findViewById(R.id.tv_item_name);
        detail = findViewById(R.id.tv_item_detail);

        Intent intent = getIntent();
        String[] data = intent.getStringArrayExtra("data");

        nama.setText(data[0]);
        detail.setText(data[1]);
        gambar.setImageResource(Integer.parseInt(data[2]));



        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }
}
