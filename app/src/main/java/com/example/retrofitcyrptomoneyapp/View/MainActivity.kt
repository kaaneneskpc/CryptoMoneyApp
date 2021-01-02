package com.example.retrofitcyrptomoneyapp.View


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitcyrptomoneyapp.Adapter.RecyclerViewAdapter
import com.example.retrofitcyrptomoneyapp.Model.CryptoModel
import com.example.retrofitcyrptomoneyapp.R
import com.example.retrofitcyrptomoneyapp.Service.CryptoAPI
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() ,RecyclerViewAdapter.Listener {

    private val BASE_URL = "https://api.nomics.com/v1/"
    private var cryptoModels : ArrayList<CryptoModel> ? = null
    private lateinit var recyclerViewAdapter : RecyclerViewAdapter

    //Disposable
    private lateinit var compositeDisposable : CompositeDisposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        compositeDisposable = CompositeDisposable()
        //RecyclerView

        val layoutManager : RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        loadData()
    }

    private fun loadData() {
        val retrofitObject = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build().create(CryptoAPI::class.java)
        compositeDisposable?.add(retrofitObject.getData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(this::handleResponse))


         /* val service = retrofitObject.create(CryptoAPI :: class.java)

          val call = service.getData()
         call.enqueue(object : Callback<List<CryptoModel>>{
             override fun onFailure(call: Call<List<CryptoModel>>, t: Throwable) {
                 t.printStackTrace()
             }

             override fun onResponse(call: Call<List<CryptoModel>>, response: Response<List<CryptoModel>>) {
                 if(response.isSuccessful){
                     response.body()?.let { //not null coming
                          cryptoModels = ArrayList(it)
                         /*for(cryptoModel : CryptoModel in cryptoModels!!){
                             println(cryptoModel.currency)
                             println(cryptoModel.price)
                         }*/
                         cryptoModels?.let {
                             recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
                             recyclerView.adapter = recyclerViewAdapter
                         }

                     }
                 }
             }

         })*/
    }
     private fun handleResponse(cryptoList: List<CryptoModel>) {
         cryptoModels = ArrayList(cryptoList)
         cryptoModels?.let{
             recyclerViewAdapter = RecyclerViewAdapter(it,this@MainActivity)
             recyclerView.adapter = recyclerViewAdapter
         }
     }
    override fun onItemClick(cryptoModel: CryptoModel) {
        Toast.makeText(this,"Clicked : + ${cryptoModel.currency}",Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}