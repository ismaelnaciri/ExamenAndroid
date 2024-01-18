package cat.insvidreres.inf.examenandroid.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Students")
data class Alumne(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "group")
    val group: String,
    @ColumnInfo(name = "grade")
    val grade: Int
)
