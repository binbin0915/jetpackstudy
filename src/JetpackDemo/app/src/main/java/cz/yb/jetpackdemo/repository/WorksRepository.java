package cz.yb.jetpackdemo.repository;

import android.content.Context;

import androidx.room.Room;

import cz.yb.jetpackdemo.dao.WorksDao;
import cz.yb.jetpackdemo.database.WorksDatabase;

public class WorksRepository {
    private static   volatile  WorksRepository instance;

    private WorksDao worksDao;
    private WorksDatabase worksDatabase;

    public WorksRepository(Context context) {
        worksDatabase = Room.databaseBuilder(context,WorksDatabase.class,"works_db").allowMainThreadQueries().build();
        worksDao = worksDatabase.getWorksDao();

    }

    public  static  WorksRepository getInstance(Context context){
        if(instance==null){
            synchronized (WorksRepository.class){
                if(instance==null){
                    instance = new WorksRepository(context);
                }

            }

        }
        return instance;
    }

    public WorksDao getWorksDao() {
        return worksDao;
    }
}
