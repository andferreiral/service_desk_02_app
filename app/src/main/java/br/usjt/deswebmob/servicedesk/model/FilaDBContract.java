package br.usjt.deswebmob.servicedesk.model;

import android.provider.BaseColumns;
/**
 * Created by andrey on 21/03/18.
 */

public final class FilaDBContract {

    public FilaDBContract(){

    }

    public static abstract class FilaBanco implements BaseColumns{
        public static final String TABLE_NAME = "Fila";
        public static final String ID_FILA = "id_fila" ;
        public static final String NM_FILA = "nm_fila";
        public static final String NM_FIGURA = "nm_figura";
        public static final String DT_ATUAL = "dt_atual";
        public static final String IMG_FIGURA = "img_figura";
    }
}