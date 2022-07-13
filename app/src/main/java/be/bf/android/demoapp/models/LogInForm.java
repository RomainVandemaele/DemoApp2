package be.bf.android.demoapp.models;

public class LogInForm implements FormModel{
    @Required @MinLength(size = 4)
    private String username;
    @Required @MinLength(size = 4)
    private String password;

        public LogInForm(String username, String password) {
            this.setUsername(username);
            this.setPassword(password);
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public boolean isValid() {
            if (username == null) return false;
            if (username.equals("")) return false;

            if (password == null) return false;
            if (password.equals("")) return false;
            if (password.length() < 4) return false;
            if (password.length() > 12) return false;

            return true;
        }
}



