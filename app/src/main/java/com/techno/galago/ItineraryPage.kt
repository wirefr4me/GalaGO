package com.techno.galago

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

data class ItineraryItem(
    val name: String,
    val description: String,
    val category: String? = null,
    val priceRange: String,
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItineraryPage(navController: NavHostController) {
    val tripDates = "May 14 - May 15, 2025"

    val day1Items = listOf(
        ItineraryItem(
            name = "Camp Riverside 2600",
            description = "Minimalist hotel and lodging inspired by local architecture",
            category = "Hotel",
            priceRange = "₱1,250 - ₱5,500 per night"
        ),
        ItineraryItem(
            name = "Tau Ceti Specialty Coffee",
            description = "Coffee & Tea, Italian",
            category = "Coffee & Tea",
            priceRange = "₱10 - ₱200"
        ),
        ItineraryItem(
            name = "Tam-awan Village",
            description = "Reconstructed Cordillera village with traditional huts, cultural information, art & a cafe.",
            category = "Historic site",
            priceRange = "Entrance: ₱0 - ₱60 depending on age"
        )
    )

    val day2Items = listOf(
        ItineraryItem(
            name = "Burnham Park",
            description = "Sprawling park with a man-made lake. Popular tourist spot in Baguio.",
            category = "Park",
            priceRange = "Entrance: Free"
        ),
        ItineraryItem(
            name = "Session Road",
            description = "A 1.7km walkable thoroughfare with restaurants, vendors, and other amenities.",
            category = "Hub",
            priceRange = "Entrance: Free"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Generated Itinerary") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Go back"
                        )
                    }
                }
            )
        }
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier
                .padding(paddingValues)
                .padding(16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                Text(
                    text = tripDates,
                    fontSize = 20.sp,
                    modifier = Modifier.padding(bottom = 16.dp),
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight.Bold
                )
            }

            item {
                Text(
                    text = "Day 1",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            items(day1Items) { item ->
                ItineraryItemRow(item = item)
                if (day1Items.indexOf(item) < day1Items.size - 1) {
                    HorizontalDivider()
                }
            }

            item { Spacer(modifier = Modifier.height(16.dp)) }

            item {
                Text(
                    text = "Day 2",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            items(day2Items) { item ->
                ItineraryItemRow(item = item)
                if (day2Items.indexOf(item) < day2Items.size - 1) {
                    HorizontalDivider()
                }
            }

            item { Spacer(modifier = Modifier.height(24.dp)) }

            item {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp)
                ) {
                    Text("Save Itinerary")
                }
            }
        }
    }
}

@Composable
fun ItineraryItemRow(item: ItineraryItem) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Outlined.Star,
            contentDescription = null,
            tint = Color.Black,
            modifier = Modifier.padding(end = 16.dp)
        )
        Column(
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Text(
                text = item.name,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
            Text(
                text = item.description,
                color = Color.Gray,
                fontSize = 14.sp
            )
            Text(
                text = item.priceRange,
                color = Color.Gray,
                fontSize = 14.sp
            )
            if (!item.category.isNullOrBlank()) {
                Text(
                    text = item.category,
                    color = MaterialTheme.colorScheme.primary,
                    fontSize = 12.sp
                )
            }
        }
    }
}
