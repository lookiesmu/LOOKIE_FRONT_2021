package com.example.myapplication6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import io.realm.Realm
import io.realm.RealmConfiguration
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)


        Realm.init(this@RealmActivity)
        val config: RealmConfiguration = RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
        //데이터 베이스의 틀에 변경이 생기면 데이터를 지워버린다. (마이그래이션이 필요해지면 데이터를 지우겠다)

        Realm.setDefaultConfiguration(config)
        val realm = Realm.getDefaultInstance() // realm을 얻어오기

        //realm 을 사용하는 방법 -> table을 만들어야 한다.
        button_save.setOnClickListener{
            realm.executeTransaction{
                // A테이블에서 데이터를 가져온다
                // B테이블에서 데이터를 가져온다
                // C테이블에서 데이터를 가져온다
                // 조합을 한다
                // D테이블에 저장한다
                // -> 이전에 변경이 되면 문제가 발생하기 때문에 고정시켜둔다

                with(it.createObject(School::class.java)){
                    this.name="어떤 대학교"
                    this.location="서울"
                }
            }
        }
        button_load.setOnClickListener{
            realm.executeTransaction{
                val data=it.where(School::class.java).findFirst() //가로 첫번째 인자가 가져옴
                Log.d("dataa", "data: "+data)
            }
        }
        button_delete.setOnClickListener{
            realm.executeTransaction{
                it.where(School::class.java).findAll().deleteAllFromRealm() // 싹 다 지우기
                // null이 불려온다

                //it.where(School::class.java).findFirst().deleteFromRealm() // 첫번째 인자만 삭제제
            }
       }


    }
}