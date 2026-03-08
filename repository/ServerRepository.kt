package com.serverhub.repository

import com.serverhub.models.Server

/**
 * Created by DevRaven
 * Simulated backend repository for servers
 */
object ServerRepository {

    private val servers = mutableListOf<Server>()

    init {
        // Sample servers
        servers.add(
            Server(
                id = "1",
                name = "Gaming Hub",
                description = "Join to discuss all games!",
                inviteLink = "https://discord.gg/gaminghub",
                category = "Gaming",
                verified = true
            )
        )
        servers.add(
            Server(
                id = "2",
                name = "Study Zone",
                description = "Students share study tips.",
                inviteLink = "https://discord.gg/studyzone",
                category = "Education",
                verified = false
            )
        )
    }

    fun getAllServers(): List<Server> = servers

    fun addServer(server: Server) {
        servers.add(server)
    }

    fun searchServers(query: String): List<Server> {
        return servers.filter { it.name.contains(query, true) || it.description.contains(query, true) }
    }
}