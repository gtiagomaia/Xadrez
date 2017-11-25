package pt.isec.a21180044.chessgame.Enums;

/**
 * Created by sergio on 24/11/2017.
 */

public enum Tipo {
    CASTELO(1), CAVALO(2), BISPO(3), RAINHA(4), REI(5), PEAO(6)//, VAZIO
    ;
    private int index;
    Tipo(int i) {
        index = i;
    }
}
