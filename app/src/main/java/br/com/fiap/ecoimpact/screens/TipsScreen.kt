package br.com.fiap.ecoimpact.screens

import android.content.res.Configuration
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.ecoimpact.R
import br.com.fiap.ecoimpact.ui.theme.EcoImpactTheme
import br.com.fiap.ecoimpact.ui.theme.LightPrimary
import br.com.fiap.ecoimpact.ui.theme.montserratFamily

@Composable
fun TipsScreen(onHistoryClick: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(stringResource(R.string.dicas_sustent_veis), fontSize = 26.sp, fontFamily = montserratFamily, fontWeight = FontWeight.SemiBold)
        Text(stringResource(R.string.use_transporte_p_blico_sempre_que_poss_vel))
        Text(stringResource(R.string.reduza_o_consumo_de_carne_durante_a_semana))
        Text(stringResource(R.string.prefira_bicicleta_ou_caminhada_em_trajetos_curtos))
        Text(stringResource(R.string.evite_desperd_cio_de_energia_el_trica))
        Text(stringResource(R.string.reutilize_materiais_e_recicle_o_lixo))

        Button(
            onClick = onHistoryClick,
            colors = ButtonDefaults.buttonColors(
                containerColor = MaterialTheme
                    .colorScheme.primary
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp)
        ) {
            Text(
                stringResource(R.string.ir_para_hist_rico),
                color = MaterialTheme.colorScheme.onPrimary
            )
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun TipsScreenPreview() {
    EcoImpactTheme {
        TipsScreen(onHistoryClick = {})
    }
}