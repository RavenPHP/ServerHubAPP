package com.serverhub.models

/**
 * Created by DevRaven
 * Model for a Discord server
 */
data class Server(
    val id: String,
    val name: String,
    val description: String,
    val inviteLink: String,
    val category: String,
    val verified: Boolean
)