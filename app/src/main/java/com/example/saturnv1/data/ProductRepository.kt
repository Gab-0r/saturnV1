package com.example.saturnv1.data
import android.util.Log
import com.example.saturnv1.model.Product
import com.example.saturnv1.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await


class ProductRepository {

    private var auth: FirebaseAuth = Firebase.auth
    private var db = Firebase.firestore

    suspend fun createProduct(product: Product): ResourceRemote<String> {
        return try {
            val documentProduct = db.collection("users").document(uid).collection("Products").document()
            db.collection("users").document(uid).collection("Products").document(documentProduct.id).set(user).await()
            ResourceRemote.success(data = documentProduct.id)
        } catch (e: FirebaseFirestoreException) {
            Log.d("CreateProduct", e.localizedMessage)
            ResourceRemote.error(message = e.localizedMessage)
        } catch (e: FirebaseFirestoreException){
            Log.d("CreateProduct", e.localizedMessage)
            ResourceRemote.error(message = e.localizedMessage)
        }
    }

}