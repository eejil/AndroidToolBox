package fr.isen.franco.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.util.Log

class lifeCycle : AppCompatActivity(), lifeCycleFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LIFECYCLE", "CREATE de l'activité")
        setContentView(R.layout.activity_life_cycle)
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


}
