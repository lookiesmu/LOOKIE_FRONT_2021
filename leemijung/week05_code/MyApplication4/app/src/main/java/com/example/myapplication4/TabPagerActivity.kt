package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPagerActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager)

        //Tablayout과 pager 연결
        tab_layout.addTab(tab_layout.newTab().setText("ONE")) //새로운 Tab을 만들고 이름짓기
        tab_layout.addTab(tab_layout.newTab().setText("TWO")) //새로운 Tab을 만들고 이름짓기
        tab_layout.addTab(tab_layout.newTab().setText("THREE")) //새로운 Tab을 만들고 이름짓기

        val pagerAdapter=FragmentPagerAdapter(supportFragmentManager, 3)
        view_pager.adapter=pagerAdapter

        //Tab과 Pager 연동
        tab_layout.addOnTabSelectedListener(object :TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                view_pager.setCurrentItem(tab!!.position)
                //Tab이 클릭되었을 때 pager이동
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }
        })
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))
        // pager가 이동했을 때 Tab을 이동시키는 코드 (반대는 아님)
    }
}


//어답터는 pager를 위한 것
class FragmentPagerAdapter(
    fragmentManager: FragmentManager, //프라그먼트를 사용하겠다
    val tabCount:Int
):FragmentStatePagerAdapter(fragmentManager){
    override fun getCount(): Int {
        return tabCount
    }

    override fun getItem(position: Int): Fragment {
        //position에 해당하는 fragment 리턴
        when(position){
            0->{
                return Fragment1()
            }
            1->{
                return Fragment2()
            }
            2->{
                return Fragment3()
            }
            else-> return Fragment1()
        }
    }
}
