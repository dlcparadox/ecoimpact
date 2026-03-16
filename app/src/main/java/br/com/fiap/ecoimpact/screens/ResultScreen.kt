@file:Suppress("UNREACHABLE_CODE")

package br.com.fiap.ecoimpact.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.ecoimpact.R
import br.com.fiap.ecoimpact.data.HistoryRepository
import br.com.fiap.ecoimpact.model.ActionItem
import br.com.fiap.ecoimpact.ui.theme.EcoImpactTheme
import br.com.fiap.ecoimpact.ui.theme.montserratFamily

@Composable
fun ResultScreen(
    actions: List<ActionItem>,
    onTipsClick: () -> Unit,
    onHistoryClick: () -> Unit
) {
    val selectedActions = actions.filter { it.selected }
    val total = selectedActions.sumOf { it.co2 }

    val historyText = if (selectedActions.isEmpty()) {
        stringResource(R.string.nenhuma_a_o_selecionada_total_0_0_kg_co)
    } else {
        selectedActions.joinToString { it.name } + " - Total: ${String.format("%.1f", total)} kg CO₂"
    }

    HistoryRepository.addRecord(historyText)
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
    ){
        Card(
            shape = RoundedCornerShape(24.dp), // curvatura
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = MaterialTheme.colorScheme.secondary),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.result_of_your_impact),
                    fontSize = 26.sp,
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                if (selectedActions.isEmpty()) {
                    Text(
                        stringResource(R.string.nenhuma_a_o_foi_selecionada),
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.ExtraLight,
                    )
                } else {
                    selectedActions.forEach {
                        Text("${it.emoji} ${it.name}: ${it.co2} kg CO₂")
                    }
                }

                Text(
                    text = "\nTotal: ${String.format("%.1f", total)} kg CO₂",
                    fontSize = 22.sp,
                    modifier = Modifier.padding(vertical = 16.dp)
                )

                Button(
                    onClick = onTipsClick,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(
                        stringResource(R.string.ver_dicas_sustent_veis),
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                }

                Button(
                    onClick = onHistoryClick,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 20.dp)
                ) {
                    Text(
                        stringResource(R.string.ver_hist_rico),
                        fontFamily = montserratFamily,
                        fontWeight = FontWeight.SemiBold,
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Preview(uiMode = android.content.res.Configuration.UI_MODE_NIGHT_YES, showBackground = true, name = "Dark Mode")
@Composable
fun ResultScreenPreview() {
    EcoImpactTheme {
        val mockActions = listOf(
            ActionItem(stringResource(R.string.dirigir_carro), 2.3, "🚗"),
        )

        ResultScreen(
            actions = mockActions,
            onTipsClick = {},
            onHistoryClick = {}
        )
    }
}