package com.example.ithinkitslastnewazombrainternetta.ui

import android.content.ContentValues.TAG
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.ithinkitslastnewazombrainternetta.R
import com.example.ithinkitslastnewazombrainternetta.data.model.ZombrFromInternet
import com.example.ithinkitslastnewazombrainternetta.data.model.remote.RetrofitClient
import com.example.ithinkitslastnewazombrainternetta.databinding.FragmentDetailedBinding
import com.example.ithinkitslastnewazombrainternetta.databinding.FragmentDetailedInfBinding
import kotlinx.coroutines.launch

class DetailedInfFragment : Fragment(R.layout.fragment_detailed_inf) {
    private var _binding: FragmentDetailedInfBinding? = null
    // Безопасный доступ к биндингу (работает только между onCreateView и onDestroyView)
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailedInfBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadZombieDetails("pirate zombiec" )
    }

    private fun loadZombieDetails(zombieName: String) {
        lifecycleScope.launch {
            Log.d(
                TAG,
                "Начинаем запрос деталей зомби: $zombieName"
            )

            showLoading(true)

            try {
                val details =
                    RetrofitClient.apiService
                        .getZombieDetails(zombieName)

                Log.d(TAG, "Детали зомби получены")
                Log.d(TAG, "Ответ сервера: $details")


                showZombieDetails(
                    zombie = details
                )
            } catch (exception: Exception) {
                showError(
                    requestName = "детали зомби $zombieName",
                    exception = exception
                )
            } finally {
                showLoading(false)
            }
        }
    }

    private fun showZombieDetails(zombie: ZombrFromInternet) {
        binding.textView4.text = zombie.name
        binding.textView5.text = zombie.toughness
        binding.textView6.text = zombie.speed
        binding.textView7.text = zombie.stamina
        binding.textView8.text = zombie.description
        binding.textView9.text = zombie.image

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
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.isVisible = isLoading

    }


}