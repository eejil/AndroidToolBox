package fr.isen.franco.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log
import android.widget.FrameLayout
import kotlinx.android.synthetic.main.activity_life_cycle.*


var visible: Boolean? = null

class lifeCycle : AppCompatActivity(), lifeCycleFragment.OnFragmentInteractionListener, lifeCycleFragmentTwo.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
        if (findViewById<FrameLayout>(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            val firstFragment = lifeCycleFragment()

            firstFragment.arguments = intent.extras

            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, firstFragment).commit()
            visible = true;
        }
    }


    override fun onPause() {
        super.onPause()
        Log.d("LIFECYCLE", "PAUSE de l'activité")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LIFECYCLE", "DESTROY de l'activité")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LIFECYCLE", "RESUME de l'activité")
    }

    fun backHome(v: View) {
        val intent = Intent( this@lifeCycle, HomeActivity::class.java)
        startActivity(intent)
    }

    fun alternate(v: View) {
        /*if(this.frag1.isVisible){
            supportFragmentManager.beginTransaction().show(this.frag2).commit()
            supportFragmentManager.beginTransaction().hide(this.frag1).commit()
        }
        else{
            supportFragmentManager.beginTransaction().show(this.frag1).commit()
            supportFragmentManager.beginTransaction().hide(this.frag2).commit()
        }*/

        if(visible == true) {
            val newFragment = lifeCycleFragmentTwo()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit()
            visible = false
        }

        else if(visible == false) {
            val newFragment = lifeCycleFragment()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, newFragment).commit()
            visible = true
        }
    }


}
