package cz.yb.jetpackdemo.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;


import cz.yb.jetpackdemo.R;
import cz.yb.jetpackdemo.viewmodel.CustomViewModel;

public class CustomViewModelActivity extends AppCompatActivity {

    private TextView mCxkTv,mJayTv;

    private  int ticketCxk,ticketJay;

    private CustomViewModel customViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewmodel);

        customViewModel = ViewModelProviders.of(this) .get(CustomViewModel.class);

        mCxkTv = findViewById(R.id.tv_cxk);
        mJayTv = findViewById(R.id.tv_jay);

        mCxkTv.setText(String.valueOf(customViewModel.getTicketCxk()));
        mJayTv.setText(String.valueOf(customViewModel.getTicketJay()));

        findViewById(R.id.btn_cxk).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewModel.setTicketCxk(customViewModel.getTicketCxk()+1);
                mCxkTv.setText(String.valueOf(customViewModel.getTicketCxk()));
            }
        });
        findViewById(R.id.btn_jay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                customViewModel.setTicketJay(customViewModel.getTicketJay()+1);
                mJayTv.setText(String.valueOf(customViewModel.getTicketJay()));
            }
        });
    }
}
