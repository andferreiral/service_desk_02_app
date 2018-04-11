package br.usjt.deswebmob.servicedesk.model;

import android.content.Context;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

import br.usjt.deswebmob.servicedesk.R;

/**
 * Created by Andrey on 25/03/2018.
 */

public class Util {
    public static Drawable getDrawableDinamic(Context contexto, String nomeImagem){
        Class<?> c = R.drawable.class;
        try {
            Field idField = c.getDeclaredField(nomeImagem);
            int id = idField.getInt(idField);
            return contexto.getResources().getDrawable(id, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
