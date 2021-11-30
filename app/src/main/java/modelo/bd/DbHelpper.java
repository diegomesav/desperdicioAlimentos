package modelo.bd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelpper extends SQLiteOpenHelper {

    private static final int DATA_VERSION = 1;
    private static final String DATABASE_NOMBRE = "desperdicio.db";
    public static final String TABLE_REGISTRO = "registros";

    public DbHelpper(@Nullable Context context) {
        super(context, DATABASE_NOMBRE, null, DATA_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "+ TABLE_REGISTRO + "(" +
                "Idusuario INTEGER PRIMARY KEY AUTOINCREMENT," +
                "Nombre TEXT NOT NULL," +
                "Apellido TEXT NOT NULL," +
                "Sexo TEXT NOT NULL," +
                "Correo TEXT NOT NULL," +
                "Foto BLOB," +
                "Ciudad TEXT NOT NULL," +
                "Celular TEXT NOT NULL," +
                "Usuario TEXT NOT NULL," +
                "Password TEXT NOT NULL)" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE " + TABLE_REGISTRO);
        onCreate(sqLiteDatabase);
    }
}
