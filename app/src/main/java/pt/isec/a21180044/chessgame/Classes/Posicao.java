package pt.isec.a21180044.chessgame.Classes;

import pt.isec.a21180044.chessgame.Classes.Pecas.Peca;
import pt.isec.a21180044.chessgame.Enums.Cor;

/**
 * Created by sergio on 23/11/2017.
 */

public class Posicao {
    private Peca peca;
    private int x, y;
    Cor cor;


//    public Posicao()
//    {
//        this.peca=null;
//        this.x=-1;
//        this.y=-1;
//    }

    public Posicao(int x, int y, Cor cor)
    {
        this.peca=null;
        this.x=x;
        this.y=y;
        this.cor=cor;
    }

    public Posicao(Peca peca, int x, int y, Cor cor) {
        this.peca = peca;
        this.x=x;
        this.y=y;
        this.cor=cor;
    }

    public Peca getPeca() {
        return peca;
    }

    public boolean temPeca(){
        return peca != null;
    }

    public Cor getCor() {
        return cor;
    }
}
