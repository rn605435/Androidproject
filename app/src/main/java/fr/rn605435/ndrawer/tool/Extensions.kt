package fr.rn605435.ndrawer.tool

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import fr.rn605435.ndrawer.R

fun AppCompatActivity.replace(frag: Fragment) {
    supportFragmentManager.beginTransaction().replace(R.id.frame, frag).commit()
}
