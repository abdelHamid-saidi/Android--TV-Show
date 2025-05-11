# TV Show App

Application Android développée en **Kotlin** avec **Jetpack Compose**, suivant l'architecture **Clean Architecture** et le modèle **MVVM**. Elle permet d'afficher une liste des émissions TV populaires ainsi que les détails d’une émission sélectionnée.


## Fonctionnalités

- Liste paginée des émissions TV populaires (API de [episodate.com](https://www.episodate.com))
- Affichage des détails d’une émission sélectionnée
- Interface moderne avec Jetpack Compose
- Architecture modulaire et maintenable
- Gestion des images avec Coil
- Injection de dépendances via Dagger-Hilt


##  Technologies

- **Jetpack Compose** : Interface utilisateur
- **MVVM** : Séparation des préoccupations
- **Clean Architecture** : Structure du code modulaire
- **Retrofit** : Appels HTTP
- **Dagger-Hilt** : Injection de dépendances
- **Coil** : Chargement d’images
- **Kotlin Coroutines** : Traitement asynchrone


##  Dépendances principales

```kotlin 
// Architecture Components
implementation("androidx.lifecycle:lifecycle-viewmodel-compose:2.8.7")

// Coroutines
implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

// Dagger-Hilt
implementation("com.google.dagger:hilt-android:2.51.1")
kapt("com.google.dagger:hilt-android-compiler:2.51.1")

// Retrofit & Gson
implementation("com.squareup.retrofit2:converter-gson:2.9.0")

// Coil
implementation("io.coil-kt.coil3:coil-compose:3.0.3")
