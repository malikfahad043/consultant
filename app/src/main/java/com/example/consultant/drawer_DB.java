package com.example.consultant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class drawer_DB extends AppCompatActivity {

    private EditText editTextId;
    private DrawerLayout drawerlayout;

    private NavigationView nav_view;

    private Toolbar toolbar;
    private EditText editTextName;
    private EditText editTextPrice;
    private Button buttonSave;
    private Button buttonUpdate;
    private Button buttonDelete;
    private FirebaseFirestore firestore;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        firestore = FirebaseFirestore.getInstance();
//        editTextId = findViewById(R.id.editTextId);
//        editTextName = findViewById(R.id.editTextName);
//        editTextPrice = findViewById(R.id.editTextPrice);
//        buttonSave = findViewById(R.id.buttonSave);
//        buttonUpdate = findViewById(R.id.buttonUpdate);
//        buttonDelete = findViewById(R.id.buttonDelete);
        drawerlayout = findViewById(R.id.drawerlayout);
        nav_view = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.navigationopen, R.string.navigationclose);
        drawerlayout.addDrawerListener(toggle);
        toggle.syncState();
        //        to select the nav items code below here
//        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                int id = item.getItemId();
//                if (id == R.id.nav_home) {
////                loadfragment(new afragment());
//                    Toast.makeText(drawer_DB.this, "HOME", Toast.LENGTH_SHORT).show();
//
////                    Intent intent = new Intent(drawer_DB.this, afragment.class);
////                    startActivity(intent);
//
//                } else if (id == R.id.nav_appointment) {
//                    Toast.makeText(drawer_DB.this, "APPOINTMENT", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.nav_consult) {
//                    Toast.makeText(drawer_DB.this, "CONSULTANT", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.nav_help) {
//                    Toast.makeText(drawer_DB.this, "HELP", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.nav_share) {
//                    Toast.makeText(drawer_DB.this, "SHARE", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.nav_rateus) {
//                    Toast.makeText(drawer_DB.this, "RateUS", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.nav_faq) {
//                    Toast.makeText(drawer_DB.this, "FAQ", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.nav_login) {
//                    Toast.makeText(drawer_DB.this, "LOGIN", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.nav_profile) {
//                    Toast.makeText(drawer_DB.this, "PROFILE", Toast.LENGTH_SHORT).show();
//                } else if (id == R.id.nav_logout) {
//                    Toast.makeText(drawer_DB.this, "LOGOUT", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(drawer_DB.this, "Null", Toast.LENGTH_SHORT).show();
//
//                }
//
//                return false;
//            }
//        });
        //           code to select items of the menu

        nav_view.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener()
        {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();

                if (id == R.id.nav_profile)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, profile.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_appointment)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, appointment.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_help)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, help.class);
                    startActivity(intent);
                }
                else if (id == R.id.nav_consult)
                {
                    // Handle Home item click
                    Intent intent = new Intent(drawer_DB.this, consultant.class);
                    startActivity(intent);
                }

                drawerlayout.closeDrawers(); // Close the drawer after handling the item click
                return true;
            }
        });



//
//        //Button
//        buttonSave.setOnClickListener(view -> {
//            saveToFirestore();
//        });
//
//        // Set a click listener on the update button
//        buttonUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                updateInFirestore();
//            }
//        });
//
//        // Set a click listener on the delete button
//        buttonDelete.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                deleteFromFirestore();
//            }
//        });
////        buttonSave.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                saveToFirestore();
////            }
////        });
//    }
//
//
//
//    private void saveToFirestore() {
//        String productId = editTextId.getText().toString().trim();
//        String productName = editTextName.getText().toString().trim();
//        double productPrice = Double.parseDouble(editTextPrice.getText().toString().trim());
//
//
//        Map<String, Object> product = new HashMap<>();
//        product.put("id", productId);
//        product.put("name", productName);
//        product.put("price", productPrice);
//
//        // Add the product to Firestore
//        firestore.collection("products")
//                .document(productId)
//                .set(product)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        // Data added successfully
//                        Toast.makeText(drawer_DB.this, "Product saved to Firestore", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(Exception e) {
//                        Toast.makeText(drawer_DB.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//
//    }
//
//    private void updateInFirestore() {
//        String productId = editTextId.getText().toString().trim();
//        String productName = editTextName.getText().toString().trim();
//        double productPrice = Double.parseDouble(editTextPrice.getText().toString().trim());
//
//        // Create a new product object
//        Map<String, Object> product = new HashMap<>();
//        product.put("name", productName);
//        product.put("price", productPrice);
//
//        // Update the product in Firestore
//        firestore.collection("products")
//                .document(productId)
//                .update(product)
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        // Data updated successfully
//                        Toast.makeText(drawer_DB.this, "Product updated in Firestore", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(Exception e) {
//                        // Error occurred while updating data
//                        Toast.makeText(drawer_DB.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
//
//    private void deleteFromFirestore() {
//        String productId = editTextId.getText().toString().trim();
//
//        // Delete the product from Firestore
//        firestore.collection("products")
//                .document(productId)
//                .delete()
//                .addOnSuccessListener(new OnSuccessListener<Void>() {
//                    @Override
//                    public void onSuccess(Void aVoid) {
//                        // Data deleted successfully
//                        Toast.makeText(drawer_DB.this, "Product deleted from Firestore", Toast.LENGTH_SHORT).show();
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(Exception e) {
//                        // Error occurred while deleting data
//                        Toast.makeText(drawer_DB.this, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//                });
//    }
}
}

