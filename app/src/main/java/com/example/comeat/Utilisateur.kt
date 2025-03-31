package com.example.comeat

import com.example.comeat.Modele.utilisateurs

data class Utilisateur(
    val id: Int,
    val nom: String,
    val prenom: String,
    val email: String,
    val mdp: String
){
    fun getUtilisateur( id: Int ): Utilisateur? {
        for( utilisateur in utilisateurs ){
            if( utilisateur.id == id ){
                return utilisateur
            }
        }
        return null
    }

    fun getUtilisateurs(): List<Utilisateur> {
        return utilisateurs
    }
}
