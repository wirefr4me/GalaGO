package com.techno.galago

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Quick() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        QuickActionButton(
            text = "Plan a Trip",
            iconId = R.drawable.pencil,
            modifier = Modifier.weight(1f)
        )
        QuickActionButton(
            text = "Saved Trips",
            iconId = R.drawable.bookm,
            modifier = Modifier.weight(1f)
        )
        QuickActionButton(
            text = "Explore More",
            iconId = R.drawable.map,
            modifier = Modifier.weight(1f)
        )
        QuickActionButton(
            text = "View Itinerary",
            iconId = R.drawable.itinerary,
            modifier = Modifier.weight(1f)
        )
    }
}

@Composable
fun QuickActionButton(text: String, iconId: Int, modifier: Modifier = Modifier) {
    Button(
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF77C95B)),
        contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        modifier = modifier.height(100.dp)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = Modifier.fillMaxWidth()
        ) {
            Icon(
                painter = painterResource(id = iconId),
                contentDescription = text,
                tint = Color.DarkGray,
                modifier = Modifier.size(24.dp).padding(top = 4.dp)
            )
            Text(
                text = text,
                color = Color.DarkGray,
                fontSize = 14.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}