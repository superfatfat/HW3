package fatfat.hw3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<Phone> phones = setPhoneList();
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rvPhone);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));
        recyclerView.setAdapter(new PhoneAdater(this,phones));
    }

    private List<Phone> setPhoneList(){
        List<Phone> list = new ArrayList<>();
        list.add(new Phone(R.drawable.apple_iphone_se,"Apple iPhone SE",15500));
        list.add(new Phone(R.drawable.htc_one_x9_dual_sim,"HTC One X9 dual sim",12600));
        list.add(new Phone(R.drawable.lg_k10,"LG K10",4500));
        list.add(new Phone(R.drawable.samsung_galaxy_j3,"Samsung Galaxy J3",3900));
        list.add(new Phone(R.drawable.samsung_galaxy_s7_edge,"Samsung Galaxy S7 Edge",22900));
        list.add(new Phone(R.drawable.huawei_gr5,"HUAWEI GR5",6700));
        list.add(new Phone(R.drawable.acer_liquid_z630s,"Acer Liquid Z630s",5690));
        list.add(new Phone(R.drawable.asus_zenfone_2_deluxe,"ASUS ZenFone 2 Deluxe",7300));
        list.add(new Phone(R.drawable.infocus_m372,"InFocus M372",3400));
        list.add(new Phone(R.drawable.meitu_m4,"Meitu M4",10390));
        list.add(new Phone(R.drawable.oppo_f1,"OPPO F1",4200));
        return list;
    }

    private class PhoneAdater extends RecyclerView.Adapter<PhoneAdater.MyViewHolder> {
        private Context context;
        private LayoutInflater layoutInflater;
        private List<Phone> phones;
        public PhoneAdater(Context context,List<Phone> phones) {
            this.context = context;
            this.phones = phones;
            layoutInflater = LayoutInflater.from(context);
        }

        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = layoutInflater.inflate(R.layout.phone_layout,parent,false);
            return new MyViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(PhoneAdater.MyViewHolder holder, int position) {
            final Phone phone = phones.get(position);
            holder.ivImage.setImageResource(phone.getImage());
            holder.tvName.setText(phone.getName());
            holder.tvPrice.setText(phone.getPrice());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,ShowActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putSerializable("phone",phone);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });
        }

        @Override
        public int getItemCount() {
            return phones.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder{
            ImageView ivImage;
            TextView tvName,tvPrice;
            public MyViewHolder(View itemView) {
                super(itemView);
                ivImage = (ImageView)itemView.findViewById(R.id.ivPhone);
                tvName = (TextView)itemView.findViewById(R.id.tvPhoneName);
                tvPrice = (TextView)itemView.findViewById(R.id.tvPhonePrice);
            }
        }
    }
}
