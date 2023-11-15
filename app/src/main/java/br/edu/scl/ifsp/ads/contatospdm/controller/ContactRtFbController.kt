package br.edu.scl.ifsp.ads.contatospdm.controller

import android.os.Message
import br.edu.scl.ifsp.ads.contatospdm.model.Constant
import br.edu.scl.ifsp.ads.contatospdm.model.Contact
import br.edu.scl.ifsp.ads.contatospdm.model.ContactDaoRtDbFb
import br.edu.scl.ifsp.ads.contatospdm.view.MainActivity

class ContactRtFbController(private val mainActivity: MainActivity) {
    private val contactDaoImpl: ContactDaoRtDbFb = ContactDaoRtDbFb()

    fun insertContact(contact: Contact) {
        Thread {
            contactDaoImpl.createContact(contact)
        }.start()
    }

    fun getContact(id: Int) = contactDaoImpl.retrieveContact(id)

    fun getContacts() {
        Thread {
            val returnList = contactDaoImpl.retrieveContacts()
            val message = Message()
            message.data.putParcelableArray(
                Constant.CONTACT_ARRAY,
                returnList.toTypedArray()
            )
            mainActivity.updateContactListHandler.sendMessage(message)
        }.start()
    }

    fun editContact(contact: Contact) {
        Thread {
            contactDaoImpl.updateContact(contact)
        }.start()
    }
    fun removeContact(contact: Contact) {
        Thread {
            contact.id?.also {
                contactDaoImpl.deleteContact(it)
            }
        }.start()
    }
}