package com.techno.galago

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Spots() {
    Column(modifier = Modifier.padding(vertical = 16.dp)) {
        SpotsHeader()
        Spacer(modifier = Modifier.height(16.dp))
        LazyRow(
            contentPadding = PaddingValues(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            item { SpotItem(name = "San Juan, La Union", distance = "• 277 km", imageId = R.drawable.elyu) }
            item { SpotItem(name = "Puerto Princesa, Palawan", distance = "• 592 km", imageId = R.drawable.puerto) }
            item { SpotItem(name = "Boracay Island", distance = "• 314 km", imageId = R.drawable.boracay) }
        }
    }
}

@Composable
fun SpotsHeader() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("Popular spots right now", fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "See More")
    }
}

@Composable
fun SpotItem(name: String, distance: String, imageId: Int) {
    Column(modifier = Modifier.size(width = 160.dp, height = 200.dp)) {
        Image(
            painter = painterResource(id = imageId),
            contentDescription = name,
            modifier = Modifier
                .fillMaxWidth()
                .height(120.dp)
                .clip(RoundedCornerShape(8.dp)),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(name, fontWeight = FontWeight.Bold, fontSize = 14.sp)
        Text(distance, fontSize = 12.sp)
    }
}