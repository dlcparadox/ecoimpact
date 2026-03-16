package br.com.fiap.ecoimpact.screens

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.ecoimpact.R
import br.com.fiap.ecoimpact.ui.theme.EcoImpactTheme
import br.com.fiap.ecoimpact.ui.theme.montserratFamily

@Composable
fun HomeScreen(onStartClick: () -> Unit) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background), // fundo escuro
        contentAlignment = Alignment.Center
    ) {

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
                modifier = Modifier.padding(32.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(R.drawable.logo),
                    contentDescription = "",
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.background),
                    modifier = Modifier
                        .size(110.dp)
                        .align(Alignment.CenterHorizontally)
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = stringResource(R.string.ecoimpact),
                    fontFamily = montserratFamily,
                    fontWeight = FontWeight.ExtraBold,
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )

                Text(
                    text = stringResource(R.string.descubra_como_suas_a_es_impactam_o_meio_ambiente),
                    fontSize = 18.sp,
                    fontFamily = montserratFamily,
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier.padding(top = 16.dp, bottom = 24.dp)
                )

                Button(
                    onClick = onStartClick,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme
                            .colorScheme.secondary
                    )) {
                    Text(
                        text = stringResource(R.string.comecar),
                        fontFamily = montserratFamily,
                        color = MaterialTheme.colorScheme.onSecondary,

                    )
                }

            }
        }
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Composable
fun HomeScreenPreview() {
    EcoImpactTheme {
        HomeScreen(onStartClick = {})
    }
}

