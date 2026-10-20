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
    val customAdapter = MyLovelyAdapter()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val dataset = listOf(
//            PlantFromInternet(
//                name = "Peashooter",
//                sunCost = 100,
//                recharge = "Fast",
//                toughness = "Typical",
//                family = "Pea",
//                image = "https://pvz-2-api.vercel.app/images/plants/peashooter.png"
//            ),
//            PlantFromInternet(
//                name = "Sunflower",
//                sunCost = 50,
//                recharge = "Fast",
//                toughness = "Typical",
//                family = "Flower",
//                image = "https://pvz-2-api.vercel.app/images/plants/sunflower.png"
//            ),
//            PlantFromInternet(
//                name = "Cherry Bomb",
//                sunCost = 150,
//                recharge = "Slow",
//                toughness = "Instant",
//                family = "Bomb",
//                image = "https://pvz-2-api.vercel.app/images/plants/cherry_bomb.png"
//            ),
//            PlantFromInternet(
//                name = "Wall-nut",
//                sunCost = 50,
//                recharge = "Sluggish",
//                toughness = "High",
//                family = "Nut",
//                image = "https://pvz-2-api.vercel.app/images/plants/wall_nut.png"
//            ),
//            PlantFromInternet(
//                name = "Potato Mine",
//                sunCost = 25,
//                recharge = "Sluggish",
//                toughness = "Typical",
//                family = "Bomb",
//                image = "https://pvz-2-api.vercel.app/images/plants/potato_mine.png"
//            ),
//            PlantFromInternet(
//                name = "Snow Pea",
//                sunCost = 175,
//                recharge = "Fast",
//                toughness = "Typical",
//                family = "Pea",
//                image = "https://pvz-2-api.vercel.app/images/plants/snow_pea.png"
//            ),
//            PlantFromInternet(
//                name = "Chomper",
//                sunCost = 150,
//                recharge = "Fast",
//                toughness = "Typical",
//                family = "Chomper",
//                image = "https://pvz-2-api.vercel.app/images/plants/chomper.png"
//            ),
//        )


        val recyclerView: RecyclerView = view.findViewById(R.id.recuclerView)
        recyclerView.adapter = customAdapter
        val layoutManager = GridLayoutManager(view.context, 2)
        recyclerView.layoutManager = layoutManager
        //loadPlants()
        loadZombrs()
    }

    private fun loadPlants() {
        lifecycleScope.launch {
            Log.d(TAG, "Начинаем запрос списка растений")

            try {
                val plants = RetrofitClient.apiService.getPlants()

                Log.d(TAG, "Список растений получен")
                Log.d(TAG, "Количество растений: ${plants.size}")

                plants.forEachIndexed { index, plant ->
                    Log.d(TAG, "Растение $index: $plant")
                }

                customAdapter.submitList(plants)


            } catch (exception: Exception) {
                showError(
                    requestName = "список растений",
                    exception = exception
                )
            }
        }
    }

    private fun loadZombrs() {
        lifecycleScope.launch {
            Log.d(TAG, "Начинаем запрос списка зомби")

            try {
                val zombrs = RetrofitClient.apiService.getZombies()

                Log.d(TAG, "Список зомби получен")
                Log.d(TAG, "Количество зомби: ${zombrs.size}")

                zombrs.forEachIndexed { index, zombr ->
                    Log.d(TAG, "Зомби $index: $zombr")
                }

                customAdapter.submitList(zombrs)


            } catch (exception: Exception) {
                showError(
                    requestName = "список зомби",
                    exception = exception
                )
            }
        }
    }

    private fun showError(
        requestName: String,
        exception: Exception
    ) {
        Log.e(
            TAG,
            "Ошибка: $requestName",
            exception
        )

        val message = when (exception) {
            is IOException -> {
                "Проблема с интернет-соединением"
            }

            is HttpException -> {
                "Ошибка сервера: ${exception.code()}"
            }

            else -> {
                exception.message
                    ?: "Неизвестная ошибка"
            }
        }
    }

    companion object {
        private const val TAG = "PvzNetwork"
    }

}