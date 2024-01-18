package cat.insvidreres.inf.examenandroid.viewModel

import android.content.Context
import androidx.lifecycle.ViewModel
import cat.insvidreres.inf.examenandroid.model.Alumn
import cat.insvidreres.inf.examenandroid.repository.Repository

class InsertViewModel: ViewModel() {

    fun insertAlumn(context: Context, alumn: Alumn) {
        Repository.insertAlumn(context, alumn)
    }
}