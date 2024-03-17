package com.example.demo.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @SuppressWarnings("deprecation")
	@Bean
    public Firestore firebaseInit() throws IOException {
    	synchronized (FirebaseConfig.class) {
            if (FirebaseApp.getApps().isEmpty()) {
                // Carga el archivo serviceAccountKey.json desde resources
                ClassPathResource serviceAccountResource = new ClassPathResource("serviceAccountKey.json");
                InputStream serviceAccount = serviceAccountResource.getInputStream();

                // Inicializa Firebase con las credenciales
                FirebaseOptions options = new FirebaseOptions.Builder()
                        .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                        .build();

                FirebaseApp.initializeApp(options);
            }
        }

        // Obtiene una instancia de Firestore
        return FirestoreClient.getFirestore();
    }
}