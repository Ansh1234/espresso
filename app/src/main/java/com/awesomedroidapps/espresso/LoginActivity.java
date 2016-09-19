package com.awesomedroidapps.espresso;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

  private EditText userName, password;
  private TextView loginTextView;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_login);

    userName = (EditText) findViewById(R.id.user_name);
    password = (EditText) findViewById(R.id.password);
    loginTextView = (TextView) findViewById(R.id.login_result);
  }

  public void loginButtonClick(View v) {
    String userNameTxt = userName.getText().toString();
    String passwordTxt = password.getText().toString();

    if (LoginHelper.areCredentialsValid(userNameTxt, passwordTxt)) {
      loginTextView.setText(getResources().getString(R.string.login_success));
    } else {
      loginTextView.setText(getResources().getString(R.string.login_failure));
    }
  }
}
