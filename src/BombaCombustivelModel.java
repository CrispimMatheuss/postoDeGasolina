public class BombaCombustivelModel {
    private String tipoCombustivel;
    private double valorLitro;
    private double qtdCombustivel;

    public BombaCombustivelModel(String tipoCombustivel, double valorLitro, double qtdCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
        this.valorLitro = valorLitro;
        this.qtdCombustivel = qtdCombustivel;
    }

    public double abastecerPorValor(double valor) {
        if (valor <= 0) {
            return 0.0;
        }

        double litrosAbastecidos = valor / valorLitro;
        if (litrosAbastecidos > qtdCombustivel) {
            litrosAbastecidos = qtdCombustivel;
        }

        qtdCombustivel -= litrosAbastecidos;

        return litrosAbastecidos;
    }

    public double abastecerPorLitro(double litros) {
        if (litros <= 0) {
            return 0.0;
        }

        if (litros > qtdCombustivel) {
            litros = qtdCombustivel;
        }

        double valorAbastecido = litros * valorLitro;
        qtdCombustivel -= litros;

        return valorAbastecido;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public double getValorLitro() {
        return valorLitro;
    }

    public double getQtdCombustivel() {
        return qtdCombustivel;
    }
}
