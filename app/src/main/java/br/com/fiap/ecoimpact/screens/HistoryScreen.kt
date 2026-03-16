package br.com.fiap.ecoimpact.screens

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.ecoimpact.R
import br.com.fiap.ecoimpact.data.HistoryRepository
import br.com.fiap.ecoimpact.ui.theme.EcoImpactTheme
import br.com.fiap.ecoimpact.ui.theme.montserratFamily

@Composable
fun HistoryScreen(onHomeClick: () -> Unit) {
    val history = HistoryRepository.getHistory()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.historico),
            fontSize = 26.sp, modifier = Modifier.padding(bottom = 16.dp),
            fontFamily = montserratFamily,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.onBackground
        )

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(history) { item ->
                Text(text = "• $item", modifier = Modifier.padding(vertical = 6.dp), fontFamily = montserratFamily, color = MaterialTheme.colorScheme.onBackground)
            }
        }

        Button(
            onClick = onHomeClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(stringResource(R.string.voltar_ao_in_cio), fontFamily = montserratFamily)
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun HistoryScreenPreview() {
    EcoImpactTheme {
        HistoryScreen(onHomeClick = {})
    }
}
