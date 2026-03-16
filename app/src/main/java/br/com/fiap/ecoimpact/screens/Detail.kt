package br.com.fiap.ecoimpact.screens

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TopEndCard(modifier: Modifier = Modifier) {
    Card(
        modifier
            .size(width = 160.dp, height = 85.dp),
        colors = CardDefaults
            .cardColors(
                containerColor = MaterialTheme.colorScheme.secondary),
        shape = RoundedCornerShape(bottomStart = 85.dp)
    ) { }
}