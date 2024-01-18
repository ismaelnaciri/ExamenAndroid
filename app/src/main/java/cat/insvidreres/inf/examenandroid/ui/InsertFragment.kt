package cat.insvidreres.inf.examenandroid.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.viewModels
import cat.insvidreres.inf.examenandroid.R
import cat.insvidreres.inf.examenandroid.databinding.FragmentAlumnsBinding
import cat.insvidreres.inf.examenandroid.databinding.FragmentInsertBinding
import cat.insvidreres.inf.examenandroid.model.Alumn
import cat.insvidreres.inf.examenandroid.viewModel.InsertViewModel


class InsertFragment : Fragment() {

    private lateinit var binding: FragmentInsertBinding
    private val viewModel: InsertViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = FragmentInsertBinding.inflate(inflater)

        binding.InsertButton.setOnClickListener {
            val name = binding.NomEditText.text.toString()
            val group = binding.GrupEditText.text.toString()
            val grade = binding.NotaEditText.text.toString().toInt()

            viewModel.insertAlumn(requireContext(), Alumn(null, name, group, grade))
        }
//        val spinner = binding.dropdownMenu
//        ArrayAdapter.createFromResource(
//            requireContext(),
//            R.array.dropdownValues,
//            android.R.layout.simple_spinner_item
//        ).also { adapter ->
//            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
//            spinner.adapter = adapter
//        }

        return binding.root
    }
}