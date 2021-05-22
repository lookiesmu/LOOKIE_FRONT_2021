package com.example.myapplication4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPager2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tab_pager2)


        //Tablayout과 pager 연결
        tab_layout.addTab(tab_layout.newTab().setText("ONE")) //새로운 Tab을 만들고 이름짓기
        tab_layout.addTab(tab_layout.newTab().setText("TWO")) //새로운 Tab을 만들고 이름짓기
        tab_layout.addTab(tab_layout.newTab().setText("THREE")) //새로운 Tab을 만들고 이름짓기

        val adapter=ThreePageAdapter(LayoutInflater.from(this@TabPager2Activity))
        view_pager.adapter=adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))


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


    }
}

//프래그먼트를 사용하지 않고 만드는 방법
class ThreePageAdapter(
    val layoutInflater: LayoutInflater
) : PagerAdapter() {  //override 두개로는 부족하다(destroyItem, instantiateItem 추가)

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View) //뷰 떼기, object를 View로 바꾸고 container에서 떼기
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        //뷰를 만드는 역할
        when (position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.fragment_two, container, false)
                container.addView(view)
                return view
            }
            2 -> {
                val view = layoutInflater.inflate(R.layout.fragment_three, container, false)
                container.addView(view)
                return view
            }
            else->{
                val view=layoutInflater.inflate(R.layout.fragment_one, container, false)
                container.addView(view)
                return view
            }
        }
    }

    override fun getCount(): Int {
        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object` as View
        //보고있는 화면과 리턴시킨 화면을 비교교
    }
}