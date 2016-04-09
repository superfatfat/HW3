package fatfat.hw3;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        Phone phone = (Phone) bundle.getSerializable("phone");
        ImageView showImage = (ImageView)findViewById(R.id.showImage);
        showImage.setImageResource(phone.getImage());
        TextView showName = (TextView)findViewById(R.id.showName);
        showName.setText(phone.getName());
        TextView showPrice = (TextView)findViewById(R.id.showPrice);
        showPrice.setText(phone.getPrice());
        Button endBtn = (Button)findViewById(R.id.endBtn);
        endBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
