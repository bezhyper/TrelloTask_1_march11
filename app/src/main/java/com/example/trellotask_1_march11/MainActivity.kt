package com.example.trellotask_1_march11

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.trellotask_1_march11.data.api.GetDataApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val firstTextForm = findViewById<TextView>(R.id.txt1)
        val secondTextForm = findViewById<TextView>(R.id.txt2)
        val thirdTextForm = findViewById<TextView>(R.id.txt3)
        val fourthTextForm = findViewById<TextView>(R.id.txt4)

        val button = findViewById<Button>(R.id.button)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://eth.neutralitywatch.com:443")
            .addConverterFactory(GsonConverterFactory.create()).build()

        val dataApi = retrofit.create(GetDataApi::class.java)



        button.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val data = dataApi.getData()

                runOnUiThread {

                    firstTextForm.text = data.start_date
                    secondTextForm.text = data.end_date
//                    thirdTextForm.text = data.overall_censorship_latency.toString()
//                    fourthTextForm.text = data.overall_censorship_latency_without_lido_censorship.toString()



                }


            }


        }






        }


    }
