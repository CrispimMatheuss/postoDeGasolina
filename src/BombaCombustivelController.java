public class BombaCombustivelController {
    private BombaCombustivelModel bomba;

    public BombaCombustivelController(BombaCombustivelModel bomba) {
        this.bomba = bomba;
    }

    public double abastecerPorValor(double valor) {
        return bomba.abastecerPorValor(valor);
    }

    public double abastecerPorLitro(double litros) {
        return bomba.abastecerPorLitro(litros);
    }
}
