package com.app.edgeapi

import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import coil.load
import com.app.edgeapi.model.Article
import com.app.edgeapi.model.NewsResponse

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var totalCount: TextView
    private lateinit var image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        //val viewModel = ViewModel()

        totalCount = findViewById(R.id.totalCount)
        image = findViewById(R.id.image)

        getNews()



    }
    private fun getNews() {
        RetrofitInstance.api.getNewsArticle().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    val newsResponse = response.body()
                    totalCount.text = "Total ${newsResponse?.totalResults} Found"
                    Log.d("LEN", "Total ${newsResponse?.totalResults}")


                    var url: String = "${newsResponse?.articles?.first()?.urlToImage}"
                    totalCount.text = "Total ${newsResponse?.totalResults} Found\n${url}"

                    Log.d("LEN", "URL ${url}")

                    image.load("https://cryptoslate.com/wp-content/uploads/2024/08/berkshire-warren-buffet.jpg"){
                        crossfade(true)
                    }


                }
            }

            override fun onFailure(call: Call<NewsResponse>, response: Throwable) {
                Log.d("API FAILED", "Sorry")
            }
        })
    }

}