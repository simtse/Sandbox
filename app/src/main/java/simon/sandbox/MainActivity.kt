package simon.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import simon.sandbox.ui.theme.SandboxTheme

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      MyApp {
        MyScreenContent()
      }
    }
  }
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
  SandboxTheme {
    // A surface container using the 'background' color from the theme
    Surface(color = MaterialTheme.colors.background) {
      content()
    }
  }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "#$it" }) {
  var count by remember {
    mutableStateOf(0)
  }
  Column(modifier = Modifier.fillMaxHeight()) {
    NamesList(names = names, Modifier.weight(1F))
    Counter(count) { newCount -> count = newCount }
    if (count > 5) {
      Text(text = "I love the count")
    }
  }
}

@Composable
fun NamesList(names: List<String>, modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier) {
    items(items = names) {
      Greeting(name = it)
      Divider()
    }
  }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
  Button(onClick = { updateCount(count + 1) }) {
    Text(text = "I've been clicked $count times")
  }
}

@Composable
fun Greeting(name: String) {
  var isSelected by remember {
    mutableStateOf(false)
  }

  val targetColor by animateColorAsState(
    targetValue = if (isSelected) MaterialTheme.colors.primary else Color.Transparent,
    animationSpec = tween(durationMillis = 2000)
  )
  Surface(color = targetColor) {
    Text(
      text = "Hello $name!",
      modifier = Modifier
        .clickable { isSelected = !isSelected }
        .padding(16.dp)
    )
  }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  MyApp {
    MyScreenContent()
  }
}