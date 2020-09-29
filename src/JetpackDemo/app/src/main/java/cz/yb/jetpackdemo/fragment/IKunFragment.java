package cz.yb.jetpackdemo.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cz.yb.jetpackdemo.viewmodel.IKunViewModel;
import cz.yb.jetpackdemo.R;

public class IKunFragment extends Fragment {

    private IKunViewModel mViewModel;

    public static IKunFragment newInstance() {
        return new IKunFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.ikun_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(IKunViewModel.class);
        // TODO: Use the ViewModel
    }

}