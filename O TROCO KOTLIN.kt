import kotlin.system.exitProcess

var saldo = 100.5 // Float
val senha : Int = 3589
var nomeUsuario: String? = ""


fun main() {
    inicio()
}
//Ao acessar o sistema, pergunte o nome do usuário e diga "Olá {Nome}
// é um prazer ter você por aqui!"

fun inicio() {

    println("Como podemos te chamar? ")
     nomeUsuario = readLine()

//Na função "inicio", utilize escolha/caso (switch/case) ou when (quando),
// se possível, para validar a opção escolhida pelo usuário.

    println("${nomeUsuario}, por favor escolha uma opção: ")

    println("1 - Ver saldo")
    println("2 - Ver Extrato")
    println("3 - Fazer saque")
    println("4 - Fazer Depósito")
    println("5 - Fazer transferência")
    println("6 - Sair()")

    val escolha = readLine()?.toIntOrNull()
//Saldo, Extrato, Saque, Depósito, Transferência e Sair.
    when (escolha)
    {
        1 -> verSaldo()
        2 -> verExtrato()
        3 -> fazerSaque()
        4 ->fazerDeposito()
        5 ->transferencia()
        6->sair()

        else -> erro()
    }
}

fun verSaldo() {
    println("Para ver o saldo digite a senha do sistema: ")
    var resposta = readln().toInt()
    while (resposta != senha)
    {
        println("Senha incorreta.:Tente novamente")
        resposta = readln().toInt()
    }

    println("Seu saldo atual é: $saldo")
    inicio()
}

fun fazerDeposito() //Caso o usuário informe um valor para depósito igual ou menor que zero, não deixe a operação ocorrer.
// Exiba uma mensagem de "Operação não autorizada".
{
    println("Para ver o saldo digite a senha do sistema: ")
    var resposta = readln().toInt()
    while (resposta != senha)
    {
        println("Senha incorreta.Tente novamente: ")
        resposta = readln().toInt()
    }

    print("Qual o valor para depósito? ")

    var deposito = readLine()?.toFloatOrNull()

    // Usando readln e Elvis operator -> Operador de coalescência nula
    // val deposito = readln().toFloatOrNull() ?: 0.0
    while (deposito == null || deposito <= 0) {
        if (deposito == null) {
            println("Por favor, informe um número válido.")
        } else if (deposito <= 0) {
            println("Operação não autorizada. Informe um número válido")
        }
        deposito = readLine()?.toFloatOrNull()
    }
        if (deposito > 0)
        {
            saldo = saldo + deposito
            verSaldo()
        }

}

//Sempre que o usuário for sacar dinheiro, o valor restante não pode ser negativo,
// ou seja, caso o usuário tente sacar mais do que tem em saldo, a ação não deve ocorrer.
// Exiba uma mensagem de "Operação não autorizada".

    fun fazerSaque() //Sempre que o usuário for sacar dinheiro, o valor a ser sacado não pode ser igual ou menor que zero.
// Exiba uma mensagem de "Operação não autorizada".
    {
        println("Para ver o saldo digite a senha do sistema: ")
        var resposta = readln().toInt()
        while (resposta != senha)
        {
            println("Senha incorreta.Tente novamente: ")
            resposta = readln().toInt()
        }

        print("Qual o valor para saque? ")
        var saque = readLine()?.toFloatOrNull()

        while (saque == null || saque > saldo || saque <= 0) {
            if (saque == null) {
                println("Informe um valor válido")

            } else if (saque > saldo) {
                print("Operação não autorizada\nSaldo insuficiente.\n")

            } else {
                println("Valor Inválido. Digite um número positivo maior que zero.")

            }
            println("Informe outro valor: ")
            saque = readLine()?.toFloatOrNull()
        }
        saldo = saldo - saque
        verSaldo()
    }

    fun verExtrato() {
        println("Para ver o saldo digite a senha do sistema: ")
        var resposta = readln().toInt()
        while (resposta != senha)
        {
            println("Senha incorreta.:Tente novamente")
            resposta = readln().toInt()
        }
        println("==============================================")
        println("                BANCO KOTLIN S.A.             ")
        println("==============================================")
        println(" AGÊNCIA: 0001-9           CONTA: 12345-6     ")
        println(" CLIENTE:                                     ")
        println("==============================================")
        println("               EXTRATO BANCÁRIO               ")
        println("----------------------------------------------")
        println(" DATA       DESCRIÇÃO                 VALOR   ")
        println("----------------------------------------------")
        println(" 31/08      SALDO ANTERIOR            300,00  ")
        println(" 28/08      PIX RECEBIDO               50,00+ ")
        println(" 27/08      COMPRA CARTÃO DÉBITO       49,50- ")
        println(" 05/08     PAGAMENTO BOLETO          200,00- ")
        println("----------------------------------------------")
        println(" SALDO ATUAL DISPONÍVEL:        R$   100,50   ")
        println(" LIMITE CHEQUE ESPECIAL:        R$   500,00   ")
        println("----------------------------------------------")
        println("     Extrato para simples conferência.        ")
        println("==============================================")
        verSaldo()
    }

    fun transferencia()
    {
        println("Para ver o saldo digite a senha do sistema: ")
        var resposta = readln().toInt()
        while (resposta != senha)
        {
            println("Senha incorreta.:Tente novamente")
            resposta = readln().toInt()
        }

        print("Informe o número da conta a receber o pagamento para fazer a transferência:")
        var numero_conta = readln().toDouble()

        println("Digite o valor a ser transferido: ")
        var transf = readln().toDouble()
        while (transf == null || transf > saldo || transf <= 0) {
            if (transf == null) {
                println("Digite um valor válido!")
            } else if (transf > saldo) {
                println("Saldo insuficiente.Operação inválida")
            } else {
                println("Operação não autorizada.Digite um número positivo maior que zero.")
            }

            println("Informe outro valor: ")
            transf = readln().toDouble()
        }


        saldo = saldo - transf
        verSaldo()
    }

    fun erro()
    {
        println("Essa opção não existe. Escolha um número entre 1 e 6 :")

        println("1 - Ver saldo")
        println("2 - Ver Extrato")
        println("3 - Fazer saque")
        println("4 - Fazer Depósito")
        println("5 - Fazer transferência")
        println("6 - Sair()")
        val tentarOutro = readln().toInt()
        when (tentarOutro)
        {
            1 -> verSaldo()
            2 -> verExtrato()
            3 -> fazerSaque()
            4 -> fazerDeposito()
            5 -> transferencia()
            6 -> sair()
        }
    }

    fun sair()
    {
        print("Você deseja sair? (S/N)")
        // Usando readln e Elvis operator -> Operador de coalescência nula
        val confirma = readln().uppercase()
        // Locale -> Localização do usuário para converter para maiúsculo
        //val confirma = readLine()?.uppercase(Locale.getDefault())

        if (confirma == "S")
        {
            println("Até mais $nomeUsuario! Foi um ter você conosco")
            exitProcess(0)
        }
        when (confirma)
        {
            "N" -> inicio() // Volta para o início
            else ->
                {
                println("Inválido, saindo do programa")
                sair()
            }
        }
    }
