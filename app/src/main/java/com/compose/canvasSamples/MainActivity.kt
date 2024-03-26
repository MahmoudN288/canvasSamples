package com.compose.canvasSamples

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.canvasSamples.components.PlayerOnPitchComponent
import com.compose.canvasSamples.theme.DarkGreen
import com.compose.canvasSamples.theme.LightGreen
import com.compose.canvasSamples.theme.PrimeTODOTheme
import com.compose.canvasSamples.utils.BoxWithLayout

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PrimeTODOTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(
                        Modifier
                            .verticalScroll(rememberScrollState())
                    ) {
                        DrawFootballPitch()
                        DrawTennisPitch()
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun DrawFootballPitch() {
    Box(
        modifier = Modifier
            .size(width = 400.dp, height = 800.dp)
            .drawBehind {
                val lighterBlock = LightGreen
                val darkerBlock = DarkGreen
                val blocksNumber = 12
                for (i in 0..blocksNumber) {
                    val blockHeight = size.height / blocksNumber
                    val color =
                        if (i % 2 == 0)
                            lighterBlock else darkerBlock
                    drawRect(
                        color = color,
                        topLeft = Offset(
                            0f,
                            i * blockHeight
                        ),
                        size = Size(
                            size.width,
                            blockHeight
                        )
                    )
                }

                //Outside Pitch Container
                drawRect(
                    color = Color.White,
                    style = Stroke(width = 10f),
                    size = Size(
                        width = size.width,
                        height = size.height
                    ),
                    topLeft = Offset(x = 0f, y = 0f)
                )

                //Center Field
                drawLine(
                    color = Color.White,
                    start = Offset(x = 0f, y = center.y),
                    end = Offset(x = size.width, y = center.y),
                    strokeWidth = 10f
                )

                drawCircle(
                    color = Color.White,
                    radius = 10f,
                    center = Offset(size.width / 2, size.height / 2)
                )

                drawCircle(
                    color = Color.White,
                    radius = 200f,
                    center = Offset(size.width / 2, size.height / 2),
                    style = Stroke(10f)
                )

                //Corner Home Left
                drawArc(
                    color = Color.White,
                    startAngle = 0f,
                    sweepAngle = 90f,
                    useCenter = false,
                    size = Size(
                        size.width / 10,
                        size.height / 20
                    ),
                    topLeft = Offset(-50f, -50f),
                    style = Stroke(10f)
                )

                //Corner Home Right
                drawArc(
                    color = Color.White,
                    startAngle = 90f,
                    sweepAngle = 90f,
                    useCenter = false,
                    size = Size(
                        size.width / 10,
                        size.height / 20
                    ),
                    topLeft = Offset(size.width / 1.05f, -50f),
                    style = Stroke(10f)
                )

                //Corner Away Left
                drawArc(
                    color = Color.White,
                    startAngle = 270f,
                    sweepAngle = 90f,
                    useCenter = false,
                    size = Size(
                        size.width / 10,
                        size.height / 20
                    ),
                    topLeft = Offset(-50f, size.height - 50f),
                    style = Stroke(10f)
                )

                //Corner Away Right
                drawArc(
                    color = Color.White,
                    startAngle = 180f,
                    sweepAngle = 90f,
                    useCenter = false,
                    size = Size(
                        size.width / 10,
                        size.height / 20
                    ),
                    topLeft = Offset(size.width / 1.05f, size.height - 50f),
                    style = Stroke(10f)
                )

                drawRect(
                    color = Color.White,
                    topLeft = Offset(
                        x = size.width.div(2) - 100f,
                        y = 0f
                    ),
                    size = Size(200f, 100f),
                    style = Stroke(10f)
                )

                drawRect(
                    color = Color.White,
                    topLeft = Offset(
                        x = size.width.div(2) - 250f,
                        y = 0f
                    ),
                    size = Size(500f, 250f),
                    style = Stroke(10f)
                )

                drawRect(
                    color = Color.White,
                    topLeft = Offset(
                        size.width.div(2) - 100f,
                        size.height - 100f
                    ), // Adjusted to ensure positive size
                    size = Size(200f, 100f),
                    style = Stroke(10f)
                )

                drawRect(
                    color = Color.White,
                    topLeft = Offset(
                        size.width.div(2) - 250f,
                        size.height - 250f
                    ), // Adjusted to ensure positive size
                    size = Size(500f, 250f),
                    style = Stroke(10f)
                )
                drawCircle(
                    color = Color.White,
                    radius = 10f,
                    center = Offset(size.width.div(2), 200f)
                )

                drawCircle(
                    color = Color.White,
                    radius = 10f,
                    center = Offset(size.width.div(2), size.height - 200f)
                )

                drawArc(
                    color = Color.White,
                    startAngle = 0f,
                    sweepAngle = 180f,
                    useCenter = false,
                    size = Size(200f, 100f),
                    topLeft = Offset(
                        size.width
                            .div(2) - 100f, 200f
                    ),
                    style = Stroke(3.dp.toPx())
                )

                drawArc(
                    color = Color.White,
                    startAngle = 180f,
                    sweepAngle = 180f,
                    useCenter = false,
                    size = Size(200f, 100f),
                    topLeft = Offset(
                        x = size.width.div(2) - 100f,
                        y = size.height.minus(300f)
                    ),
                    style = Stroke(3.dp.toPx())
                )
            }
    ) {
        BoxWithLayout {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
                    .fillMaxHeight()
                    .padding(vertical = 25.dp)
            ) {
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 1.dp)
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        PlayerOnPitchComponent(
                            playerImage = R.drawable.player_f,
                            name = "GK Home",
                            number = 1,
                            goals = 0,
                            assists = 0,
                            playerRating = "4.5",
                            yellowCards = 1,
                            redCards = 0,
                            hasSubbed = false,
                            hasInvolved = true,
                            isCaptain = false
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 1.dp)
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        for (i in 1..4) {
                            PlayerOnPitchComponent(
                                playerImage = R.drawable.player_f,
                                name = "Def Home",
                                number = 3,
                                goals = 1,
                                assists = 2,
                                playerRating = "6.5",
                                yellowCards = 1,
                                redCards = 0,
                                hasSubbed = false,
                                hasInvolved = true,
                                isCaptain = false
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 1.dp)
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        for (i in 1..3) {
                            PlayerOnPitchComponent(
                                playerImage = R.drawable.player_f,
                                name = "Mid Home",
                                number = 8,
                                goals = 2,
                                assists = 2,
                                playerRating = "7.5",
                                yellowCards = 1,
                                redCards = 0,
                                hasSubbed = true,
                                hasInvolved = true,
                                isCaptain = false
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 1.dp)
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        for (i in 1..3) {
                            PlayerOnPitchComponent(
                                playerImage = R.drawable.player_f,
                                name = "FW Home",
                                number = 10,
                                goals = 3,
                                assists = 2,
                                playerRating = "9.5",
                                yellowCards = 1,
                                redCards = 0,
                                hasSubbed = true,
                                hasInvolved = true,
                                isCaptain = true
                            )
                        }
                    }
                }
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceBetween,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        for (i in 1..2) {
                            PlayerOnPitchComponent(
                                playerImage = R.drawable.player_f,
                                name = "FW Away",
                                number = 7,
                                goals = 2,
                                assists = 1,
                                playerRating = "8.6",
                                yellowCards = 1,
                                redCards = 0,
                                hasSubbed = true,
                                hasInvolved = true,
                                isCaptain = false
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        for (i in 1..4) {
                            PlayerOnPitchComponent(
                                playerImage = R.drawable.player_f,
                                name = "Mid Away",
                                number = 5,
                                goals = 0,
                                assists = 1,
                                playerRating = "7.4",
                                yellowCards = 1,
                                redCards = 0,
                                hasSubbed = true,
                                hasInvolved = true,
                                isCaptain = false
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        for (i in 1..4) {
                            PlayerOnPitchComponent(
                                playerImage = R.drawable.player_f,
                                name = "Def Away",
                                number = 4,
                                goals = 1,
                                assists = 0,
                                playerRating = "6.1",
                                yellowCards = 1,
                                redCards = 0,
                                hasSubbed = false,
                                hasInvolved = true,
                                isCaptain = true
                            )
                        }
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        PlayerOnPitchComponent(
                            playerImage = R.drawable.player_f,
                            name = "GK Away",
                            number = 13,
                            goals = 0,
                            assists = 0,
                            playerRating = "5.1",
                            yellowCards = 0,
                            redCards = 1,
                            hasSubbed = false,
                            hasInvolved = true,
                            isCaptain = false
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DrawGoogleIcon() {
    Canvas(
        modifier = Modifier
            .size(100.dp)
            .padding(20.dp)
    ) {
        val width = this.size.width
        val height = this.size.height

        val path = Path()
        path.moveTo(width / 2, height / 2)
        path.lineTo(width + 5, height * .05f)
        path.lineTo(width + 20, height * 0.45f)


        clipPath(path = path, clipOp = ClipOp.Difference) {
            drawCircle(
                color = Color.Transparent,
                radius = 100f,
                style = Stroke(40f, cap = StrokeCap.Round)
            )
            drawPath(path = path, color = Color.Transparent)
        }

        drawRect(
            color = Color(0xFF4384f3),
            size = Size(width * .57f, 20f),
            topLeft = Offset(width * .55f, height * .45f)
        )

        drawRect(
            color = Color(0xFF4384f3),
            size = Size(width * .45f, 20f),
            topLeft = Offset(width * .55f, height * .54f)
        )

        drawArc(
            color = Color(0xFF4384f3),
            startAngle = 0f,
            sweepAngle = 45f,
            useCenter = false,
            style = Stroke(width = 40f)
        )
        drawArc(
            color = Color(0xFF33a852),
            startAngle = 45f,
            sweepAngle = 135f,
            useCenter = false,
            style = Stroke(width = 40f)
        )
        drawArc(
            color = Color(0xFFfabd03),
            startAngle = 155f,
            sweepAngle = 80f,
            useCenter = false,
            style = Stroke(width = 40f)
        )

        drawArc(
            color = Color(0xFFeb4435),
            startAngle = 200f,
            sweepAngle = 120f,
            useCenter = false,
            style = Stroke(width = 40f)
        )
    }
}

@Composable
fun DrawTennisPitch() {
    Box(modifier = Modifier
        .size(width = 400.dp, height = 800.dp)
        .drawBehind {
            drawRect(
                color = Color(0xFF4384f3),
                topLeft = Offset(x = 0f, y = 0f),
                size = Size(
                    width = size.width,
                    height = size.height
                )
            )
            drawRect(
                color = Color.White,
                style = Stroke(width = 25f)
            )
            drawRect(
                color = Color.White,
                style = Stroke(width = 15f),
                topLeft = Offset(x = 110f, y = 0f),
                size = Size(
                    width = size.width / 1.35f,
                    height = size.height
                )
            )
            //Web
            drawLine(
                color = Color.White,
                start = Offset(x = 0f, y = center.y),
                end = Offset(x = size.width, y = center.y),
                strokeWidth = 10f
            )
            drawRoundRect(
                color = Color.DarkGray,
                size = Size(width = 20f, height = 40f),
                cornerRadius = CornerRadius(15f, 15f),
                topLeft = Offset(x = 0f, y = center.y / 1.02f)
            )
            drawRoundRect(
                color = Color.DarkGray,
                size = Size(width = 20f, height = 40f),
                cornerRadius = CornerRadius(15f, 15f),
                topLeft = Offset(x = size.width / 1.03f, y = center.y / 1.02f)
            )
            //Inner Lines
            //Top
            drawLine(
                color = Color.White,
                start = Offset(x = size.width / 10, y = center.y / 2),
                end = Offset(x = size.width / 1.2f, y = center.y / 2),
                strokeWidth = 10f
            )
            //Bottom
            drawLine(
                color = Color.White,
                start = Offset(x = size.width / 10, y = center.y * 1.5f),
                end = Offset(x = size.width / 1.2f, y = center.y * 1.5f),
                strokeWidth = 10f
            )
            //Vertical
            drawLine(
                color = Color.White,
                start = Offset(x = center.x, y = center.y / 2),
                end = Offset(x = center.x, y = center.y * 1.5f),
                strokeWidth = 10f
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(10.dp)
                .fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
            DrawAndroidLogo()
        }
    }
}

@Composable
fun DrawAndroidLogo() {
    Canvas(modifier = Modifier.size(150.dp)) {
        drawArc(
            color = Color(0xFF3DDC84),
            startAngle = 180f,
            sweepAngle = 180f,
            useCenter = false,
            size = Size(
                width = size.width / 2,
                height = size.height / 2
            ),
            topLeft = Offset(
                x = center.x / 2.2f, y = center.y / 2.2f
            )
        )
        drawCircle(
            color = Color.White,
            radius = 12f,
            center = Offset(
                x = center.x / 1.4f,
                y = center.y / 1.4f
            )
        )
        drawCircle(
            color = Color.White,
            radius = 12f,
            center = Offset(
                x = center.x * 1.2f,
                y = center.y / 1.4f
            )
        )
        drawLine(
            color = Color(0xFF3DDC84),
            start = Offset(
                x = center.x / 1.3f, y = center.y / 2.1f
            ),
            end = Offset(
                x = center.x / 1.5f, y = center.y / 2.8f
            ),
            strokeWidth = 10f,
            cap = StrokeCap.Round
        )
        drawLine(
            color = Color(0xFF3DDC84),
            start = Offset(
                x = center.x * 1.14f, y = center.y / 2.1f
            ),
            end = Offset(
                x = center.x * 1.23f, y = center.y / 2.8f
            ),
            strokeWidth = 10f,
            cap = StrokeCap.Round
        )
        //Rectangle
        val cornerRadius = CornerRadius(10f, 50f)
        val path = Path().apply {
            addRoundRect(
                RoundRect(
                    rect = Rect(
                        offset = Offset(
                            center.x / 2.2f, center.y
                        ),
                        size = Size(
                            size.width / 2,
                            size.height / 3
                        ),
                    ),
                    bottomLeft = cornerRadius,
                    bottomRight = cornerRadius
                )
            )
        }
        drawPath(path, color = Color(0xFF3DDC84))
        //Right Leg
        val cornerRadiusRightLeg = CornerRadius(10f, 10f)
        val pathRightLeg = Path().apply {
            addRoundRect(
                RoundRect(
                    rect = Rect(
                        offset = Offset(x = center.x * 1.1f, y = center.y * 1.7f),
                        size = Size(
                            width = size.width / 10,
                            height = size.height / 7.5f
                        ),
                    ),
                    bottomLeft = cornerRadiusRightLeg,
                    bottomRight = cornerRadiusRightLeg
                )
            )
        }
        drawPath(pathRightLeg, color = Color(0xFF3DDC84))
        //Left Leg
        val cornerRadiusLeftLeg = CornerRadius(10f, 10f)
        val pathLeftLeg = Path().apply {
            addRoundRect(
                RoundRect(
                    rect = Rect(
                        offset = Offset(x = center.x / 1.7f, y = center.y * 1.7f),
                        size = Size(
                            width = size.width / 10,
                            height = size.height / 7.5f
                        ),
                    ),
                    bottomLeft = cornerRadiusLeftLeg,
                    bottomRight = cornerRadiusLeftLeg
                )
            )
        }
        drawPath(pathLeftLeg, color = Color(0xFF3DDC84))
        //Right Hand
        drawRoundRect(
            color = Color(0xFF3DDC84),
            size = Size(
                width = size.width / 8,
                height = size.height / 3.5f
            ),
            cornerRadius = CornerRadius(25f, 25f),
            topLeft = Offset(
                x = center.x * 1.5f, y = center.y / 1.03f
            )
        )
        //Left Hand
        drawRoundRect(
            color = Color(0xFF3DDC84),
            size = Size(
                width = size.width / 8,
                height = size.height / 3.5f
            ),
            cornerRadius = CornerRadius(25f, 25f),
            topLeft = Offset(
                x = center.x / 6.2f, y = center.y / 1.03f
            )
        )
    }
}

@Composable
fun DrawWhatsapp() {
    Canvas(
        modifier = Modifier
            .padding(10.dp)
            .size(150.dp)
    ) {
        drawRoundRect(
            color = Color(0xFF25D366),
            cornerRadius = CornerRadius(50f, 50f)
        )
        drawArc(
            color = Color.White,
            startAngle = 140f,
            sweepAngle = 350f,
            useCenter = false,
            style = Stroke(width = 20f),
            topLeft = Offset(x = center.x / 6, y = center.y / 6),
            size = Size(width = size.width / 1.2f, height = size.height / 1.2f)
        )
        /*drawRoundRect(
            color = Color.White,
            size = Size(
                width = size.width / 6f,
                height = size.height / 7
            ),
            topLeft = Offset(
                x = center.x / 1.85f,
                y = center.y / 1.8f
            ),
            cornerRadius = CornerRadius(30f, 40f)
        )*/
        drawArc(
            color = Color.White,
            topLeft = Offset(
                x = center.x / 1.65f,
                y = center.y / 50
            ),
            size = Size(
                width = size.width / 2,
                height = size.height / 1.5f
            ),
            startAngle = 175f,
            sweepAngle = -105f,
            useCenter = false,
            style = Stroke(width = 30f)
        )
        /*drawRoundRect(
            color = Color.White,
            size = Size(
                width = size.width / 5.5f,
                height = size.height / 8.5f
            ),
            topLeft = Offset(
                x = center.x * 1.07f,
                y = center.y * 1.2f
            ),
            cornerRadius = CornerRadius(40f, 60f)
        )*/
        val pathDown = Path()
        pathDown.moveTo(x = center.x * 1.01f, y = center.y * 1.28f)
        pathDown.lineTo(x = center.x * 1.15f, y = center.y * 1.18f)
        pathDown.lineTo(x = center.x * 1.35f, y = center.y * 1.24f)
        pathDown.lineTo(x = center.x * 1.32f, y = center.y * 1.36f)
        drawPath(
            path = pathDown,
            color = Color.White
        )
        val pathTri = Path()
        pathTri.moveTo(x = center.x / 1.9f, y = center.y * 1.65f)
        pathTri.lineTo(x = center.x / 4.5f, y = center.y * 1.8f)
        pathTri.lineTo(x = center.x / 3f, y = center.y * 1.5f)
        drawPath(
            style = Stroke(width = 20f),
            path = pathTri,
            color = Color.White
        )
        val pathTop = Path()
        pathTop.moveTo(x = center.x / 1.9f, y = center.y / 1.35f)
        pathTop.lineTo(x = center.x / 1.7f, y = center.y / 1.8f)
        pathTop.lineTo(x = center.x / 1.4f, y = center.y / 2.1f)
        pathTop.lineTo(x = center.x / 1.32f, y = center.y / 2f)
        pathTop.lineTo(x = center.x / 1.2f, y = center.y / 1.7f)
        pathTop.lineTo(x = center.x / 1.15f, y = center.y / 1.25f)
        pathTop.lineTo(x = center.x / 1.5f, y = center.y / 1.1f)
        drawPath(
            path = pathTop,
            color = Color.White
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DrawWhatsappPreview() {
    DrawWhatsapp()
}

@Preview(showBackground = true)
@Composable
fun DrawAndroidLogoPreview() {
    DrawAndroidLogo()
}

@Preview(showBackground = false)
@Composable
fun DrawTennisPitchPreview() {
    DrawTennisPitch()
}

@Preview(showBackground = true)
@Composable
fun DrawGoogleIconPreview() {
    DrawGoogleIcon()
}

@Preview(showBackground = true)
@Composable
fun DrawPitchPreview() {
    DrawFootballPitch()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    PrimeTODOTheme {
        Greeting("Android")
    }
}