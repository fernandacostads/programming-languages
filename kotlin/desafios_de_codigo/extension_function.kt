fun main() {
    val titulo = readLine() ?: ""
    val autor = readLine() ?: ""
    
    // Aqui usamos a Extension Function "generateSlug()" nas Strings de Entrada.
    val slugTitulo = titulo.generateSlug()
    val slugAutor = autor.generateSlug()
    
    println("Slug gerado para o livro:")
    println("${slugTitulo}_${slugAutor}")
}

fun String.generateSlug(): String {
    // Remove espaços e caracteres especiais, substituindo-os por traços
    return this
        .toLowerCase() // Converte para minúsculas
        .replace(Regex("[^a-zA-Z0-9]"), "-") // Substitui caracteres especiais por traços
        .replace(Regex("-+"), "-") // Remove múltiplos traços consecutivos
        .removePrefix("-") // Remove traços no início da string, se houver
        .removeSuffix("-") // Remove traços no final da string, se houver
}
