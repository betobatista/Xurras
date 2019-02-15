package com.betobatista.xurras.constants;

public class DatabaseConstants {


    public static class SQLITE{
        // Database ver //
        public static final int DATABASE_VER = 1;

        // Database Name //
        public static final String DATABASE_NAME = "DC_APP";
    }

    // Tabelas //
    public static class TABLES{

        // Amigos //
        public static class AMIGOS{
            // Table Name //
            public static final String TABLE_NAME = "AMIGOS";

            // Table Itens //
            public static final String KEY_ID = "ID_AMIGO";
            public static final String KEY_NAME = "DS_AMIGO";
            public static final String KEY_SEX = "SX_AMIGO";
            public static final String KEY_CASH = "VL_AMIGO";

        }

    }
}
