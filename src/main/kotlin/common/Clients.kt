package common

import java.net.http.HttpClient

object Clients {
    val httpClient = HttpClient.newHttpClient()

}