package eu.tutorials.news.presentation.news_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import eu.tutorials.news.R
import eu.tutorials.news.util.Screen

@Composable
fun MainScreen(navController: NavController) {

    var isExpanded by remember { mutableStateOf(false) }

    val countries = listOf(
        "United Arab Emirates", "Argentina", "Austria", "Australia", "Belgium",
        "Bulgaria", "Brazil", "Canada", "Switzerland", "China",
        "Colombia", "Cuba", "Czech Republic", "Germany", "Egypt",
        "France", "United Kingdom", "Greece", "Hong Kong", "Hungary",
        "Indonesia", "Ireland", "Israel", "India", "Italy",
        "Japan", "South Korea", "Lithuania", "Latvia", "Morocco",
        "Mexico", "Malaysia", "Nigeria", "Netherlands", "Norway",
        "New Zealand", "Philippines", "Poland", "Portugal", "Romania",
        "Serbia", "Russia", "Saudi Arabia", "South Africa", "Sweden", "Singapore",
        "Slovakia", "Thailand", "Turkey", "Taiwan", "Ukraine",
        "United States", "Venezuela"
    )

    val blue = Color(0xFF023e8a)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.illustrations),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 96.dp, bottom = 16.dp)
                .size(400.dp)
        )
        Text(
            text = "Welcome!",
            style = MaterialTheme.typography.headlineMedium.copy(color = blue, fontSize = 48.sp, fontWeight = FontWeight.SemiBold),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(
            text = "\"The news shapes our understanding of the world around us.\"",
            style = MaterialTheme.typography.bodyMedium.copy(color = blue, fontSize = 15.sp),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(12.dp))
        Box(
            contentAlignment = Alignment.Center
        ) {
            Button(
                onClick = { isExpanded = true },
                modifier = Modifier.padding(bottom = 16.dp),
                colors = ButtonDefaults.buttonColors(Color.Transparent)
            ) {
                Text(text = "Select Country", color = blue)
                if (isExpanded) {
                    Icon(
                        Icons.Default.KeyboardArrowUp,
                        contentDescription = "Arrow Up",
                        tint = blue
                    )
                } else {
                    Icon(Icons.Default.KeyboardArrowDown,
                        contentDescription = "Arrow Down",
                        tint = blue
                    )
                }
            }
            DropdownMenu(
                modifier = Modifier
                    .height(250.dp)
                    .background(Color(0xFFdef7e5)),
                expanded = isExpanded,
                onDismissRequest = { isExpanded = false }
            ) {
                countries.forEach { country ->
                    DropdownMenuItem(
                        text = { Text(text = country, color = Color(0xFF023047)) },
                        onClick = {
                            isExpanded = false
                            navController.navigate("${Screen.NewsScreen.route}/$country")
                        }
                    )
                    if (countries.last() != country) {
                        Divider(
                            thickness = 0.3.dp,
                            color = Color(0xFF92e3a9)
                        )
                    }
                }
            }

        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    MainScreen()
//}
