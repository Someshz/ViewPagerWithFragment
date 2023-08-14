package com.example.viewpagerwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.viewpagerwithfragment.adapter.MyAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager2: ViewPager2 = findViewById(R.id.viewPager2)
        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        val adapter: MyAdapter = MyAdapter(supportFragmentManager, lifecycle)
        val tabTitles = arrayOf("RED", "GREEN", "YELLOW")

        adapter.addFragment(RedFragment());
        adapter.addFragment(GreenFragment());
        adapter.addFragment(YellowFragment());
        viewPager2.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }
}