package br.com.fiap.ecoimpact.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.ecoimpact.R
import br.com.fiap.ecoimpact.model.ActionItem
import br.com.fiap.ecoimpact.ui.theme.EcoImpactTheme
import br.com.fiap.ecoimpact.ui.theme.montserratFamily

@Composable
fun ActionScreen(
    actions: List<ActionItem>,
    onToggleAction: (Int) -> Unit,
    onCalculateClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)

    ){
        Card (
            shape = RoundedCornerShape(24.dp), // curvatura
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.onPrimary
            ),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ){
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    // .padding(16.dp)
                    .background(color = MaterialTheme.colorScheme.primary)
            ) {
                Text(
                    text = stringResource(R.string.selecione_suas_a_es_de_hoje),
                    color = MaterialTheme.colorScheme.onPrimary,
                    fontSize = 24.sp,
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )

                LazyColumn(
                    modifier = Modifier.weight(1f)
                ) {
                    itemsIndexed(actions) { index, item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp, horizontal = 20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = "${item.emoji} ${item.name} (${item.co2} kg CO₂)",
                                color = MaterialTheme.colorScheme.onPrimary,
                                fontFamily = montserratFamily,
                                fontWeight = FontWeight.ExtraLight,
                            )

                            Checkbox(
                                checked = item.selected,
                                onCheckedChange = { onToggleAction(index) }
                            )
                        }
                    }
                }

                Button(
                    onClick = onCalculateClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme
                            .colorScheme.secondary
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp)
                ) {
                    Text(
                        stringResource(R.string.calcular_impacto),
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun ActionScreenPreview() {

    val actions = listOf(
        ActionItem(stringResource(R.string.dirigir_carro), 2.3, "🚗"),
        ActionItem(stringResource(R.string.viajar_de_aviao), 8.5, "✈️"),
        ActionItem(stringResource(R.string.comer_carne), 1.5, "🍔"),
        ActionItem(stringResource(R.string.andar_de_bicicleta), 0.0, "🚲"),
        ActionItem(stringResource(R.string.usar_transporte_p_blico), 0.8, "🚌")
    )

    EcoImpactTheme {
        ActionScreen(
            actions = actions,
            onToggleAction = {},
            onCalculateClick = {}
        )
    }
}