function initialiseGame() {
    initialisePlayers();
}

function initialisePlayers() {
    cpu1 = new Cpu('cpu1');
    cpu2 = new Cpu('cpu2');
    cpu3 = new Cpu('cpu3');
    player = new Player('p1');
}