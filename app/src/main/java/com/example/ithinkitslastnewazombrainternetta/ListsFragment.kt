package com.example.ithinkitslastnewazombrainternetta

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListsFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val dataset = arrayOf(
            PlantFromInternet(
                name = "Peashooter",
                sunCost = 100,
                recharge = "Fast",
                toughness = "Typical",
                family = "Pea",
                image = "https://pvz-2-api.vercel.app/images/plants/peashooter.png"
            ),
            PlantFromInternet(
                name = "Sunflower",
                sunCost = 50,
                recharge = "Fast",
                toughness = "Typical",
                family = "Flower",
                image = "https://pvz-2-api.vercel.app/images/plants/sunflower.png"
            ),
            PlantFromInternet(
                name = "Cherry Bomb",
                sunCost = 150,
                recharge = "Slow",
                toughness = "Instant",
                family = "Bomb",
                image = "https://pvz-2-api.vercel.app/images/plants/cherry_bomb.png"
            ),
            PlantFromInternet(
                name = "Wall-nut",
                sunCost = 50,
                recharge = "Sluggish",
                toughness = "High",
                family = "Nut",
                image = "https://pvz-2-api.vercel.app/images/plants/wall_nut.png"
            ),
            PlantFromInternet(
                name = "Potato Mine",
                sunCost = 25,
                recharge = "Sluggish",
                toughness = "Typical",
                family = "Bomb",
                image = "https://pvz-2-api.vercel.app/images/plants/potato_mine.png"
            ),
            PlantFromInternet(
                name = "Snow Pea",
                sunCost = 175,
                recharge = "Fast",
                toughness = "Typical",
                family = "Pea",
                image = "https://pvz-2-api.vercel.app/images/plants/snow_pea.png"
            ),
            PlantFromInternet(
                name = "Chomper",
                sunCost = 150,
                recharge = "Fast",
                toughness = "Typical",
                family = "Chomper",
                image = "https://pvz-2-api.vercel.app/images/plants/chomper.png"
            ),
        )
        val customAdapter = MyLovelyAdapter(dataset)

        val recyclerView: RecyclerView = view.findViewById(R.id.recuclerView)
        recyclerView.adapter = customAdapter

    }
}