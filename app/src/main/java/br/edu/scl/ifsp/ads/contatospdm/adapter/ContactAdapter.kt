package br.edu.scl.ifsp.ads.contatospdm.adapter

import android.content.Context
import android.content.Context.LAYOUT_INFLATER_SERVICE
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import br.edu.scl.ifsp.ads.contatospdm.R
import br.edu.scl.ifsp.ads.contatospdm.databinding.TileContactBinding
import br.edu.scl.ifsp.ads.contatospdm.model.Contact

class ContactAdapter(context: Context, private val contactList: MutableList<Contact>):
    ArrayAdapter<Contact>(context, R.layout.tile_contact, contactList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val contact = contactList[position]
        var tcb: TileContactBinding? = null

        var contactTileView = convertView
        if(contactTileView == null) {
            tcb = TileContactBinding.inflate(
                context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater,
                parent,
                false
            )
            contactTileView = tcb.root

            val tileContactHolder = TileContactHolder(tcb.nameTv, tcb.emailTv)
            contactTileView.tag = tileContactHolder
        }
        val holder = contactTileView.tag as TileContactHolder
        holder.nameTv.setText(contact.name)
        holder.emailTv.setText(contact.email)

        tcb?.nameTv?.text = contact.name
        tcb?.emailTv?.text = contact.email

        return contactTileView
    }

    private data class TileContactHolder(val nameTv: TextView, val emailTv: TextView)
}