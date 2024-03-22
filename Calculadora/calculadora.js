var valor;
var resultado;

function botao(num) {
    valor = document.calc.visor.value += num;
}

function reseta() {
    document.calc.visor.value = '';
    valor = 0;
}

function calcula() {
    resultado = eval(valor);
    if (resultado == undefined) {
        resultado = 0;
    }
    document.calc.visor.value = resultado;
}