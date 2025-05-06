package com.techno.galago

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BotBar() {
    var selectedIndex by remember { mutableIntStateOf(0) }

    val items = listOf(
        Icons.Filled.Home to "Home",
        Icons.Filled.Search to "Search",
        painterResource(id = R.drawable.bookm) to "Saved",
        Icons.Filled.Notifications to "Notifications"
    )

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.LightGray
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 16.dp, end = 16.dp, bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            items.forEachIndexed { index, (icon, label) ->
                val isSelected = index == selectedIndex
                val modifier = Modifier.clickable { selectedIndex = index }

                when (icon) {
                    is ImageVector -> {
                        Icon(
                            imageVector = icon,
                            contentDescription = label,
                            tint = if (isSelected) Color.Black else Color.Gray,
                            modifier = modifier
                        )
                    }
                    is Painter -> {
                        Image(
                            painter = icon,
                            contentDescription = label,
                            colorFilter = if (isSelected) null else ColorFilter.tint(Color.Gray),
                            modifier = modifier.height(15.dp)
                        )
                    }
                }
            }
        }
    }
}