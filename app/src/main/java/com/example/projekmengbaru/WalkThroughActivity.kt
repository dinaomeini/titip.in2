package com.example.projekmengbaru

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.widget.TextView
import androidx.annotation.MainThread
import androidx.viewpager.widget.ViewPager
import com.example.projekmengbaru.adapter.WalkthroughAdapter
import kotlinx.android.synthetic.main.activity_walk_through.*

class WalkThroughActivity : AppCompatActivity() {

    lateinit var wkadapter: WalkthroughAdapter
    val dots = arrayOfNulls<TextView>(3)
    var curretpage: Int = 0
    val a: Int = 4
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_walk_through)

        wkadapter = WalkthroughAdapter(this)
        vp_walkthrough.adapter = wkadapter
        dotIndicator(curretpage)

        initAction()
    }

    fun initAction(){
        vp_walkthrough.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled( position: Int, positionOffset: Float, positionOffsetPixels: Int) {

            }

            override fun onPageSelected(position: Int) {
                dotIndicator(position)
                curretpage = position


            }

        })

        tv_lanjutkan.setOnClickListener {
            if (vp_walkthrough.currentItem + 1 < dots.size){
                vp_walkthrough.currentItem += 1
            } else {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }


        }

        tv_lewati.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    fun dotIndicator(p: Int){
        ll_dots.removeAllViews()

        for (i in 0..dots.size-1){
            dots[i] = TextView(this)
            dots[i]?.textSize = 53f
            dots[i]?.setTextColor(resources.getColor(R.color.grey))
            dots[i]?.text = Html.fromHtml("&#8226");

            ll_dots.addView(dots[i])
        }
        if (dots.size > 0) {
            dots[p]?.setTextColor(resources.getColor(R.color.colorPrimary))
        }

    }

}
