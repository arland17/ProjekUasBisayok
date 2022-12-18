package id.ac.umn.projekuasbisayok;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class RegisterActivity extends AppCompatActivity {


        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://projekuaaassss-default-rtdb.firebaseio.com/");
//    private FirebaseDatabase database;
//    private DatabaseReference mDatabase;
//    private static final String USERS = "users";
//    private String TAG = "RegisterActivity";
//    private Button btnRegister;
//    private FirebaseAuth mAuth;
//    private EditText textViewUsername, textViewEmail, textViewPassword, textViewConfirmPassword, textViewAuthors;
//    private String email, password;
//    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText inputUsername = findViewById(R.id.inputUsername);
        final EditText inputEmail = findViewById(R.id.inputEmail);
        final EditText inputPassword = findViewById(R.id.inputPassword);
        final EditText inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        final EditText inputAuthors = findViewById(R.id.inputAuthors);

        final Button btnRegister = findViewById(R.id.btnRegister);

        final TextView textViewSignIn = findViewById(R.id.textViewSignIn);

//        textViewUsername = findViewById(R.id.inputUsername);
//        textViewEmail = findViewById(R.id.inputEmail);
//        textViewPassword = findViewById(R.id.inputPassword);
//        textViewConfirmPassword = findViewById(R.id.inputConfirmPassword);
//        textViewAuthors = findViewById(R.id.inputAuthors);
//
//        btnRegister = findViewById(R.id.btnRegister);
//
//        database = FirebaseDatabase.getInstance();
//        mDatabase = database.getReference(USERS);
//        mAuth = FirebaseAuth.getInstance();
//
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
//
//        btnRegister.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("RestrictedApi")
//            @Override
//            public void onClick(View v) {
//                //insert data into firebase database
//                String username = textViewUsername.getText().toString();
//                String email = textViewEmail.getText().toString();
//                String password = textViewPassword.getText().toString();
//                String confirmpassword = textViewConfirmPassword.getText().toString();
//                String authors = textViewAuthors.getText().toString();
//
//                if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password)) {
//                    Toast.makeText(getApplicationContext(), "Enter email and password", Toast.LENGTH_SHORT).show();
//                    return;
//                }
////                username = textViewUsername.getText().toString();
////                email = textViewEmail.getText().toString();
////                password = textViewPassword.getText().toString();
////                conpassword = textViewConfirmPassword.getText().toString();
////                authors = textViewAuthors.getText().toString();
//                user = new User(email,username,conpassword,authors,password);
//                registerUser();
//                }
//        });
//    }
//
//    public void registerUser() {
//        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//                        if (task.isSuccessful()) {
//                            // Sign in success, update UI with the signed-in user's information
//                            Log.d(TAG, "createUserWithEmail:success");
//                            FirebaseUser user = mAuth.getCurrentUser();
//                            updateUI(user);
//                        } else {
//                            // If sign in fails, display a message to the user.
//                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
//                            Toast.makeText(RegisterActivity.this, "Authentication failed.",
//                                    Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
//    }
//
//    public void updateUI(FirebaseUser currentUser) {
//        String keyid = mDatabase.push().getKey();
//        mDatabase.child(keyid).setValue(user); //adding user info to database
//        Intent loginIntent = new Intent(this, LoginActivity.class);
//        startActivity(loginIntent);
//    }
//}

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = inputUsername.getText().toString();
                final String email = inputEmail.getText().toString();
                final String password = inputPassword.getText().toString();
                final String conPassword = inputConfirmPassword.getText().toString();
                final String authors = inputAuthors.getText().toString();

                if (username.isEmpty() || email.isEmpty() || authors.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                }
                else if (!password.equals(conPassword)) {
                    Toast.makeText(RegisterActivity.this, "Password are not matching", Toast.LENGTH_SHORT).show();
                }
                else  {
                    databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot snapshot) {

                            if (snapshot.hasChild(username)) {
                                Toast.makeText(RegisterActivity.this, "Phone` is already", Toast.LENGTH_SHORT).show();
                            }
                            else {
                                databaseReference.child("users").child(username).child("email").setValue(email);
                                databaseReference.child("users").child(username).child("authors").setValue(authors);
                                databaseReference.child("users").child(username).child("password").setValue(password);

                                Toast.makeText(RegisterActivity.this, "User registered succesfully", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {

                        }
                    });
                }
            }
        });

        textViewSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}