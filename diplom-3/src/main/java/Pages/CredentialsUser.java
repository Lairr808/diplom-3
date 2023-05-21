package Pages;

public class CredentialsUser {

        private String email;
        private String password;

        public CredentialsUser(String email, String password) {
            this.email = email;
            this.password = password;
        }

        public static CredentialsUser from (User user){
            return new CredentialsUser(user.getEmail(), user.getPassword());
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public static CredentialsUser getDefault(){
        return new CredentialsUser("ninja@yandex.ru", "000000");
    }

}

