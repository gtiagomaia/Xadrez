package pt.isec.a21180044.chessgame.Classes;

import android.widget.ImageView;

import pt.isec.a21180044.chessgame.Enums.*;
import pt.isec.a21180044.chessgame.R;


/**
 * Created by sergio on 23/11/2017.
 */

public class Tabuleiro {
    public final static int NLIN = 8;
    public final static int NCOL = 8;
//    public enum Tipo{
//        CASTELO, CAVALO, BISPO, RAINHA, REI, PEAO, VAZIO
//    }

    private Posicao [][] posicoes;

    public Tabuleiro()
    {
        posicoes = new Posicao [8][8];
        distribuiPecas();

    }


    public void distribuiPecas()
    {

        //PREENCHER TOPO DO TABULEIRO
        posicoes[0][0] = new Posicao(new Peca(new Jogador(), Tipo.CASTELO, Cor.BRANCO, 0, 0), 0, 0, Cor.PRETO);//torre
        posicoes[0][7] = new Posicao(new Peca(new Jogador(), Tipo.CASTELO, Cor.BRANCO, 0, 7), 0, 7, Cor.BRANCO);//torre
        posicoes[0][1] = new Posicao(new Peca(new Jogador(), Tipo.CAVALO, Cor.BRANCO, 0, 1), 0, 1, Cor.BRANCO);//cavalo
        posicoes[0][6] = new Posicao(new Peca(new Jogador(), Tipo.CAVALO, Cor.BRANCO, 0, 6), 0, 6, Cor.PRETO);//cavalo
        posicoes[0][2] = new Posicao(new Peca(new Jogador(), Tipo.BISPO, Cor.BRANCO, 0, 2), 0, 2, Cor.PRETO);//bispo
        posicoes[0][5] = new Posicao(new Peca(new Jogador(), Tipo.BISPO, Cor.BRANCO, 0, 5), 0, 5, Cor.BRANCO);//bispo
        posicoes[0][3] = new Posicao(new Peca(new Jogador(), Tipo.RAINHA, Cor.BRANCO, 0, 3), 0, 3, Cor.BRANCO);//rainha
        posicoes[0][4] = new Posicao(new Peca(new Jogador(), Tipo.REI, Cor.BRANCO, 0, 4), 0, 4, Cor.PRETO);//rei
        for(int i=1, j=0; j<NCOL; j++)
        {
            if(j % 2 == 0)
                posicoes[i][j]=new Posicao(new Peca(new Jogador(), Tipo.PEAO, Cor.BRANCO, i, j), i, j, Cor.BRANCO);//peoes
            else
                posicoes[i][j]=new Posicao(new Peca(new Jogador(), Tipo.PEAO, Cor.BRANCO, i, j), i, j, Cor.PRETO);//peoes
        }
        //PREENCHER CENTRO DO TABULEIRO COM POSICOES VAZIAS
        for(int i=2; i<=5; i++)
        {
            for(int j=0; j<NCOL; j++)
            {
                if(i % 2 == 0) {
                    if (j % 2 == 0)
                        posicoes[i][j] = new Posicao(i, j, Cor.PRETO); //posicao vazia
                    else
                        posicoes[i][j] = new Posicao(i, j, Cor.BRANCO); //posicao vazia
                }
                else
                {
                    if (j % 2 == 0)
                        posicoes[i][j] = new Posicao(i, j, Cor.BRANCO); //posicao vazia
                    else
                        posicoes[i][j] = new Posicao(i, j, Cor.PRETO); //posicao vazia
                }
            }
        }

        //PREENCHER BASE DO TABULEIRO
        posicoes[7][0] = new Posicao(new Peca(new Jogador(), Tipo.CASTELO, Cor.PRETO, 7, 0), 7, 0, Cor.BRANCO);//torre
        posicoes[7][7] = new Posicao(new Peca(new Jogador(), Tipo.CASTELO, Cor.PRETO, 7, 7), 7, 7, Cor.PRETO);//torre
        posicoes[7][1] = new Posicao(new Peca(new Jogador(), Tipo.CAVALO, Cor.PRETO, 7, 1), 7, 1, Cor.PRETO);//cavalo
        posicoes[7][6] = new Posicao(new Peca(new Jogador(), Tipo.CAVALO, Cor.PRETO, 7, 6), 7, 6, Cor.BRANCO);//cavalo
        posicoes[7][2] = new Posicao(new Peca(new Jogador(), Tipo.BISPO, Cor.PRETO, 7, 2), 7, 2, Cor.BRANCO);//bispo
        posicoes[7][5] = new Posicao(new Peca(new Jogador(), Tipo.BISPO, Cor.PRETO, 7, 5), 7, 5, Cor.PRETO);//bispo
        posicoes[7][3] = new Posicao(new Peca(new Jogador(), Tipo.RAINHA, Cor.PRETO, 7, 3), 7, 3, Cor.PRETO);//rainha
        posicoes[7][4] = new Posicao(new Peca(new Jogador(), Tipo.REI, Cor.PRETO, 7, 4), 7, 4, Cor.BRANCO);//rei
        for(int i=6, j=0; j<NCOL; j++)
        {
            if(j % 2 == 0)
                posicoes[i][j]=new Posicao(new Peca(new Jogador(), Tipo.PEAO, Cor.PRETO, i, j), i, j, Cor.PRETO);//peoes
            else
                posicoes[i][j]=new Posicao(new Peca(new Jogador(), Tipo.PEAO, Cor.PRETO, i, j), i, j, Cor.BRANCO);//peoes
        }
    }


    public Posicao[][] getPosicoes() {
        return posicoes;
    }
}
