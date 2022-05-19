package com.vinciguerra.dd.modele;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class ConnexionSQLite extends SQLiteOpenHelper {
    private static final String DB_NAME = "DandD";
    private static final int DB_VERSION = 1;
    private static final String TABLE_NAME ="races";
    private static final String ID_COL = "Race";
//    private static final String TAUX_COL = "taux";

    private static final String CREATE_BDD = "CREATE TABLE " + TABLE_NAME + " (" + ID_COL+ " TEXT PRIMARY KEY )";
    private static final String INSERT_MONNAIE = "INSERT INTO `races` (`race`) VALUES\n" +
            "('Elfe'),\n" +
            "('Halfelin'),\n" +
            "('Humain'),\n" +
            "('Nain'),\n" +
            "('Demi-elfe'),\n" +
            "('Drakéide'),\n" +
            "('Gnome'),\n" +
            "('Tieffelin');";

    public ConnexionSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_BDD);
        db.execSQL(INSERT_MONNAIE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    @Override
    public SQLiteDatabase getWritableDatabase() {
        return super.getWritableDatabase();
    }
}
