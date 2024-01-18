package cat.insvidreres.inf.examenandroid.adapter

import android.content.Context
import android.content.DialogInterface.OnClickListener
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cat.insvidreres.inf.examenandroid.databinding.ItemAlumneBinding
import cat.insvidreres.inf.examenandroid.model.Alumn

class AlumnAdapter(val context: Context, var dataset: List<Alumn>, val itemOnClickListener: (Alumn) -> Unit)
    : RecyclerView.Adapter<AlumnAdapter.AlumnViewHolder>() {

        inner class AlumnViewHolder(private var binding: ItemAlumneBinding)
            : RecyclerView.ViewHolder(binding.root) {

                fun bind(alumn: Alumn) {
                    binding.textViewName.text = alumn.name
                    binding.textViewGrup.text = alumn.group
                    binding.textViewNota.text = alumn.grade.toString()

                    binding.root.setOnClickListener {
                        itemOnClickListener.invoke(alumn)
                    }
                }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlumnViewHolder {
        val itemBinding = ItemAlumneBinding.inflate(LayoutInflater.from(context), parent, false)
        return AlumnViewHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

    override fun onBindViewHolder(holder: AlumnViewHolder, position: Int) {
        val alumn = dataset[position]
        holder.bind(alumn)
    }
}