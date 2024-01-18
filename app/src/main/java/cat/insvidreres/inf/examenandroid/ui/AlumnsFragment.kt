package cat.insvidreres.inf.examenandroid.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cat.insvidreres.inf.examenandroid.R
import cat.insvidreres.inf.examenandroid.adapter.AlumnAdapter
import cat.insvidreres.inf.examenandroid.databinding.FragmentAlumnsBinding
import cat.insvidreres.inf.examenandroid.viewModel.RecyclerAlumnViewModel


class AlumnsFragment : Fragment() {

    private lateinit var binding: FragmentAlumnsBinding
    private val viewModel: RecyclerAlumnViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAlumnsBinding.inflate(inflater)

        val alumnRecyclerView = binding.recyclerView
        alumnRecyclerView.layoutManager = LinearLayoutManager(context)
        alumnRecyclerView.setHasFixedSize(true)

        var alumnAdapter = AlumnAdapter(requireContext(), emptyList()) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Name: " + selectedItem.name
                        + " | Gruo: " + selectedItem.group
                        + " | Nota: " + selectedItem.grade,
                Toast.LENGTH_LONG).show()
        }

        viewModel.getAllAlumns(requireContext())
        viewModel.alumns.observe(viewLifecycleOwner) { alumnsList ->
            alumnAdapter.dataset = alumnsList
            alumnRecyclerView.adapter = alumnAdapter

            binding.failedSwitch.setOnClickListener {
                if (binding.failedSwitch.isChecked) {
                    viewModel.getAlumnsAprovats(requireContext())
                } else {
                    viewModel.getFailedAlumns(requireContext())
                }
            }
        }
        return binding.root
    }
}