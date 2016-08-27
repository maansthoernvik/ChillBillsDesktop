package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.AccountManager;
import model.SQLiteConnection;
import model.objects.User;

/**
 * Created by MTs on 19/08/16.
 *
 *
 */

public class LoginController {

    @FXML private TextField tfLogin;
    @FXML private PasswordField pwfLogin;
    @FXML private Button btnLogin;

    private AccountManager accountManager;

    /**
     *
     */

    public void setAccountManager(AccountManager accountManager) {
        this.accountManager = accountManager;
    }

    /**
     * Automatically called due to its name
     */

    @SuppressWarnings("unused")
    public void initialize() {
        tfLogin.setText("alpha");
        pwfLogin.setText("opq531");
        btnLogin.setOnMouseReleased( releaseEvent -> {
            User user = authenticate();

            // Fetch User will return null upon error.
            if (user != null) {
                accountManager.setCurrentUser(user);
                accountManager.showMainView();
            }
        });
    }

    /**
     *
     * @return
     */

    private User authenticate() {
        SQLiteConnection SQLiteConn = new SQLiteConnection();

        return SQLiteConn.fetchUser("SELECT UserID, Username FROM Users WHERE Username = ? AND Password = ?",
                tfLogin.getText(), pwfLogin.getText());
    }
}
