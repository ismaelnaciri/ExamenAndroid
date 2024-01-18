package cat.insvidreres.inf.examenandroid.viewModel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import cat.insvidreres.inf.examenandroid.model.Alumn
import cat.insvidreres.inf.examenandroid.repository.Repository

class RecyclerAlumnViewModel: ViewModel() {

    lateinit var alumns: LiveData<List<Alumn>>

    fun getAllAlumns(context: Context) {
        alumns = Repository.getAllAlumns(context)!!
    }

    fun getAlumnsAprovats(context: Context) {
        alumns = Repository.getAlmnsAprovats(context)!!
    }

    fun getFailedAlumns(context: Context) {
        alumns = Repository.getFailedAlumns(context)!!
    }
}