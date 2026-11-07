package com.example.ithinkitslastnewazombrainternetta.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ithinkitslastnewazombrainternetta.R
import com.example.ithinkitslastnewazombrainternetta.data.model.remote.RetrofitClient
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class ListsFragment : Fragment() {
    private lateinit var recyclerView: RecyclerView
    private var customAdapter: MyLovelyAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(
            view, savedInstanceState
        )
        recyclerView = view.findViewById(R.id.recuclerView)
        recyclerView.layoutManager = GridLayoutManager(view.context, 2)
        customAdapter = MyLovelyAdapter(emptyList()) { itemName ->
            Log.d(
                "RecyclerClick", "Clicked: $itemName"
            )
        }
        recyclerView.adapter = customAdapter
        //loadPlants()
        loadZombrs()
    }

    private fun loadPlants() {
        lifecycleScope.launch {
            try {
                val plants = RetrofitClient.apiService.getPlants()
                updateAdapter(plants)
            } catch (exception: Exception) {
                showError("список растений", exception)
            }
        }
    }

    private fun loadZombrs() {
        lifecycleScope.launch {
            try {
                val zombrs = RetrofitClient.apiService.getZombies()
                updateAdapter(zombrs)
            } catch (exception: Exception) {
                showError("список зомби", exception)
            }
        }
    }

    private fun updateAdapter(names: List<String>) {
        customAdapter = MyLovelyAdapter(names) { itemName ->
            Log.d("RecyclerClick", "Clicked: $itemName")
        }
        recyclerView.adapter = customAdapter
    }
    companion object {
        private const val TAG = "PvzNetwork"
    }
    private fun showError(requestName: String, exception: Exception) {
        Log.e(
            "PvzNetwork", "Ошибка: $requestName", exception
        )
    }
}




