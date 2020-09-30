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
import android.widget.EditText;

import java.util.Objects;

import cz.yb.jetpackdemo.R;
import cz.yb.jetpackdemo.entity.WorksEntity;
import cz.yb.jetpackdemo.repository.WorksRepository;
import cz.yb.jetpackdemo.viewmodel.AddViewModel;

//Entity
//Dao
//Database
public class AddFragment extends Fragment {

    private AddViewModel mViewModel;

    public static AddFragment newInstance() {
        return new AddFragment();
    }

    private  String name;
    private  String works;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.add_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddViewModel.class);
        // TODO: Use the ViewModel

        final EditText nameEt= Objects.requireNonNull(getView()).findViewById(R.id.edName);
        final EditText worksEt= Objects.requireNonNull(getView()).findViewById(R.id.edWorks);

        Objects.requireNonNull(getView()).findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = nameEt.getText().toString();
                works = worksEt.getText().toString();

                insert();
                NavController controller = Navigation.findNavController(getView());
                controller.navigate(R.id.action_addFragment_to_worksFragment);
            }
        });

    }

    private void insert() {
        WorksRepository.getInstance(getContext()).getWorksDao().insert(new WorksEntity(name,works));
    }

}