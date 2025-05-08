package com.techno.galago

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Social() {
    Column(Modifier.padding(vertical =8.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                "Real experiences, real stories",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
            Icon(Icons.AutoMirrored.Filled.ArrowForward, contentDescription = "See More")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            SocialItem(
                userName = "David",
                location = "Siargao, Philippines",
                elapsedTime = "2 days ago",
                description = "Just came back from Siargao, and the experience was unforgettable. Exploring the " +
                        "island led me to unexpected finds...",
                userProfileImageId = R.drawable.dave
            )
        }
    }
}

@Composable
fun SocialItem(
    userName: String,
    location: String,
    elapsedTime: String,
    description: String,
    userProfileImageId: Int
) {
    Card(
        modifier = Modifier.fillMaxWidth().height(165.dp),
        shape = RoundedCornerShape(12.dp),
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = userProfileImageId),
                contentDescription = "User Profile",
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape),
            )
            Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(text = userName, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "went to", color = Color.Gray, fontSize = 14.sp)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = location, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                }
                Text(text = elapsedTime, color = Color.Gray, fontSize = 12.sp)
                Text(text = description, fontSize = 18.sp)
            }
        }
    }
}