// ScreenProducts.kt
package com.example.lab09

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage

@Composable
fun ScreenProducts(navController: NavHostController, servicio: ProductApiService) {
    var listaProductos by remember { mutableStateOf<List<ProductModel>>(emptyList()) }

    LaunchedEffect(Unit) {
        val listado = servicio.getProducts().products
        listaProductos = listado
    }

    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(listaProductos) { producto ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp) // Corrected elevation
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    AsyncImage(
                        model = producto.thumbnail,
                        contentDescription = "Imagen del producto",
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    )
                    Spacer(Modifier.height(8.dp))
                    Text(text = producto.title, style = MaterialTheme.typography.titleMedium) // Changed h6 to titleMedium
                    Text(text = "Precio: ${producto.price}$")
                    Text(text = producto.description)
                }
            }
        }
    }
}
