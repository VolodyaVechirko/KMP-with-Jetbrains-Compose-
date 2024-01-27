package ui.other

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.addPathNodes
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

/**
 * Simple xml vector path parser. If can't use painterResource(resource).
 */
private fun pathToImageVector(
    path: String,
): ImageVector = vectorBuilder()
    .addPath(path)
    .build()

private fun vectorBuilder(
    viewportWidth: Float = 24f,
    viewportHeight: Float = 24f,
    defaultWidth: Dp = 24.dp,
    defaultHeight: Dp = 24.dp,
) = ImageVector.Builder(
    defaultWidth = defaultWidth,
    defaultHeight = defaultHeight,
    viewportWidth = viewportWidth,
    viewportHeight = viewportHeight,
)

private fun ImageVector.Builder.addPath(
    path: String,
    fillColor: Color = Color.Black,
    strokeColor: Color = Color.Black,
) = addPath(
    pathData = addPathNodes(path),
    fill = SolidColor(fillColor),
    stroke = SolidColor(strokeColor),
)

val AccountIcon: ImageVector
    get() = vectorBuilder()
        .addPath("M19,3H5C3.9,3 3,3.9 3,5v14c0,1.1 0.9,2 2,2h14c1.1,0 2,-0.9 2,-2V5C21,3.9 20.1,3 19,3zM12,6c1.93,0 3.5,1.57 3.5,3.5c0,1.93 -1.57,3.5 -3.5,3.5s-3.5,-1.57 -3.5,-3.5C8.5,7.57 10.07,6 12,6zM19,19H5v-0.23c0,-0.62 0.28,-1.2 0.76,-1.58C7.47,15.82 9.64,15 12,15s4.53,0.82 6.24,2.19c0.48,0.38 0.76,0.97 0.76,1.58V19z")
        .build()

val AutoMosaicIcon: ImageVector
    get() = vectorBuilder()
        .addPath("M3,5v14c0,1.1 0.89,2 2,2h6V3H5C3.89,3 3,3.9 3,5zM19,3h-6v8h8V5C21,3.9 20.1,3 19,3zM13,21h6c1.1,0 2,-0.9 2,-2v-6h-8V21z")
        .build()


val ComplexIcon: ImageVector
    get() = vectorBuilder()
        .addPath("M3,8c0,0.55 0.45,1 1,1s1,-0.45 1,-1V6h2c0.55,0 1,-0.45 1,-1s-0.45,-1 -1,-1H5V2c0,-0.55 -0.45,-1 -1,-1s-1,0.45 -1,1v2H1c-0.55,0 -1,0.45 -1,1s0.45,1 1,1h2v2z")
        .addPath("M13,14m-3,0a3,3 0,1 1,6 0a3,3 0,1 1,-6 0")
        .addPath("M21,6h-3.17l-1.24,-1.35c-0.37,-0.41 -0.91,-0.65 -1.47,-0.65h-6.4c0.17,0.3 0.28,0.63 0.28,1 0,1.1 -0.9,2 -2,2L6,7v1c0,1.1 -0.9,2 -2,2 -0.37,0 -0.7,-0.11 -1,-0.28L3,20c0,1.1 0.9,2 2,2h16c1.1,0 2,-0.9 2,-2L23,8c0,-1.1 -0.9,-2 -2,-2zM13,19c-2.76,0 -5,-2.24 -5,-5s2.24,-5 5,-5 5,2.24 5,5 -2.24,5 -5,5z")
        .build()
