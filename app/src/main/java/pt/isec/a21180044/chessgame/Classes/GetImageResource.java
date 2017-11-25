package pt.isec.a21180044.chessgame.Classes;

import pt.isec.a21180044.chessgame.Enums.Cor;
import pt.isec.a21180044.chessgame.Enums.Tipo;
import pt.isec.a21180044.chessgame.R;

/**
 * Created by tiagomaia on 24/11/2017.
 */

public final class GetImageResource {

    //setImageResource((int)R.drawable.nome);
    public static int ByTipoCor(Tipo tipo, Cor cor) {
        int r = -1;

        if (cor == Cor.BRANCO) {
            switch (tipo) {
                case BISPO:
                    r = R.drawable.branco_bispo;
                    break;
                case CAVALO:
                    r = R.drawable.branco_cavalo;
                    break;
                case REI:
                    r = R.drawable.branco_rei;
                    break;
                case PEAO:
                    r = R.drawable.branco_peao;
                    break;
                case CASTELO:
                    r = R.drawable.branco_castelo;
                    break;
                case RAINHA:
                    r = R.drawable.branco_rainha;
                    break;
            }
        } else { //então e preto
            switch (tipo) {
                case BISPO:
                    r = R.drawable.preto_bispo;
                    break;
                case CAVALO:
                    r = R.drawable.preto_cavalo;
                    break;
                case REI:
                    r = R.drawable.preto_rei;
                    break;
                case PEAO:
                    r = R.drawable.preto_peao;
                    break;
                case CASTELO:
                    r = R.drawable.preto_castelo;
                    break;
                case RAINHA:
                    r = R.drawable.preto_rainha;
                    break;
            }
        }
        return r;
    }
}
