package cat.insvidreres.inf.examenandroid.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import cat.insvidreres.inf.examenandroid.model.Alumn

@Dao
interface AlumnDAO {
    @Insert(onConflict = OnConflictStrategy.ABORT)
    fun insertAlumn(alumn: Alumn)

    @Query("SELECT * FROM Students")
    fun initialAlumnsQuery(): LiveData<List<Alumn>>?

    @Query("SELECT * FROM Students WHERE grade >= 5")
    fun getAlumnsAprovats(): LiveData<List<Alumn>>?

    @Query("SELECT * FROM Students WHERE grade < 5")
    fun getFailedStudents(): LiveData<List<Alumn>>?
}