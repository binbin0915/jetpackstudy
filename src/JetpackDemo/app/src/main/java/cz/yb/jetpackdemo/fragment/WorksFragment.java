package cz.yb.jetpackdemo.fragment;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import cz.yb.jetpackdemo.R;
import cz.yb.jetpackdemo.entity.WorksEntity;
import cz.yb.jetpackdemo.repository.WorksRepository;
import cz.yb.jetpackdemo.viewmodel.WorksViewModel;

public class WorksFragment extends Fragment {

    private WorksViewModel mViewModel;

    public static WorksFragment newInstance() {
        return new WorksFragment();
    }

    public TextView mResultTv;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.works_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(WorksViewModel.class);
        // TODO: Use the ViewModel
        final NavController controller = Navigation.findNavController(getView());
        getView().findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.navigate(R.id.action_worksFragment_to_addFragment);
            }
        });

        getView().findViewById(R.id.btnSearch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchAll();
            }
        });

        getView().findViewById(R.id.btnDelete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                deleteAll();
            }
        });

        mResultTv = getView().findViewById(R.id.tvDesc);
    }

    private void deleteAll() {
        WorksRepository.getInstance(getContext()).getWorksDao().deleteAll();
    }

    private void searchAll() {
        List<WorksEntity> list = WorksRepository.getInstance(getContext()).getWorksDao().getWorks();
        StringBuilder sb = new StringBuilder();
        for (WorksEntity worksEntity :
                list) {
            sb.append(worksEntity.getName() + "   " + worksEntity.getWorks());
        }
        mResultTv.setText(sb.toString());
    }

}