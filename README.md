# 🔐 AssetVault

## Personal Asset & Warranty Manager

AssetVault is a simple Android application developed to help users manage their personal assets in one place.

The application allows users to add, view, edit, and delete information about their assets such as electronic devices, appliances, vehicles, and other valuable items. It also stores purchase and warranty information for easy reference.

---

## 👨‍🎓 Student Information

| Detail | Information |
|---|---|
| **Student Name** | Het Patel |
| **Enrollment No.** | 24012011207 |
| **University** | Ganpat University |
| **Program** | B.Tech. |
| **Semester** | 5th Semester |
| **Subject** | Mobile Application Development |
| **Project Title** | AssetVault |
| **Project Type** | Individual Project |

---

## 📌 Project Overview

Managing personal assets manually can make it difficult to remember important information such as purchase price, purchase date, brand, and warranty period.

AssetVault provides a simple digital solution where users can store and manage their asset information using an Android application.

The application uses a local SQLite database to store asset records.

---

## 🎯 Objectives

The main objectives of AssetVault are:

- To provide a simple application for managing personal assets.
- To store asset information digitally in one place.
- To allow users to add new assets easily.
- To view complete information about saved assets.
- To allow users to edit existing asset information.
- To allow users to delete unwanted assets.
- To store data using a local SQLite database.
- To display the total number of assets on the dashboard.
- To demonstrate Android application development using Kotlin and XML.

---

## ✨ Features

### 🔐 Login Screen
- Provides a simple entry screen for the application.
- Allows the user to enter the application before accessing the dashboard.

### 🏠 Dashboard
- Displays the AssetVault application title.
- Shows the total number of saved assets.
- Provides navigation to Add Asset and My Assets.

### ➕ Add Asset
Users can add the following information:

- Asset Name
- Category
- Brand
- Purchase Price
- Purchase Date
- Warranty Period

### 📋 My Assets
- Displays all saved assets.
- Shows basic asset information.
- Allows the user to select an asset to view its complete details.

### 📄 Asset Details
Displays:

- Asset Name
- Category
- Brand
- Purchase Price
- Purchase Date
- Warranty Period

### ✏️ Edit Asset
- Allows users to modify existing asset information.
- Updated information is stored in the database.

### 🗑️ Delete Asset
- Allows users to remove an asset from the database.

### 📊 Asset Count
- The dashboard automatically displays the total number of stored assets.

---

## 🛠️ Technologies Used

| Technology | Purpose |
|---|---|
| **Kotlin** | Application programming |
| **XML** | User interface design |
| **Android Studio** | Development environment |
| **SQLite** | Local database |
| **Android SDK** | Android application development |
| **Gradle** | Project build system |
| **Git & GitHub** | Version control and project management |

---

## 📱 Platform

- **Platform:** Android
- **Development Environment:** Android Studio
- **Minimum Android Version:** As configured in the project
- **Database:** SQLite

---

## 📂 Project Structure

```text
AssetVault
│
├── app
│   └── src
│       └── main
│           │
│           ├── java
│           │   └── com.example.mad_assignment
│           │       │
│           │       ├── MainActivity.kt
│           │       ├── AddAssetActivity.kt
│           │       ├── MyAssetsActivity.kt
│           │       ├── AssetDetailActivity.kt
│           │       ├── EditAssetActivity.kt
│           │       └── AssetDatabaseHelper.kt
│           │
│           ├── res
│           │   └── layout
│           │       │
│           │       ├── activity_main.xml
│           │       ├── activity_add_asset.xml
│           │       ├── activity_my_assets.xml
│           │       ├── activity_asset_details.xml
│           │       └── activity_edit_asset.xml
│           │
│           └── AndroidManifest.xml
│
└── README.md
