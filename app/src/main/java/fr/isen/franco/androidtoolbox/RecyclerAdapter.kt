package fr.isen.franco.androidtoolbox

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_form.*
import kotlinx.android.synthetic.main.list_contact_item.view.*
import java.security.AccessControlContext

class RecyclerAdapter(private val items: ArrayList<Contact>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {
    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.list_contact_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.nomContact?.text = items.get(position).nom
        holder?.phoneContact?.text = items.get(position).phone
    }
}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    val nomContact = view.nomContact
    val phoneContact = view.phoneContact
}
