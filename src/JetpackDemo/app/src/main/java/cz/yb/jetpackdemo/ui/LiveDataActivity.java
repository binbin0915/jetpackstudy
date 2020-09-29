package cz.yb.jetpackdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import cz.yb.jetpackdemo.R;
import cz.yb.jetpackdemo.viewmodel.CustomViewModel;
import cz.yb.jetpackdemo.viewmodel.LiveDataViewModel;

public class LiveDataActivity extends AppCompatActivity {

    private TextView mCxkTv,mJayTv;

//    private  int ticketCxk,ticketJay;

    private LiveDataViewModel liveDataViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        liveDataViewModel = ViewModelProviders.of(this) .get(LiveDataViewModel.class);

        mCxkTv = findViewById(R.id.tv_cxk);
        mJayTv = findViewById(R.id.tv_jay);

//        mCxkTv.setText(String.valueOf(ticketCxk));
//        mJayTv.setText(String.valueOf(ticketJay));
        liveDataViewModel.getTicketJay().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mJayTv.setText(String.valueOf(liveDataViewModel.getTicketJay().getValue()));
            }
        });
        liveDataViewModel.getTicketCxk().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                mCxkTv.setText(String.valueOf(liveDataViewModel.getTicketCxk().getValue()));
            }
        });

        findViewById(R.id.btn_cxk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveDataViewModel.addCxk();
//                ticketCxk++;
//                mCxkTv.setText(String.valueOf(ticketCxk));
            }
        });
        findViewById(R.id.btn_jay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                liveDataViewModel.addJay();
//                ticketJay++;
//                mJayTv.setText(String.valueOf(ticketJay));
            }
        });
    }


}
