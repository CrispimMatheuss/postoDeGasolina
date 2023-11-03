public class Main {
    public static void main(String[] args) {
        BombaCombustivelModel bomba = new BombaCombustivelModel("Gasolina", 5.0, 100.0);
        BombaCombustivelController controller = new BombaCombustivelController(bomba);
        BombaCombustivelView view = new BombaCombustivelView(controller);
    }
}