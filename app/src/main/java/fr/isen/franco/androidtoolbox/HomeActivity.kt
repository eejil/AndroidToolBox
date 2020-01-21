package fr.isen.franco.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View


class HomeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

    }

    fun lifeCycle(v: View) {
        val intent = Intent( this@HomeActivity, lifeCycle::class.java)
        startActivity(intent)
    }

    fun save(v: View) {
        setContentView(R.layout.activity_life_cycle);
    }

    fun permissions(v: View) {
        setContentView(R.layout.activity_life_cycle);
    }

    fun webservices(v: View) {
        setContentView(R.layout.activity_life_cycle);
    }


}
