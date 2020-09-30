package cz.yb.jetpackdemo.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import cz.yb.jetpackdemo.dao.WorksDao;
import cz.yb.jetpackdemo.entity.WorksEntity;

@Database(entities = {WorksEntity.class},version = 1,exportSchema = false)
public abstract class WorksDatabase extends RoomDatabase {
    public abstract WorksDao getWorksDao();
}
