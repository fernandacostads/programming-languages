class OldCurrencyConverter {
    fun convertUSDtoGBP(amount: Double): Double {
        return amount * 0.80
    }
}

class CurrencyAdapter(private val oldConverter: OldCurrencyConverter) {
    fun convertUSDtoEUR(amount: Double): Double {
        // Converter de USD para GBP usando a classe antiga
        val gbpAmount = oldConverter.convertUSDtoGBP(amount)

        // Aplicar a taxa de conversão de GBP para EUR
        val gbpToEurRate = 1.0625
        return gbpAmount * gbpToEurRate
    }
}

fun main() {
    val input = readLine()?.toDoubleOrNull() ?: return
    val oldConverter = OldCurrencyConverter()
    val adapter = CurrencyAdapter(oldConverter)

    val amountInEUR = adapter.convertUSDtoEUR(input)

    println("USD: $input")
    println("EUR: $amountInEUR")
}
