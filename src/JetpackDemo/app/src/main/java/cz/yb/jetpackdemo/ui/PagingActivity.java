package cz.yb.jetpackdemo.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import cz.yb.jetpackdemo.R;
import cz.yb.jetpackdemo.adapter.PagingAdapter;
import cz.yb.jetpackdemo.entity.WorksEntity;
import cz.yb.jetpackdemo.repository.WorksRepository;

public class PagingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paging);

        RecyclerView recyclerView = findViewById(R.id.recycleView);
        final PagingAdapter adapter = new PagingAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LiveData<PagedList<WorksEntity>> data = new LivePagedListBuilder<>(WorksRepository.getInstance(this).getWorksDao().getWorksForPaging(),3).build();
        data.observe(this, new Observer<PagedList<WorksEntity>>() {
            @Override
            public void onChanged(PagedList<WorksEntity> worksEntities) {
                adapter.submitList(worksEntities);
            }
        });

    }
}