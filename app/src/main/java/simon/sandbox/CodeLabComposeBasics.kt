package simon.sandbox

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import simon.sandbox.ui.theme.SandboxTheme

class CodeLabComposeBasics : ComponentActivity() {
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
    content()
  }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android $it" }) {

  val counterState = remember { mutableStateOf(0) }

  Column(modifier = Modifier.fillMaxHeight()) {
    NameList(names, Modifier.weight(1f))
    Counter(
      count = counterState.value,
      updateCount = { counterState.value = it })
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!", modifier = Modifier.padding(24.dp))
}

@Composable
fun NameList(names: List<String>, modifier: Modifier = Modifier) {
  LazyColumn(modifier = modifier) {
    items(items = names) { name ->
      Greeting(name = name)
      Divider(color = Color.Black)
    }
  }
}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {

  Button(
    onClick = { updateCount(count + 1) },
    colors = ButtonDefaults.buttonColors(
      backgroundColor = if (count > 5) Color.Green else Color.White
    )
  ) {
    Text("I've been clicked $count times")
  }
}

@Preview
@Composable
fun CodeLabComposePreview() {
  MyApp {
    MyScreenContent()
  }
}