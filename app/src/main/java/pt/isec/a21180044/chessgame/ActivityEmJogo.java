package pt.isec.a21180044.chessgame;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

import pt.isec.a21180044.chessgame.Classes.GetImageResource;
import pt.isec.a21180044.chessgame.Classes.Tabuleiro;

public class ActivityEmJogo extends Activity {

    Tabuleiro tabuleiro ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);                                                                  //no title
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);    //fullscreen
        setContentView(R.layout.activity_em_jogo);

        tabuleiro = new Tabuleiro();
        tabuleiro.distribuiPecas();

        constroiVistaTabuleiro();
    }

    private void constroiVistaTabuleiro(){
        ImageView imageViewCxx;
        String nomeIDimageview;
        int resID;
        int img_resource = -1;
        Resources res = getResources();


        for(int i = 0;  i < tabuleiro.NLIN; i++){
            for(int j = 0; j < tabuleiro.NCOL; j++){

                nomeIDimageview = "c" + i +j ;

                resID =  getResources().getIdentifier(nomeIDimageview, "id", getPackageName()); //getRes().getIdentifier(buttonID, "id", getPackageName());
                imageViewCxx = (ImageView)findViewById(resID);

                Log.i("debug", "tem_peca em [" + i + "][" + j + "] " + tabuleiro.getPosicoes()[i][j].temPeca());
                if(tabuleiro.getPosicoes()[i][j].temPeca()) {



                    img_resource = GetImageResource.ByTipoCor(tabuleiro.getPosicoes()[i][j].getPeca().getTipo(), tabuleiro.getPosicoes()[i][j].getPeca().getCor());

                    if (img_resource == -1) {
                        Log.i("debug", "img_resource = null");
                    }else{
                        //imageViewCxx.setImageResource(img_resource);
                        // imageViewCxx.setForeground(getResources().getDrawable(img_resource));
                        imageViewCxx.setImageDrawable(getResources().getDrawable(img_resource));
                    }

                }

            } //for j
        } // for i


        //resID =  getResources().getIdentifier("c74", "id", getPackageName()); //getRes().getIdentifier(buttonID, "id", getPackageName());
        //imageViewCxx = (ImageView)findViewById(resID);
        //imageViewCxx.setImageDrawable(null);  //para apagar

    }
}
