package com.example.esiea3a.presentation.data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class ReceiptListFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private val adapter = ReceiptAdapter(listOf())
    private val layoutManager = LinearLayoutManager(context)
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_receipt_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = view.findViewById(R.id.book_recyclerview)
        recyclerView.apply {
            layoutManager = this@ReceiptListFragment.layoutManager
            adapter = this@ReceiptListFragment.adapter
        }
        val bookList: ArrayList<Receipt> = arrayListOf<Receipt>().apply {
            add(Receipt(1, title = "pistache", description = "faites"))
            add(Receipt(2, title = "ndole", description = "un bon ndole"))
            add(Receipt(3, title = "hero", description = "bon hero"))
            add(Receipt(4, title = "mitumba", description = "bien malaxé"))


        }
        adapter.updateList(bookList)
    }
}