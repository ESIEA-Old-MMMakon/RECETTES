package com.example.esiea3a.presentation.network

import android.app.Service
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.esiea3a.R
import com.example.esiea3a.presentation.data.Receipt
import com.example.esiea3a.presentation.ui.ReceiptAdapter
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
const val BASEURL = "https://jsonplaceholder.typicode.com/"

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

        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        val receiptApi:ReceiptApi = retrofit.create(ReceiptApi::class.java)

        receiptApi.fetchAllReceipts().enqueue(object: Callback<ReceiptResponse> {
            override fun onFailure(call: Call<ReceiptResponse>, t: Throwable){
                //TODO("not implemented")
            }
            override fun onResponse(call: Call<ReceiptResponse>, response: Response<ReceiptResponse>){
                if(response.isSuccessful && response.body() !=null){
                    val receiptResponse: ReceiptResponse = response.body()!!
                    adapter.updateList(receiptResponse.result)
                }
            }
        })

        val bookList: ArrayList<Receipt> = arrayListOf<Receipt>().apply {
            add(Receipt(1, title = "pistache", description = "faites",url=""))
            add(Receipt(2, title = "ndole", description = "un bon ndole",url=""))
            add(Receipt(3, title = "hero", description = "bon hero",url=""))
            add(Receipt(4, title = "mitumba", description = "bien malaxé",url=""))


        }
        adapter.updateList(bookList)
    }
}