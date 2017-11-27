package pt.isec.a21180044.chessgame;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;


import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_IMAGE_CAPTURE = 100;
    private static final int REQUEST_FROM_GALLERY = 101;
    private Context context; //para classes anonimas


    //dados do jogador
    private CircleImageView imv;
    private TextView nickname;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Intent intent = new Intent(this,ActivityEmJogo.class);
        //startActivity(intent);

        context = this;


        nickname = (TextView) findViewById(R.id.tvNickname);
        ImageView editIco = (ImageView)findViewById(R.id.tvNickname_editIcon);
        editIco.setImageResource(android.R.drawable.ic_menu_edit);
        //nickname.setCompoundDrawablesWithIntrinsicBounds(0, 0, android.R.drawable.ic_menu_edit, 0);
        editIco.setOnClickListener(changeNicknameListener);

        imv = (CircleImageView) findViewById(R.id.imv_jogador);
        imv.setOnClickListener(changePictureListener);

    }


/*    private void TakePicture(View view) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }

    }*/

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_IMAGE_CAPTURE) {



            if (resultCode == RESULT_OK) {
                Bundle extras = data.getExtras();
                Bitmap imageBitmap = (Bitmap) extras.get("data");
                imv.setImageBitmap(imageBitmap);
                //Drawable d = new BitmapDrawable(getResources(), imageBitmap);
                //imv.setImageDrawable(d);
            }
        }else if(requestCode == REQUEST_FROM_GALLERY){
            Bitmap bitmap = null;
            try {
                bitmap = MediaStore.Images.Media.getBitmap(getApplicationContext().getContentResolver(), data.getData());
            } catch (IOException e) {
                e.printStackTrace();
            }
            imv.setImageBitmap(bitmap);
        }
    }

    @Override
    public void onBackPressed() {


        //dialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setMessage(R.string.messageExit);
        //builder.setIcon(android.R.drawable.ic_delete);
        builder.setIcon(R.mipmap.xadrez_round);
        builder.setTitle(R.string.app_name);
        builder.setCancelable(true);

        builder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface,int i){
                finish();
            }
        });

        builder.setNegativeButton(R.string.no, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                dialogInterface.cancel();
            }
        });

        builder.show();

    }


    //=============================================================
    //=============================================================
    // Listeners para alterar foto perfil e nickname
    //=============================================================

    private View.OnClickListener changeNicknameListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.dialog_changenickname);

            //editText
            final EditText input = new EditText(context);
            input.setInputType(InputType.TYPE_CLASS_TEXT);

            input.setMinLines(1);
            //definir max length da editext
            int maxLength = 16;
            input.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});

            builder.setView(input);

            // definir os botoes ok e cancel
            builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    nickname.setText(input.getText().toString());
                }
            });
            builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            builder.show();
        }
    };


    private View.OnClickListener changePictureListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle(R.string.dialog_changepicture_title);
            builder.setIcon(android.R.drawable.ic_menu_gallery);
            builder.setItems(R.array.dialog_changepicture_choices, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // the user clicked on colors[which]
                    switch (which){
                        case 0:
                            Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                            if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                                startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                            }
                            break;
                        case 1:

                            Intent galleryIntent=new Intent(Intent.ACTION_PICK,android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                            if (galleryIntent.resolveActivity(getPackageManager()) != null) {
                                startActivityForResult(galleryIntent, REQUEST_FROM_GALLERY);
                            }
                            break;
                    }
                }
            });
            builder.show();
        }
    };

}
