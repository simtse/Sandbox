package simon.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.FirstBaseline
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import simon.sandbox.ui.theme.SandboxTheme

class CodeLabComposeCustomLayouts : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApp {
        BaseLineTopSample()
      }
    }
  }
}

@Composable
fun MyOwnColumn(
  modifier : Modifier = Modifier,
  content: @Composable () ->Unit
) {
  Layout(
    modifier = modifier,
    content = content,
  ) { measurables, constraints ->
    // Don't constrain child views further, measure them with given constraints
    // List of measured children
    val placeables = measurables.map { measurable ->
      measurable.measure(constraints)
    }

    // Track the y co-ord we have placed children up to
    var yPosition = 0

    // Set the size of the layout as big as it can
    layout(constraints.maxWidth, constraints.maxHeight) {
      // Place children in the parent layout
      placeables.forEach { placeable ->
        placeable.placeRelative(x = 0, y = yPosition)
        yPosition += placeable.height
      }
    }
  }
}

@Composable
fun BaseLineTopSample() {
  MyOwnColumn(Modifier.padding(8.dp)) {
    Text("Basic text box", Modifier.background(Color.Green))
    Text(
      "Padding top of baseline",
      Modifier
        .background(Color.Yellow)
        .firstBaselineToTop(32.dp)
    )
    Text("MyOwnColumn")
    Text("places items")
    Text("vertically.")
    Text("We've done it by hand!")
  }
}

fun Modifier.firstBaselineToTop(
  firstBaselineToTop: Dp
) = this.then(
  layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    // Check the composable has a first baseline
    val firstBaseLine = placeable[FirstBaseline]
    check(firstBaseLine != AlignmentLine.Unspecified)

    // Height of the composable with padding - first baseline
    val placeableY = firstBaselineToTop.roundToPx() - firstBaseLine
    val height = placeable.height + placeableY
    layout(placeable.width, height) {
      // where the composable gets placed
      placeable.placeRelative(0, placeableY)
    }
  }
)


@Preview
@Composable
fun CustomLayoutsPreview() {
  SandboxTheme {
    BaseLineTopSample()
  }
}