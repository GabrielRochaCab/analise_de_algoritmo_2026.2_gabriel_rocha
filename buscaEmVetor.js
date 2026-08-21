const vetor = [];

for(let i=0; i < 10000000; i++){
    vetor.push(i); //coloca o valor de i na lista
}

//numero a ser encontrado no vetor
const numeroAlvo = 5000000;

const inicio = Date.now();
let numeroEncontrado = false;
for (let i=0; i < vetor.length; i++){
    if (vetor[i] == numeroAlvo){
        numeroEncontrado = true
        break;
    }
}

const tempo = Date.now() - inicio;

console.log(`encontrou: ${numeroEncontrado}`);
console.log(`tempo: ${tempo}ms`);