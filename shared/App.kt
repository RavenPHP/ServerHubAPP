package com.serverhub

import androidx.compose.runtime.Composable
import com.serverhub.models.Server
import com.serverhub.repository.ServerRepository
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Created by DevRaven
 * Shared UI for Android & iOS
 */

@Composable
fun App() {
    var searchQuery by remember { mutableStateOf("") }
    var servers by remember { mutableStateOf(ServerRepository.getAllServers()) }

    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "ServerHub", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        BasicTextField(
            value = searchQuery,
            onValueChange = {
                searchQuery = it
                servers = if (it.isEmpty()) {
                    ServerRepository.getAllServers()
                } else {
                    ServerRepository.searchServers(it)
                }
            },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        ServerList(servers)
    }
}

@Composable
fun ServerList(servers: List<Server>) {
    LazyColumn {
        items(servers) { server ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(8.dp)) {
                    Text(text = server.name, style = MaterialTheme.typography.titleMedium)
                    Text(text = server.description)
                    Text(text = "Category: ${server.category}")
                    if (server.verified) {
                        Text(text = "Verified Bot ✅")
                    }
                }
            }
        }
    }
}