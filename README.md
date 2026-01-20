# Appzmm.ru - Android WebView App

## Описание

Android-приложение WebView для сайта https://appzmm.ru

## Функционал

- ✅ Splash screen с логотипом и индикатором загрузки
- ✅ WebView с поддержкой JavaScript, LocalStorage, Cookie
- ✅ Нижняя панель навигации (Главная, Задачи, Проект X, +)
- ✅ Загрузка файлов через FileChooser
- ✅ Поддержка камеры для загрузки фото
- ✅ Блокировка HTTP (только HTTPS)
- ✅ Открытие внешних ссылок в браузере
- ✅ Экран ошибки при отсутствии интернета
- ✅ Системная навигация "Назад" (swipe-back)
- ✅ Сохранение состояния WebView при переключении вкладок

## Как открыть в Android Studio

1. Откройте Android Studio
2. Выберите **File → Open**
3. Укажите путь к папке `android-project`
4. Дождитесь синхронизации Gradle

## Как скомпилировать APK

### Debug APK (для тестирования):
```bash
./gradlew assembleDebug
```
APK будет в: `app/build/outputs/apk/debug/app-debug.apk`

### Release APK (для публикации):
```bash
./gradlew assembleRelease
```
APK будет в: `app/build/outputs/apk/release/app-release-unsigned.apk`

## Добавление логотипа

1. Подготовьте PNG-изображение логотипа
2. Поместите его в:
   ```
   app/src/main/res/drawable/splash_logo.png
   ```
3. В файле `activity_splash.xml` замените:
   ```xml
   android:src="@drawable/splash_logo_placeholder"
   ```
   на:
   ```xml
   android:src="@drawable/splash_logo"
   ```

## Подписание Release APK

Для публикации в Google Play необходимо подписать APK:

1. Создайте keystore:
```bash
keytool -genkey -v -keystore appzmm-release-key.jks -keyalg RSA -keysize 2048 -validity 10000 -alias appzmm
```

2. Добавьте в `app/build.gradle.kts`:
```kotlin
android {
    signingConfigs {
        create("release") {
            storeFile = file("appzmm-release-key.jks")
            storePassword = "YOUR_STORE_PASSWORD"
            keyAlias = "appzmm"
            keyPassword = "YOUR_KEY_PASSWORD"
        }
    }
    buildTypes {
        release {
            signingConfig = signingConfigs.getByName("release")
            // ...
        }
    }
}
```

## Структура проекта

```
android-project/
├── app/
│   ├── src/main/
│   │   ├── java/ru/appzmm/webapp/
│   │   │   ├── SplashActivity.kt      # Экран загрузки
│   │   │   ├── MainActivity.kt        # Главный экран с WebView
│   │   │   └── PlusBottomSheetFragment.kt  # Меню создания
│   │   ├── res/
│   │   │   ├── layout/                # XML-разметки
│   │   │   ├── drawable/              # Иконки и фоны
│   │   │   ├── values/                # Цвета, строки, темы
│   │   │   ├── menu/                  # Меню навигации
│   │   │   └── xml/                   # Конфигурации
│   │   └── AndroidManifest.xml
│   └── build.gradle.kts
├── build.gradle.kts
├── settings.gradle.kts
└── gradle.properties
```

## Требования

- Android Studio Hedgehog (2023.1.1) или новее
- Gradle 8.2+
- Android SDK 34
- Kotlin 1.9.20

## Минимальная версия Android

- minSdk: 24 (Android 7.0 Nougat)
- targetSdk: 34 (Android 14)
