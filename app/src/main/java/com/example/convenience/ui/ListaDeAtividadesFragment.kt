package com.example.convenience.ui
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.convenience.R

class ListaDeAtividadesFragment : Fragment() {

    private lateinit var listView: ListView
    private lateinit var editText: EditText
    private lateinit var buttonAdd: Button
    private lateinit var buttonSave: Button
    private lateinit var adapter: ArrayAdapter<String>

    private val items = mutableListOf<String>()
    private var selectedItemPosition: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.lista_de_atividades, container, false)

        listView = view.findViewById(R.id.listView)
        editText = view.findViewById(R.id.editTextNewItem)
        buttonAdd = view.findViewById(R.id.buttonAddItem)
        buttonSave = view.findViewById(R.id.buttonSaveItem)

        adapter = ArrayAdapter(requireContext(), R.layout.item_atividade, R.id.textViewListItem, items)
        listView.adapter = adapter

        buttonAdd.setOnClickListener {
            addItem()
        }

        buttonSave.setOnClickListener {
            saveItem()
        }

        listView.onItemClickListener = AdapterView.OnItemClickListener { _, _, position, _ ->
            editItem(position)
        }

        return view
    }
    //salva ou edita o item
    private fun addItem() {
        val newItem = editText.text.toString()
        if (newItem.isNotBlank()) {
            if (selectedItemPosition != null) {

                items[selectedItemPosition!!] = newItem
                selectedItemPosition = null
            } else {

                items.add(newItem)
            }
            adapter.notifyDataSetChanged()
            editText.text.clear()
            buttonSave.visibility = View.GONE // ocultar botao
        } else {
            Toast.makeText(requireContext(), "Digite um item válido.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun editItem(position: Int) {
        val item = items[position]
        editText.setText(item)
        selectedItemPosition = position
        buttonSave.visibility = View.VISIBLE // exibir botao
    }

    //salvar item
    private fun saveItem() {
        addItem()
        buttonSave.visibility = View.GONE
    }
}
