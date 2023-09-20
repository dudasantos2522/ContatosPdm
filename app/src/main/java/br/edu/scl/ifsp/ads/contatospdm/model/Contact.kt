package br.edu.scl.ifsp.ads.contatospdm.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    var id: Int,
    var name: String,
    var address: String,
    var phone: String,
    var email: String
): Parcelable