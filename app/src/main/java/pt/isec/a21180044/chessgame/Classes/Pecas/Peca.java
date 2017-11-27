package pt.isec.a21180044.chessgame.Classes.Pecas;

import pt.isec.a21180044.chessgame.Classes.Jogador;
import pt.isec.a21180044.chessgame.Enums.Cor;
import pt.isec.a21180044.chessgame.Enums.Tipo;

/**
 * Created by sergio on 23/11/2017.
 */

public class Peca {
    private int x, y;
    private Cor cor;
    private Tipo tipo;
    private Jogador jogador;

//    public Peca()
//    {
//        jogador=null;
//        this.tipo=Tipo.CASTELO;
//        this.x=-1;
//        this.y=-1;
//        this.cor=-1;
//    }

    public Peca(Jogador jogador, Tipo t, Cor cor, int x, int y)
    {
        this.jogador=jogador;
        this.tipo=t;
        this.x=x;
        this.y=y;
        this.cor=cor;
    }

    public Tipo getTipo() {return tipo; }

    public Cor getCor() {
        return cor;
    }

    @Override
    public String toString() {
        return "Peca{" +
                "x=" + x +
                ", y=" + y +
                ", cor=" + cor +
                ", tipo=" + tipo +
                ", jogador=" + jogador +
                '}';
    }
}
