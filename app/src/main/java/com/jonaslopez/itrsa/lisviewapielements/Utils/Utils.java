package com.jonaslopez.itrsa.lisviewapielements.Utils;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jonaslopez.itrsa.lisviewapielements.Constants.Constants;
import com.jonaslopez.itrsa.lisviewapielements.models.Book;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import static java.nio.charset.StandardCharsets.UTF_8;

public class Utils {
    public static final Charset ISO_8859_1 = Charset.forName("ISO-8859-1");
    public static final Charset UTF_8 = Charset.forName("UTF-8");
    public static boolean showingDialogMessage = false;
    private static AlertDialog.Builder dlgAlert;



    public static void  alertError(Context context, String message) {
        dlgAlert  = new AlertDialog.Builder(context)
                .setMessage(message)
                .setTitle("Error")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                       // ActivityCompat.finishAffinity((Activity) context);
                        showingDialogMessage = false;
                    }
                })
                .setCancelable(true);

        if(!showingDialogMessage){
            showingDialogMessage = true;
            dlgAlert.create().show();
        }
    }


    public static List parseJsonToObject(String jsonString) {
        jsonString = encodeStringToUTF8( jsonString );
        Gson gson = new GsonBuilder().create();
        ArrayList<Book> bookList = new ArrayList<>( );

        try {
            JSONArray jsonarray = new JSONArray(jsonString);
            for (int i = 0; i < jsonarray.length(); i++) {
                JSONObject jsonobject = jsonarray.getJSONObject(i);
                String dataObject = jsonobject.toString();
                Book book = gson.fromJson( dataObject, Book.class );
                bookList.add( book );
            }

        } catch (JSONException e1) {
            e1.printStackTrace();

        }
        return   bookList;
    }

    public static String encodeStringToUTF8(String text){




        byte[] ptext = text.getBytes(ISO_8859_1);
        String encodeText = new String(ptext, UTF_8);

        return encodeText;
    }


}
