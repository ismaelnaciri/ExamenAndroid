package cat.insvidreres.inf.examenandroid.repository

import android.content.Context
import androidx.lifecycle.LiveData
import cat.insvidreres.inf.examenandroid.database.AlumnDatabase
import cat.insvidreres.inf.examenandroid.model.Alumn
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Repository {

    companion object {
        var alumnDatabase: AlumnDatabase? = null
        var alumns : LiveData<List<Alumn>>? = null

        fun initializeDB(context: Context): AlumnDatabase {
            return AlumnDatabase.getDatabase(context)
        }

        fun insertAlumn(context: Context, alumn: Alumn) {
            alumnDatabase = initializeDB(context)

            CoroutineScope(Dispatchers.IO).launch {
                alumnDatabase!!.alumnDAO().insertAlumn(alumn)
            }
        }

        fun getAllAlumns(context: Context): LiveData<List<Alumn>>? {
            alumnDatabase = initializeDB(context)

            alumns = alumnDatabase!!.alumnDAO().getAlumnsAprovats()
            return alumns
        }

        fun getAlmnsAprovats(context: Context): LiveData<List<Alumn>>? {
            alumnDatabase = initializeDB(context)

            alumns = alumnDatabase!!.alumnDAO().getAlumnsAprovats()
            return alumns
        }

        fun getFailedAlumns(context: Context): LiveData<List<Alumn>>? {
            alumnDatabase = initializeDB(context)

            alumns = alumnDatabase!!.alumnDAO().getFailedStudents()
            return alumns
        }
    }
}