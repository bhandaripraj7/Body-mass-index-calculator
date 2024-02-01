import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun Bmi() {
    var heightInput: String by remember { mutableStateOf(value = "") }
    var weightInput: String by remember { mutableStateOf(value = "") }
    val height = heightInput.toFloatOrNull() ?: 0.0f
    val weight= weightInput.toIntOrNull() ?:0
    val bmi= if (weight>0 && height>0) weight/(height*height)else 0.0
    Column(
        modifier = Modifier.padding(16.dp),

        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Body Mass Index",
            fontSize = 24.sp,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp)
        )

        OutlinedTextField(
            value = heightInput,
            onValueChange = { heightInput = it.replace(',', '.').take(5) }, // Handle comma as a decimal separator
            label = { Text("Height") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier= Modifier.fillMaxWidth()
        )


        OutlinedTextField(
            value = weightInput,
            onValueChange = { weightInput = it.replace(',', '.') }, // Limit the length of weight input
            label = { Text("Weight") },
            singleLine = true,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            modifier = Modifier.fillMaxWidth()
        )
        Text(text = "Body mass index is $bmi")

    }

}

@Preview
@Composable
fun BmiPreview() {
    Bmi()
}
