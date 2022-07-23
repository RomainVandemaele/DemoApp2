package be.bf.android.demoapp.configs;


public abstract class Config {

    public abstract static class Preferences {
        public static final String EMAIL_PREF_KEY = "email";
        public static final String PASSWORD_PREF_KEY = "password";
        public static final String CHECKED_PREF_KEY = "checked";
    }

    public abstract static class FilePaths {
        public static final String FILE_DEMO = "text.txt";
    }

    public abstract static class DBLite {
       // public static final AppDatabase db = Room.databaseBuilder(getApplicationContext(),)
        public static final String DB_NAME = "DemoDBV2";
    }

}
