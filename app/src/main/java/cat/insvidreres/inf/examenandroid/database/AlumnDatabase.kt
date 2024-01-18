package cat.insvidreres.inf.examenandroid.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import cat.insvidreres.inf.examenandroid.model.Alumn

@Database(entities = [Alumn::class], version = 1, exportSchema = false)
abstract class AlumnDatabase: RoomDatabase() {

    abstract fun alumnDAO(): AlumnDAO
    companion object {
        @Volatile
        private var INSTANCE: AlumnDatabase? = null

        fun getDatabase(context: Context): AlumnDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = buildDatabase(context)
                }
            }

            return INSTANCE!!
        }

        fun buildDatabase(context: Context): AlumnDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AlumnDatabase::class.java,
                "alumn_db"
            )
                .build()
        }

    }
}