package com.compose.canvasSamples.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.compose.canvasSamples.R
import com.compose.canvasSamples.theme.LightGreen
import com.compose.canvasSamples.theme.LightRed
import com.compose.canvasSamples.theme.Orange

@Composable
fun PlayerOnPitchComponent(
    playerImage: Int, name: String, number: Int,
    goals: Int, assists: Int, playerRating: String,
    yellowCards: Int, redCards: Int, hasSubbed: Boolean,
    hasInvolved: Boolean, isCaptain: Boolean
) {
    ConstraintLayout(
        modifier = Modifier
    ) {
        val (
            image, nameNum, cap, goalIcon, goalsN, assistIcon,
            assistsN, yellowCardIcon, redCardIcon, rating, subIcon
        ) = createRefs()
        Card(
            modifier = Modifier
                .clip(CircleShape)
                .constrainAs(image) {
                    top.linkTo(parent.top, margin = 2.dp)
                    start.linkTo(parent.start, margin = 10.dp)
                    end.linkTo(parent.end, margin = 10.dp)
                },
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(4.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(width = 55.dp, height = 55.dp),
                painter = painterResource(id = playerImage),
                contentDescription = "image"
            )
        }
        if (isCaptain) {
            Text(
                modifier = Modifier
                    .constrainAs(cap) {
                        start.linkTo(parent.start, margin = 3.dp)
                        end.linkTo(image.start, margin = 3.dp)
                        top.linkTo(nameNum.top)
                        bottom.linkTo(nameNum.bottom)
                    }
                    .clip(RoundedCornerShape(2.dp))
                    .background(Color.White)
                    .size(width = 9.dp, height = 9.dp),
                text = "C",
                style = TextStyle(
                    color = Color.Black,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 8.sp
                ),
                textAlign = TextAlign.Center
            )
        }
        Text(
            modifier = Modifier
                .constrainAs(nameNum) {
                    top.linkTo(image.bottom, margin = 2.dp)
                    bottom.linkTo(parent.bottom, margin = 1.dp)
                    end.linkTo(image.end)
                    start.linkTo(image.start)
                }
                .width(50.dp),
            text = "$number. $name",
            style = TextStyle(
                color = Color.White,
                fontWeight = FontWeight.SemiBold,
                fontSize = 8.sp
            ),
            maxLines = 2
        )
        //Goals
        if (goals > 0) {
            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 0.1.dp, color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                    .constrainAs(goalIcon) {
                        end.linkTo(image.end, margin = 3.4.dp)
                        top.linkTo(image.top)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Image(
                    modifier = Modifier.size(width = 12.dp, height = 12.dp),
                    painter = painterResource(id = R.drawable.goal_lineups),
                    contentDescription = "Goal Icon"
                )
            }
            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .constrainAs(goalsN) {
                        start.linkTo(goalIcon.end, margin = 1.dp)
                        top.linkTo(goalIcon.top)
                        bottom.linkTo(goalIcon.bottom)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            )  {
                Text(
                    modifier = Modifier.padding(0.3.dp),
                    text = "x$goals",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 6.sp
                    )
                )
            }
        }
        //Assists
        if (assists > 0) {
            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .border(
                        width = 0.1.dp, color = MaterialTheme.colorScheme.primary,
                        shape = CircleShape
                    )
                    .constrainAs(assistIcon) {
                        end.linkTo(image.end, margin = 3.4.dp)
                        bottom.linkTo(image.bottom)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            ) {
                Image(
                    modifier = Modifier.size(width = 13.dp, height = 13.dp),
                    painter = painterResource(id = R.drawable.assist),
                    contentDescription = "Goal Icon"
                )
            }
            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .constrainAs(assistsN) {
                        start.linkTo(assistIcon.end, margin = 1.dp)
                        top.linkTo(assistIcon.top)
                        bottom.linkTo(assistIcon.bottom)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(2.dp)
            )  {
                Text(
                    modifier = Modifier.padding(0.3.dp),
                    text = "x$assists",
                    style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 6.sp
                    )
                )
            }
        }
        //Yellow Card
        if (yellowCards > 0) {
            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .constrainAs(yellowCardIcon) {
                        start.linkTo(image.start)
                        top.linkTo(image.top)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(1.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(1.5.dp)
                        .size(width = 10.dp, height = 10.dp),
                    painter = painterResource(id = R.drawable.y_card),
                    contentDescription = "Yellow Card"
                )
            }
        }
        //Red Card
        if (redCards > 0) {
            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .constrainAs(redCardIcon) {
                        start.linkTo(image.start)
                        bottom.linkTo(image.bottom)
                    },
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(1.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(1.5.dp)
                        .size(width = 10.dp, height = 10.dp),
                    painter = painterResource(id = R.drawable.r_card),
                    contentDescription = "Red Card"
                )
            }
        }
        //Rating
        if (hasInvolved) {
            Card(
                modifier = Modifier
                    .constrainAs(rating) {
                        end.linkTo(image.end, margin = (-7).dp)
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                    }
                    .clip(RoundedCornerShape(3.dp)),
                elevation = CardDefaults.cardElevation(4.dp),
                colors = CardDefaults.cardColors(
                    containerColor =
                    if (playerRating.toDouble() in 0.0..3.9)
                        Color.Red
                    else if (playerRating.toDouble() in 4.0..5.9)
                        LightRed
                    else if (playerRating.toDouble() in 6.0..6.9)
                        Orange
                    else if (playerRating.toDouble() in 7.0..7.9)
                        LightGreen
                    else if (playerRating.toDouble() in 8.0..10.0)
                        Color.Green
                    else Color.White
                )
            ) {
                Text(
                    modifier = Modifier.width(20.dp),
                    text = playerRating,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 8.sp
                    ),
                    textAlign = TextAlign.Center,
                    maxLines = 1
                )
            }
        }
        //Sub
        if (hasSubbed) {
            Card(
                modifier = Modifier
                    .clip(CircleShape)
                    .constrainAs(subIcon) {
                        start.linkTo(image.start, margin = (-6).dp)
                        top.linkTo(image.top)
                        bottom.linkTo(image.bottom)
                    }
                ,
                colors = CardDefaults.cardColors(
                    containerColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Image(
                    modifier = Modifier
                        .padding(0.5.dp)
                        .size(width = 10.dp, height = 10.dp),
                    painter = painterResource(id = R.drawable.sub_out),
                    contentDescription = "Sub"
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Prev() {
    PlayerOnPitchComponent(
        playerImage = R.drawable.player_f,
        name = "Player",
        number = 7,
        goals = 2,
        assists = 1,
        playerRating = "8.6",
        yellowCards = 1,
        redCards = 0,
        hasSubbed = true,
        hasInvolved = true,
        isCaptain = true
    )
}
