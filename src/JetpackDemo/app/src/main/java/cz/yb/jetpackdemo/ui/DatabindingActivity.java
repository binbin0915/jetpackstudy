package cz.yb.jetpackdemo.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import cz.yb.jetpackdemo.R;
import cz.yb.jetpackdemo.databinding.ActivityDatabindingBinding;
import cz.yb.jetpackdemo.viewmodel.DatabindingViewModel;
import cz.yb.jetpackdemo.viewmodel.LiveDataViewModel;

public class DatabindingActivity extends AppCompatActivity {

//    private TextView mCxkTv,mJayTv;

//    private  int ticketCxk,ticketJay;

    private ActivityDatabindingBinding binding;
    private DatabindingViewModel dataBindingViewModel;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_databinding);
//        setContentView(R.layout.activity_normal);
        dataBindingViewModel = ViewModelProviders.of(this) .get(DatabindingViewModel.class);

        binding.setData(dataBindingViewModel);
        binding.setLifecycleOwner(this);
//        mCxkTv = findViewById(R.id.tv_cxk);
//        mJayTv = findViewById(R.id.tv_jay);

//        mCxkTv.setText(String.valueOf(ticketCxk));
//        mJayTv.setText(String.valueOf(ticketJay));
//        dataBindingViewModel.getTicketJay().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.tvCxk.setText(String.valueOf(dataBindingViewModel.getTicketJay().getValue()));
//            }
//        });
//        dataBindingViewModel.getTicketCxk().observe(this, new Observer<Integer>() {
//            @Override
//            public void onChanged(Integer integer) {
//                binding.tvJay.setText(String.valueOf(dataBindingViewModel.getTicketCxk().getValue()));
//            }
//        });
//
//        findViewById(R.id.btn_cxk).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dataBindingViewModel.addCxk();
////                ticketCxk++;
////                mCxkTv.setText(String.valueOf(ticketCxk));
//            }
//        });
//        findViewById(R.id.btn_jay).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                dataBindingViewModel.addJay();
////                ticketJay++;
////                mJayTv.setText(String.valueOf(ticketJay));
//            }
//        });
    }


}
