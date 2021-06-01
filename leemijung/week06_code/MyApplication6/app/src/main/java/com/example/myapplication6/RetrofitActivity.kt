package com.example.myapplication6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retrofit)


        //  Retrofit 추가
        // http://mellowcode.org/ 기본 주소
        // http://mellowcode.org/json/students/
        // http://mellowcode.org/test/code/
        val retrofit= Retrofit.Builder()
            .baseUrl("http://mellowcode.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        //    Retrofit과 연결
        val service=retrofit.create(RetrofitService::class.java)

        //    Retrofit 사용 [get 방식]  (enqueue: 대기줄에 올렸다)
        service.getStudentsList().enqueue(object:Callback<ArrayList<PersonFromServer>>{
            override fun onFailure(call: Call<ArrayList<PersonFromServer>>, t: Throwable) {
                Log.d("retrofitt", "ERROR")
                call.isCanceled
                call.isExecuted
                call.cancel()
            }

            override fun onResponse(
                call: Call<ArrayList<PersonFromServer>>,
                response: Response<ArrayList<PersonFromServer>>
            ) {
                if(response.isSuccessful){
                    val personList=response.body()
                    Log.d("retrofitt", "res : "+personList?.get(0)?.age)

                    val code=response.code()
                    Log.d("retrofitt", "code : "+code)

                    val header=response.headers()
                    Log.d("retrofitt", "code : "+header)

                }
            }
        })


        ////    Retrofit 사용 [post 방식]
        //val params=HashMap<String, Any>()
        //params.put("name", "김개똥")
        //params.put("age", 20)
        //params.put("intro", "안녕하세요")
        //service.createStudent(params).enqueue(object :Callback<PersonFromServer>{
        //    override fun onResponse(
        //        call: Call<PersonFromServer>,
        //        response: Response<PersonFromServer>
        //    ) {
        //        if(response.isSuccessful){
        //            val person=response.body()
        //            Log.d("retrofitt", "name : "+person?.name)
        //        }
        //    }

        //    override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {

        //    }
        //})

        // [get2 방식]
        val person=PersonFromServer(name="김철수", age=12, intro="안녕하세요 철수입니다")
        service.createStudentEasy(person).enqueue(object :Callback<PersonFromServer> {
            override fun onResponse(
                call: Call<PersonFromServer>,
                response: Response<PersonFromServer>
            ) {
                if (response.isSuccessful) {
                    val person = response.body()
                    Log.d("retrofitt", "name : " + person?.name)
                }
            }

            override fun onFailure(call: Call<PersonFromServer>, t: Throwable) {

            }
        })
    }
}